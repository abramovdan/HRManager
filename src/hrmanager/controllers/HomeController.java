package hrmanager.controllers;

import hrmanager.enums.Command;
import hrmanager.models.*;
import hrmanager.views.*;
import hrmanager.views.department.AddDepartmentView;
import hrmanager.views.employee.AddEmployeeView;
import hrmanager.views.employee.DeleteEmployeeView;
import hrmanager.views.employee.EditEmployeeView;
import hrmanager.views.employee.EmployeesView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import repository.JsonRepository;
import repository.Repository;


public class HomeController {
	
	private Repository<Department> departmentRepository;
	private Repository<Employee> employeeRepository;
	
	public HomeController(Repository<Employee> employeeRepo, Repository<Department> departmentRepo) {
		employeeRepository = employeeRepo;
		departmentRepository = departmentRepo;
		HomeView homeView;
		Command command;
		do {
			homeView = new HomeView();
			command = homeView.getCommand();
			if (command==null) continue;
			switch (command) {
			case ADDEMPLOYEE:
				addEmployee();
				break;
				
			case DELETEEMPLOYEE:
				deleteEmployee();
				break;
			
			case EDITEMPLOYEE:
				editEmployee();
				break;
				
			case SHOWEMPLOYEES:
				showEmployees();
				break;
				//TODO: other commands
			case ADDDEPARTMENT:
				AddDepartment();
				break;
				
			default:
				break;
			}
		} while (command != Command.EXIT);
		
	}
	
	private void AddDepartment() {
		AddDepartmentView addDepartmentView = new AddDepartmentView();
		//add fields validation
		Department department = new Department();
		department.setName(addDepartmentView.getName());
		Collection<Employee> foundedEmployees = findEmployeesByName(addDepartmentView.getChiefName(), employeeRepository.entities());
		if (foundedEmployees.size() > 0) {
			department.setChief(foundedEmployees.iterator().next().getId());
		} else {
			//add validation error
			department.setChief(null);
		}
		departmentRepository.create(department);
	}

	private void editEmployee() {
		EditEmployeeView editEmployeeView = new EditEmployeeView();
		String targetName = editEmployeeView.getName();
		Collection<Employee> employeesToEdit = findEmployeesByName(targetName, employeeRepository.entities());
		if (employeesToEdit.size() > 0) {
			Employee targetEmployee = employeesToEdit.iterator().next();
			editEmployeeView.getEmployeeDetails();
			//TODO: add validation of model fields
			targetEmployee.setName(editEmployeeView.getName());
			targetEmployee.setSalary(editEmployeeView.getSalary());
			targetEmployee.setPhoneNumber(editEmployeeView.getPhoneNumber());
			Collection<Department> departments = findDepartmentByName(editEmployeeView.getDepartment(), departmentRepository.entities());
			if (departments.size() > 0) {
				targetEmployee.setDepartmentId(departments.iterator().next().getId());
			} else {
				//add validation error
			}
			employeeRepository.update(targetEmployee);
		} else {
			MessageView messageView = new MessageView("There are no employees with such name. Press enter to continue.");
		}

	};

	private void deleteEmployee() {
		DeleteEmployeeView deleteEmployeeView = new DeleteEmployeeView();
		String targetName = deleteEmployeeView.getName();
		Collection<Employee> employeesToDelete = findEmployeesByName(targetName, employeeRepository.entities());
		if (employeesToDelete.size() > 0){
			for (Employee employee : employeesToDelete) {
				employeeRepository.delete(employee);
			}
			MessageView messageView = new MessageView("Employees with name " + targetName + " were deleted. Press enter to continue.");
			return;
		} else {
			MessageView messageView = new MessageView("There are no employees with such name. Press enter to continue.");
		}
	};

	private void showEmployees() {
		Collection<Employee> employees = employeeRepository.entities();
		if (employees.size() > 0){
			EmployeesView employeesView = new EmployeesView(employees);
			MessageView messageView = new MessageView("Press enter to continue.");
		} else {
			MessageView messageView = new MessageView("There are no added employees. Press enter to continue.");
		}
		
	}

	public void addEmployee(){
		AddEmployeeView addEmployeeView = new AddEmployeeView();
		Employee employee = new Employee(addEmployeeView.getName(), addEmployeeView.getSalary());
		employee.setPhoneNumber(addEmployeeView.getPhoneNumber());
		//Department department = departmentRepository.getDepartmentByName(addEmployeeView.getDepartment());
		//if (department!=null) {
		//	employee.setDepartmentId(department.getId());
		//}
		employeeRepository.create(employee);
	}
	
	private Collection<Employee> findEmployeesByName(String name, Collection<Employee> employees){
		Collection<Employee> result = new ArrayList<Employee>();
		if (name == null || "".equals(name)) return result;
		for (Employee employee : employees) {
			if (name.equals(employee.getName())){
				result.add(employee);
			}
		}
		return result;
	}
	
	private Collection<Department> findDepartmentByName(String name, Collection<Department> departments){
		Collection<Department> result = new ArrayList<Department>();
		if (name == null || "".equals(name)) return result;
		for (Department dep : departments) {
			if (name.equals(dep.getName())){
				result.add(dep);
			}
		}
		return result;
	}
}

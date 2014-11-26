package hrmanager.controllers;

import hrmanager.enums.Command;
import hrmanager.models.*;
import hrmanager.views.*;

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
				//editEmployee();
				break;
				
			case SHOWEMPLOYEES:
				showEmployees();
				break;
				//TODO: other commands
			
			default:
				break;
			}
		} while (command != Command.EXIT);
		
	}
	
	private void deleteEmployee() {
		DeleteEmployeeView deleteEmployeeView = new DeleteEmployeeView();
		String targetName = deleteEmployeeView.getName();
		if (targetName == null || "".equals(targetName)){
			MessageView messageView = new MessageView("There are no employees with such name. Press enter to continue.");
			return;
		} else {
			for (Employee emp : employeeRepository.entities()) {
				if (targetName.equals(emp.getName())) {
					employeeRepository.delete(emp);
					MessageView messageView = new MessageView("Employee " + emp.getName() + " was deleted. Press enter to continue.");
					return;
				}
				MessageView messageView = new MessageView("There are no employees with such name. Press enter to continue.");
			};
		}
	}

	private void showEmployees() {
		Collection<Employee> employees = employeeRepository.entities();
		EmployeesView employeesView = new EmployeesView(employees);
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
}

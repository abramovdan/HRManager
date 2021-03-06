package hrmanager.controllers;

import hrmanager.enums.Command;
import hrmanager.models.*;
import hrmanager.views.*;
import hrmanager.views.department.AddDepartmentView;
import hrmanager.views.department.DeleteDepartmentView;
import hrmanager.views.department.DepartmentsView;
import hrmanager.views.department.EditDepartmentView;
import hrmanager.views.employee.AddEmployeeView;
import hrmanager.views.employee.DeleteEmployeeView;
import hrmanager.views.employee.EditEmployeeView;
import hrmanager.views.employee.EmployeesView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import repository.Repository;


public class HomeController {
	
	private Repository<Department> departmentRepository;
	private Repository<Employee> employeeRepository;
	
	public HomeController(Repository<Employee> employeeRepo, Repository<Department> departmentRepo) {
		employeeRepository = employeeRepo;
		departmentRepository = departmentRepo;
		Command command;
		do {
			HomeView.printAvailableCommands();

			Scanner scanner = getScanner();
			String selectedCommand = scanner.next();
			command = Command.fromString(selectedCommand);
			if (command==null) continue;

			switch (command) {
			case ADDEMPLOYEE:
				addEmployee();
				break;

			case ADDDEPARTMENT:
				addDepartment();
				break;
				
			case DELETEEMPLOYEE:
				deleteEmployee();
				break;

			case DELETEDEPARTMENT:
				deleteDepartment();
				break;
			
			case EDITEMPLOYEE:
				editEmployee();
				break;

			case EDITDEPARTMENT:
				editDepartment();
				break;

			case SHOWEMPLOYEES:
				showEmployees();
				break;

			case SHOWDEPARTMENTS:
				showDepartments();
				break;

			default:
				break;
			}
		} while (command != Command.EXIT);
		
	}

	private void showDepartments() {
		Collection<Department> departments = departmentRepository.entities();
		Scanner scanner = getScanner();
		DepartmentsView view = new DepartmentsView(departments, employeeRepository.entities());
		if (departments.size() > 0){
			view.printDepartments();
		} else {
			view.printNoDepartmentsMsg();
		}
		scanner.nextLine();
	}

	private Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	private void addDepartment() {
		AddDepartmentView view = new AddDepartmentView();
		Scanner scanner = getScanner();
		Department department = new Department();

		view.printEditDepartmentName();
		String name = scanner.next();
		department.setName(name);

		view.printEditDepartmentChiefName();
		String chiefName = scanner.next();
		scanner.nextLine();

		Collection<Employee> foundedEmployees = findEmployeesByName(chiefName, employeeRepository.entities());
		if (foundedEmployees.size() > 0) {
			department.setChiefId(foundedEmployees.iterator().next().getId());
		} else {
			department.setChiefId(null);
		}
		departmentRepository.create(department);
		view.printOperationCompleted();
		scanner.nextLine();
	}

	public void addEmployee() {
		AddEmployeeView view = new AddEmployeeView();
		Scanner scanner = getScanner();
		Employee employee = new Employee();

		view.printEditEmployeeName();
		String name = scanner.next();
		employee.setName(name);

		view.printEditEmployeeSalary();
		long salary = scanner.nextLong();
		employee.setSalary(salary);

		view.printEditEmployeePhone();
		String phoneNumber = scanner.next();
		employee.setPhoneNumber(phoneNumber);

		view.printEditEmployeeDepartment();
		String depName = scanner.next();
		scanner.nextLine();

		Collection<Department> dep = findDepartmentByName(depName, departmentRepository.entities());
		Iterator<Department> it = dep.iterator();
		if (it.hasNext()) {
			employee.setDepartmentId(it.next().getId());
		} else {
			view.printNoSuchDepartmentWarnMsg();
		}

		employeeRepository.create(employee);
		view.printOperationCompleted();
		scanner.nextLine();
	}

	private void editEmployee() {
		EditEmployeeView view = new EditEmployeeView();
		Scanner scanner = getScanner();

		view.printEditTargetEmployeeName();
		String targetName = scanner.next();
		Collection<Employee> employeesToEdit = findEmployeesByName(targetName, employeeRepository.entities());
		if (!employeesToEdit.iterator().hasNext()) {
			view.printNoSuchEmployeeWarnMsg();
			scanner.nextLine();
			return;
		}

		Employee employee = employeesToEdit.iterator().next();

		view.printEditEmployeeName();
		String name = scanner.next();
		employee.setName(name);

		view.printEditEmployeeSalary();
		long salary = scanner.nextLong();
		employee.setSalary(salary);

		view.printEditEmployeePhone();
		String phoneNumber = scanner.next();
		employee.setPhoneNumber(phoneNumber);

		view.printEditEmployeeDepartment();
		String depName = scanner.next();
		scanner.nextLine();

		Collection<Department> dep = findDepartmentByName(depName, departmentRepository.entities());
		Iterator<Department> it = dep.iterator();
		if (it.hasNext()) {
			employee.setDepartmentId(it.next().getId());
		} else {
			view.printNoSuchDepartmentWarnMsg();
		}

		employeeRepository.update(employee);
		view.printOperationCompleted();
		scanner.nextLine();
	};

	private void editDepartment() {
		EditDepartmentView view = new EditDepartmentView();
		Scanner scanner = getScanner();

		view.printEditTargetDepartmentName();
		String targetName = scanner.next();
		Collection<Department> departmentsToEdit = findDepartmentByName(targetName, departmentRepository.entities());
		if (!departmentsToEdit.iterator().hasNext()) {
			view.printNoSuchDepartmentWarnMsg();
			scanner.nextLine();
			return;
		}

		Department department = departmentsToEdit.iterator().next();

		view.printEditDepartmentName();
		String name = scanner.next();
		department.setName(name);

		view.printEditDepartmentChiefName();
		String chiefName = scanner.next();
		scanner.nextLine();

		Collection<Employee> foundedEmployees = findEmployeesByName(chiefName, employeeRepository.entities());
		if (foundedEmployees.size() > 0) {
			department.setChiefId(foundedEmployees.iterator().next().getId());
		} else {
			department.setChiefId(null);
		}
		departmentRepository.update(department);
		view.printOperationCompleted();
		scanner.nextLine();
	}

	private void deleteEmployee() {
		DeleteEmployeeView view = new DeleteEmployeeView();
		Scanner scanner = getScanner();
		view.printDeleteEmployeeName();

		String targetName = scanner.next();
		Collection<Employee> employeesToDelete = findEmployeesByName(targetName, employeeRepository.entities());
		if (!employeesToDelete.iterator().hasNext()){
			view.printNoSuchEmployeeWarnMsg();
			scanner.nextLine();
			return;
		}

		Employee targetEmployee = employeesToDelete.iterator().next();
		for (Employee employee : employeesToDelete) {
			employeeRepository.delete(employee);
		}
		view.printOperationCompleted();
		scanner.nextLine();
	};

	private void deleteDepartment() {
		DeleteDepartmentView view = new DeleteDepartmentView();
		Scanner scanner = getScanner();
		view.printDeleteDepartmentName();

		String targetName = scanner.next();
		Collection<Department> departmentsToDelete = findDepartmentByName(targetName, departmentRepository.entities());
		if (!departmentsToDelete.iterator().hasNext()){
			view.printNoSuchDepartmentWarnMsg();
			scanner.nextLine();
			return;
		}

		Department targetDepartment = departmentsToDelete.iterator().next();
		for (Department department : departmentsToDelete) {
			departmentRepository.delete(department);
		}
		view.printOperationCompleted();
		scanner.nextLine();
	}

	private void showEmployees() {
		Collection<Employee> employees = employeeRepository.entities();
		Scanner scanner = getScanner();
		EmployeesView view = new EmployeesView(employees, departmentRepository.entities());
		if (employees.size() > 0){
			view.printEmployees();
		} else {
			view.printNoEmployeesMsg();
		}
		scanner.nextLine();
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

package controllers;

import java.util.UUID;

import enums.Command;
import repository.*;
import models.*;
import views.*;

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
			
			case EDITEMPLOYEE:
				//editEmployee();
				break;
				
				//TODO: other commands
				
			default:
				break;
			}
		} while (command != Command.EXIT);
		
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

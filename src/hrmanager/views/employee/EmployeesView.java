package hrmanager.views.employee;

import hrmanager.models.Employee;
import hrmanager.views.BaseView;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class EmployeesView extends BaseView {
	private Collection<Employee> employees;

	public EmployeesView(Collection<Employee> employees){
		this.employees = employees;
	}

	public void printEmployees(){
		showTitle();
		for (Employee employee : employees) {
			showEmployeeInfo(employee);
		}
		printContinueMsg();
	}

	public void printNoEmployeesMsg(){
		System.out.println("There are no added employees.");
		printContinueMsg();
	}
	
	private void showTitle(){
		System.out.printf("%-15s", "Employee name");
		System.out.printf("%-15s", "Phone number");
		System.out.printf("%-15s", "Department"); //TODO: show department name here
		System.out.printf("%-15s", "Salary");
		System.out.println();
	}
	
	private void showEmployeeInfo(Employee employee){
		System.out.printf("%-15s", employee.getName());
		System.out.printf("%-15s", employee.getPhoneNumber());
		System.out.printf("%-15s", employee.getDepartmentId()); //TODO: show department name here
		System.out.printf("%-15d", employee.getSalary());
		System.out.println();
	}
}

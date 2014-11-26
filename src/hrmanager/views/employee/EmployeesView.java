package hrmanager.views.employee;

import hrmanager.models.Employee;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class EmployeesView {
	public EmployeesView(Collection<Employee> employees){
		showTitle();
		for (Employee employee : employees) {
			showEmployeeInfo(employee);
		}
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
		System.out.printf("%-15f", employee.getSalary());
		System.out.println();
	}
}

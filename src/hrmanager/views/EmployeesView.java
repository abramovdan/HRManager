package hrmanager.views;

import hrmanager.models.Employee;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class EmployeesView {
	public EmployeesView(Collection<Employee> employees){
		if (employees.size() > 0) {
			showTitle();
			for (Employee employee : employees) {
				showEmployeeInfo(employee);
			}
			System.out.println();
			System.out.println("Press enter to continue;");
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

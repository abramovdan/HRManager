package hrmanager.views.employee;

import hrmanager.helpers.UUIDWrapper;
import hrmanager.models.Department;
import hrmanager.models.Employee;
import hrmanager.views.BaseView;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class EmployeesView extends BaseView {
	private Collection<Employee> employees;
	private Collection<Department> departments;

	public EmployeesView(Collection<Employee> employees, Collection<Department> departments){
		this.employees = employees;
		this.departments = departments;
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
		System.out.printf("%-20s", "Employee name");
		System.out.printf("%-20s", "Phone number");
		System.out.printf("%-20s", "Department");
		System.out.printf("%-20s", "Salary");
		System.out.println();
	}
	
	private void showEmployeeInfo(Employee employee){
		System.out.printf("%-20s", employee.getName());
		System.out.printf("%-20s", employee.getPhoneNumber());
		System.out.printf("%-20s", getDepartmentNameById(employee.getDepartmentId()));
		System.out.printf("%-20d", employee.getSalary());
		System.out.println();
	}

	private String getDepartmentNameById(UUIDWrapper id){
		if (id!=null) {
			for (Department department : departments) {
				if (department.getId().equals(id)) return department.getName();
			}
		}
		return "no department";
	}
}

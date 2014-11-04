package Models;

import java.util.UUID;

public class Employee {
	private UUID id;
	private String name;
	private Department department;
	private String phoneNumber;
	private double salary;
	
	public Employee(String n) {
		id = UUID.randomUUID();
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public UUID getId() {
		return id;
	}
}

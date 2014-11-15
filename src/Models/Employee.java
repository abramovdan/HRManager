package models;

import java.util.UUID;

public class Employee {
	private UUID id;
	private String name;
	private UUID departmentId;
	private String phoneNumber;
	private double salary;
	
	public Employee(String name, double salary) {
		id = UUID.randomUUID();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(UUID departmentId) {
		this.departmentId = departmentId;
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

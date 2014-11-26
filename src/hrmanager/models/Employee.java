package hrmanager.models;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import repository.annotations.JsonDAO;

@JsonDAO(path="employees")
public class Employee extends SimpleEntity {
	
	@NotNull(message = "Name must be not null")
	private String name;
	private UUID departmentId;
	private String phoneNumber;
	private double salary;
	
	public Employee(){}
	
	public Employee(String name, double salary) {
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

	@Override
	public UUID getParentId() {
		return getDepartmentId();
	}
	
	@Override
	public void setParentId(UUID parentId){
		setDepartmentId(parentId);
	}

}

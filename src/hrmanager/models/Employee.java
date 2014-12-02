package hrmanager.models;

import javax.validation.constraints.NotNull;

import hrmanager.helpers.UUIDWrapper;
import repository.annotations.JsonDAO;

@JsonDAO(path="employees")
public class Employee extends SimpleEntity {
	
	@NotNull(message = "Name must be not null")
	private String name;
	private UUIDWrapper departmentId;
	private String phoneNumber;
	private long salary;
	
	public Employee(){}
	
	public Employee(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUIDWrapper getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(UUIDWrapper departmentId) {
		this.departmentId = departmentId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public UUIDWrapper getParentId() {
		return getDepartmentId();
	}
	
	@Override
	public void setParentId(UUIDWrapper parentId){
		setDepartmentId(parentId);
	}

}

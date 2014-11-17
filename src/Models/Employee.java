package models;

import java.util.Collection;
import java.util.UUID;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.util.JSONBuilder;
import repository.JsonSerializable;
import annotations.JsonDAO;

@JsonDAO(path="employees")
public class Employee extends SimpleEntity implements JsonSerializable<Employee>{
	
	@NotNull(message = "Name must be not null")
	private String name;
	private UUID departmentId;
	private String phoneNumber;
	private double salary;
	
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
	public JSON toJSON() {
		JSONSerializer jsonSerializer = new JSONSerializer();
		return jsonSerializer.toJSON(this);
	}

	@Override
	public Collection<Employee> findByParent(UUID parentUUID) {
		// TODO Auto-generated method stub
		return null;
	}
}

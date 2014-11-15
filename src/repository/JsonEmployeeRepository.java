package repository;

import java.util.*;
import net.sf.json.JSONArray;
import models.Employee;

public class JsonEmployeeRepository implements EmployeeRepository {

	private String fileName;
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public JsonEmployeeRepository() {
		fileName = "employeeRepo.json";
	}
	
	public JsonEmployeeRepository(String filename) {
		this.fileName = fileName;
	}
	
	@Override
	public Collection<Employee> entities() {
		return null;
	}

	@Override
	public void create(Employee entity) {
		if (entity!=null) {
			employees.add(entity);
			JSONArray jsonArray = JSONArray.fromObject(employees);
			
			System.out.println(jsonArray);
			//TODO: write jsonArray to file
		}
	}

	@Override
	public void update(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee entity) {
		// TODO Auto-generated method stub
		
	}

}

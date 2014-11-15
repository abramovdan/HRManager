package repository;

import models.Department;

public interface DepartmentRepository extends Repository<Department>{
	public Department getDepartmentByName(String name);
}

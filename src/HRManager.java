import jsonrepository.repository.*;
import hrmanager.controllers.*;
import hrmanager.models.*;


public class HRManager {
	public static void main(String[] args){
		Repository<Department> departmentRepository = new JsonRepository<Department>(Department.class);
		Repository<Employee> employeeRepository = new JsonRepository<Employee>(Employee.class);
		HomeController homeController = new HomeController(employeeRepository, departmentRepository);
	}
}

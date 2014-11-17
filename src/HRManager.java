import models.*;
import repository.*;
import controllers.*;


public class HRManager {
	public static void main(String[] args){
		Repository<Department> departmentRepository = new JsonRepository<Department>();
		Repository<Employee> employeeRepository = new JsonRepository<Employee>();
		HomeController homeController = new HomeController(employeeRepository, departmentRepository);
	}
}

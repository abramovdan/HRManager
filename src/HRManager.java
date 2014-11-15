import repository.DepartmentRepository;
import repository.EmployeeRepository;
import repository.JsonDepartmentRepository;
import repository.JsonEmployeeRepository;
import controllers.HomeController;


public class HRManager {
	public static void main(String[] args){
		DepartmentRepository departmentRepository = new JsonDepartmentRepository();
		EmployeeRepository employeeRepository = new JsonEmployeeRepository();
		HomeController homeController = new HomeController(employeeRepository, departmentRepository);
	}
}

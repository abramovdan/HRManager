package hrmanager.views.department;

import hrmanager.helpers.UUIDWrapper;
import hrmanager.models.Department;
import hrmanager.models.Employee;
import hrmanager.views.BaseView;

import java.util.Collection;

/**
 * Created by Dan on 02.12.2014.
 */
public class DepartmentsView extends BaseView {
    private Collection<Department> departments;
    private Collection<Employee> employees;

    public DepartmentsView(Collection<Department> departments, Collection<Employee> employees){
        this.departments = departments;
        this.employees = employees;
    }

    public void printDepartments(){
        showTitle();
        for (Department department : departments) {
            showDepartmentInfo(department);
        }
        printContinueMsg();
    }

    public void printNoDepartmentsMsg(){
        System.out.println("There are no added departments.");
        printContinueMsg();
    }

    private void showTitle(){
        System.out.printf("%-20s", "Department name");
        System.out.printf("%-20s", "Chief");
        System.out.println();
    }

    private void showDepartmentInfo(Department department){
        System.out.printf("%-20s", department.getName());
        System.out.printf("%-20s", getEmployeeNameById(department.getChiefId())); //TODO: show chief name here
        System.out.println();
    }

    private String getEmployeeNameById(UUIDWrapper id){
        if (id!=null) {
            for (Employee employee : employees) {
                if (employee.getId().equals(id)) return employee.getName();
            }
        }
        return "no chief";
    }
}

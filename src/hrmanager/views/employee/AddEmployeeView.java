package hrmanager.views.employee;


import hrmanager.views.BaseView;

public class AddEmployeeView extends BaseView {
	public void printEditEmployeeName() {
		System.out.println("Please enter employee name:");
	}

	public void printEditEmployeeSalary() {
		System.out.println("Please enter employee salary:");
	}

	public void printEditEmployeePhone() {
		System.out.println("Please enter employee phone number:");
	}

	public void printEditEmployeeDepartment() {
		System.out.println("Please enter employee department name:");
	}

	public void printNoSuchDepartmentWarnMsg(){
		System.out.println("There are no department with such name. The employee does not belong to any department");
	}
}

package hrmanager.views.employee;

import java.io.*;

import hrmanager.models.Employee;

public class EditEmployeeView extends AddEmployeeView {

	public void printEditTargetEmployeeName() {
		System.out.println("Please enter employee name for editing:");
	}

	public void printNoSuchEmployeeWarnMsg(){
		System.out.println("There are no employees with such name.");
		printContinueMsg();
	}
}

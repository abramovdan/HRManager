package hrmanager.views.employee;

import hrmanager.views.BaseView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteEmployeeView extends BaseView {
	public void printDeleteEmployeeName(){
		System.out.println("Please enter employee name to delete");
	}

	public void printNoSuchEmployeeWarnMsg(){
		System.out.println("There are no employees with such name.");
		printContinueMsg();
	}

	public void printOperationCompleted() {
		System.out.println("Delete operation was completed successfully.");
		printContinueMsg();
	}
}

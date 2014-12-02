package hrmanager.views.department;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import hrmanager.models.Department;
import hrmanager.views.BaseView;

public class AddDepartmentView extends BaseView {

	public void printEditDepartmentName() {
		System.out.println("Please enter department name");
	}

	public void printEditDepartmentChiefName() {
		System.out.println("Please enter department chief name");
	}
}

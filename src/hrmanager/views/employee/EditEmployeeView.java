package hrmanager.views.employee;

import java.io.*;

import hrmanager.models.Employee;

public class EditEmployeeView {
	private String name;
	private double salary;
	private String phoneNumber;
	private String departmentName;
	
	public EditEmployeeView(){
		try {
			getEmployeeName();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}

	public String getDepartment() {
		return departmentName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public double getSalary() {
		return salary;
	}
	
	public void getEmployeeDetails(){
		System.out.println("\n");
		System.out.println("Please enter employee name:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			name = br.readLine();
			System.out.println("Please enter employee salary:");
			salary = Double.parseDouble(br.readLine());
			System.out.println("Please enter employee phone number:");
			phoneNumber = br.readLine();
			System.out.println("Please enter employee department name:");
			departmentName = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getEmployeeName() throws IOException {
		System.out.println("\n");
		System.out.println("Please enter employee name, which you wanna to edit:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		name = br.readLine();
	}
	
	
}

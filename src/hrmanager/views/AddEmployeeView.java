package hrmanager.views;

import hrmanager.models.Department;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.UUID;


public class AddEmployeeView {
	private UUID id;
	private String name;
	private String departmentName;
	
	public AddEmployeeView(){
		try {
			getUserInput();
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

	private String phoneNumber;
	private double salary;

	private void getUserInput() throws IOException {
		System.out.println("\n");
		System.out.println("Please enter employee name:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		name = br.readLine();
		System.out.println("Please enter employee salary:");
		salary = Double.parseDouble(br.readLine());
		System.out.println("Please enter employee phone number:");
		phoneNumber = br.readLine();
		System.out.println("Please enter employee department name:");
		departmentName = br.readLine();
	}
}

package hrmanager.views.department;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import hrmanager.models.Department;

public class AddDepartmentView {
	private String name;
	private String chiefName;
	
	public AddDepartmentView() {
		try {
			getUserInput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getUserInput() throws IOException{
		System.out.println("\n");
		System.out.println("Please enter department name:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		name = br.readLine();
		System.out.println("Please enter chief name:");
		chiefName = br.readLine();
	}

	public String getName() {
		return name;
	}
	
	public String getChiefName() {
		return chiefName;
	}

}

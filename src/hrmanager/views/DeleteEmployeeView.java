package hrmanager.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteEmployeeView {
	private String employeeName;
	
	public DeleteEmployeeView(){
		try {
			getUserInput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName(){
		return employeeName;
	}
	
	private void getUserInput() throws IOException {
		System.out.println("\n");
		System.out.println("Please enter employee name to delete");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		employeeName = br.readLine();
	}
}

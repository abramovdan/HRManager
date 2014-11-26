package hrmanager.views;

import hrmanager.enums.Command;

import java.io.*;
import java.util.*;


public class HomeView {
	private Command command;
	private Map<String, Command> commandTable = new HashMap<String, Command>();
	
	public HomeView(){
		fillCommandTable();
		getUserCommand();
	}
	
	public Command getCommand(){
		return command;
	}
	
	private void getUserCommand(){
		System.out.println("Available commands:\n");
		for (String cmnd : commandTable.keySet()) {
			System.out.println(cmnd);
		}
		System.out.println("\nPlease enter your command\n");
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput = "";
		try {
			userInput = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        if (commandTable.containsKey(userInput)) {
        	command = commandTable.get(userInput);
		} else {
			command = null;
		}
	}
	
	private void fillCommandTable() {
		commandTable.put("showEmployees", command.SHOWEMPLOYEES);
		commandTable.put("addEmployee", command.ADDEMPLOYEE);
		commandTable.put("editEmployee", command.EDITEMPLOYEE);
		commandTable.put("deleteEmployee", command.DELETEEMPLOYEE);
		commandTable.put("findEmployee", command.FINDEMPLOYEE);
		commandTable.put("showDepartments", command.SHOWDEPARTMENTS);
		commandTable.put("addDepartment", command.ADDDEPARTMENT);
		commandTable.put("deleteDepartment", command.DELETEDEPARTMENT);
		commandTable.put("editDepartment", command.EDITDEPARTMENT);
		commandTable.put("findDepartment", command.FINDDEPARTMENT);
		commandTable.put("exit", command.EXIT);
	}
}

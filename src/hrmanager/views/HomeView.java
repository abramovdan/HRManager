package hrmanager.views;

import hrmanager.enums.Command;


public class HomeView {
	public static void printAvailableCommands() {
		System.out.println("Available commands:\n");
		for (Command c : Command.values()) {
			System.out.println(c.getInternalName());
		}
		System.out.println("\nPlease enter your command");
	}
}

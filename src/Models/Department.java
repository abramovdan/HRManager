package Models;

import java.util.UUID;

public class Department {
	private UUID id;
	private String name;
	private Employee chief;
	
	public Department() {
		id = UUID.randomUUID();
	}
	
	
}

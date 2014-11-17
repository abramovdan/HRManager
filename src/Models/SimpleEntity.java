package models;

import java.util.UUID;

public class SimpleEntity {
	private UUID Id;
	
	public SimpleEntity(){
		Id = UUID.randomUUID();
	}
	
	public UUID getId(){
		return Id;
	}
}

package models;

import java.util.UUID;

public class Department {
	private UUID id;
	private String name;
	private UUID chiefId;
	
	public Department() {
		id = UUID.randomUUID();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getChiefId() {
		return chiefId;
	}

	public void setChief(UUID chiefId) {
		this.chiefId = chiefId;
	}

	public UUID getId() {
		return id;
	}
}

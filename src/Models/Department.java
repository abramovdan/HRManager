package models;

import java.util.Collection;
import java.util.UUID;

import net.sf.json.JSON;
import repository.JsonSerializable;
import annotations.JsonDAO;
import annotations.JsonDependent;

@JsonDAO(path="/department/")

public class Department extends SimpleEntity implements JsonSerializable<Department>{
	private String name;
	private UUID chiefId;
	
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

	@Override
	public JSON toJSON() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Department> findByParent(UUID parentUUID) {
		// TODO Auto-generated method stub
		return null;
	}
}

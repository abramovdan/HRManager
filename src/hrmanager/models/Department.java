package hrmanager.models;

import java.util.UUID;

import repository.annotations.JsonDAO;
import repository.annotations.JsonDependent;

@JsonDAO(path="/department/")
@JsonDependent({Employee.class})
public class Department extends SimpleEntity {
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
	public UUID getParentId() {
		return null;
	}
}

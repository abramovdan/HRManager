package hrmanager.models;

import hrmanager.helpers.UUIDWrapper;
import repository.annotations.JsonDAO;
import repository.annotations.JsonDependent;

@JsonDAO(path="/department/")
@JsonDependent({Employee.class})
public class Department extends SimpleEntity {
	private String name;
	private UUIDWrapper chiefId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUIDWrapper getChiefId() {
		return chiefId;
	}

	public void setChief(UUIDWrapper chiefId) {
		this.chiefId = chiefId;
	}

	@Override
	public UUIDWrapper getParentId() {
		return null;
	}
}

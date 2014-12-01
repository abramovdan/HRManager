package hrmanager.enums;

public enum Command {
	ADDEMPLOYEE("addEmployee"),
	EDITEMPLOYEE("editEmployee"),
	SHOWEMPLOYEES("showEmployees"),
	DELETEEMPLOYEE("deleteEmployee"),
	FINDEMPLOYEE("findEmployee"),
	ADDDEPARTMENT("addDepartment"),
	EDITDEPARTMENT("editDepartment"),
	SHOWDEPARTMENTS("showDepartments"),
	DELETEDEPARTMENT("deleteDepartment"),
	FINDDEPARTMENT("findDepartment"),
	EXIT("exit");

	private String internalName;

	Command(String internalName) {
		this.internalName = internalName;
	}

	public String getInternalName() {
		return internalName;
	}

	public static Command fromString(String internalName) {
		for (Command c : Command.values()) {
			if (c.getInternalName().equals(internalName)) {
				return c;
			}
		}
		return null;
	}
}

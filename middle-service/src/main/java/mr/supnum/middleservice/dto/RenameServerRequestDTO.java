package mr.supnum.middleservice.dto;

public class RenameServerRequestDTO {
	private String newName;

	public RenameServerRequestDTO() {
	}

	public RenameServerRequestDTO(String newName) {
		this.newName = newName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}
}



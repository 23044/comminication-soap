package mr.supnum.middleservice.dto;

public class ServerDTO {
	private Long id;
	private String name;
	private String ipAddress;
	private Boolean running;

	public ServerDTO() {
	}

	public ServerDTO(Long id, String name, String ipAddress, Boolean running) {
		this.id = id;
		this.name = name;
		this.ipAddress = ipAddress;
		this.running = running;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Boolean getRunning() {
		return running;
	}

	public void setRunning(Boolean running) {
		this.running = running;
	}
}

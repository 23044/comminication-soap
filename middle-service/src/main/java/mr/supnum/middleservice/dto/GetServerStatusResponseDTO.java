package mr.supnum.middleservice.dto;

public class GetServerStatusResponseDTO {
    private Long id;
    private Boolean running;

    public GetServerStatusResponseDTO() {
    }

    public GetServerStatusResponseDTO(Long id, Boolean running) {
        this.id = id;
        this.running = running;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }
}

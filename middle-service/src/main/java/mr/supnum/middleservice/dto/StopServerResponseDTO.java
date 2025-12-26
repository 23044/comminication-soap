package mr.supnum.middleservice.dto;

public class StopServerResponseDTO {
    private ServerDTO server;

    public StopServerResponseDTO() {
    }

    public StopServerResponseDTO(ServerDTO server) {
        this.server = server;
    }

    public ServerDTO getServer() {
        return server;
    }

    public void setServer(ServerDTO server) {
        this.server = server;
    }
}

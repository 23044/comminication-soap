package mr.supnum.middleservice.dto;

public class StartServerResponseDTO {
    private ServerDTO server;

    public StartServerResponseDTO() {
    }

    public StartServerResponseDTO(ServerDTO server) {
        this.server = server;
    }

    public ServerDTO getServer() {
        return server;
    }

    public void setServer(ServerDTO server) {
        this.server = server;
    }
}

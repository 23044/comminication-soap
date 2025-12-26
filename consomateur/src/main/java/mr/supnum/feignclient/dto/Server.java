package mr.supnum.feignclient.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Server {
    private Long id;
    private String name;
    private String ipAddress;
    private Boolean running;
}
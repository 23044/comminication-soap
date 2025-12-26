package mr.supnum.feignclient.client;

import mr.supnum.feignclient.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "middle-service", url = "${middle.service.url}")
public interface ConsumateurClient {

    @PostMapping("/api/servers")
    Server createServer(@RequestBody CreateServerRequest request);

    @GetMapping("/api/servers")
    List<Server> getAllServers();

    @GetMapping("/api/servers/{id}/status")
    GetServerStatusResponse getServerStatus(@PathVariable("id") Long id);

    @PostMapping("/api/servers/{id}/start")
    StartServerResponse startServer(@PathVariable("id") Long id);

    @PostMapping("/api/servers/{id}/stop")
    StopServerResponse stopServer(@PathVariable("id") Long id);

    @PutMapping("/api/servers/{id}/rename")
    Server renameServer(@PathVariable("id") Long id, @RequestBody RenameServerRequest request);

    @DeleteMapping("/api/servers/{id}")
    void deleteServer(@PathVariable("id") Long id);
}

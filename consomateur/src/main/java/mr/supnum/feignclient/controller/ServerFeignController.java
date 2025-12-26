package mr.supnum.feignclient.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mr.supnum.feignclient.client.ConsumateurClient;
import mr.supnum.feignclient.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client/servers")
@Tag(name = "Server Management", description = "API pour gérer les serveurs via le middle-service")
public class ServerFeignController {

    private final ConsumateurClient consumateurClient;

    public ServerFeignController(ConsumateurClient consumateurClient) {
        this.consumateurClient = consumateurClient;
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau serveur", description = "Crée un serveur avec le nom et l'adresse IP fournis")
    public ResponseEntity<Server> createServer(@RequestBody CreateServerRequest request) {
        Server server = consumateurClient.createServer(request);
        return ResponseEntity.status(201).body(server);
    }

    @GetMapping
    public ResponseEntity<List<Server>> getAllServers() {
        List<Server> servers = consumateurClient.getAllServers();
        return ResponseEntity.ok(servers);
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<GetServerStatusResponse> getServerStatus(@PathVariable Long id) {
        GetServerStatusResponse response = consumateurClient.getServerStatus(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/start")
    public ResponseEntity<StartServerResponse> startServer(@PathVariable Long id) {
        StartServerResponse response = consumateurClient.startServer(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/stop")
    public ResponseEntity<StopServerResponse> stopServer(@PathVariable Long id) {
        StopServerResponse response = consumateurClient.stopServer(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/rename")
    public ResponseEntity<Server> renameServer(@PathVariable Long id, @RequestBody RenameServerRequest request) {
        Server server = consumateurClient.renameServer(id, request);
        return ResponseEntity.ok(server);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServer(@PathVariable Long id) {
        consumateurClient.deleteServer(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.SUPNUM_TD1_23044.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SUPNUM_TD1_23044.model.Server;
import com.example.SUPNUM_TD1_23044.service.ServerService;

import java.util.List;

@RestController
@RequestMapping("/api/servers")
public class ServerController {

    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @PostMapping
    public ResponseEntity<Server> createServer(@RequestBody Server server) {
        Server created = serverService.createServer(server);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Server> listServers() {
        return serverService.listServers();
    }

    @PatchMapping("/{id}/rename")
    public Server renameServer(@PathVariable Long id, @RequestParam String name) {
        return serverService.renameServer(id, name);
    }

    @GetMapping("/{id}/status")
    public Boolean getStatus(@PathVariable Long id) {
        return serverService.getServerStatus(id);
    }

    @PostMapping("/{id}/start")
    public Server startServer(@PathVariable Long id) {
        return serverService.startServer(id);
    }

    @PostMapping("/{id}/stop")
    public Server stopServer(@PathVariable Long id) {
        return serverService.stopServer(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServer(@PathVariable Long id) {
        serverService.deleteServer(id);
        return ResponseEntity.noContent().build();
    }
}
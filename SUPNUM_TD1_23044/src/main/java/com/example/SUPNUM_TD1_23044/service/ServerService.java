package com.example.SUPNUM_TD1_23044.service;

import org.springframework.stereotype.Service;

import com.example.SUPNUM_TD1_23044.exception.ServerNotFoundException;
import com.example.SUPNUM_TD1_23044.exception.ServerRunningException;
import com.example.SUPNUM_TD1_23044.model.Server;
import com.example.SUPNUM_TD1_23044.repository.ServerRepository;

import java.util.List;

@Service
public class ServerService {

    private final ServerRepository serverRepository;

    public ServerService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    public Server createServer(Server server) {
        server.setId(null);
        server.setStatus(server.getStatus());
        // server.setStatus(false);

        return serverRepository.save(server);
    }

    public List<Server> listServers() {
        return serverRepository.findAll();
    }

    public Server renameServer(Long id, String newName) {
        Server server = getServerById(id);
        server.setName(newName);
        return serverRepository.save(server);
    }

    public Boolean getServerStatus(Long id) {
        return getServerById(id).getStatus();
    }

    public Server startServer(Long id) {
        Server server = getServerById(id);
        server.setStatus(true);
        return serverRepository.save(server);
    }

    public Server stopServer(Long id) {
        Server server = getServerById(id);
        server.setStatus(false);
        return serverRepository.save(server);
    }

    public void deleteServer(Long id) {
        Server server = getServerById(id);
        if (Boolean.TRUE.equals(server.getStatus())) {
            throw new ServerRunningException(id);
        }
        serverRepository.delete(server);
    }

    private Server getServerById(Long id) {
        return serverRepository.findById(id)
                .orElseThrow(() -> new ServerNotFoundException(id));
    }
}

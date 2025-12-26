package com.example.SUPNUM_TD1_23044.soap;

import com.example.SUPNUM_TD1_23044.model.Server;
import com.example.SUPNUM_TD1_23044.service.ServerService;
import com.example.SUPNUM_TD1_23044.soap.dto.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class ServerEndpoint {

    private static final String NAMESPACE_URI = "http://supnum.com/server";

    private final ServerService serverService;

    public ServerEndpoint(ServerService serverService) {
        this.serverService = serverService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createServerRequest")
    @ResponsePayload
    public CreateServerResponse create(@RequestPayload CreateServerRequest request) {

        // System.out.println("SOAP CreateServerRequest -> name=" + request.getName()
        //         + ", ipAddress=" + request.getIpAddress());

        Server server = new Server();
        server.setName(request.getName());
        server.setIpAddress(request.getIpAddress());
        server.setStatus(request.getStatus());

        Server created = serverService.createServer(server);

        CreateServerResponse response = new CreateServerResponse();
        response.setServer(toSoap(created));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listServersRequest")
    @ResponsePayload
    public ListServersResponse list(@RequestPayload ListServersRequest request) {
        List<Server> servers = serverService.listServers();
        ListServersResponse response = new ListServersResponse();
        for (Server s : servers) {
            response.getServers().add(toSoap(s));
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getServerStatusRequest")
    @ResponsePayload
    public GetServerStatusResponse status(@RequestPayload GetServerStatusRequest request) {
        Boolean status = serverService.getServerStatus(request.getId());
        GetServerStatusResponse response = new GetServerStatusResponse();
        response.setStatus(status);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "startServerRequest")
    @ResponsePayload
    public StartServerResponse start(@RequestPayload StartServerRequest request) {
        Server started = serverService.startServer(request.getId());

        StartServerResponse response = new StartServerResponse();
        response.setServer(toSoap(started));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "stopServerRequest")
    @ResponsePayload
    public StopServerResponse stop(@RequestPayload StopServerRequest request) {
        Server stopped = serverService.stopServer(request.getId());
        StopServerResponse response = new StopServerResponse();
        response.setServer(toSoap(stopped));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "renameServerRequest")
    @ResponsePayload
    public RenameServerResponse rename(@RequestPayload RenameServerRequest request) {
        Server renamed = serverService.renameServer(request.getId(), request.getNewName());
        RenameServerResponse response = new RenameServerResponse();
        response.setServer(toSoap(renamed));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteServerRequest")
    @ResponsePayload
    public DeleteServerResponse delete(@RequestPayload DeleteServerRequest request) {
        serverService.deleteServer(request.getId());
        DeleteServerResponse response = new DeleteServerResponse();
        response.setSuccess(true);
        return response;
    }

    private ServerSoap toSoap(Server server) {
        ServerSoap soap = new ServerSoap();
        soap.setId(server.getId());
        soap.setName(server.getName());
        soap.setIpAddress(server.getIpAddress());
        soap.setStatus(Boolean.TRUE.equals(server.getStatus()));
        return soap;
    }
}

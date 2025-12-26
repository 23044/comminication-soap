package com.example.SUPNUM_TD1_23044.soap.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "startServerResponse", namespace = "http://supnum.com/server")
public class StartServerResponse {

    @XmlElement
    private ServerSoap server;

    public StartServerResponse() {
    }

    public ServerSoap getServer() {
        return server;
    }

    public void setServer(ServerSoap server) {
        this.server = server;
    }
}

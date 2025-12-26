package com.example.SUPNUM_TD1_23044.soap.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "stopServerResponse", namespace = "http://supnum.com/server")
public class StopServerResponse {

    @XmlElement
    private ServerSoap server;

    public StopServerResponse() {
    }

    public ServerSoap getServer() {
        return server;
    }

    public void setServer(ServerSoap server) {
        this.server = server;
    }
}

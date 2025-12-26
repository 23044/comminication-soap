package com.example.SUPNUM_TD1_23044.soap.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "renameServerResponse", namespace = "http://supnum.com/server")
public class RenameServerResponse {

    @XmlElement
    private ServerSoap server;

    public RenameServerResponse() {
    }

    public ServerSoap getServer() {
        return server;
    }

    public void setServer(ServerSoap server) {
        this.server = server;
    }
}

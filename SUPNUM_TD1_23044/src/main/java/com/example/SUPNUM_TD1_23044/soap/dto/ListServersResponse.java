package com.example.SUPNUM_TD1_23044.soap.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "listServersResponse", namespace = "http://supnum.com/server")
public class ListServersResponse {

    @XmlElement(name = "servers")
    private List<ServerSoap> servers = new ArrayList<>();

    public ListServersResponse() {
    }

    public List<ServerSoap> getServers() {
        return servers;
    }
}

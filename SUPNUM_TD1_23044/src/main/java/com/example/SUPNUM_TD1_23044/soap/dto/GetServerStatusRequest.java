package com.example.SUPNUM_TD1_23044.soap.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getServerStatusRequest", namespace = "http://supnum.com/server")
public class GetServerStatusRequest {

    private Long id;

    public GetServerStatusRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

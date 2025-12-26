package com.example.SUPNUM_TD1_23044.soap.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getServerStatusResponse", namespace = "http://supnum.com/server")
public class GetServerStatusResponse {

    private Boolean status;

    public GetServerStatusResponse() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

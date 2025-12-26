package com.example.SUPNUM_TD1_23044.exception;

public class ServerRunningException extends RuntimeException {
    public ServerRunningException(Long id) {
        super("Cannot delete server " + id + " because it is running");
    }
}

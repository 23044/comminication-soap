package com.example.SUPNUM_TD1_23044.exception;

public class ServerNotFoundException extends RuntimeException {
    public ServerNotFoundException(Long id) {
        super("Server not found with id " + id);
    }
}

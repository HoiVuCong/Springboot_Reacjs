package com.vchoi.springboot.exceptionhandler;

public class EntityNotFoundException extends RuntimeException {
    private String name;

    public EntityNotFoundException(String message) {
        super(message);
    }
    public EntityNotFoundException(String message, String name) {
        super(message);
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}

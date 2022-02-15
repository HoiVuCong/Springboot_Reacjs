package com.vchoi.springboot.exceptionhandler;

import lombok.Data;


public class TeacherNotFoundException extends RuntimeException {
    private String name;

    public TeacherNotFoundException(String message) {
        super(message);
    }
    public TeacherNotFoundException(String message, String name) {
        super(message);
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}

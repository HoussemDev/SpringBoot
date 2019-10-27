package com.houssem.springboot.tuto.error;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ErrorDetails {
    private String message;


    public ErrorDetails(){

    }
    public ErrorDetails(String message, String uri) {
        this();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}

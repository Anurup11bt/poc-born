package com.born.techmahindra.model;

public class Response {
    private String message;
    private Boolean status;

    public Response(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
}

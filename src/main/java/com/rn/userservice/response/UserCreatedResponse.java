package com.rn.userservice.response;

import java.net.URI;

public class UserCreatedResponse {

    private String message;
    private URI path;

    public UserCreatedResponse() {
    }

    public UserCreatedResponse(String message, URI path) {
        this.message = message;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public URI getPath() {
        return path;
    }

    public void setPath(URI path) {
        this.path = path;
    }
}

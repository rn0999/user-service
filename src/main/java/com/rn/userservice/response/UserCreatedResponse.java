package com.rn.userservice.response;

import java.net.URI;

public class UserCreatedResponse {

    private Integer userId;
    private String message;
//    private URI path;

    public UserCreatedResponse() {
    }

//    public UserCreatedResponse(Integer userId, String message, URI path) {
//        this.userId = userId;
//        this.message = message;
//        this.path = path;
//    }


    public UserCreatedResponse(Integer userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public URI getPath() {
//        return path;
//    }
//
//    public void setPath(URI path) {
//        this.path = path;
//    }
}

package com.bouali.oauth2.social.dto;

public class AuthResponseDto {
    private Boolean success;
    private String message;
//    private String tokenType;
    private String accessToken;
//    private String refreshToken;
    private String email;

    private String name;
//    private String userId;
//    private String[] scopes;
//    private String grantType;
//    private String oAuthId; // ?


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

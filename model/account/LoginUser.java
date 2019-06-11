package com.example.water.marketplace.model.account;

/**
 * Created by water on 16.10.2017.
 */

public class LoginUser {
    public LoginUser(String id_user, String nickname_user, String email_user, String token) {
        this.id_user = id_user;
        this.nickname_user = nickname_user;
        this.email_user = email_user;
        this.token = token;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNickname_user() {
        return nickname_user;
    }

    public void setNickname_user(String nickname_user) {
        this.nickname_user = nickname_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String id_user;
    private String nickname_user;
    private String email_user;
    private String token;
}

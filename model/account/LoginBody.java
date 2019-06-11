package com.example.water.marketplace.model.account;

import com.google.gson.annotations.SerializedName;

/**
 * Created by water on 16.10.2017.
 */

public class LoginBody {
    @SerializedName("id_user")
    private String id_user;
    private String password;

    public LoginBody(String id_user, String password) {
        this.id_user = id_user;
        this.password = password;
    }

    public String getUserId() {
        return id_user;
    }

    public void setUserId(String userId) {
        this.id_user = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.example.water.marketplace.model.error;

/**
 * Created by water on 16.10.2017.
 */

public class ErrorApi {
    public ErrorApi(int status, int code, String message, String moreInfo, String developerMessage) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.moreInfo = moreInfo;
        this.developerMessage = developerMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    private int status;
    private int code;
    private String message;
    private String moreInfo;
    private String developerMessage;
}

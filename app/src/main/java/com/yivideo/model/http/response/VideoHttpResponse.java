package com.yivideo.model.http.response;

/**
 * Created by codeest on 16/8/28.
 */

public class VideoHttpResponse<T> {

    private int status;
    private String message;
    T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

package com.example.schoolmanagement_01.core.dto;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

    private Integer status;

    private String data;

    private String message;


    public ResponseDTO(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseDTO() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

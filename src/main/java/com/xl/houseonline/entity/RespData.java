package com.xl.houseonline.entity;

public class RespData {
    private Integer status;
    private String message;
    private Object data;

    public RespData() {
    }

    public RespData(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public  static RespData success(String message){return new RespData(200,message,null);}
    public static RespData success(String message,Object data){return new RespData(200,message,data);}
    public  static RespData fail(String message){return new RespData(500,message,null);}
    public static RespData fail(String message,Object data){return new RespData(500,message,data);}

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

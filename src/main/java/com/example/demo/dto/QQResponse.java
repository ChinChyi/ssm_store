package com.example.demo.dto;

/**
 * @program: demo
 * @description: 前后端消息
 * @author: Mr.Qin
 * @create: 2019-12-09 22:41
 **/

public class QQResponse {

    private int code;
    private String message;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private QQResponse(){}

    public static QQResponse ok(Object data){
        QQResponse qqResponse=new QQResponse();
        qqResponse.setCode(0);
        qqResponse.setData(data);
        return qqResponse;
    }

    public static QQResponse ok(){
        return ok(null);
    }

    public static QQResponse fail(int code,String message){
        QQResponse qqResponse=new QQResponse();
        if(code==0){
            code=-1;
        }
        qqResponse.setCode(code);
        qqResponse.setMessage(message);
        return qqResponse;
    }
}

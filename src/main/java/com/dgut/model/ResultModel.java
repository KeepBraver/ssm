package com.dgut.model;

public class ResultModel {
    private Integer code;
    private Long count;
    private String message;
    private Object data;
    public ResultModel(){
        code = 0;
        count = 0L;
        message = "";
        data = "";
    }

    public ResultModel(Integer code) {
        count = 0L;
        this.code = code;
        this.data = "";
        this.message = "";
    }
    public ResultModel(Long count) {
        this.count = count;
        this.code = 0;
        this.data = "";
        this.message = "";
    }
    public ResultModel(String message) {
        count = 0L;
        code = 0;
        data = "";
        this.message = message;
    }
    public ResultModel(Object data) {
        count = 0L;
        code = 0;
        this.message = "";
        this.data = data;
    }

    public ResultModel(Integer code, Long count) {
        this.code = code;
        this.count = count;
        this.message = "";
        this.data = "";
    }
    public ResultModel(Integer code, String message) {
        this.code = code;
        this.count = 0L;
        this.message = message;
        this.data = "";
    }
    public ResultModel(Integer code, Object data) {
        this.code = code;
        this.count = 0L;
        this.message = "";
        this.data = data;
    }
    public ResultModel(Long count, String message) {
        this.count = count;
        this.code = 0;
        this.data = "";
        this.message = message;
    }

    public ResultModel(Long count, Object data) {
        this.count = count;
        this.code = 0;
        this.data = data;
        this.message = "";
    }
    public ResultModel(String message, Object data) {
        this.count = 0L;
        this.code = 0;
        this.data = data;
        this.message = message;
    }

    public ResultModel(Integer code, Long count, String message) {
        this.code = code;
        this.count = count;
        this.message = message;
        this.data = "";
    }

    public ResultModel(Integer code, Long count, Object data) {
        this.code = code;
        this.count = count;
        this.data = data;
        this.message = "";
    }

    public ResultModel(Long count, String message, Object data) {
        code = 0;
        this.count = count;
        this.message = message;
        this.data = data;
    }

    public ResultModel(Integer code, Long count, String message, Object data) {
        this.code = code;
        this.count = count;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
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

    @Override
    public String toString() {
        return "ResultModel{" +
                "code=" + code +
                ", count=" + count +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

package com.hong.library.okhttp;


/**
 * 服务器异常信息类
 */
public class ApiException extends RuntimeException {
    //异常码

    private int code;
    //异常信息
    private String msg;

    public ApiException() {
    }

    public ApiException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.code = errorCode;
        this.msg = errorMessage;
    }

    public int getErrorCode() {
        return code;
    }

    public void setErrorCode(int errorCode) {
        this.code = errorCode;
    }

    public String getErrorMsg() {
        return msg;
    }

    public void setErrorMsg(String errorMsg) {
        this.msg = errorMsg;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "errorCode=" + code +
                ", errorMsg='" + msg + '\'' +
                '}';
    }
}

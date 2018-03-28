package com.xprogect.api.init;

/**
 * @param <T> 基类的解析工厂
 */
public class BeanFactory<T> {
    private String message;
    private T result;
    private int status;
    private long ts;

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public T getData() {
        return result;
    }

    public void setData(T data) {
        this.result = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "BeanFactory{" +
                "msg='" + message + '\'' +
                ", data=" + result +
                ", status=" + status +
                ", ts=" + ts +
                '}';
    }
}

package com.xprogect.api.init;

/**
 * @param <T> 基类的解析工厂
 */
public class BeanFactory<T> {
    private String info;
    private T list;
    private int status;
    private long ts;

    public String getMsg() {
        return info;
    }

    public void setMsg(String msg) {
        this.info = msg;
    }

    public T getData() {
        return list;
    }

    public void setData(T data) {
        this.list = data;
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
                "msg='" + info + '\'' +
                ", data=" + list +
                ", status=" + info +
                ", ts=" + ts +
                '}';
    }
}

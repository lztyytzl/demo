package com.lyj.manage.entity;

public class Code {
    private int code;
    private Object result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Code(int code, Object result) {
        this.code = code;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Code{" +
                "code=" + code +
                ", result=" + result +
                '}';
    }
}

package com.lyj.manage.entity;

public class Code {
    private int code;
    private String result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Code(int code, String result) {
        this.code = code;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Code{" +
                "code=" + code +
                ", result='" + result + '\'' +
                '}';
    }
}

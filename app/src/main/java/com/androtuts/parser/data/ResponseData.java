package com.androtuts.parser.data;

public class ResponseData {
    private String cod;
    private long message;
    private int cnt;

    public ResponseData() {
    }

    public ResponseData(String cod, long message, int cnt) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public long getMessage() {
        return message;
    }

    public void setMessage(long message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}

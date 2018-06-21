package com.miaodiyun.huiDiao.entity;

public class MoNoticeReq {
    private String MOPort;
    private String phone;
    private String content;
    private String MOTime;
    private String timestamp;
    private String sig;

    public String getMOPort() {
        return MOPort;
    }

    public void setMOPort(String MOPort) {
        this.MOPort = MOPort;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMOTime() {
        return MOTime;
    }

    public void setMOTime(String MOTime) {
        this.MOTime = MOTime;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }
}

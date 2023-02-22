package org.example.model;

public class Message {
    private String mess;
    private int status;

    public Message(String mess, int status) {
        this.mess = mess;
        this.status = status;
    }

    public Message(String mess) {
        this.mess = mess;
    }

    public Message(int status) {
        this.status = status;
    }


    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

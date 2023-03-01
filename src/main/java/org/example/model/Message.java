package org.example.model;

import java.io.Serializable;
import java.util.UUID;

public class Message implements Serializable {
    private String mess;
    private int status;
    private UUID id;

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;

    public Message(String mess, int status) {
        this.mess = mess;
        this.status = status;
        this.id = UUID.randomUUID();
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

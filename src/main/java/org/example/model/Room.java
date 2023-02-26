package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Room implements Serializable {
    public Room(String name, int type, String location) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.id = UUID.randomUUID();
        this.status = 1;
        this.date = "";
        this.userOrder = "";
        this.lessons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    private int status;
    private String name;
    private int type;
    private String location;

    public String getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(String userOrder) {
        this.userOrder = userOrder;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String userOrder;
    private String date;

    public List<String> getLessons() {
        return lessons;
    }

    public void setLessons(List<String> lessons) {
        this.lessons = lessons;
    }

    private List<String> lessons;
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private UUID id;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

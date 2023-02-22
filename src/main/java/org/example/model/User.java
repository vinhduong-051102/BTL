package org.example.model;

import java.util.UUID;

public class User {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    UUID id;
    String name;
    String role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;
    public User(String name, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.role = "user";
        this.password = password;
    }

}

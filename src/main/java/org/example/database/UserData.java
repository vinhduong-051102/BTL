package org.example.database;

import org.example.model.Message;
import org.example.model.User;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserData {
    private List<User> db = new ArrayList<>();

    public UserData() {
        db.add(new User("admin", "admin"));
    }

    public Message addUser(@NotNull User user) {
        if (!user.getName().isEmpty() && !user.getPassword().isEmpty()) {
            db.add(new User(user.getName(), user.getPassword()));
            return new Message("Đăng ký thành công", 1);
        }
        return new Message("Đăng ký thất bại", 0);
    }

    public User getUser(@NotNull User user) {
        if (!user.getName().isEmpty() && !user.getPassword().isEmpty()) {
            for (User u :
                    db) {
                if (u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword())) {
                    return u;
                }
            }
        }
        return null;
    }
}

package org.example.database;

import org.example.model.Message;
import org.example.model.User;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class UserData {
    private List<User> db = new ArrayList<>();

    public UserData() {
        db.add(new User("admin", "admin"));
    }

    public Message addUser(@NotNull User user) {
        int flag = 0;
        if (!user.getName().isEmpty() && !user.getPassword().isEmpty()) {
            for (User u :
                    db) {
                if (u.getName().equals(user.getName())) {
                    flag = 1;
                }
            }
            if(flag == 0) {
                db.add(new User(user.getName(), user.getPassword()));
                return new Message("Đăng ký thành công", 1);
            }
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
    public User getUserById(UUID id) {
        for (User u: db) {
            if(u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }
}

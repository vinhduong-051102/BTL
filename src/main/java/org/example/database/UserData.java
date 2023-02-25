package org.example.database;

import org.example.model.Message;
import org.example.model.User;
import org.example.service.UserFIleService;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserData {
  private final List<User> db = new ArrayList<>();
  private final UserFIleService userFIleService;

  public UserData() throws IOException, ClassNotFoundException {
    int flag = 0;
    userFIleService = new UserFIleService();
    List<User> dataGetFromFile = (List<User>) userFIleService.readFile();
    dataGetFromFile.forEach(data -> {
      db.add(data);
    });
    for (User u :
            db) {
        if (u.getName().equals("admin") && u.getPassword().equals("admin")) {
            flag = 1;
            break;
        }
    }
    if (flag == 0) {
      db.add(new User("admin", "admin"));
      userFIleService.writeToFile(db);
    }
  }

  public Message addUser(@NotNull User user) throws IOException {
    int flag = 0;
    if (!user.getName().isEmpty() || !user.getPassword().isEmpty()) {
      for (User u :
              db) {
          if (u.getName().equals(user.getName())) {
              flag = 1;
              break;
          }
      }
      if (flag == 0) {
        db.add(new User(user.getName(), user.getPassword()));
        userFIleService.writeToFile(db);
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
    for (User u : db) {
      if (u.getId().equals(id)) {
        return u;
      }
    }
    return null;
  }
}

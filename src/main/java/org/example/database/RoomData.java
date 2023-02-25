package org.example.database;

import org.example.model.Message;
import org.example.model.Room;
import org.example.model.User;
import org.example.service.RoomFileService;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomData {
    private List<Room> db = new ArrayList<>();
    private RoomFileService roomFileService;

    public RoomData() throws IOException, ClassNotFoundException {
        roomFileService = new RoomFileService();
        List<Room> dataGetFromFile = (List<Room>) roomFileService.readFile();
        dataGetFromFile.forEach(data -> db.add(data));
    }
    public Message addRoom(@NotNull Room room) throws IOException {
        int flag = 0;
        if (!room.getName().isEmpty()) {
            for (Room r :
                    db) {
                if (r.getName().equals(room.getName()) && r.getLocation().equals(room.getLocation())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                db.add(new Room(room.getName(), room.getType(), room.getLocation()));
                roomFileService.writeToFile(db);
                return new Message("Thêm phòng thành công", 1);
            }
        }
        return new Message("Thêm phòng thất bại", 0);
    }
    public List<Room> getAll() {
        return db;
    }
    public List<Room> getByCondition(String name, int type, int status) {
        List<Room> re = new ArrayList<>();
        db.stream().filter(room -> {
            if(name.isEmpty() && type != 0 && status != 0) {
                return room.getType() == type && room.getStatus() == status;
            }
            else if(name.isEmpty() && type == 0) {
                return room.getStatus() == status;
            } else if (name.isEmpty() && status == 0) {
                return room.getType() == type;
            } else if (type == 0 && status == 0) {
                return room.getName().equals(name);
            } else if (type == 0) {
                return room.getName().equals(name) && room.getStatus() == status;
            } else if (status == 0) {
                return room.getName().equals(name) && room.getType() == type;
            }
            return room.getName().equals(name) && room.getType() == type && room.getStatus() == status;
        }).forEach(room -> {
            re.add(room);
        });
        return re;
    }
}

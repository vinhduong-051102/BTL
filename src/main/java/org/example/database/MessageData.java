package org.example.database;

import org.example.CommonVariable;
import org.example.model.Message;
import org.example.service.MessageFileService;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MessageData {
    private List<Message> db = new ArrayList<>();
    private MessageFileService messageFileService;
    public MessageData(@NotNull CommonVariable commonVariable) throws IOException, ClassNotFoundException {
        messageFileService = new MessageFileService();
        List<Message> dataGetFromFile = (List<Message>) messageFileService.readFile();
        dataGetFromFile.forEach(data -> db.add(data));
        commonVariable.setListMessage(db);
    }
    public void addMessage(Message message) throws IOException {
        db.add(message);
        messageFileService.writeToFile(db);
    }
    public void deleteMessage(UUID id) throws IOException {
        db.stream().filter(mess -> mess.getId().equals(id)).forEach(mess -> {
            mess.setStatus(0);
        });
        messageFileService.writeToFile(db);
    }
    public List<Message> getMessByUserName(String name) {
        List<Message> re = new ArrayList<>();
        db.stream().filter(mess -> mess.getUserName().equals(name)).forEach(mess -> re.add(mess));
        return re;
    }
}

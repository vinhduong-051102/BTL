package org.example;

import org.example.model.Message;

import java.util.ArrayList;
import java.util.List;

public class CommonVariable {
    private List<Message> listMessage;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
    public List<Message> getListMess(String name) {
        List<Message> re = new ArrayList<>();
        listMessage.stream().filter(mess -> mess.getUserName().equals(name)).forEach(mess -> re.add(mess));
        return re;
    }
    public void setListMessage(List<Message> listMessage) {
        this.listMessage = listMessage;
    }
}

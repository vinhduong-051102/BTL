package org.example;

import org.example.controller.CommonController;
import org.example.database.MessageData;
import org.example.database.RoomData;
import org.example.database.UserData;
import org.example.view.AdminUI;
import org.example.view.LoginAndRegisterUI;
import org.example.view.UserUI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserData userData = new UserData();
        RoomData roomData = new RoomData();
        CommonVariable commonVariable = new CommonVariable();
        MessageData messageData = new MessageData(commonVariable);
        CommonController commonController = new CommonController();

        new LoginAndRegisterUI(userData, commonVariable, commonController);
        new AdminUI(userData, commonVariable, commonController, roomData, messageData);
        new UserUI(roomData, commonController, commonController, commonVariable, messageData);
    }
}
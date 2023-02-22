package org.example;

import org.example.controller.CommonController;
import org.example.database.UserData;
import org.example.view.AdminUI;
import org.example.view.LoginAndRegisterUI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UserData userData = new UserData();
        CommonVariable commonVariable = new CommonVariable();
        CommonController commonController = new CommonController();
        new LoginAndRegisterUI(userData, commonVariable, commonController);
        new AdminUI(userData, commonVariable, commonController);
    }
}
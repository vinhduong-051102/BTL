package org.example;

import javax.swing.*;
import java.util.UUID;

public class CommonVariable {
    //new

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
    public void openFrame(JFrame frame) {
        frame.setVisible(true);
    }
}

package org.example;

import javax.swing.*;
import java.util.UUID;

public class CommonVariable {
    public UUID getIdUserLogin() {
        return idUserLogin;
    }

    public void setIdUserLogin(UUID idUserLogin) {
        this.idUserLogin = idUserLogin;
    }

    private UUID idUserLogin;
    public void openFrame(JFrame frame) {
        frame.setVisible(true);
    }
}

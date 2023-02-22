package org.example.controller;

import org.example.view.AdminUI;
import org.example.view.LoginAndRegisterUI;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommonController implements ActionListener {
    private LoginAndRegisterUI loginAndRegister;
    private AdminUI admin;

    public LoginAndRegisterUI getLoginAndRegister() {
        return loginAndRegister;
    }

    public void setLoginAndRegister(LoginAndRegisterUI loginAndRegister) {
        this.loginAndRegister = loginAndRegister;
    }

    public AdminUI getAdmin() {
        return admin;
    }

    public void setAdmin(AdminUI admin) {
        this.admin = admin;
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        if(e.getActionCommand().equals("loginAction") || e.getActionCommand().equals("dialogButtonAction")) {
            loginAndRegister.login();
            loginAndRegister.setVisible(false);
            admin.setVisible(true);
        }
        else {
            loginAndRegister.register();
        }
    }
}

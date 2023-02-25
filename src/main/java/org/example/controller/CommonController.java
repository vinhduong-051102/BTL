package org.example.controller;

import org.example.model.User;
import org.example.view.AdminUI;
import org.example.view.LoginAndRegisterUI;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
            User user = loginAndRegister.login();
            if(user != null) {
                loginAndRegister.setVisible(false);
                if(user.getName().equals("admin")) {
                    admin.setVisible(true);
                }
            }
        }
        else if(e.getActionCommand().equals("registerAction")) {
            try {
                loginAndRegister.register();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(e.getActionCommand().equals("addNewClassAction")) {
            admin.openModalAddNewClass();
        }
        else if(e.getActionCommand().equals("submitFormAddNewClass")) {
            try {
                admin.addNewClass();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand().equals("searchAction")) {
            admin.searchRoom();
        }

    }
}

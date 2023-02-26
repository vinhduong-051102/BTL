package org.example.controller;

import org.example.model.User;
import org.example.view.AdminUI;
import org.example.view.LoginAndRegisterUI;
import org.example.view.UserUI;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CommonController implements ActionListener {
    private LoginAndRegisterUI loginAndRegister;
    private AdminUI admin;

    private UserUI userUI;

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
                    loginAndRegister.resetField();
                }
                else {
                    userUI.setVisible(true);
                    loginAndRegister.resetField();
                }
            }
        }
        if(e.getActionCommand().equals("registerAction")) {
            try {
                loginAndRegister.register();
                loginAndRegister.resetField();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getActionCommand().equals("addNewClassAction")) {
            admin.openModalAddNewClass();
        }
        if(e.getActionCommand().equals("submitAddNewClassAction")) {
            try {
                admin.addNewClass();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getActionCommand().equals("searchAction")) {
            admin.searchRoom();
        }
        if (e.getActionCommand().equals("searchUserUIAction")) {
            userUI.searchRoom();
        }
        if (e.getActionCommand().equals("resetFilterUserUIAction")) {
            userUI.resetFilter();
            userUI.searchRoom();
        }
        if (e.getActionCommand().equals("logoutUserUIAction")) {
            userUI.dispose();
            loginAndRegister.setVisible(true);
        }
        if (e.getActionCommand().equals("logoutAdminUIAction")) {
            admin.dispose();
            loginAndRegister.setVisible(true);
        }
        if (e.getActionCommand().equals("resetFilterAdminUIAction")) {
            admin.resetFilter();
            admin.searchRoom();
        }
        if (e.getActionCommand().equals("submitMenuItemAction")) {
            int rowSelect = admin.getRowSelect();
            if(rowSelect != -1) {
                try {
                    admin.submitClass(rowSelect);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
        if (e.getActionCommand().equals("deleteMenuItemAction")) {
            int rowSelect = admin.getRowSelect();
            if(rowSelect != -1) {
                try {
                    admin.deleteClass(rowSelect);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
        if (e.getActionCommand().equals("editMenuItemAction")) {
            int rowSelect = admin.getRowSelect();
            if(rowSelect != -1) {
                admin.editClass(rowSelect);
            }
        }
        if(e.getActionCommand().equals("submitEditClassAction")) {
            try {
                admin.submitEdit();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getActionCommand().equals("orderMenuItemAction")) {
            userUI.openModalOrderClass();
        }
        if (e.getActionCommand().equals("submitOrderClass")) {
            try {
                userUI.submitOrderClass();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public UserUI getUserUI() {
        return userUI;
    }

    public void setUserUI(UserUI userUI) {
        this.userUI = userUI;
    }
}

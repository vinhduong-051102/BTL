package org.example.view;

import org.example.CommonVariable;
import org.example.controller.CommonController;
import org.example.database.MessageData;
import org.example.database.UserData;
import org.example.model.Message;
import org.example.model.User;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class LoginAndRegisterUI extends JFrame {
    private final CommonVariable commonVariable;
    private final UserData userData;
    private final ActionListener ac;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel passwordLabel;
    private JPasswordField passwordTextField;
    private javax.swing.JButton registerBtn;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    public LoginAndRegisterUI(UserData userData, CommonVariable commonVariable, @NotNull CommonController ac) {
        this.ac = ac;
        ac.setLoginAndRegister(this);
        this.commonVariable = commonVariable;
        this.userData = userData;
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        setLocationRelativeTo(null);
        userNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        registerBtn = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        userNameLabel.setText("Tên đăng nhập");
        passwordLabel.setText("Mật khẩu");
        loginBtn.setText("Đăng nhập");
        loginBtn.addActionListener(ac);
        loginBtn.setActionCommand("loginAction");
        registerBtn.setText("Đăng ký");
        registerBtn.addActionListener(ac);
        registerBtn.setActionCommand("registerAction");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(userNameLabel)
                                        .addComponent(passwordLabel))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(loginBtn)
                                                .addGap(60, 60, 60)
                                                .addComponent(registerBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userNameLabel))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginBtn)
                                        .addComponent(registerBtn))
                                .addContainerGap(182, Short.MAX_VALUE))
        );

        pack();
    }

    public User login() {
        User user = userData.getUser(new User(userNameTextField.getText(), String.valueOf(passwordTextField.getPassword())));
        if (user != null) {
            new DialogWithoutAction(this, "Đăng nhập thành công", true);
            commonVariable.setUserName(user.getName());
        } else {
            new DialogWithoutAction(this, "Đăng nhập thất bại", true);
        }
        return user;
    }

    public void register() throws IOException {
        Message message = userData.addUser(new User(userNameTextField.getText(), String.valueOf(passwordTextField.getPassword())));
        if (message.getStatus() == 1) {
            new DialogWithAction(this, true, message.getMess(), "Đăng nhập", ac);
        } else {
            new DialogWithoutAction(this, message.getMess(), true);
        }
    }
    public void resetField() {
        userNameTextField.setText("");
        passwordTextField.setText("");
    }
    public List<Message> getListMess(String name) {
        return commonVariable.getListMess(name);
    }
}

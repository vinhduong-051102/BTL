package org.example.view;

import org.example.CommonVariable;
import org.example.controller.CommonController;
import org.example.database.UserData;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AdminUI extends JFrame {
    private UserData userData;
    private CommonVariable commonVariable;
    private ActionListener ac;

    public AdminUI(UserData userData, CommonVariable commonVariable, CommonController ac) {
        this.ac = ac;
        ac.setAdmin(this);
        this.commonVariable = commonVariable;
        this.userData = userData;
        initComponents();

    }
    private void initComponents() {
        setLocationRelativeTo(null);
        searchLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        allClass = new javax.swing.JRadioButton();
        type_1 = new javax.swing.JRadioButton();
        type_2 = new javax.swing.JRadioButton();
        classLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        deActive = new javax.swing.JRadioButton();
        active = new javax.swing.JRadioButton();
        searchBtn = new javax.swing.JButton();
        sp = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        allStatus = new javax.swing.JRadioButton();
        addBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchLabel.setText("Tìm kiếm");

        allClass.setText("Tất cả ");
        allClass.setActionCommand("1");

        type_1.setText("Phòng lý thuyết");
        type_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_1ActionPerformed(evt);
            }
        });

        type_2.setText("Phòng thực hành");

        classLabel.setText("Loại phòng");

        statusLabel.setText("Trạng thái");

        deActive.setText("Chưa mượn");
        deActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deActiveActionPerformed(evt);
            }
        });

        active.setText("Đã mượn");

        searchBtn.setText("Tìm kiếm");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String [] {
                        "Số phòng", "Loại phòng", "Trạng thái"
                }
        ));
        sp.setViewportView(jTable1);

        allStatus.setText("Tất cả");


        addBtn.setText("Thêm mới phòng học");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(40, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(classLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addGap(44, 44, 44))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(allClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(allStatus)
                                                                                                .addGap(18, 18, 18))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(6, 6, 6)))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(active)
                                                                                .addGap(54, 54, 54)
                                                                                .addComponent(deActive))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(type_1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(type_2)))))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchLabel)
                                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(allClass)
                                        .addComponent(type_1)
                                        .addComponent(type_2)
                                        .addComponent(classLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(statusLabel)
                                        .addComponent(deActive)
                                        .addComponent(active)
                                        .addComponent(allStatus))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void type_1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void deActiveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void allStatusActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }




    private javax.swing.JRadioButton active;
    private javax.swing.JButton addBtn;
    private javax.swing.JRadioButton allClass;
    private javax.swing.JRadioButton allStatus;
    private javax.swing.JLabel classLabel;
    private javax.swing.JRadioButton deActive;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JScrollPane sp;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JRadioButton type_1;
    private javax.swing.JRadioButton type_2;
}




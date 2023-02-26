package org.example.view;

import java.awt.event.ActionListener;

public class DialogWithAction extends javax.swing.JDialog {
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify
    private javax.swing.JButton button;
    private javax.swing.JLabel label;

    public DialogWithAction(java.awt.Frame parent, boolean modal, String title, String labelBtn, ActionListener ac) {
        super(parent, modal);
        initComponents();
        label.setText(title);
        button.setText(labelBtn);
        button.addActionListener(ac);
        button.setActionCommand("dialogButtonAction");
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setLocationRelativeTo(null);
        label = new javax.swing.JLabel();
        button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("\"Thông báo\"");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button)
                                        .addComponent(label))
                                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(label)
                                .addGap(32, 32, 32)
                                .addComponent(button)
                                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    // End of variables declaration
    public void close() {
        dispose();
    }
}

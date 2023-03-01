package org.example.view;

import org.example.model.Room;

import java.awt.event.ActionListener;

public class SubmitClassModal extends javax.swing.JDialog {
    private Room room;
    private ActionListener ac;
    /**
     * Creates new form SubmitClassModal
     */
    public SubmitClassModal(java.awt.Frame parent, boolean modal, ActionListener ac, Room room) {
        super(parent, modal);
        this.ac = ac;
        this.room = room;
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        usernameLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        lessonsLabel = new javax.swing.JLabel();
        lessons = new javax.swing.JLabel();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Giao diện xác nhận phòng");

        usernameLabel.setText("Tên người đăng kí");

        dateLabel.setText("Ngày đăng kí");

        username.setText(room.getUserOrder());

        date.setText(room.getDate());

        submitBtn.setText("Xác nhận");
        submitBtn.setActionCommand("submitClassModalAction");
        submitBtn.addActionListener(ac);
        cancelBtn.setText("Huỷ xác nhận");
        cancelBtn.setActionCommand("cancelClassModalAction");
        cancelBtn.addActionListener(ac);

        lessonsLabel.setText("Tiết đăng kí");

        lessons.setText(room.toStringLessons());

        title.setText(room.getName() + " - " + room.toStringType() + " - " + room.getLocation());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(usernameLabel)
                                                .addGap(42, 42, 42)
                                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(64, 64, 64)
                                                .addComponent(submitBtn)
                                                .addGap(73, 73, 73)
                                                .addComponent(cancelBtn))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(lessonsLabel)
                                                        .addGap(81, 81, 81)
                                                        .addComponent(lessons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(dateLabel)
                                                        .addGap(72, 72, 72)
                                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(100, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(title)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameLabel)
                                        .addComponent(username))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLabel)
                                        .addComponent(date))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lessonsLabel)
                                        .addComponent(lessons))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>



    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel date;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel lessonsLabel;
    private javax.swing.JLabel lessons;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel title;
    private javax.swing.JLabel username;
    // End of variables declaration
}
package org.example.view;

import org.example.CommonVariable;
import org.example.controller.CommonController;
import org.example.database.RoomData;
import org.example.database.UserData;
import org.example.model.Message;
import org.example.model.Room;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminUI extends JFrame {
    private AddRoomUI addRoomUI;
    private UserData userData;
    private CommonVariable commonVariable;
    private ActionListener ac;
    private RoomData roomData;
    private TableModel tableModel;
    private String[] tableColNames = {"Tên phòng học", "Toà nhà", "Loại phòng", "Trạng thái"};
    public AdminUI(UserData userData, CommonVariable commonVariable, @NotNull CommonController ac, RoomData roomData) {
        this.ac = ac;
        this.roomData = roomData;
        ac.setAdmin(this);
        this.commonVariable = commonVariable;
        this.userData = userData;
        addRoomUI = new AddRoomUI(this, true, ac);
        initComponents();

    }
    private void initComponents() {
        setLocationRelativeTo(null);
        tableModel = new TableModel(roomData);

        searchLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        typeClassLabel = new javax.swing.JLabel();
        typeClassComboBox = new javax.swing.JComboBox<>();
        statusLabel = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        searchBtn = new javax.swing.JButton();
        addNewClassBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchLabel.setText("Tìm kiếm");


        typeClassLabel.setText("Loại phòng");

        typeClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Phòng thực hành", "Phòng lý thuyết" }));

        statusLabel.setText("Trạng thái");

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Chưa được mượn", "Đang chờ xác nhận", "Đã được mượn" }));

        searchBtn.setText("Tìm kiếm");
        searchBtn.setActionCommand("searchAction");
        searchBtn.addActionListener(ac);
        addNewClassBtn.setText("Thêm phòng học mới");
        addNewClassBtn.addActionListener(ac);
        addNewClassBtn.setActionCommand("addNewClassAction");
        table.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        table.setModel(tableModel);
        table.setToolTipText("");
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(searchLabel)
                                        .addComponent(typeClassLabel)
                                        .addComponent(statusLabel))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(31, 31, 31)
                                                        .addComponent(addNewClassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(statusComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(typeClassComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchLabel)
                                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(typeClassLabel)
                                        .addComponent(typeClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(statusLabel)
                                        .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(addNewClassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                        .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(245, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private javax.swing.JButton addNewClassBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> typeClassComboBox;
    private javax.swing.JLabel typeClassLabel;
    class TableModel extends AbstractTableModel {
        protected RoomData data;
        private List<Room> renderData = new ArrayList<>();
        public TableModel(@NotNull RoomData data) {
            this.data = data;
            setRenderData(data.getAll());
        }

        public void setRenderData(List<Room> data) {
            this.renderData = data;
        }

        @Override
        public int getRowCount() {
            return renderData.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Room room = renderData.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return room.getName();
                case 2:
                    if(room.getType() == 1) {
                        return "Phòng thực hành";
                    }
                    return "Phòng lý thuyết";
                case 1:
                    return room.getLocation();
                case 3:
                    if(room.getStatus() == 1) {
                        return "Chưa được mượn";
                    }
                    else if(room.getStatus() == 3) {
                        return "Đã được mượn";
                    }
                    return "Đang chờ xác nhận";
                default:
                    return null;
            }
        }
        @Override
        public String getColumnName(int index) {
            return tableColNames[index];
        }
    }
    public void openModalAddNewClass() {
        this.addRoomUI.setVisible(true);
    }
    public void addNewClass() throws IOException {
        Message mess = roomData.addRoom(new Room(this.addRoomUI.getClassName(), this.addRoomUI.getTypeClass(), this.addRoomUI.getLocate()));
        new DialogWithoutAction(this, mess.getMess(), true);
        table.updateUI();
    }
    public void searchRoom() {
        List<Room> dataSearch = roomData.getByCondition(searchTextField.getText(), typeClassComboBox.getSelectedIndex(), statusComboBox.getSelectedIndex());
        tableModel.setRenderData(dataSearch);
        table.updateUI();
    }
}




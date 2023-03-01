package org.example.view;

import org.example.CommonVariable;
import org.example.controller.CommonController;
import org.example.database.MessageData;
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
import java.util.UUID;

public class AdminUI extends JFrame {
    private AddRoomUI addRoomUI;
    private final MessageData messageData;
    private final UserData userData;
    private final CommonVariable commonVariable;
    private final ActionListener ac;
    private final RoomData roomData;
    private TableModel tableModel;
    private final String[] tableColNames = {"Tên phòng học", "Toà nhà", "Loại phòng", "Trạng thái"};
    private javax.swing.JButton addNewClassBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton resetFilterBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton summaryBtn;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> typeClassComboBox;
    private javax.swing.JLabel typeClassLabel;
    private JPopupMenu popupMenu;
    private JMenuItem submitMenuItem;
    private JMenuItem editMenuItem;
    private JMenuItem deleteMenuItem;
    private JMenuItem viewDetailMenuItem;
    private ViewDetail viewDetailUI;
    private SubmitClassModal submitClassModal;
    public AdminUI(UserData userData, CommonVariable commonVariable, @NotNull CommonController ac, RoomData roomData, MessageData messageData) {
        this.messageData = messageData;
        this.ac = ac;
        this.roomData = roomData;
        ac.setAdmin(this);
        this.commonVariable = commonVariable;
        this.userData = userData;
        addRoomUI = new AddRoomUI(this, true, ac, "submitAddNewClassAction");
        initComponents();

    }

    private void initComponents() {
        setTitle("Giao diện quản trị viên");
        setLocationRelativeTo(null);
        tableModel = new TableModel(roomData);
        popupMenu = new JPopupMenu();
        submitMenuItem = new JMenuItem("Xác nhận");
        submitMenuItem.setActionCommand("submitMenuItemAction");
        submitMenuItem.addActionListener(ac);
        editMenuItem = new JMenuItem("Sửa thông tin");
        editMenuItem.setActionCommand("editMenuItemAction");
        editMenuItem.addActionListener(ac);
        deleteMenuItem = new JMenuItem("Xoá");
        deleteMenuItem.setActionCommand("deleteMenuItemAction");
        deleteMenuItem.addActionListener(ac);
        viewDetailMenuItem = new JMenuItem("Xem chi tiết");
        viewDetailMenuItem.setActionCommand("viewDetailMenuItemAction");
        viewDetailMenuItem.addActionListener(ac);
        popupMenu.add(submitMenuItem);
        popupMenu.add(editMenuItem);
        popupMenu.add(deleteMenuItem);
        popupMenu.add(viewDetailMenuItem);
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
        table.setComponentPopupMenu(popupMenu);
        logoutBtn = new javax.swing.JButton();
        resetFilterBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchLabel.setText("Tìm kiếm");


        typeClassLabel.setText("Loại phòng");

        typeClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Tất cả", "Phòng thực hành", "Phòng lý thuyết"}));

        statusLabel.setText("Trạng thái");
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Tất cả", "Chưa được mượn", "Đang chờ xác nhận", "Đã được mượn"}));
        summaryBtn = new javax.swing.JButton();
        summaryBtn.setText("Xuất thống kê");
        summaryBtn.setActionCommand("summaryBtnAction");
        summaryBtn.addActionListener(ac);
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
        logoutBtn.setText("Đăng xuất");
        logoutBtn.addActionListener(ac);
        logoutBtn.setActionCommand("logoutAdminUIAction");
        resetFilterBtn.setText("Cài lại bộ lọc");
        resetFilterBtn.setActionCommand("resetFilterAdminUIAction");
        resetFilterBtn.addActionListener(ac);
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
                                                        .addGap(18, 18, 18)
                                                        .addComponent(resetFilterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(addNewClassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(summaryBtn))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(statusComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(typeClassComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addContainerGap(165, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logoutBtn)
                                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logoutBtn)
                                .addGap(10, 10, 10)
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(resetFilterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addNewClassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(summaryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

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
    public void resetFilter() {
        searchTextField.setText("");
        typeClassComboBox.setSelectedIndex(0);
        statusComboBox.setSelectedIndex(0);
    }
    public int getRowSelect() {
        return table.getSelectedRow();
    }
    public void submitClass(int rowIndex) throws IOException {
        Room roomSelected = tableModel.getRenderData().get(rowIndex);
        if(roomSelected.getStatus() == 2) {
            UUID id = roomSelected.getId();
            Room newRoom = new Room(roomSelected.getName(), roomSelected.getType(), roomSelected.getLocation());
            newRoom.setStatus(3);
            roomData.updateRoom(id, newRoom);
            table.updateUI();
            JOptionPane.showMessageDialog(this, "Đã xác nhận phòng học");
            Message message = new Message("Quản trị viên đã xác nhận yêu cầu mượn phòng", 1);
            message.setUserName(roomSelected.getUserOrder());
            messageData.addMessage(message);
        }
        else {
            JOptionPane.showMessageDialog(this, "Xác nhận thất bại");
        }
    }
    public void openSubmitClassModal() {
        if(table.getSelectedRow() != -1) {
            Room roomSelected = tableModel.getRenderData().get(table.getSelectedRow());
            if(roomSelected.getStatus() == 2) {
                new SubmitClassModal(this, true, ac, roomSelected);
            }
            else {
                JOptionPane.showMessageDialog(this, "Vui lòng chỉ xác nhận phòng ở trạng thái 'Chờ xác nhận'");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng học");
        }
    }
    public void deleteClass(int rowIndex) throws IOException {
        Room roomSelected = tableModel.getRenderData().get(rowIndex);
        UUID id = roomSelected.getId();
        int isSubmit = JOptionPane.showConfirmDialog(this, "Xác nhận xoá phòng " + roomSelected.getName() + " toà " + roomSelected.getLocation());
        if(isSubmit == 0) {
            roomData.deleteRoom(id);
            table.updateUI();
            Message message = new Message("Quản trị viên đã xoá phòng mà bạn đăng kí vui lòng đăng kí phòng khác", 1);
            message.setUserName(roomSelected.getUserOrder());
            messageData.addMessage(message);
        }
    }
    public void editClass(int rowIndex) {
        Room roomSelected = tableModel.getRenderData().get(rowIndex);
        addRoomUI = new AddRoomUI(this, true, ac, "Sửa thông tin", "submitEditClassAction");
        addRoomUI.setClassName(roomSelected.getName());
        addRoomUI.setTypeClassComboBox(roomSelected.getType());
        addRoomUI.setStatusComboBox(roomSelected.getStatus());
        addRoomUI.setLocationComboBox(roomSelected.getLocation());
        addRoomUI.setVisible(true);
    }
    public void submitEdit() throws IOException {
        Room roomSelected = tableModel.getRenderData().get(table.getSelectedRow());
        if((roomSelected.getStatus() == 3 || roomSelected.getStatus() == 2) && !roomSelected.getUserOrder().isEmpty()) {
            if(addRoomUI.getStatus() == 1) {
                Room newRoom = new Room(addRoomUI.getClassName(), addRoomUI.getTypeClass(), addRoomUI.getLocate());
                newRoom.setStatus(addRoomUI.getStatus());
                Message message = roomData.updateRoom(roomSelected.getId(), newRoom);
                JOptionPane.showMessageDialog(this, message.getMess());
                Message mess = new Message("Quản trị viên đã cập nhập lại thông tin của phòng " + roomSelected.getName() + " toà " + roomSelected.getLocation() + ".Bạn hãy đăng kí phòng học mới", 1);
                mess.setUserName(roomSelected.getUserOrder());
                messageData.addMessage(mess);
            } else if (roomSelected.getStatus() == 3 && addRoomUI.getStatus() == 2) {
                Room newRoom = new Room(addRoomUI.getClassName(), addRoomUI.getTypeClass(), addRoomUI.getLocate());
                newRoom.setStatus(addRoomUI.getStatus());
                newRoom.setLessons(roomSelected.getLessons());
                newRoom.setDate(roomSelected.getDate());
                newRoom.setUserOrder(roomSelected.getUserOrder());
                Message message = roomData.updateRoom(roomSelected.getId(), newRoom);
                JOptionPane.showMessageDialog(this, message.getMess());
                Message mess = new Message("Quản trị viên đã cập nhập lại thông tin của phòng " + roomSelected.getName() + " toà " + roomSelected.getLocation() + ".Bạn hãy đăng kí lại", 1);
                mess.setUserName(roomSelected.getUserOrder());
                messageData.addMessage(mess);
            } else {
                Room newRoom = new Room(addRoomUI.getClassName(), addRoomUI.getTypeClass(), addRoomUI.getLocate());
                newRoom.setStatus(addRoomUI.getStatus());
                Message message = roomData.updateRoom(roomSelected.getId(), newRoom);
                JOptionPane.showMessageDialog(this, message.getMess());
            }
        } else if ((roomSelected.getStatus() == 3 || roomSelected.getStatus() == 2) && roomSelected.getUserOrder().isEmpty()) {
            Room newRoom = new Room(addRoomUI.getClassName(), addRoomUI.getTypeClass(), addRoomUI.getLocate());
            newRoom.setStatus(addRoomUI.getStatus());
            Message message = roomData.updateRoom(roomSelected.getId(), newRoom);
            JOptionPane.showMessageDialog(this, message.getMess());
        } else {
            if(roomSelected.getUserOrder().isEmpty()) {
                if(addRoomUI.getStatus() == 2) {
                    int re = JOptionPane.showConfirmDialog(this, "Xác nhận thay đổi trạng thái của phòng chưa có người đăng kí sang 'Chờ xác nhận'");
                    if(re == 0) {
                        Room newRoom = new Room(addRoomUI.getClassName(), addRoomUI.getTypeClass(), addRoomUI.getLocate());
                        newRoom.setStatus(addRoomUI.getStatus());
                        Message message = roomData.updateRoom(roomSelected.getId(), newRoom);
                        JOptionPane.showMessageDialog(this, message.getMess());
                    }
                }
                else if(addRoomUI.getStatus() == 3) {
                    int re = JOptionPane.showConfirmDialog(this, "Xác nhận thay đổi trạng thái của phòng chưa có người đăng kí sang 'Đã được mượn'");
                    if(re == 0) {
                        Room newRoom = new Room(addRoomUI.getClassName(), addRoomUI.getTypeClass(), addRoomUI.getLocate());
                        newRoom.setStatus(addRoomUI.getStatus());
                        Message message = roomData.updateRoom(roomSelected.getId(), newRoom);
                        JOptionPane.showMessageDialog(this, message.getMess());
                    }
                }
                else {
                    Room newRoom = new Room(addRoomUI.getClassName(), addRoomUI.getTypeClass(), addRoomUI.getLocate());
                    newRoom.setStatus(addRoomUI.getStatus());
                    Message message = roomData.updateRoom(roomSelected.getId(), newRoom);
                    JOptionPane.showMessageDialog(this, message.getMess());
                }
            }
            else {
                Room newRoom = new Room(addRoomUI.getClassName(), addRoomUI.getTypeClass(), addRoomUI.getLocate());
                newRoom.setStatus(addRoomUI.getStatus());
                Message message = roomData.updateRoom(roomSelected.getId(), newRoom);
                JOptionPane.showMessageDialog(this, message.getMess());
            }
        }

        table.updateUI();
    }
    public void viewDetail() {
        if(table.getSelectedRow() != -1) {
            Room roomSelected = tableModel.getRenderData().get(table.getSelectedRow());

            new ViewDetail(this, true, roomSelected);
        }
        else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng học");
        }

    }
    public void cancelClass() throws IOException {
        Room roomSelected = tableModel.getRenderData().get(table.getSelectedRow());
        UUID id = roomSelected.getId();
        Room newRoom = new Room(roomSelected.getName(), roomSelected.getType(), roomSelected.getLocation());
        newRoom.setStatus(1);
        roomData.updateRoom(id, newRoom);
        table.updateUI();
        JOptionPane.showMessageDialog(this, "Huỷ xác nhận thành công");
        Message mes = new Message("Quản trị viên đã huỷ xác nhận phòng mà bạn đã đăng kí", 1);
        mes.setUserName(roomSelected.getUserOrder());
        messageData.addMessage(mes);
    }
    public void viewSummary() {
        new Summary(this, true, roomData.getAll());
    }
    class TableModel extends AbstractTableModel {
        protected RoomData data;
        public List<Room> getRenderData() {
            return renderData;
        }

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
                    if (room.getType() == 1) {
                        return "Phòng thực hành";
                    }
                    return "Phòng lý thuyết";
                case 1:
                    return room.getLocation();
                case 3:
                    if (room.getStatus() == 1) {
                        return "Chưa được mượn";
                    } else if (room.getStatus() == 3) {
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
}




package org.example.view;

public class DialogWithoutAction extends javax.swing.JDialog {


    public DialogWithoutAction(java.awt.Frame parent, String title, boolean modal) {
        super(parent, modal);
        initComponents(title);
        setVisible(true);
    }


    @SuppressWarnings("unchecked")

    private void initComponents(String title) {

        label = new javax.swing.JLabel();
        label.setText(title);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(81, Short.MAX_VALUE)
                                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>


    public void close() {
        dispose();
    }
    protected javax.swing.JLabel label;

}
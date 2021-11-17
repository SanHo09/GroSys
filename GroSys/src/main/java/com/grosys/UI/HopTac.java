/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.UI;

import utils.HeaderColor;

/**
 *
 * @author Sang
 */
public class HopTac extends javax.swing.JPanel {

    /**
     * Creates new form HopTac
     */
    public HopTac() {
        initComponents();
        prepareUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabNhaSanXuat = new javax.swing.JPanel();
        cbbNhaPhanPhoi = new javax.swing.JComboBox<>();
        txtMaNSX = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTimKiemNSX = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenNSX = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChiNSX = new javax.swing.JTextArea();
        btnSuaNSX = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnMoiNSX = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnThemNSX = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnXoaNSX = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblNSX = new javax.swing.JTable();
        tabNhaPhanPhoi = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblNPP = new javax.swing.JTable();
        txtTimKiemNPP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMaNPP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTenNPP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDiaChiNPP = new javax.swing.JTextArea();
        btnThemNPP = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnSuaNPP = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnXoaNPP = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnMoiNPP = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tabNhaSanXuat.setBackground(new java.awt.Color(255, 255, 255));
        tabNhaSanXuat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbbNhaPhanPhoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNhaPhanPhoiActionPerformed(evt);
            }
        });
        tabNhaSanXuat.add(cbbNhaPhanPhoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 184, -1));
        tabNhaSanXuat.add(txtMaNSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 180, -1));

        jLabel1.setText("Tìm Kiếm:");
        tabNhaSanXuat.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 25, -1, -1));

        jLabel2.setText("Nhà Phân Phối");
        tabNhaSanXuat.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jLabel3.setText("Mã Nhà Sản Xuất");
        tabNhaSanXuat.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));
        tabNhaSanXuat.add(txtTimKiemNSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 120, -1));

        jLabel4.setText("Tên Nhà Sản Xuất");
        tabNhaSanXuat.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, -1));
        tabNhaSanXuat.add(txtTenNSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 180, -1));

        jLabel5.setText("Địa chỉ:");
        tabNhaSanXuat.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        txtDiaChiNSX.setColumns(20);
        txtDiaChiNSX.setRows(5);
        jScrollPane2.setViewportView(txtDiaChiNSX);

        tabNhaSanXuat.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 180, 100));

        btnSuaNSX.setBackground(new java.awt.Color(10, 102, 194));
        btnSuaNSX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SỬA");

        javax.swing.GroupLayout btnSuaNSXLayout = new javax.swing.GroupLayout(btnSuaNSX);
        btnSuaNSX.setLayout(btnSuaNSXLayout);
        btnSuaNSXLayout.setHorizontalGroup(
            btnSuaNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSuaNSXLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        btnSuaNSXLayout.setVerticalGroup(
            btnSuaNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        tabNhaSanXuat.add(btnSuaNSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, 80, 30));

        btnMoiNSX.setBackground(new java.awt.Color(10, 102, 194));
        btnMoiNSX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MỚI");

        javax.swing.GroupLayout btnMoiNSXLayout = new javax.swing.GroupLayout(btnMoiNSX);
        btnMoiNSX.setLayout(btnMoiNSXLayout);
        btnMoiNSXLayout.setHorizontalGroup(
            btnMoiNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMoiNSXLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        btnMoiNSXLayout.setVerticalGroup(
            btnMoiNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        tabNhaSanXuat.add(btnMoiNSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 490, 80, 30));

        btnThemNSX.setBackground(new java.awt.Color(10, 102, 194));
        btnThemNSX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("THÊM");

        javax.swing.GroupLayout btnThemNSXLayout = new javax.swing.GroupLayout(btnThemNSX);
        btnThemNSX.setLayout(btnThemNSXLayout);
        btnThemNSXLayout.setHorizontalGroup(
            btnThemNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThemNSXLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        btnThemNSXLayout.setVerticalGroup(
            btnThemNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        tabNhaSanXuat.add(btnThemNSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 80, 30));

        btnXoaNSX.setBackground(new java.awt.Color(10, 102, 194));
        btnXoaNSX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("XÓA");

        javax.swing.GroupLayout btnXoaNSXLayout = new javax.swing.GroupLayout(btnXoaNSX);
        btnXoaNSX.setLayout(btnXoaNSXLayout);
        btnXoaNSXLayout.setHorizontalGroup(
            btnXoaNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnXoaNSXLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        btnXoaNSXLayout.setVerticalGroup(
            btnXoaNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        tabNhaSanXuat.add(btnXoaNSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 80, 30));

        tblNSX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblNSX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaNSX", "TenNSX", "TenNPP", "DiaChi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNSX.setRowHeight(25);
        tblNSX.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblNSX.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblNSX.setShowGrid(true);
        tblNSX.setShowVerticalLines(false);
        tblNSX.getTableHeader().setReorderingAllowed(false);
        tblNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNSXMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblNSX);

        tabNhaSanXuat.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 550));

        jTabbedPane1.addTab("Nhà Sản Xuất", tabNhaSanXuat);

        tabNhaPhanPhoi.setBackground(new java.awt.Color(255, 255, 255));
        tabNhaPhanPhoi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblNPP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblNPP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaNPP", "TenNPP", "DiaChi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNPP.setRowHeight(25);
        tblNPP.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblNPP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblNPP.setShowGrid(true);
        tblNPP.setShowVerticalLines(false);
        tblNPP.getTableHeader().setReorderingAllowed(false);
        tblNPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNPPMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblNPP);

        tabNhaPhanPhoi.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 550));
        tabNhaPhanPhoi.add(txtTimKiemNPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 120, -1));

        jLabel10.setText("Tìm Kiếm:");
        tabNhaPhanPhoi.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 25, -1, -1));
        tabNhaPhanPhoi.add(txtMaNPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 180, -1));

        jLabel11.setText("Mã Nhà Phân Phối:");
        tabNhaPhanPhoi.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));
        tabNhaPhanPhoi.add(txtTenNPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 180, -1));

        jLabel12.setText("Tên Nhà Phân Phối:");
        tabNhaPhanPhoi.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

        jLabel13.setText("Địa chỉ:");
        tabNhaPhanPhoi.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));

        txtDiaChiNPP.setColumns(20);
        txtDiaChiNPP.setRows(5);
        jScrollPane3.setViewportView(txtDiaChiNPP);

        tabNhaPhanPhoi.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 180, 100));

        btnThemNPP.setBackground(new java.awt.Color(10, 102, 194));
        btnThemNPP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("THÊM");

        javax.swing.GroupLayout btnThemNPPLayout = new javax.swing.GroupLayout(btnThemNPP);
        btnThemNPP.setLayout(btnThemNPPLayout);
        btnThemNPPLayout.setHorizontalGroup(
            btnThemNPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThemNPPLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        btnThemNPPLayout.setVerticalGroup(
            btnThemNPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        tabNhaPhanPhoi.add(btnThemNPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 80, 30));

        btnSuaNPP.setBackground(new java.awt.Color(10, 102, 194));
        btnSuaNPP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("SỬA");

        javax.swing.GroupLayout btnSuaNPPLayout = new javax.swing.GroupLayout(btnSuaNPP);
        btnSuaNPP.setLayout(btnSuaNPPLayout);
        btnSuaNPPLayout.setHorizontalGroup(
            btnSuaNPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSuaNPPLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        btnSuaNPPLayout.setVerticalGroup(
            btnSuaNPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        tabNhaPhanPhoi.add(btnSuaNPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, 80, 30));

        btnXoaNPP.setBackground(new java.awt.Color(10, 102, 194));
        btnXoaNPP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("XÓA");

        javax.swing.GroupLayout btnXoaNPPLayout = new javax.swing.GroupLayout(btnXoaNPP);
        btnXoaNPP.setLayout(btnXoaNPPLayout);
        btnXoaNPPLayout.setHorizontalGroup(
            btnXoaNPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnXoaNPPLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        btnXoaNPPLayout.setVerticalGroup(
            btnXoaNPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        tabNhaPhanPhoi.add(btnXoaNPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 80, 30));

        btnMoiNPP.setBackground(new java.awt.Color(10, 102, 194));
        btnMoiNPP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("MỚI");

        javax.swing.GroupLayout btnMoiNPPLayout = new javax.swing.GroupLayout(btnMoiNPP);
        btnMoiNPP.setLayout(btnMoiNPPLayout);
        btnMoiNPPLayout.setHorizontalGroup(
            btnMoiNPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMoiNPPLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        btnMoiNPPLayout.setVerticalGroup(
            btnMoiNPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        tabNhaPhanPhoi.add(btnMoiNPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 490, 80, 30));

        jTabbedPane1.addTab("Nhà Phân Phối", tabNhaPhanPhoi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbNhaPhanPhoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNhaPhanPhoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNhaPhanPhoiActionPerformed

    private void tblNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNSXMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblNSXMouseClicked

    private void tblNPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNPPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNPPMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnMoiNPP;
    private javax.swing.JPanel btnMoiNSX;
    private javax.swing.JPanel btnSuaNPP;
    private javax.swing.JPanel btnSuaNSX;
    private javax.swing.JPanel btnThemNPP;
    private javax.swing.JPanel btnThemNSX;
    private javax.swing.JPanel btnXoaNPP;
    private javax.swing.JPanel btnXoaNSX;
    private javax.swing.JComboBox<String> cbbNhaPhanPhoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel tabNhaPhanPhoi;
    private javax.swing.JPanel tabNhaSanXuat;
    private javax.swing.JTable tblNPP;
    private javax.swing.JTable tblNSX;
    private javax.swing.JTextArea txtDiaChiNPP;
    private javax.swing.JTextArea txtDiaChiNSX;
    private javax.swing.JTextField txtMaNPP;
    private javax.swing.JTextField txtMaNSX;
    private javax.swing.JTextField txtTenNPP;
    private javax.swing.JTextField txtTenNSX;
    private javax.swing.JTextField txtTimKiemNPP;
    private javax.swing.JTextField txtTimKiemNSX;
    // End of variables declaration//GEN-END:variables

    private void prepareUI() {
        tblNSX.getTableHeader().setDefaultRenderer(new HeaderColor());
        tblNPP.getTableHeader().setDefaultRenderer(new HeaderColor());
    }
}
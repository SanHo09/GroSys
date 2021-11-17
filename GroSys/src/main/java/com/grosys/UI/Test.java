/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.UI;

import com.grosys.DAO1.LoaiSanPhamDAO;
import com.grosys.DAO1.NhaPhanPhoiDAO;
import com.grosys.DAO1.NhaSanXuatDAO;
import com.grosys.DAO1.SanPhamDAO;
import com.grosys.untity.HoaDonChiTiet;
import com.grosys.untity.LoaiSanPham;
import com.grosys.untity.NhaPhanPhoi;
import com.grosys.untity.NhaSanXuat;
import com.grosys.untity.SanPham;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import utils.Auth;
import utils.MsgBox;
import utils.XDate;
import utils.XImage;

/**
 *
 * @author Sang
 */
public class Test extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    SanPhamDAO dao =new SanPhamDAO();
    NhaPhanPhoiDAO nppdao =new NhaPhanPhoiDAO();
    NhaSanXuatDAO nsxdao =new NhaSanXuatDAO();
    LoaiSanPhamDAO lspdao = new LoaiSanPhamDAO();
    HoaDonChiTiet hdctdao = new HoaDonChiTiet();
    public Test() {
        initComponents();
        fillComboBoxNPP();
        fillToComboboxLSP();
        this.row=-1;
        ClearForm();
        this.updateStatus();
        
    }
       
void chonAnh (){
         JFileChooser fc=new JFileChooser();
        if (fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
          File file =fc.getSelectedFile();
          XImage.save(file);
            ImageIcon icon =XImage.read(file.getName(),lblAnh);
            lblAnh.setIcon(icon);
            lblAnh.setToolTipText(file.getName());
        }
    }
    int row=-1;
    void fillComboBoxNPP() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbNhaPhanPhoi.getModel();
        model.removeAllElements();
        List<NhaPhanPhoi> list = nppdao.selectAll();
        for (NhaPhanPhoi cd : list) {
            model.addElement(cd);
        }
        fillToComboboxNSX();
    }

    private void fillToComboboxNSX() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbNhaSanXuat.getModel();
        model.removeAllElements();
        NhaPhanPhoi cd = (NhaPhanPhoi) cbbNhaPhanPhoi.getSelectedItem();
        if (cd != null) {
            List<NhaSanXuat> list = nsxdao.selectByNhaphanPhoi(cd.getMaNPP());
            for (NhaSanXuat kh : list) {
                model.addElement(kh);
            }
            fillTable();
        }
    }
    void fillToComboboxLSP() {
        DefaultComboBoxModel model = (DefaultComboBoxModel)cbbLoaiSanPham.getModel();
        model.removeAllElements();
        List<LoaiSanPham> list = lspdao.selectAll();
        for(LoaiSanPham i : list) {
            model.addElement(i);
        }
    }
    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachSanPham.getModel();
        model.setRowCount(0);
        NhaSanXuat nsx = (NhaSanXuat) cbbNhaSanXuat.getSelectedItem();
        if (nsx != null) {
            try {
                List<SanPham> list = dao.selectbyNhaSanXuat(nsx.getMaNSX());
                for (SanPham sp : list) {
                    Object[] row = {sp.getMaSP(), sp.getTenSP(), sp.getTenLSP(),
                        sp.getGiaBan(), sp.getHanSuDung(),
                         sp.getDonViTinh(), sp.getSoLuong(), sp.getTenNSX(), sp.getAnh()};
                    model.addRow(row);
                }
            } catch (Exception e) {
                MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
                e.printStackTrace();
            }
        }

    }
    void updateStatus(){
        boolean edit=(this.row>=0);
        boolean first=(this.row==0);
        boolean last=(this.row==tblDanhSachSanPham.getRowCount()-1);
        //Trạng Thái Form
        txtMaSanPham.setEnabled(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
        System.out.println(this.row);
        //Trạng thái diều hướng
        btnFirst.setEnabled(edit&&!first);
        btnPrev.setEnabled(edit&&!first);
        btnNext.setEnabled(edit&&!last);
        btnLast.setEnabled(edit&&!last);
    }
    
        void setForm(SanPham sp){
       
        LoaiSanPham lsp = lspdao.selectById(sp.getMaLSP());
        txtMaSanPham.setText(sp.getMaSP());
        txtGiaBan.setText(String.valueOf(sp.getGiaBan()));
        txtHanSuDung1.setText(String.valueOf(sp.getHanSuDung()));
        txtSoLuong.setText(String.valueOf(sp.getSoLuong()));
        txtTenSanPham.setText(sp.getTenSP());
        cbbLoaiSanPham.setSelectedItem(lsp);
        if (sp.getAnh()!=null) {
            lblAnh.setToolTipText(sp.getAnh());
            lblAnh.setIcon(XImage.read(sp.getAnh(),lblAnh));
        }
        cbbDonviTinh.setSelectedItem(sp.getDonViTinh());
        txtGiaNhap.setText(String.valueOf(sp.getGiaNhap()));    
    }
    SanPham getForm(){
        SanPham sp =new SanPham();
        NhaSanXuat nsx = (NhaSanXuat)cbbNhaSanXuat.getSelectedItem();
        NhaPhanPhoi npp = (NhaPhanPhoi)cbbNhaPhanPhoi.getSelectedItem();
        LoaiSanPham lsp = (LoaiSanPham)cbbLoaiSanPham.getSelectedItem();
        sp.setMaSP(txtMaSanPham.getText());
        sp.setTenSP(txtTenSanPham.getText());
        sp.setDonViTinh((String)cbbDonviTinh.getSelectedItem());
        sp.setGiaNhap(Double.parseDouble(txtGiaNhap.getText()));
        sp.setGiaBan(Double.parseDouble(txtGiaBan.getText()));
        sp.setMaNSX(nsx.getMaNSX());
        sp.setMaNPP(npp.getMaNPP());
        sp.setMaLSP(lsp.getMaLSP());
        sp.setHanSuDung(XDate.toDate(txtHanSuDung1.getText()));
        sp.setAnh(lblAnh.getToolTipText());
        return sp;
    }
    void ClearForm(){
        SanPham sp =new SanPham();
        this.setForm(sp);
        this.row=1;
        this.updateStatus();
    }
    void edit(){
        String Masp =(String) tblDanhSachSanPham.getValueAt(this.row,0);
        SanPham sp =dao.selectById(Masp);
        System.out.println(this.row);
        this.setForm(sp);
        this.updateStatus();
    }
    void insert(){
        
        SanPham sp = getForm();
       
          try {
            MsgBox.alert(this, "Thêm Thành CÔng!");
            dao.insert(sp);
            this.fillTable();
            this.ClearForm();
            
        } catch (Exception e) {

        }  
        
        
        
        
    }
    void update(){
        
       
          SanPham sp = getForm();
        try {
            MsgBox.alert(this, "Sửa Thành CÔng!");
           
            dao.update(sp);
            this.fillTable();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }  
        
        
        
    }
    void delete() {
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa khóa học này?")) {
            String MaSp= txtMaSanPham.getText();
            try {
                dao.delete(MaSp);
                this.fillTable();
                this.ClearForm();
                MsgBox.alert(this, "Xóa thành công!");
            }  
            catch (Exception e) {
                MsgBox.alert(this, " vui lòng kiểm tra khóa ngoại");
                e.printStackTrace();
            }
        }
        
    }
    void fist(){
        this.row=0;
        this.edit();
    }
    void last(){
        if(this.row<tblDanhSachSanPham.getRowCount()-1){
            this.row=tblDanhSachSanPham.getRowCount()-1;
        this.edit();
        }
    }
    void prev(){
        if (this.row>0) {
            this.row--;
            this.edit();
        }
    }
    void next(){
       this.row++;
       this.edit();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabsSanPham = new javax.swing.JTabbedPane();
        tabsDanhSachSanPham = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblDanhSachSanPham = new javax.swing.JTable();
        btnXuatFileExcel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tabsCapNhatSanPham = new javax.swing.JPanel();
        txtMaSanPham = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblAnh = new javax.swing.JLabel();
        txtHanSuDung1 = new javax.swing.JTextField();
        cbbLoaiSanPham = new javax.swing.JComboBox<>();
        cbbDonviTinh = new javax.swing.JComboBox<>();
        lblgianhap1 = new javax.swing.JLabel();
        lblgianhap2 = new javax.swing.JLabel();
        pnlCbbNhaPhanPhoi = new javax.swing.JPanel();
        cbbNhaSanXuat = new javax.swing.JComboBox<>();
        pnlCbbNhaSanXuat1 = new javax.swing.JPanel();
        cbbNhaPhanPhoi = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabsDanhSachSanPham.setBackground(new java.awt.Color(255, 255, 255));
        tabsDanhSachSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDanhSachSanPham.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaSP", "TenSP", "TenLSP", "GiaBan", "HanSuDung", "DonViTinh", "SoLuong", "TenNSX", "Anh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachSanPham.setRowHeight(25);
        tblDanhSachSanPham.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblDanhSachSanPham.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDanhSachSanPham.setShowGrid(true);
        tblDanhSachSanPham.setShowVerticalLines(false);
        tblDanhSachSanPham.getTableHeader().setReorderingAllowed(false);
        tblDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSanPhamMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblDanhSachSanPham);

        tabsDanhSachSanPham.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 718, 404));

        btnXuatFileExcel.setBackground(new java.awt.Color(73, 164, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_send_file_20px_1.png"))); // NOI18N
        jLabel1.setText("Xuất File Excel");

        javax.swing.GroupLayout btnXuatFileExcelLayout = new javax.swing.GroupLayout(btnXuatFileExcel);
        btnXuatFileExcel.setLayout(btnXuatFileExcelLayout);
        btnXuatFileExcelLayout.setHorizontalGroup(
            btnXuatFileExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        btnXuatFileExcelLayout.setVerticalGroup(
            btnXuatFileExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        tabsDanhSachSanPham.add(btnXuatFileExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 130, 30));

        btnThongKe.setBackground(new java.awt.Color(73, 164, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_chart_20px.png"))); // NOI18N
        jLabel2.setText("Thống kê");

        javax.swing.GroupLayout btnThongKeLayout = new javax.swing.GroupLayout(btnThongKe);
        btnThongKe.setLayout(btnThongKeLayout);
        btnThongKeLayout.setHorizontalGroup(
            btnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnThongKeLayout.setVerticalGroup(
            btnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabsDanhSachSanPham.add(btnThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 100, 30));

        tabsSanPham.addTab("Danh Sách Sản Phẩm", tabsDanhSachSanPham);

        tabsCapNhatSanPham.setBackground(new java.awt.Color(255, 255, 255));
        tabsCapNhatSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMaSanPham.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtMaSanPham.setForeground(new java.awt.Color(51, 102, 255));
        txtMaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSanPhamActionPerformed(evt);
            }
        });
        tabsCapNhatSanPham.add(txtMaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 41, 288, -1));

        jLabel14.setText("Mã Sản Phẩm:");
        tabsCapNhatSanPham.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 19, 90, -1));

        txtTenSanPham.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtTenSanPham.setForeground(new java.awt.Color(51, 102, 255));
        tabsCapNhatSanPham.add(txtTenSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 288, -1));

        jLabel15.setText("Tên Sản Phẩm:");
        tabsCapNhatSanPham.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 103, -1));

        jLabel16.setText("Giá Nhập");
        tabsCapNhatSanPham.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 210, 103, -1));

        txtGiaNhap.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtGiaNhap.setForeground(new java.awt.Color(51, 102, 255));
        tabsCapNhatSanPham.add(txtGiaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 230, 307, -1));

        jLabel17.setText("Loại Sản Phẩm");
        tabsCapNhatSanPham.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 147, 103, -1));

        txtGiaBan.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtGiaBan.setForeground(new java.awt.Color(51, 102, 255));
        tabsCapNhatSanPham.add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 288, -1));

        jLabel18.setText("Giá Bán:");
        tabsCapNhatSanPham.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 103, -1));

        txtSoLuong.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtSoLuong.setForeground(new java.awt.Color(51, 102, 255));
        tabsCapNhatSanPham.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 288, -1));

        jLabel19.setText("Số Lượng:");
        tabsCapNhatSanPham.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 103, -1));

        jLabel20.setText("Hạn Sử Dụng:");
        tabsCapNhatSanPham.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 103, -1));

        jLabel21.setText("Đơn vị tính");
        tabsCapNhatSanPham.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 103, -1));

        btnSua.setBackground(new java.awt.Color(73, 164, 255));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        tabsCapNhatSanPham.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 100, -1));

        btnThem.setBackground(new java.awt.Color(73, 164, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        tabsCapNhatSanPham.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 100, -1));

        btnXoa.setBackground(new java.awt.Color(73, 164, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        tabsCapNhatSanPham.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 103, -1));

        btnMoi.setBackground(new java.awt.Color(73, 164, 255));
        btnMoi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });
        tabsCapNhatSanPham.add(btnMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 103, -1));

        btnFirst.setBackground(new java.awt.Color(73, 164, 255));
        btnFirst.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("<|");
        tabsCapNhatSanPham.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 75, 30));

        btnPrev.setBackground(new java.awt.Color(73, 164, 255));
        btnPrev.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("<<");
        tabsCapNhatSanPham.add(btnPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 67, 30));

        btnNext.setBackground(new java.awt.Color(73, 164, 255));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        tabsCapNhatSanPham.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 69, 30));

        btnLast.setBackground(new java.awt.Color(73, 164, 255));
        btnLast.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText("|>");
        tabsCapNhatSanPham.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 78, 30));

        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/No_image.jpg"))); // NOI18N
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });
        tabsCapNhatSanPham.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 200, 120));

        txtHanSuDung1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtHanSuDung1.setForeground(new java.awt.Color(51, 102, 255));
        tabsCapNhatSanPham.add(txtHanSuDung1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 288, -1));

        tabsCapNhatSanPham.add(cbbLoaiSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 300, -1));

        cbbDonviTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bịch", "chai", "lon", "hộp" }));
        tabsCapNhatSanPham.add(cbbDonviTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 300, -1));

        lblgianhap1.setForeground(new java.awt.Color(255, 51, 51));
        tabsCapNhatSanPham.add(lblgianhap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 120, 20));

        lblgianhap2.setForeground(new java.awt.Color(255, 51, 51));
        tabsCapNhatSanPham.add(lblgianhap2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 120, 20));

        tabsSanPham.addTab("Cập nhật sản phẩm", tabsCapNhatSanPham);

        pnlCbbNhaPhanPhoi.setBackground(new java.awt.Color(255, 255, 255));
        pnlCbbNhaPhanPhoi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhà Sản Xuất", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        pnlCbbNhaPhanPhoi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbbNhaSanXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbNhaSanXuatMouseClicked(evt);
            }
        });
        cbbNhaSanXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNhaSanXuatActionPerformed(evt);
            }
        });
        pnlCbbNhaPhanPhoi.add(cbbNhaSanXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, -1));

        pnlCbbNhaSanXuat1.setBackground(new java.awt.Color(255, 255, 255));
        pnlCbbNhaSanXuat1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhà Phân Phối", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        pnlCbbNhaSanXuat1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbbNhaPhanPhoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbNhaPhanPhoiMouseClicked(evt);
            }
        });
        cbbNhaPhanPhoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNhaPhanPhoiActionPerformed(evt);
            }
        });
        pnlCbbNhaSanXuat1.add(cbbNhaPhanPhoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 240, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnlCbbNhaPhanPhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(pnlCbbNhaSanXuat1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(tabsSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCbbNhaPhanPhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCbbNhaSanXuat1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tabsSanPham))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 723, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSanPhamMouseClicked
        // TODO add your handling code here:
         if (evt.getClickCount()==2) {
             
            this.row=tblDanhSachSanPham.getSelectedRow();
            tabsSanPham.setSelectedIndex(1);
            this.edit();
        }

    }//GEN-LAST:event_tblDanhSachSanPhamMouseClicked

    private void cbbNhaSanXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNhaSanXuatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNhaSanXuatMouseClicked

    private void cbbNhaSanXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNhaSanXuatActionPerformed
        // TODO add your handling code here:
        fillTable();
    }//GEN-LAST:event_cbbNhaSanXuatActionPerformed

    private void cbbNhaPhanPhoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNhaPhanPhoiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNhaPhanPhoiMouseClicked

    private void cbbNhaPhanPhoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNhaPhanPhoiActionPerformed
        // TODO add your handling code here:
        fillToComboboxNSX();
    }//GEN-LAST:event_cbbNhaPhanPhoiActionPerformed

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        // TODO add your handling code here:
        chonAnh();
    }//GEN-LAST:event_lblAnhMouseClicked

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        ClearForm();
        this.row =-1;
        updateStatus();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtMaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSanPhamActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JPanel btnThongKe;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel btnXuatFileExcel;
    private javax.swing.JComboBox<String> cbbDonviTinh;
    private javax.swing.JComboBox<String> cbbLoaiSanPham;
    private javax.swing.JComboBox<String> cbbNhaPhanPhoi;
    private javax.swing.JComboBox<String> cbbNhaSanXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblgianhap1;
    private javax.swing.JLabel lblgianhap2;
    private javax.swing.JPanel pnlCbbNhaPhanPhoi;
    private javax.swing.JPanel pnlCbbNhaSanXuat1;
    private javax.swing.JPanel tabsCapNhatSanPham;
    private javax.swing.JPanel tabsDanhSachSanPham;
    private javax.swing.JTabbedPane tabsSanPham;
    private javax.swing.JTable tblDanhSachSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHanSuDung1;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSanPham;
    // End of variables declaration//GEN-END:variables
}


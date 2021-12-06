/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grosys.DAO1;

import com.grosys.untity.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class ThongkeDao {
    SanPhamDAO spDao = new SanPhamDAO();
    public List<Object[]> doanhThuTheoThang() {
        String sql = "{CALL sp_doanhThuTheoThang}";
        String[] cols = {"SoTien","Thang"};
        List<Object[]> list = getListOfArrays(sql, cols);
        return list;
    }
        
    public List<TopDoanhThu> topDoanhThu() throws SQLException {
        String sql = "{CALL sp_topDoanhThu}";
        ResultSet rs = Xjdbc.query(sql);
        List<TopDoanhThu> list = new ArrayList<>();
        while(rs.next()) {
            TopDoanhThu top = new TopDoanhThu();
            SanPham sp = spDao.selectById(rs.getString("MaSP"));
            top.setTenSP(sp.getTenSP());
            top.setDoanhThu(rs.getDouble("DoanhThu"));
            list.add(top);
        }
        return list;   
    }
    
    public double tongDoanhThu() throws SQLException{
        String sql = "SELECT SUM(Sotien) AS TongDoanhThu FROM HoaDon";
        ResultSet rs = Xjdbc.query(sql);
        double tongDoanhThu =0;
        while(rs.next()) {
            tongDoanhThu = rs.getDouble("TongDoanhThu");
        }
        return tongDoanhThu;
    }
    
    public List<Object[]> vonTheoThang() {
        String sql = "{CALL sp_vonBoRaTheoThang}";
        String[] cols = {"DoanhThu","MaSP"};
        List<Object[]> list = getListOfArrays(sql, cols);
        return list;    
    }
    
    public double doanhThuTheoThangNV(int thang) throws SQLException {
        String sql = "{CALL sp_doanhThuTheoThangNV (?)}";
        ResultSet rs = Xjdbc.query(sql, thang);
        double doanhThu =0;
        while(rs.next()) {
            doanhThu = rs.getDouble("DoanhThu");
        }
        return doanhThu;
    }
    
    public List<Object[]> doanhThuTheoTungSP() throws SQLException {
        String sql = "{sp_doanhThuTheoTungSP}";
        String[] cols = {"DoanhThu","MaSP"};
        List<Object[]> list = getListOfArrays(sql, cols);
        return list;
    }
    
    public double DoanhThuTheoLSP(String lsp) throws SQLException {
        String sql = "{CALL sp_thongKeDoanhThuTheoLSP(?)}";
        ResultSet rs = Xjdbc.query(sql, lsp);
        double doanhThu =0;
        while(rs.next()) {
            doanhThu = rs.getDouble("ThongKe");
        }
        return doanhThu;
    }
    public double tongVon() throws SQLException {
        String sql = "SELECT SUM(GiaNhap) AS GiaNhap FROM ChiTietHopDong";
        ResultSet rs = Xjdbc.query(sql);
        double tongVon =0;
        while(rs.next()) {
            tongVon = rs.getDouble("GiaNhap");
        }
        return tongVon;
    }
    
    public double chiTieuTheoThang(int thang) throws SQLException {
        String sql = "{CALL sp_ChiTieuTheoThang (?)}";
        ResultSet rs = Xjdbc.query(sql, thang);
        double chiTieu = 0;
        while(rs.next()){
            chiTieu = rs.getDouble("GiaNhap");
        }
        return chiTieu;
    }
    
    
    
    public int tongLuotMua() throws SQLException {
        String sql = "SELECT COUNT(*) AS TongSoLuotMua FROM HoaDon";
        ResultSet rs = Xjdbc.query(sql);
        int tongLuotMua = 0;
        while (rs.next()) {
            tongLuotMua = rs.getInt("TongSoLuotMua");
        }
        return tongLuotMua;
    }
    
    public int luotMuaTheoThang(int thang) throws SQLException {
        String sql = "{CALL sp_SoLuotMuaTheoThang (?)}";
        ResultSet rs = Xjdbc.query(sql, thang);
        int LuotMua = 0;
        while (rs.next()) {
            LuotMua = rs.getInt("SoLuotMua");
        }
        return LuotMua;
    }
     
    public int tongSoSanPhamDuocMua() throws SQLException {
        String sql = "SELECT SUM(SoLuong) AS SoLuong FROM HoaDonChiTiet";
        ResultSet rs = Xjdbc.query(sql);
        int soSanPham =0;
        while (rs.next()) {
            soSanPham = rs.getInt("SoLuong");
        }
        return soSanPham;
    }
    
    public List<Object[]> thongKeSanPham() {
        String sql = "SELECT SanPham.MaSP, SUM(HoaDonChiTiet.SoLuong*SanPham.GiaBan) AS DoanhThu, SUM(HoaDonChiTiet.SoLuong) AS DoanhSo\n"
                + "FROM SanPham JOIN HoaDonChiTiet ON SanPham.MaSP = HoaDonChiTiet.MaSanPham\n"
                + "GROUP By SanPham.MaSP";
        String[] cols = {"MaSP","DoanhThu","DoanhSo"};
        List<Object[]> list = getListOfArrays(sql, cols);
        return list;
    }

    
    public List<Object[]> getListOfArrays(String sql, String[] cols, Object ...arg) {
        try {
            List<Object[]>list = new ArrayList<>();
            ResultSet rs = Xjdbc.query(sql, arg);
            while(rs.next()) {
                Object[] vals = new Object[cols.length];
                for(int i=0;i<cols.length;i++) {
                    vals[i] = rs.getObject(cols[i]);  
                }
                list.add(vals);
            }
            rs.getStatement().close();
            return list;
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public class TopDoanhThu {
        private String tenSP;
        private double DoanhThu;
        public double getDoanhThu() {
            return DoanhThu;
        }

        public void setDoanhThu(double DoanhThu) {
            this.DoanhThu = DoanhThu;
        }
        
        public String getTenSP() {
            return tenSP;
        }

        public void setTenSP(String tenSP) {
            this.tenSP = tenSP;
        }
        
    }
    
    public class ThongKeTheoThang {
        private String thang;
        private double doanhThu;
        private double chiTieu;

        public String getThang() {
            return thang;
        }

        public double getDoanhThu() {
            return doanhThu;
        }

        public double getChiTieu() {
            return chiTieu;
        }

        public void setThang(String thang) {
            this.thang = thang;
        }

        public void setDoanhThu(double doanhThu) {
            this.doanhThu = doanhThu;
        }

        public void setChiTieu(double chiTieu) {
            this.chiTieu = chiTieu;
        }
        
        
    }
}

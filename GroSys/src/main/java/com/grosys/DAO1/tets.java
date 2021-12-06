/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.DAO1;

import com.grosys.untity.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.XDate;
import utils.Xjdbc;

/**
 *
 * @author Sang
 */
public class tets {
    SanPhamDAO spDao = new SanPhamDAO();
    NhaSanXuatDAO nsxDao = new NhaSanXuatDAO();
    LoaiSanPhamDAO lspDao = new LoaiSanPhamDAO();
    HoivienDao hvDao = new HoivienDao();
    PhieuGiamGiaDao pggDao = new PhieuGiamGiaDao();
    HoaDonDAO hdDao = new HoaDonDAO();
    HDCTDAO hdctDao = new HDCTDAO();
    NhanvienDao dao = new NhanvienDao();
    String maHD = "";
    public static String TaoMaNV() throws SQLException {
        String sql = "SELECT TOP 1 * FROM NhanVien ORDER BY MaNV DESC";
        int SoNV = 0;
        String maNV = "";
        ResultSet rs = Xjdbc.query(sql);
        while(rs.next()) {
             maNV = rs.getString(1);
        }
        SoNV = Integer.parseInt(maNV.substring(2));
        return "NV"+(SoNV+1);
    }
    public static void main(String[] args) throws SQLException {
       
        System.out.println(TaoMaNV());
       
    }
}

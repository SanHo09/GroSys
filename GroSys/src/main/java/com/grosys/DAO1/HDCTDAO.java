/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.DAO1;

import com.grosys.untity.HoaDonChiTiet;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class HDCTDAO extends GrosysDAO<HoaDonChiTiet, String> {

    @Override
    public void insert(HoaDonChiTiet model) {
        String sql ="INSERT INTO HoaDonChiTiet(MaHD, MaSanPham, SoLuong)VALUES(?,?,?)";
        Xjdbc.update(sql,
               model.getMaHD(),
               model.getMaSP(),
               model.getSoLuong()
        );
    }

    @Override
    public void update(HoaDonChiTiet model) {
        String sql ="UPDATE HoaDonChiTiet SET MaHD=?, MaSanPham=?, soLuong=? Where MaHDCT=?";
        Xjdbc.update(sql,
               model.getMaHD(),
               model.getMaSP(),
               model.getMaHDCT(),
               model.getSoLuong());
    }

    @Override
    public void delete(String id) {
       String sql="DELETE FROM HoaDonChiTiet WHERE MaHDCT=?";
        Xjdbc.update(sql, id);
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        String sql="SELECT hdct.*, sp.TenSP AS 'TenSP', sp.GiaBan*hdct.SoLuong AS 'Gia'\n" +
"FROM HoaDonChiTiet hdct JOIN SanPham sp ON hdct.MaSanPham = sp.MaSP";
        return this.selectBySql(sql);
    }

    @Override
    public HoaDonChiTiet selectById(String id) {
        String sql="SELECT * FROM HoaDonChiTiet WHERE MaHDCT=?";
        List<HoaDonChiTiet> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<HoaDonChiTiet>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    HoaDonChiTiet entity =new HoaDonChiTiet();
                    entity.setMaHD(rs.getString("MaHD"));
                    entity.setMaHDCT(rs.getString("MaHDCT"));
                    entity.setMaSP(rs.getString("MaSanPham"));
                    entity.setTenSP(rs.getString("TenSP"));
                    entity.setSoLuong(rs.getInt("soLuong"));
                    entity.setGia(rs.getDouble("Gia"));
                    list.add(entity);
                }
            } finally{
                rs.getStatement().getConnection().close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    public void thucHienGiaoDich(HoaDonChiTiet model) {
        String sql = "{CALL sp_GiaoDich(?,?)}";
        Xjdbc.update(sql, model.getMaSP(), model.getSoLuong());
    }
    
    public List<HoaDonChiTiet> selectByMaHD(String MaHD) {
        String sql="SELECT hdct.*, sp.TenSP AS 'TenSP', sp.GiaBan*hdct.SoLuong AS 'Gia'\n" +
                "FROM HoaDonChiTiet hdct JOIN SanPham sp ON hdct.MaSanPham = sp.MaSP WHERE MaHD=?";
        return this.selectBySql(sql, MaHD);
    }
    
}

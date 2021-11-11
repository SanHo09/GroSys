/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.DAO1;


import com.grosys.DAO.*;
import com.grosys.untity.sanPham;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.Xjdbc;

/**
 *
 * @author HP
 */
public class sanPhamDAO extends grosysDAO<sanPham, String>{

    
    public void insert(sanPham model) {
      
        String sql ="INSERT INTO SanPham(MaSP, TenSP, MaLSP, GiaBan, HanSuDung, DonViTinh, SoLuong, Anh)VALUES(?,?,?,?,?,?,?,?)";
        Xjdbc.update(sql,
                model.getMaSP(),
                model.getTenSP(),
                model.getMaLSP(),
                model.getGiaBan(),
                model.getHanSuDung(),
                model.getDonViTinh(),
                model.getSoLuong(),
                model.getAnh());
    }

    
    public void update(sanPham model) {
        String sql ="UPDATE SanPham SET TenSP=?, MaLSP=?, GiaBan=?, HanSuDung=?, DonViTinh=?, SoLuong=?, Anh=? WHERE MaSP=?";
        Xjdbc.update(sql,
                model.getTenSP(),
                model.getMaLSP(),
                model.getGiaBan(),
                model.getHanSuDung(),
                model.getDonViTinh(),
                model.getSoLuong(),
                model.getAnh());
    }

    
    public void delete(String MaSP) {
        String sql="DELETE FROM SanPham WHERE MaSP=?";
        Xjdbc.update(sql, MaSP);
    }

    
    public List<sanPham> selectAll() {
        String sql="SELECT*FROM SanPham";
        return this.selectBySql(sql);
    }

    
    public sanPham selectById(String masp) {
        String sql="SELECT * FROM SanPham WHERE MaSP=?";
        List<sanPham> list = selectBySql(sql, masp);
        return list.size() > 0 ? list.get(0) : null;
    }

    
    protected List<sanPham> selectBySql(String sql, Object... args) {
        List<sanPham> list = new ArrayList<sanPham>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    sanPham entity =new sanPham();
                    entity.setMaSP(rs.getString("MaSP"));
                    entity.setTenSP(rs.getString("TenSP"));
                    entity.setMaLSP(rs.getString("MaLSP"));
                    entity.setGiaBan(rs.getDouble("GiaBan"));
                    entity.setHanSuDung(rs.getDate("HanSuDung"));
                    entity.setDonViTinh(rs.getString("DonViTinh"));
                    entity.setSoLuong(rs.getInt("SoLuong"));
                    entity.setAnh(rs.getString("Anh"));
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
    
}

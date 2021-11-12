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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.XDate;
import utils.Xjdbc;

/**
 *
 * @author HP
 */
public class SanPhamDAO extends GrosysDAO<SanPham, String>{

    
    public void insert(SanPham model) {
        String sql ="{CALL sp_Them_SanPham (?,?,?,?,?,?,?,?,?,?,?,?)}";
        Xjdbc.query(sql,
                model.getMaSP(),
                model.getTenSP(),
                model.getMaLSP(),
                model.getGiaBan(),
                model.getHanSuDung(),
                model.getDonViTinh(),
                model.getSoLuong(),
                model.getAnh(),
                model.getMaNPP(),
                model.getMaNSX(),
                model.getTenNSX(),
                model.getGiaNhap());
    }

    
    public void update(SanPham model) {
        String sql ="UPDATE SanPham SET TenSP=?, MaLSP=?, GiaBan=?, HanSuDung=?, DonViTinh=?, SoLuong=?, Anh=? WHERE MaSP=?";
        Xjdbc.query(sql,
                model.getTenSP(),
                model.getMaLSP(),
                model.getGiaBan(),
                model.getHanSuDung(),
                model.getDonViTinh(),
                model.getSoLuong(),
                model.getAnh());
    }

    
    public void delete(String MaSP) {
        String sql="{CALL sp_Xoa_SanPham WHERE MaSP(?)}";
        Xjdbc.query(sql, MaSP);
    }

    
    public List<SanPham> selectAll() {
            List<SanPham> list = new ArrayList<>();
            String sql="{CALL sp_LoadSanPham}";
            ResultSet rs = Xjdbc.query(sql);
        try {
            while(rs.next()) {
                SanPham model = new SanPham();
                model.setMaNSX(rs.getString("MaNSX"));                                           
                model.setMaSP(rs.getString("MaSP"));
                model.setTenSP(rs.getString("TenSP"));
                model.setGiaNhap(rs.getDouble("GiaNhap"));
                model.setMaLSP(rs.getString("MaLSP"));
                model.setGiaBan(rs.getFloat("GiaBan"));
                model.setHanSuDung(rs.getDate("HanSuDung"));
                model.setDonViTinh(rs.getString("DonViTinh"));
                model.setSoLuong(rs.getInt("SoLuong"));
                model.setAnh(rs.getString("Anh"));
                model.setTenLSP(rs.getString("TenLSP"));
                list.add(model);
            }
                
                
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 

    
    public SanPham selectById(String masp) {
        String sql="{CALL sp_LoadSanPhamTheoID WHERE MaSP(?)}";
        List<SanPham> list = selectBySql(sql, masp);
        return list.size() > 0 ? list.get(0) : null;
    }

    
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<SanPham>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    SanPham entity =new SanPham();
                    entity.setMaSP(rs.getString("MaSP"));
                    entity.setTenSP(rs.getString("TenSP"));
                    entity.setMaLSP(rs.getString("MaLSP"));
                    entity.setGiaBan(rs.getDouble("GiaBan"));
                    entity.setHanSuDung(rs.getDate("HanSuDung"));
                    entity.setDonViTinh(rs.getString("DonViTinh"));
                    entity.setSoLuong(rs.getInt("SoLuong"));
                    entity.setAnh(rs.getString("Anh"));
                    entity.setMaNPP(rs.getString("MaNPP"));
                    entity.setMaNSX(rs.getString("MaNSX"));
                    entity.setTenNSX(rs.getString("TenNXS"));
                    entity.setGiaNhap(rs.getDouble("GiaNhap"));
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

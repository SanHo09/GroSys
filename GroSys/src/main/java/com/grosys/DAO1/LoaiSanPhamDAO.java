/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.DAO1;

import com.grosys.untity.LoaiSanPham;
import com.grosys.untity.NhaPhanPhoi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class LoaiSanPhamDAO extends  GrosysDAO<LoaiSanPham, String>{

    @Override
    public void insert(LoaiSanPham entity) {
        String sql = "INSERT INTO SanPham(MaLSP, TenLSP, GhiChu) VALUES(?,?,?)";
        Xjdbc.update(sql, entity.getMaLSP()
                        , entity.getTenLSP()
                        , entity.getGhiChu());
    }

    @Override
    public void update(LoaiSanPham entity) {
        String sql = "UPDATE LoaiSanPham SET TenLSP = ?, GhiChu = ? WHERE MaLSP = ?";
        Xjdbc.update(sql, entity.getTenLSP()
                        , entity.getGhiChu()
                        , entity.getMaLSP());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE LoaiSanPham WHERE MaLSP = ?";
        Xjdbc.update(sql, id);
    }

    @Override
    public List<LoaiSanPham> selectAll() {
        String sql = "SELECT * FROM LoaiSanPham";
        return this.selectBySql(sql);
    }

    @Override
    public LoaiSanPham selectById(String id) {
        String sql = "SELECT * FROM LoaiSanPham WHERE MaLSP = ?";
        List<LoaiSanPham> list = this.selectBySql(sql, id);
        return list.size()>0?list.get(0):null;
    }

    @Override
    protected List<LoaiSanPham> selectBySql(String sql, Object... args) {
        List<LoaiSanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    LoaiSanPham entity =new LoaiSanPham();
                    entity.setMaLSP(rs.getString("MaLSP"));
                    entity.setTenLSP(rs.getString("TenLSP"));
                    entity.setGhiChu(rs.getString("GhiChu"));
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

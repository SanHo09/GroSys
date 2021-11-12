/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.DAO1;

import com.grosys.untity.PhieuGiamGia;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class PhieuGiamGiaDao extends grosysDAO<PhieuGiamGia, String> {

    @Override
    public void insert(PhieuGiamGia model) {
        String sql ="INSERT INTO PhieuGiamGia(MaHV, HanSD, MaNV, MaSP)VALUES(?,?,?,?)";
               Xjdbc.update(sql,
               model.getMaHV(),
               model.getHanSD(),
               model.getMaNV(),
               model.getMaSP());
    }

    @Override
    public void update(PhieuGiamGia model) {
        String sql ="UPDATE PhieuGiamGia SET HanSD=?, MaNV=? Where MaHV=? and MaSP=?";
        Xjdbc.update(sql,
               model.getHanSD(),
               model.getMaNV(),
               model.getMaHV());
               model.getMaSP();
    }

    @Override
    public void delete(String id) {
        String sql="DELETE FROM PhieuGiamGia WHERE MaHV=?";
        Xjdbc.update(sql, id);
    }

    @Override
    public List<PhieuGiamGia> selectAll() {
         String sql="SELECT*FROM PhieuGiamGia";
        return this.selectBySql(sql);
    }

    @Override
    public PhieuGiamGia selectById(String id) {
        String sql="SELECT * FROM HoaDon WHERE MaHD=?";
        List<PhieuGiamGia> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<PhieuGiamGia> selectBySql(String sql, Object... args) {
        List<PhieuGiamGia> list = new ArrayList<PhieuGiamGia>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    PhieuGiamGia entity =new PhieuGiamGia();
                    entity.setMaHV(rs.getString("MaHV"));
                    entity.setMaSP(rs.getString("MaSP"));
                    entity.setHanSD(rs.getDate("HanSD"));
                    entity.setMaNV(rs.getString("MaNV"));
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

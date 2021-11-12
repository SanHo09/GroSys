/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.DAO1;


import com.grosys.untity.HoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.Xjdbc;

/**
 *
 * @author HP
 */
public class HoaDonDAO extends GrosysDAO<HoaDon, String>{

    
    public void insert(HoaDon model) {
       String sql ="INSERT INTO HoaDon(MaHD, NgayLHD, SoTien, MaNV)VALUES(?,?,?,?)";
       Xjdbc.update(sql,
               model.getMaHD(),
               model.getNgayLHD(),
               model.getSoTien(),
               model.getMaNV());
    }

    
    public void update(HoaDon model) {
        String sql ="UPDATE HoaDon SET NgayLHD=?, SoTien=?, MaNV=? Where MaHD=?";
        Xjdbc.update(sql,
               model.getNgayLHD(),
               model.getSoTien(),
               model.getMaNV());
               model.getMaHD();
    }

    
    public void delete(String MaHD) {
        String sql="DELETE FROM HoaDon WHERE MaHD=?";
        Xjdbc.update(sql, MaHD);
    }

    
    public List<HoaDon> selectAll() {
        String sql="SELECT*FROM HoaDon";
        return this.selectBySql(sql);
    }

    
    public HoaDon selectById(String mahd) {
        String sql="SELECT * FROM HoaDon WHERE MaHD=?";
        List<HoaDon> list = selectBySql(sql, mahd);
        return list.size() > 0 ? list.get(0) : null;
    }

    
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<HoaDon>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    HoaDon entity =new HoaDon();
                    entity.setMaHD(rs.getString("MaHD"));
                    entity.setNgayLHD(rs.getString("NgayLHD"));
                    entity.setSoTien(rs.getInt("SoTien"));
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

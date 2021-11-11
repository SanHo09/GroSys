/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.DAO1;


import com.grosys.untity.hoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.Xjdbc;

/**
 *
 * @author HP
 */
public class hoaDonDAO extends grosysDAO<hoaDon, String>{

    
    public void insert(hoaDon model) {
       String sql ="INSERT INTO HoaDon(MaHD, NgayLHD, SoTien, MaNV)VALUES(?,?,?,?)";
       Xjdbc.update(sql,
               model.getMaHD(),
               model.getNgayLHD(),
               model.getSoTien(),
               model.getMaNV());
    }

    
    public void update(hoaDon model) {
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

    
    public List<hoaDon> selectAll() {
        String sql="SELECT*FROM HoaDon";
        return this.selectBySql(sql);
    }

    
    public hoaDon selectById(String mahd) {
        String sql="SELECT * FROM HoaDon WHERE MaHD=?";
        List<hoaDon> list = selectBySql(sql, mahd);
        return list.size() > 0 ? list.get(0) : null;
    }

    
    protected List<hoaDon> selectBySql(String sql, Object... args) {
        List<hoaDon> list = new ArrayList<hoaDon>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    hoaDon entity =new hoaDon();
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grosys.dao;
import com.grosys.help.Xjdbc;
import com.grosys.untity.Hoivien;
import com.grosys.untity.hoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoivienDao extends grosysDAO<Hoivien, String> {
    
    @Override
    public void insert(Hoivien model) {
        String sql ="INSERT INTO HoaDon(MaHV, TenHV, Email, SDT)VALUES(?,?,?,?)";
       Xjdbc.update(sql,
               model.getMaHV(),
               model.getTenHV(),
               model.getEmail(),
               model.getSDT());
    }

    @Override
    public void update(Hoivien model) {
         String sql ="UPDATE HoiVien SET TenHV=?, Email=?, SDT=? Where MaHV=?";
        Xjdbc.update(sql,
               model.getMaHV(),
               model.getEmail(),
               model.getSDT());
               model.getMaHV();
    }

    @Override
    public void delete(String MaHV) {
        String sql="DELETE FROM HoiVien WHERE MAHV=?";
        Xjdbc.update(sql, MaHV);
    }

    @Override
    public List<Hoivien> selectAll() {
         String sql="SELECT*FROM Hocvien";
        return this.selectBySql(sql);
    }

    @Override
    public Hoivien selectById(String id) {
         String sql="SELECT*FROM HoaDon where MaHV=?";
        List<Hoivien> list =selectBySql(sql,id);
        return list.size()>0 ? list.get(0) :null;
    }

    @Override
    protected List<Hoivien> selectBySql(String sql, Object... args) {
         List<Hoivien> list = new ArrayList<Hoivien>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    Hoivien entity =new Hoivien();
                    entity.setMaHV(rs.getString("MaHV"));
                    entity.setTenHV(rs.getString("TenHV"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setSDT(rs.getString("SDT"));
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

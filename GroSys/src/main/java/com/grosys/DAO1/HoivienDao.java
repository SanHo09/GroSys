/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grosys.DAO1;

import com.grosys.untity.Hoivien;
import com.grosys.untity.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class HoivienDao extends GrosysDAO<Hoivien, String> {
    
    @Override
    public void insert(Hoivien model) {
        String sql ="INSERT INTO HoiVien(MaHV, TenHV, Email, SDT)VALUES(?,?,?,?)";
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
         String sql="SELECT*FROM HoiVien";
        return this.selectBySql(sql);
    }

    @Override
    public Hoivien selectById(String maHV) {
         String sql="SELECT*FROM HoiVien where MaHV=?";
        List<Hoivien> list =selectBySql(sql,maHV);
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
    
    public String TaoMaNV() throws SQLException {
        String sql = "SELECT TOP 1 * FROM HoiVien ORDER BY MaHV DESC";
        int SoNV = 0;
        String maNV = "";
        ResultSet rs = Xjdbc.query(sql);
        while(rs.next()) {
             maNV = rs.getString(1);
        }
        SoNV = Integer.parseInt(maNV.substring(2));
        return "HV"+(SoNV+1);
    }
    
}

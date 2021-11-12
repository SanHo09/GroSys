/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.DAO1;




import com.grosys.untity.KhuyenMai;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.Xjdbc;

/**
 *
 * @author HP
 */
public class KhuyenMaiDAO extends GrosysDAO<KhuyenMai, String>{

    
    public void insert(KhuyenMai model) {
        String sql ="INSERT INTO (MaHV, MaSP, HanSD, MaNV)VALUES(?,?,?,?)";
        Xjdbc.update(sql,
               model.getMaHV(),
               model.getMaSP(),
               model.getHanSD(),
               model.getMaNV());
    }

    
    public void update(KhuyenMai model) {
        String sql ="UPDATE PhieuGiamGia SET MaSP=?, HanSD=?, MaNV=? WHERE MaHV=?";
        Xjdbc.update(sql,
               model.getMaSP(),
               model.getHanSD(),
               model.getMaNV());
    }

    
    public void delete(String MaHV) {
        String sql="DELETE FROM PhieuGiamGia WHERE MaHV=?";
        Xjdbc.update(sql, MaHV);
    }

    
    public List<KhuyenMai> selectAll() {
        String sql="SELECT*FROM PhieuGiamGia";
        return this.selectBySql(sql);
    }

    
    public KhuyenMai selectById(String mahv) {
        String sql="SELECT * FROM PhieuGiamGia WHERE MaHV=?";
        List<KhuyenMai> list = selectBySql(sql, mahv);
        return list.size() > 0 ? list.get(0) : null;
    }

    
    protected List<KhuyenMai> selectBySql(String sql, Object... args) {
        List<KhuyenMai> list = new ArrayList<KhuyenMai>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    KhuyenMai entity =new KhuyenMai();
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

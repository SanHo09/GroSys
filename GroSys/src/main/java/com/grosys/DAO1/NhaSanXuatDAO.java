/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.DAO1;

/**
 *
 * @author ADMIN
 */
import com.grosys.untity.NhaSanXuat;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.Xjdbc;


public class NhaSanXuatDAO extends GrosysDAO<NhaSanXuat, String>{

    @Override
    public void insert(NhaSanXuat model) {
         String sql ="INSERT INTO NhaSanXuat(MaNSX, TenNSX, DiaChi, MaNPP)VALUES(?,?,?,?)";
               Xjdbc.update(sql,
               model.getMaNSX(),
               model.getTenNSX(),
               model.getDiaChi(),
               model.getMaNPP());
    }

    @Override
    public void update(NhaSanXuat model) {
         String sql ="UPDATE NhaSanXuat SET TenNSX=?, Diachi=? ,MaNPP=? where MaNSX=?";
        Xjdbc.update(sql,
               model.getTenNSX(),
               model.getDiaChi(),
               model.getMaNPP(),
                model.getMaNSX());
    }

    @Override
    public void delete(String id) {
        String sql="DELETE FROM NhaSanXuat WHERE MaNSX=?";
        Xjdbc.update(sql, id);
    }

    @Override
    public List<NhaSanXuat> selectAll() {
        String sql="select * from NhaSanXuat";
        return this.selectBySql(sql);
    }

    @Override
    public NhaSanXuat selectById(String id) {
         String sql="SELECT * FROM HoaDon WHERE MaHD=?";
        List<NhaSanXuat> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhaSanXuat> selectBySql(String sql, Object... args) {
         List<NhaSanXuat> list = new ArrayList<NhaSanXuat>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    NhaSanXuat entity =new NhaSanXuat();
                    entity.setMaNSX(rs.getString("MaNSX"));
                    entity.setTenNSX(rs.getString("TenNSX"));
                    entity.setDiaChi(rs.getString("DiaChi"));
                    entity.setMaNPP(rs.getString("MaNPP"));
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
    

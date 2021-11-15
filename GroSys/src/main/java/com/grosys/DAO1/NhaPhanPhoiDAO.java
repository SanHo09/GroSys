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
import com.grosys.untity.NhaPhanPhoi;
import com.grosys.untity.NhaSanXuat;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.Xjdbc;

public class NhaPhanPhoiDAO extends GrosysDAO<NhaPhanPhoi, String> {

    @Override
    public void insert(NhaPhanPhoi model) {
        String sql ="INSERT INTO NhaPhanPhoi(MaNPP, TenNPP, DiaChi, NamHoptac)VALUES(?,?,?,?)";
               Xjdbc.update(sql,
               model.getMaNPP(),
               model.getTenNPP(),
               model.getDiaChi(),
               model.getNamHoptac());
               
    }

    @Override
    public void update(NhaPhanPhoi model) {
         String sql ="UPDATE NhaPhanPhoi SET TenNPP=?, Diachi=? ,NamHopTac=? where MaNPP=?";
        Xjdbc.update(sql,
               model.getTenNPP(),
               model.getDiaChi(),
               model.getNamHoptac(),
                model.getMaNPP());
    }

    @Override
    public void delete(String id) {
         String sql="DELETE FROM NhaPhanPhoi WHERE MaNPP=?";
        Xjdbc.update(sql, id);
    }

    @Override
    public List<NhaPhanPhoi> selectAll() {
        String sql ="select * from NhaPhanPhoi";
        return this.selectBySql(sql);
    }

    @Override
    public NhaPhanPhoi selectById(String id) {
        String sql ="select * from NhaPhanPhoi where MaNPP=?";
        List<NhaPhanPhoi> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhaPhanPhoi> selectBySql(String sql, Object... args) {
        List<NhaPhanPhoi> list = new ArrayList<NhaPhanPhoi>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    NhaPhanPhoi entity =new NhaPhanPhoi();
                    entity.setMaNPP(rs.getString("MaNPP"));
                    entity.setTenNPP(rs.getString("TenNPP"));
                    entity.setDiaChi(rs.getString("DiaChi"));
                    entity.setNamHoptac(rs.getDate("NamHopTac"));
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

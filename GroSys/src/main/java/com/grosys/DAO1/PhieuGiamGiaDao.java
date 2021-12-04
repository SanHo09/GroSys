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
public class PhieuGiamGiaDao extends GrosysDAO<PhieuGiamGia, String> {

    @Override
    public void insert(PhieuGiamGia model) {
        String sql ="INSERT INTO PhieuGiamGia(MaHV, HanSD, MaNV, MaSP, GiaTri)VALUES(?,?,?,?,?)";
               Xjdbc.update(sql,
                    model.getMaHV(),
                    model.getHanSD(),
                    model.getMaNV(),
                    model.getMaSP(),
                    model.getGiaTri());
    }

    @Override
    public void update(PhieuGiamGia model) {
        String sql ="UPDATE PhieuGiamGia SET HanSD=?, MaNV=?, giaTri=? Where MaHV=? and MaSP=?";
        Xjdbc.update(sql,
               model.getHanSD(),
               model.getMaNV(),
               model.getMaHV());
               model.getMaSP();
    }

    public void deleteByIdMaSP(String MaHV, String MaSP) {
        String sql="DELETE PhieuGiamGia WHERE MaHV=? AND MaSP=?";
        Xjdbc.update(sql, MaHV, MaSP);
    }

    @Override
    public List<PhieuGiamGia> selectAll() {
        String sql = "SELECT hv.MaHV, hv.TenHV,sp.MaSP ,sp.TenSP, pgg.GiaTri, pgg.HanSD, nv.MaNV, nv.Ten AS 'TenNV'\n"
                + "	FROM PhieuGiamGia pgg JOIN SanPham sp ON pgg.MaSP = sp.MaSP\n"
                + "						  JOIN HoiVien hv ON pgg.MaHV = hv.MaHV\n"
                + "						  JOIN NhanVien nv ON pgg.MaNV = nv.MaNV\n";
            return this.selectBySql(sql);
    }

    @Override
    public PhieuGiamGia selectById(String id) {
        String sql = "SELECT hv.MaHV, hv.TenHV, pgg.MaSP, sp.TenSP, pgg.GiaTri, pgg.HanSD,nv.MaNV, nv.Ten AS 'TenNV'\n" +
"		FROM PhieuGiamGia pgg JOIN SanPham sp ON pgg.MaSP = sp.MaSP\n" +
"							  JOIN HoiVien hv ON pgg.MaHV = hv.MaHV\n" +
"							  JOIN NhanVien nv ON pgg.MaNV = nv.MaNV";
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
                    entity.setTenHV(rs.getString("TenHV"));
                    entity.setTenSP(rs.getString("TenSP"));
                    entity.setTenNV(rs.getString("TenNV"));
                    entity.setMaSP(rs.getString("MaSP"));
                    entity.setHanSD(rs.getDate("HanSD"));
                    entity.setMaNV(rs.getString("MaNV"));
                    entity.setGiaTri(rs.getDouble("GiaTri"));
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

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<PhieuGiamGia> selectByAnyThing(String MaHV, String tenHV, String MaSP, String tenSP, String hanSD, String tenNV, String maNV) {
        String sql = "SELECT hv.MaHV, hv.TenHV, sp.TenSP, pgg.GiaTri, pgg.HanSD, nv.Ten AS 'TenNV'\n"
                + "	FROM PhieuGiamGia pgg JOIN SanPham sp ON pgg.MaSP = sp.MaSP\n"
                + "						  JOIN HoiVien hv ON pgg.MaHV = hv.MaHV\n"
                + "						  JOIN NhanVien nv ON pgg.MaNV = nv.MaNV\n"
                + "	WHERE pgg.MaHV = ? OR TenHV=? OR pgg.MaSP = ? OR sp.TenSP = ? OR HanSD = ? OR nv.Ten= ? OR nv.MaNV = ?";
        return selectBySql(sql, MaHV, tenHV, MaSP, tenSP, hanSD, tenNV, maNV);
    }
   
    
    
}

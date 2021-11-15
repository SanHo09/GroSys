/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grosys.DAO1;
import com.grosys.untity.Nhanvien;
import java.util.List;
import com.grosys.untity.HoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.Xjdbc;
/**
 *
 * @author ADMIN
 */

public class NhanvienDao extends GrosysDAO<Nhanvien, String> {
    

    @Override
    public void insert(Nhanvien model) {
        String sql ="insert into Nhanvien(MaNV,MatKhau,Ten,SoDienThoai,Email,Anh,VaiTro) values (?,?,?,?,?,?,?)";
        Xjdbc.update(sql,
        model.getMaNV(),
        model.getMatkhau(),
        model.getHoten(),
        model.getSDT(),
        model.getEmail(),
        model.getAnh(),
        model.isVaitro()
        );
    }

    @Override
    public void update(Nhanvien model) {
        String sql ="update Nhanvien set MatKhau=?,ten=?,SoDienThoai=?,Email=?,Anh=?,VaiTro=? where MaNV=?";
        Xjdbc.update(sql,
        model.getMatkhau(),
        model.getHoten(),
        model.getSDT(),
        model.getEmail(),
        model.getAnh(),
        model.isVaitro(),
        model.getMaNV()
        );
    }

    @Override
    public void delete(String MaNV) {
        String sql ="Delete from Nhanvien where MaNV=?";
        Xjdbc.update(sql,MaNV);
    }

    @Override
    public List<Nhanvien> selectAll() {
        String sql="SELECT*FROM Nhanvien";
        return this.selectBySql(sql);
    }

    @Override
    public Nhanvien selectById(String MaNV) {
        String sql ="Select * from Nhanvien  where MaNV=?";
        List<Nhanvien> list=selectBySql(sql,MaNV);
        return list.size() >0 ?list.get(0) :null;
    }

    @Override
    protected List<Nhanvien> selectBySql(String sql, Object... args) {
        List<Nhanvien> list = new ArrayList<Nhanvien>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    Nhanvien entity =new Nhanvien();
                    entity.setMaNV(rs.getString("MaNV"));
                    entity.setMatkhau(rs.getString("MatKhau"));
                    entity.setHoten(rs.getString("ten"));
                    entity.setSDT(rs.getString("SoDienThoai"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setAnh(rs.getString("Anh"));
                    entity.setVaitro(rs.getBoolean("VaiTro"));
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.DAO1;

import com.grosys.untity.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.XDate;
import utils.Xjdbc;

/**
 *
 * @author Sang
 */
public class tets {
    
    public static void main(String[] args) throws SQLException {
        LoaiSanPhamDAO dap = new LoaiSanPhamDAO();
        System.out.println(dap.selectById("LSP01").getMaLSP());
        SanPhamDAO dao = new SanPhamDAO();
        SanPham sp = dao.selectById("sp01");
        sp.setMaSP("sp11");
        System.out.println(sp.getHanSuDung());
        String sql = "{CALL sp_Them_SanPham (?,?,?,?,?,?,?,?,?,?,?)}";
        Xjdbc.query(sql, "NPP01", "NSS01", "SP13", "San Pham 12", 12,"LSP01",
                    12, XDate.toDate("16-11-2021", "dd-MM-yyyy"), "Chai", 12, "");
       
    }
}

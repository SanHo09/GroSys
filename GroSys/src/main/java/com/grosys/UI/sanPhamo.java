/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.UI;

import com.grosys.DAO1.SanPhamDAO;
import com.grosys.untity.SanPham;
import utils.XDate;
import utils.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class sanPhamo {
    public static void main(String[] args) {
        SanPhamDAO dao = new SanPhamDAO();
        SanPham sp = dao.selectById("sp01");
        sp.setMaSP("sp11");
        System.out.println(sp.getHanSuDung());
        String sql = "{CALL sp_Them_SanPham (?,?,?,?,?,?,?,?,?,?,?)}";
        Xjdbc.query(sql, "NPP01", "NSS01", "SP12", "San Pham 12", 12,"LSP01",
                    12, XDate.toDate("16-11-2021", "dd-MM-yyyy"), "Chai", 12, "");
        
    }
}

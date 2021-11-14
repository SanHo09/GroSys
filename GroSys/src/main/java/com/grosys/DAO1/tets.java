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
import utils.Xjdbc;

/**
 *
 * @author Sang
 */
public class tets {
    
    public static void main(String[] args) throws SQLException {
        SanPhamDAO dao = new SanPhamDAO();
        SanPham sp = dao.selectById("Sp01");
        System.out.println(sp.getTenLSP());
    }
}

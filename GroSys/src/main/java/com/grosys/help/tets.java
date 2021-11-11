/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.help;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sang
 */
public class tets {
    public static void main(String[] args) throws SQLException {
        ResultSet st = Xjdbc.query("SELECT * FROM NhanVien");
        while(st.next()) {
            System.out.println(st.getString(1));
        }
    }
}

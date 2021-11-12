/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sang
 */
public class Xjdbc {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost:1433;Database = GroSys";
    static String user = "sa";
    static String password = "songlong";
    static {
        try {
            Class.forName(driver);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public static  PreparedStatement getStmt(String sql, Object ...args) throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt=null;
        if(sql.trim().startsWith("{")) {
            stmt = conn.prepareCall(sql);//PROC
            
        } else {
            stmt = conn.prepareStatement(sql); // SQL Query
        }
        for(int i=0;i<args.length;i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }
    
    public static ResultSet query(String sql, Object ...args)  {
        try{
            PreparedStatement stmt = Xjdbc.getStmt(sql, args);
            return stmt.executeQuery();   
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static Object value(String sql, Object ...args) {
        try {
            ResultSet rs = Xjdbc.query(sql, args);
            if(rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return null; 
        
    }
    
    public static int update(String sql, Object ...args) {
        try {
            PreparedStatement stmt = Xjdbc.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            }
            finally {
                stmt.getConnection().close();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

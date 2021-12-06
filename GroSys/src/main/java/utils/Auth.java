/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.grosys.untity.Nhanvien;

/**
 *
 * @author Sang
 */
public class Auth {
    public static Nhanvien user = null;
    public static void clear() {
        Auth.user = null;
    }
    public static boolean islogin() {
        return Auth.user!=null;
    }
    public static boolean isManager() {
        return Auth.islogin() && user.isVaitro();
    }

    
    
    
}

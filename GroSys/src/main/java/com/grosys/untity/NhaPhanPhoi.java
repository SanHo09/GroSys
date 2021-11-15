/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.untity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhaPhanPhoi {
    private String MaNPP;
    private String TenNPP;
    private String DiaChi;
    private Date NamHoptac;

    public NhaPhanPhoi() {
    }

    public NhaPhanPhoi(String MaNPP, String TenNPP, String DiaChi, Date NamHoptac) {
        this.MaNPP = MaNPP;
        this.TenNPP = TenNPP;
        this.DiaChi = DiaChi;
        this.NamHoptac = NamHoptac;
    }

    public String getMaNPP() {
        return MaNPP;
    }

    public String getTenNPP() {
        return TenNPP;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public Date getNamHoptac() {
        return NamHoptac;
    }

    public void setMaNPP(String MaNPP) {
        this.MaNPP = MaNPP;
    }

    public void setTenNPP(String TenNPP) {
        this.TenNPP = TenNPP;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setNamHoptac(Date NamHoptac) {
        this.NamHoptac = NamHoptac;
    }  

    @Override
    public String toString() {
        return this.getTenNPP();
    }
    
    
}

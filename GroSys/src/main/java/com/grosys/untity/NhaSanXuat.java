/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.untity;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.STItemType;

/**
 *
 * @author ADMIN
 */
public class NhaSanXuat {
    private String MaNSX;
    private String TenNSX;
    private String DiaChi;
    private String MaNPP;

    public NhaSanXuat() {
    }

    public NhaSanXuat(String MaNSX, String TenNSX, String DiaChi, String MaNPP) {
        this.MaNSX = MaNSX;
        this.TenNSX = TenNSX;
        this.DiaChi = DiaChi;
        this.MaNPP = MaNPP;
    }

    public String getMaNSX() {
        return MaNSX;
    }

    public String getTenNSX() {
        return TenNSX;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getMaNPP() {
        return MaNPP;
    }

    public void setMaNSX(String MaNSX) {
        this.MaNSX = MaNSX;
    }

    public void setTenNSX(String TenNSX) {
        this.TenNSX = TenNSX;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setMaNPP(String MaNPP) {
        this.MaNPP = MaNPP;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.untity;

/**
 *
 * @author ADMIN
 */
public class LoaiSanPham {
    String MaLSP;
    String TenLSP;
    String GhiChu;

    public String getMaLSP() {
        return MaLSP;
    }

    public String getTenLSP() {
        return TenLSP;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setMaLSP(String MaLSP) {
        this.MaLSP = MaLSP;
    }

    public void setTenLSP(String TenLSP) {
        this.TenLSP = TenLSP;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    @Override
    public String toString() {
        return this.getTenLSP();
    }
    
    
    
}

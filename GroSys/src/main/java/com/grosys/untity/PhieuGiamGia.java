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
public class PhieuGiamGia {
    private String MaHV;
    private String MaSP;
    private Date HanSD;
    private String MaNV;

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(String MaHV, String MaSP, Date HanSD, String MaNV) {
        this.MaHV = MaHV;
        this.MaSP = MaSP;
        this.HanSD = HanSD;
        this.MaNV = MaNV;
    }

    public Date getHanSD() {
        return HanSD;
    }

    public String getMaHV() {
        return MaHV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaHV(String MaHV) {
        this.MaHV = MaHV;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public void setHanSD(Date HanSD) {
        this.HanSD = HanSD;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
    
}

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
    private double giaTri;
    private String tenHV;
    private String tenSP;
    private String tenNV;
    

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(String MaHV, String MaSP, Date HanSD, String MaNV, double giaTri) {
        this.MaHV = MaHV;
        this.MaSP = MaSP;
        this.HanSD = HanSD;
        this.MaNV = MaNV;
        this.giaTri = giaTri;
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

    public double getGiaTri() {
        return giaTri;
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

    public void setGiaTri(double giaTri) {
        this.giaTri = giaTri;
    }

    public String getTenHV() {
        return tenHV;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenHV(String tenHV) {
        this.tenHV = tenHV;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    
    
    
}

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
public class HoaDonChiTiet {
    private String MaHDCT;
    private String MaHD;
    private String MaSP;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String MaHDCT, String MaHD, String MaSP) {
        this.MaHDCT = MaHDCT;
        this.MaHD = MaHD;
        this.MaSP = MaSP;
    }

    public String getMaHDCT() {
        return MaHDCT;
    }

    public String getMaHD() {
        return MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaHDCT(String MaHDCT) {
        this.MaHDCT = MaHDCT;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }
    
    
    
}

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
    private String tenSP;
    private int soLuong;
    private double gia;
    
    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String MaHDCT, String MaHD, String MaSP, int soLuong) {
        this.MaHDCT = MaHDCT;
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.soLuong = soLuong;
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

    public int getSoLuong() {
        return soLuong;
    }

    public String getTenSP() {
        return tenSP;
    }

    public double getGia() {
        return gia;
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

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
    
}

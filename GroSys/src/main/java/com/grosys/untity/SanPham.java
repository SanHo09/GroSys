/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.untity;

import java.util.Date;

/**
 *
 * @author HP
 */
public class SanPham {
    private String maSP;
    private String tenSP;
    private String maLSP;
    private String TenLSP;
    private double giaBan;
    private double GiaNhap; 
    private Date hanSuDung;
    private String donViTinh;
    private int soLuong;
    private String anh;
    private String MaNPP;
    private String MaNSX;
    private String TenNSX;
    
    
    public String getTenLSP() {
        return TenLSP;
    }

    public void setTenLSP(String TenLSP) {
        this.TenLSP = TenLSP;
    }
    
    
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaLSP() {
        return maLSP;
    }

    public void setMaLSP(String maLSP) {
        this.maLSP = maLSP;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMaNPP() {
        return MaNPP;
    }

    public String getMaNSX() {
        return MaNSX;
    }

    public String getTenNSX() {
        return TenNSX;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setMaNPP(String MaNPP) {
        this.MaNPP = MaNPP;
    }

    public void setMaNSX(String MaNSX) {
        this.MaNSX = MaNSX;
    }

    public void setTenNSX(String TenNSX) {
        this.TenNSX = TenNSX;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }
    
}

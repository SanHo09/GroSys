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
public class HoaDon {
    private String maHD;
    private Date ngayLHD;
    private double soTien;
    private String maNV;

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayLHD() {
        return ngayLHD;
    }

    public void setNgayLHD(Date ngayLHD) {
        this.ngayLHD = ngayLHD;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
}

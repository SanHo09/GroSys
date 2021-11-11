/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grosys.untity;

/**
 *
 * @author ADMIN
 */
public class Hoivien {
    private String MaHV;
    private String TenHV;
    private String Email ;
    private String SDT;

    public Hoivien() {
    }

    public Hoivien(String MaHV, String TenHV, String Email, String SDT) {
        this.MaHV = MaHV;
        this.TenHV = TenHV;
        this.Email = Email;
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public String getMaHV() {
        return MaHV;
    }

    public String getSDT() {
        return SDT;
    }

    public String getTenHV() {
        return TenHV;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setMaHV(String MaHV) {
        this.MaHV = MaHV;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setTenHV(String TenHV) {
        this.TenHV = TenHV;
    }
    
    
    
}

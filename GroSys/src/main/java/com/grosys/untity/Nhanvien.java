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
public class Nhanvien {
    private String MaNV;
    private String Matkhau;
    private String Email;
    private String SDT;
    private boolean Vaitro;
    private String Anh;
    private String Hoten;

    public Nhanvien() {
    }

    public Nhanvien(String MaNV, String Matkhau, String Email, String SDT, boolean Vaitro, String Anh, String Hoten) {
        this.MaNV = MaNV;
        this.Matkhau = Matkhau;
        this.Email = Email;
        this.SDT = SDT;
        this.Vaitro = Vaitro;
        this.Anh = Anh;
        this.Hoten = Hoten;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public String getEmail() {
        return Email;
    }

    public String getSDT() {
        return SDT;
    }

    public boolean isVaitro() {
        return Vaitro;
    }

    public String getAnh() {
        return Anh;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setVaitro(boolean Vaitro) {
        this.Vaitro = Vaitro;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }
    
    
}

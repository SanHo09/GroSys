/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.UI;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sang
 */
public class xuLyChuoi {
    static class hoadon {
       String tenSP;
       int soLuong;
       double Gia;

        public hoadon(String tenSP, int soLuong, double Gia) {
            this.tenSP = tenSP;
            this.soLuong = soLuong;
            this.Gia = Gia;
        }
       
       
    }
    public static void main(String[] args) {
        System.out.println("VIM nước rửa bồn cầu".length());
        System.out.println("---------------------------------------------------------");

        System.out.println("                          Hóa Đơn                   ");

        System.out.println("---------------------------------------------------------");

        System.out.println("---------------------------------------------------------");

        System.out.println(" Tên Sản Phẩm           Số Lượng         Giá             ");//số lượng: 24, Giá: 41

        System.out.println("---------------------------------------------------------");
        

        System.out.println("---------------------------------------------------------");

        List<hoadon> list = new ArrayList<>();
        hoadon hd1 = new hoadon("Ky tu ngan nhat ", 1, 1000);
        hoadon hd2 = new hoadon("Ky tu dai  nhat chuoi ", 123, 10000000);
        hoadon hd3 = new hoadon("Ky tu trung binh ne ", 11, 10000);
        list.add(hd1);
        list.add(hd2);
        list.add(hd3);
        for(hoadon i: list) {
            
            String string = " "+i.tenSP+"           "+i.soLuong+"       "+i.Gia;                      ;
            var theString = new StringBuilder(string);
            int begin = 23;
            while(String.valueOf(string.charAt(begin)).equals(" ")) {
                
                if(String.valueOf(string.charAt(begin)).equals(" ")) {
                    theString.deleteCharAt(begin);
                } else {
                    break;
                }
                begin++;
            }
            string = theString.toString();  
            System.out.println(string);
        }
        System.out.println("---------------------------------------------------------");
        System.out.println(" Total amount: " + 1000000 + "                           ");

        System.out.println("---------------------------------------------------------");

        System.out.println("                     Tây Nguyên Town                     ");

        System.out.println("                          GroSys                         ");

        System.out.println("*********************************************************");

        System.out.println("     Cảm Ơn quý khách đã mua hàng tại Tây Nguyên Town    ");

        System.out.println("*********************************************************");
    }
}

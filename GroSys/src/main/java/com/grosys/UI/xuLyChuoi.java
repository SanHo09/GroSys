/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.UI;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sang
 */
public class xuLyChuoi {
    static boolean boxInBox(int[] a, int[] b) {
        if(a[0]>=b[0]&&a[1]>=b[1]&&a[2]>=b[2])
            return true;
        else if(a[0]<=b[0]&&a[1]<=b[1]&&a[2]<=b[2])
            return true;
        return false;
    }
    public static void main(String[] args) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        System.out.println(month);
    }
}

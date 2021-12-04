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
    static boolean boxInBox(int[] a, int[] b) {
        if(a[0]>=b[0]&&a[1]>=b[1]&&a[2]>=b[2])
            return true;
        else if(a[0]<=b[0]&&a[1]<=b[1]&&a[2]<=b[2])
            return true;
        return false;
    }
    public static void main(String[] args) {
        int[] a = {15,9,3};
        int[] b = {4,4,4};
        System.out.println(boxInBox(a, b));
    }
}

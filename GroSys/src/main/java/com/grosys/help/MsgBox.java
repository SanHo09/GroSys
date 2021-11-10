/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grosys.help;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Sang
 */
public class MsgBox {
    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent,message,
                "GroSys",JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message,
                "Grosys",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    public static String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message, 
                "Grosys", JOptionPane.INFORMATION_MESSAGE);
    }
}

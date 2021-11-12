/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.*;
/**
 *
 * @author Sang
 */
public class HeaderColor extends DefaultTableCellRenderer{
       public HeaderColor() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            setForeground(Color.white);
            setFont(new Font("Segoe UI",Font.BOLD,12));
            setBackground(new java.awt.Color(10,102,194));
            
            return this;
        }

}


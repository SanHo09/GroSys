/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Sang
 */
public class HeaderColorGiaoDich extends DefaultTableCellRenderer{
       public HeaderColorGiaoDich() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            setForeground(Color.BLACK);
            setFont(new Font("Segoe UI",Font.BOLD,12));
            setBackground(new java.awt.Color(231, 235, 222));
            
            return this;
        }
    
}

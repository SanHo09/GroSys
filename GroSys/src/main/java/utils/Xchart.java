/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Sang
 */
public class Xchart {
    
    static public void drawBarChart(String title,String type,String value, Map<String, Double> map) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key: map.keySet()) {
            dataset.setValue(map.get(key), title, key);
        }
        JFreeChart chart = ChartFactory.createBarChart(title,type,value,dataset,
                PlotOrientation.VERTICAL, false, true, true);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame = new ChartFrame(title,chart);
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    static public void drawPieChart(String title, Map<String, Double> map) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (String key: map.keySet()) {
            dataset.setValue(key, map.get(key));
        }
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, true);
        PiePlot p = (PiePlot)chart.getPlot();
        ChartFrame frame = new ChartFrame(title,chart);
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    static public void drawLineChart(String title, String type, String value, Map<String, Double> map) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key: map.keySet()) {
            dataset.setValue(map.get(key), type, key);
        }
        JFreeChart chart = ChartFactory.createLineChart(title,type,value,dataset,
                PlotOrientation.VERTICAL, false, true, true);
        BarRenderer renderer = new BarRenderer();
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame = new ChartFrame(title,chart);
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

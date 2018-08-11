/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.text.DecimalFormat;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.BubbleXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;

/**
 *
 * @author angel
 */
public class Graphs extends JFrame {

    JFreeChart chart;
    XYZDataset data;

    public Graphs(DefaultXYZDataset dataset) {
        super("Robot");
        data = dataset;

        chart = ChartFactory.createBubbleChart("Robot", "Eje X", "Eje Y", data);

        // Set range for X-Axis
        XYPlot plot = chart.getXYPlot();
        NumberAxis domain = (NumberAxis) plot.getDomainAxis();
        domain.setRange(-50, 50);

        // Set range for Y-Axis
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(-50, 50);

        XYBubbleRenderer renderer = (XYBubbleRenderer) plot.getRenderer();
        BubbleXYItemLabelGenerator generator = new BubbleXYItemLabelGenerator(" {0}:({1},{2},{3}) ", new DecimalFormat("0"), new DecimalFormat("0"), new DecimalFormat("0"));
        renderer.setBaseItemLabelGenerator(generator);
        renderer.setBaseItemLabelsVisible(true);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

}

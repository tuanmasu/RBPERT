package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DoThi extends JPanel {

    String tit;

    public DoThi( ArrayList<ArrayList<Double>> duLieu, String tit) {
        this.tit = tit;
        setLayout(null);
        XYSeries a2 = new XYSeries("Do thi thoi gian");
        for (int i = 0; i < duLieu.size(); i++) {
            a2.add(duLieu.get(i).get(0), duLieu.get(i).get(1));
        }
        XYSeriesCollection B = new XYSeriesCollection();
        B.addSeries(a2);
        JFreeChart barChart = ChartFactory.createXYLineChart("Đồ thị phân bố xác suất thời gian hoàn thành của dự án" , "Time", "Probability", B, PlotOrientation.VERTICAL, false, false, false);
        barChart.getPlot().setBackgroundPaint(Color.WHITE);
        XYPlot plot = barChart.getXYPlot();
        XYLineAndShapeRenderer re = new XYLineAndShapeRenderer();
        re.setSeriesPaint(0, Color.BLUE);
        re.setSeriesStroke(0, new BasicStroke(4.0f));
        plot.setRenderer(re);
        ChartPanel panel = new ChartPanel(barChart);
        panel.setSize(400, 400);
        panel.setLocation(0, 0);
        this.add(panel);
    }

    public DoThi(ArrayList<ArrayList<Double>> duLieu, String s, int size) {
        XYSeries a = new XYSeries("Do thi thoi gian");
        for (int i = 0; i < duLieu.size(); i++) {
            a.add(duLieu.get(i).get(0), duLieu.get(i).get(1));
        }

        XYSeriesCollection B = new XYSeriesCollection();
        B.addSeries(a);
        JFreeChart barChart = ChartFactory.createXYLineChart("Đồ thị thể hiện sự phụ thuộc thời gian và xác suất", "Time", "Probability", B, PlotOrientation.VERTICAL, true, true, true);
        barChart.getPlot().setBackgroundPaint(Color.WHITE);
        XYPlot plot = barChart.getXYPlot();
        XYLineAndShapeRenderer re = new XYLineAndShapeRenderer();
        re.setSeriesPaint(0, Color.BLUE);
        re.setSeriesStroke(0, new BasicStroke(4.0f));

        plot.setRenderer(re);
        ChartPanel panel = new ChartPanel(barChart);
        //JFrame fame = new JFrame();
        this.add(panel);
        this.setSize(400, 400);
        this.setVisible(true);
    }
}

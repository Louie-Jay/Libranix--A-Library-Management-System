package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class CustomChart extends JPanel{
	
	private JFreeChart chart;
	private String title;
	private Map<Integer, List<String>> data;
	
	private BufferedImage buffImg;
	private File chartFile;
	private FileInputStream chartInput;
	
	public CustomChart(String prmType, String prmTitle, Map<Integer, List<String>> prmData) {
		this.title = prmTitle;
		this.data = prmData;
		this.loadChart(prmType);
		this.setBorder(new LineBorder(new Color(100, 149, 237)));
		this.setLayout(new GridLayout(1,1));
		this.setMaximumSize(new Dimension(360, 360));
		this.setMinimumSize(new Dimension(360, 360));
		this.setPreferredSize(new Dimension(360, 360));
		this.add(getChart());
		
	}
	
	public FileInputStream getImg() {
		
		try {
			buffImg = chart.createBufferedImage(480, 360);
			
			chartFile = new File(title+".png");
			ImageIO.write(buffImg, "png", chartFile);
			
			chartInput = new FileInputStream(chartFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return chartInput;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public Map<Integer, List<String>> getData(){
		return this.data;
	}
	
	private ChartPanel getChart() {
		return new ChartPanel(chart);
	}
	
	private void loadChart(String prmType) {
		switch (prmType) {
		case "Pie":
			chart = ChartFactory.createPieChart3D(this.getTitle(), this.createPieData(), false, true, false);
			break;
		case "Bar":
			chart = ChartFactory.createBarChart(this.getTitle(), "", "Total No.", this.createBarData(), PlotOrientation.VERTICAL, false, true, false);
			break;
		default:
			break;
		}
		
		chart.setBorderPaint(new Color(100, 149, 237));
		chart.getTitle().setFont(new Font("Lucida Sans", Font.BOLD, 15));
		chart.getTitle().setPaint(new Color(100, 149, 237));
		chart.setBackgroundPaint(new Color(0, 0, 0, 0));
		this.applyChartTheme(chart);
	}
	
	public void applyChartTheme(JFreeChart chart) {
        final StandardChartTheme chartTheme = (StandardChartTheme)org.jfree.chart.StandardChartTheme.createJFreeTheme();

        if (Locale.getDefault().getLanguage().equals(Locale.ENGLISH.getLanguage())) {
            final Font oldExtraLargeFont = chartTheme.getExtraLargeFont();
            final Font oldLargeFont = chartTheme.getLargeFont();
            final Font oldRegularFont = chartTheme.getRegularFont();
            final Font oldSmallFont = chartTheme.getSmallFont();

            final Font extraLargeFont = new Font("Lucida Sans", oldExtraLargeFont.getStyle(), oldExtraLargeFont.getSize());
            final Font largeFont = new Font("Lucida Sans", oldLargeFont.getStyle(), oldLargeFont.getSize());
            final Font regularFont = new Font("Lucida Sans", oldRegularFont.getStyle(), oldRegularFont.getSize());
            final Font smallFont = new Font("Lucida Sans", oldSmallFont.getStyle(), oldSmallFont.getSize());

            chartTheme.setExtraLargeFont(extraLargeFont);
            chartTheme.setLargeFont(largeFont);
            chartTheme.setRegularFont(regularFont);
            chartTheme.setSmallFont(smallFont);
        }

        chartTheme.apply(chart);
    }
	
	private PieDataset createPieData() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for(List<String> list : (this.getData()).values()) {
			dataset.setValue(list.get(0), Integer.valueOf(list.get(1)));
		}
		
		return dataset;
	}
	
	private DefaultCategoryDataset createBarData() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for(List<String> list : (this.getData()).values()) {
			dataset.addValue(Integer.valueOf(list.get(1)), list.get(0), "Books");
		}
		
		return dataset;
	}
	
}

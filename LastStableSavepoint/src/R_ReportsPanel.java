import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;


public class R_ReportsPanel extends JPanel{
	
	JPanel headerTitle;
	JLabel title;
	
	JFreeChart chart;
	ChartPanel cp;
	
	JPanel footerButtons;
	JButton btnGenerateReport;

	public R_ReportsPanel() {
		this.setLayout(new BorderLayout(0,5));
		
		loadHeader();
		loadContentChart();
		loadFooterOptions();
		
	}
	
	private void loadHeader() {
		headerTitle = new JPanel(new FlowLayout(FlowLayout.LEADING));
		title = new JLabel("Library Reports");
		title.setFont(new Font("Arial", 1, 30)); // header title font here
		
		headerTitle.add(Box.createRigidArea(new Dimension(5,75)));
		headerTitle.add(title);
		headerTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLACK)); // border color here
		this.add(headerTitle, BorderLayout.PAGE_START);
	}
	
	private void loadContentChart() {
		DefaultCategoryDataset ds = createDataset(); // creates the dataset
		
		chart = ChartFactory.createBarChart("", "", "Total", ds); // applies the dataset into the chart
		
		cp = new ChartPanel(chart); // adds the chart to the ChartPanel(JPanel)
		
		this.add(cp,BorderLayout.CENTER);
	}
	
	private DefaultCategoryDataset createDataset() {// initialize dataset for BarChart
		//DefaultXYDataset ds = new DefaultXYDataset();
		//double[][] data = { {0.1, 0.2, 0.3}, {1, 2, 3} }; // data here
		//ds.addSeries("series1",data);
		
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		
		ds.addValue(2, "Borrowed", "");
		ds.addValue(5, "Available", "");
		ds.addValue(3, "Members", "");
		 
		return ds;
	}
	
	private void loadFooterOptions() {
		footerButtons = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		
		btnGenerateReport = new JButton("Generate Report");
		
		JCheckBox chkBorrowedBook = new JCheckBox("Borrowed Books");
		JCheckBox chkAvailableBook = new JCheckBox("Available Books");
		JCheckBox chkMembers = new JCheckBox("Members");
		
		
		footerButtons.add(chkBorrowedBook);
		footerButtons.add(chkAvailableBook);
		footerButtons.add(chkMembers);
		footerButtons.add(btnGenerateReport);
		
		this.add(footerButtons,BorderLayout.PAGE_END);
		
	}
}

package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;

import controller.R_ReportsController;
import controller.RequestController;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.ScrollPaneConstants;


public class R_ReportsPanel extends JPanel{
	
	JPanel parentPanel;
	HeaderPanel header;
	
	JPanel contentPanel;
	
	JPanel chartPanel;
	CustomChart pieChart1;
	CustomChart barChart1;
	CustomChart barChart2;
	CustomChart pieChart2;
	
	JEditorPane txtAreaRequest;
	
	JPanel footerButtons;
	JButton btnGenReport;
	R_ReportsController controller;
	RequestController rqstController;
	
	HashMap<String,CustomChart> charts;
	JFileChooser chooser;
	
	public R_ReportsPanel(JPanel parentPnl) {
		setBackground(new Color(255, 250, 250));
		this.parentPanel = parentPnl;
		this.setLayout(new BorderLayout(0,5));
		
		this.controller = new R_ReportsController();
		this.rqstController = new RequestController();
		
		this.charts = new HashMap<String,CustomChart>();
		
		loadHeader();
		loadContentChart();
		loadFooterOptions();
		
	}
	
	private void loadHeader() {
		header = new HeaderPanel("Library Reports",false);
		this.add(header, BorderLayout.PAGE_START);
		
	}
	
	private void loadContentChart() {
		contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 250));
		chartPanel = new JPanel(new GridLayout(2,2));
		chartPanel.setBackground(new Color(255, 250, 250));
		pieChart1 = new CustomChart("Pie", "Books & Members", controller.getBkMbr());
		barChart1 = new CustomChart("Bar", "Borrowed Total", controller.getBrwBk());
		barChart2 = new CustomChart("Bar", "Books Quantity", controller.getBkQuantity());
		pieChart2 = new CustomChart("Pie", "Most Borrowed", controller.getMostBorrowed());
		chartPanel.add(pieChart1);
		chartPanel.add(barChart1);
		chartPanel.add(barChart2);
		chartPanel.add(pieChart2);
		
		charts.put("P1", pieChart1);
		charts.put("B1", barChart1);
		charts.put("B2", barChart2);
		charts.put("P2", pieChart2);
		
		
		chartPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Charts:"));
		TitledBorder border1 = (TitledBorder) chartPanel.getBorder();
		border1.setTitleFont(new Font("Lucida Sans", Font.BOLD, 13));
		
		contentPanel.add(chartPanel, BorderLayout.CENTER);
		
		txtAreaRequest = new JEditorPane();
		txtAreaRequest.setToolTipText("Add/Edit request at Dashboard > Requests");
		txtAreaRequest.setEditable(false);
		txtAreaRequest.setMinimumSize(new Dimension(7, 100));
		txtAreaRequest.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rqstController.loadRequest(txtAreaRequest);
		txtAreaRequest.setPreferredSize(new Dimension(0,100));
		
		JScrollPane sp = new JScrollPane(txtAreaRequest,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setToolTipText("");
		sp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		sp.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		sp.setPreferredSize(new Dimension(500, 100));
		sp.setMaximumSize(new Dimension(500, 100));
		sp.setMinimumSize(new Dimension(500, 100));
		sp.setOpaque(false);
		sp.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Request:"));
		sp.getVerticalScrollBar().setUI(new CustomScrollBarProperties());
		sp.getHorizontalScrollBar().setUI(new CustomScrollBarProperties());
		TitledBorder border2 = (TitledBorder) sp.getBorder();
		border2.setTitleFont(new Font("Lucida Sans", Font.BOLD, 13));
		
		contentPanel.add(sp, BorderLayout.PAGE_END);
		
		this.add(contentPanel,BorderLayout.CENTER);
	}
	
	private void loadFooterOptions() {
		footerButtons = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		footerButtons.setBackground(new Color(100, 149, 237));
		
		btnGenReport = new JButton("Generate Report");
		btnGenReport.setMaximumSize(new Dimension(125, 23));
		btnGenReport.setMinimumSize(new Dimension(125, 23));
		btnGenReport.setPreferredSize(new Dimension(125, 23));
		btnGenReport.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnGenReport.setBorder(new LineBorder(new Color(255, 250, 250)));
		btnGenReport.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		btnGenReport.setBackground(new Color(255, 250, 250));
		
		btnGenReport.addActionListener(new ButtonHandler());
		btnGenReport.addMouseListener(new MouseHandler());
		
		footerButtons.add(btnGenReport);
		
		this.add(footerButtons,BorderLayout.PAGE_END);
		
	}
	
	
	private class ButtonHandler implements ActionListener{
		JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(parentPanel);
		@Override
		public void actionPerformed(ActionEvent evt) {
			chooser = new JFileChooser(FileSystemView.getFileSystemView());
			chooser.setDialogTitle("Choose a directory to save reports:");
			int returnVal;
			
			if (ConfirmDialog.getResult(parent, "Generate reports?")) {
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				while (true) {
					returnVal = chooser.showSaveDialog(parentPanel);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						if (controller.generateReport((chooser.getSelectedFile()), charts)) {
							MessageDialog.showDialog(parent, "Reports file saved!", "Success");
							break;
						} else {
							ErrorDialog.showErrorDialog(parent, controller.getErrorMsg());
						}
					}else {
						break;
					}
				}
			}
		}
	}
	
	private class MouseHandler extends MouseAdapter{
		JButton btnSource;
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(30, 144, 255));
			btnSource.setOpaque(true);
			btnSource.setForeground(new Color(255, 250, 250));
			btnSource.setBorder(new LineBorder((Color)new Color(255, 250, 250)));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(255, 250, 250));
			btnSource.setOpaque(true);
			btnSource.setForeground(new Color(0, 0, 0));
			btnSource.setBorder(new LineBorder(new Color(255, 250, 250)));
		}
		
	}
	
}

package sample;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class DashboardJLayeredPaneSample extends JLayeredPane{
	
	JPanel heading = new JPanel();
	JPanel totalBooks = new JPanel();
	JPanel totalMembers = new JPanel();
	JPanel currentlyBorrowed = new JPanel();
	JPanel checkInsOuts = new JPanel();
	JPanel generateReport = new JPanel();
	
	
	public DashboardJLayeredPaneSample() {
		
		//this.setLayout(new GridBagLayout());
		this.setBackground(CustomDesign.color4);
		this.setOpaque(true);
		initializeContent();
	}
	
	public void initializeContent(){
		
		JLabel dashboardHeader = new JLabel("Dashboard - Reports");
		dashboardHeader.setFont(CustomDesign.headerFont);
		dashboardHeader.setForeground(CustomDesign.color2);
		heading.setBounds(0, 0, 1100, 139);
		heading.setBackground(CustomDesign.backgroundColor);
		heading.setLayout(new FlowLayout(FlowLayout.LEADING,5,50));
		dashboardHeader.setLocation(0,5);
		heading.add(dashboardHeader);
		this.add(heading, JLayeredPane.DEFAULT_LAYER);
		
		JLabel txttotalBook = new JLabel("Total Books");
		JLabel txtvalttlBooks = new JLabel("2342"); // dynamic
		txttotalBook.setFont(CustomDesign.subheaderFont);
		txttotalBook.setForeground(CustomDesign.color2);
		txtvalttlBooks.setFont(CustomDesign.textFont);
		txtvalttlBooks.setForeground(CustomDesign.color2);
		totalBooks.setBounds(100, 200, 300, 100);
		totalBooks.setBackground(CustomDesign.color1); // color3 when hover, clicked
		
		totalBooks.setLayout(new BoxLayout(totalBooks, BoxLayout.PAGE_AXIS));
		totalBooks.add(txttotalBook);
		totalBooks.add(txtvalttlBooks);
		txttotalBook.setAlignmentX(CENTER_ALIGNMENT);
		txtvalttlBooks.setAlignmentX(LEFT_ALIGNMENT);
		this.add(totalBooks, 2);
		
	}
	
	
}

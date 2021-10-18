package sample;
/*
package backup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;

public class MainWindow extends JFrame{
	
	JPanel leftPanel;
	JButton btnA;
	JButton btnB;
	JButton btnC;
	JButton btnD;
	JButton btnE;
	//JButton btnLogout;
	JButton btnExit;
	
	JPanel rightPanel;
	JSplitPane mainSplitPane;
	
	Dashboard dashboardPanel = new Dashboard();
	PanelB bPanel = new PanelB();
	PanelC cPanel = new PanelC();
	PanelD dPanel = new PanelD();
	PanelE ePanel = new PanelE();
	
	public MainWindow(){
		super("Library Management System");
		
		leftPanel = new JPanel();
		createLeftComponent();
		
		rightPanel = new JPanel();
		//mainPanel = (JPanel) this.getContentPane();
		mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		mainSplitPane.setOneTouchExpandable(true);
		mainSplitPane.setDividerLocation(200);

		mainSplitPane.setDividerSize(0);
		
		this.add(mainSplitPane);
		this.pack();
		
		this.setSize(1280, 720); // width, height
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		setRightComponent(dashboardPanel);
		mainSplitPane.setDividerLocation(200);
	}
	
	private void createLeftComponent() {
		leftPanel.setLayout(new GridLayout(10,0));
		
		btnA = new JButton("Dashboard");
		btnB = new JButton("BBBB");
		btnC = new JButton("CCCC");
		btnD = new JButton("DDDD");
		btnE = new JButton("EEEE");
		//btnLogout = new JButton("Logout");
		btnExit = new JButton("Exit");
		
		leftPanel.add(btnA);
		leftPanel.add(btnB);
		leftPanel.add(btnC);
		leftPanel.add(btnD);
		leftPanel.add(btnE);
		//leftPanel.add(btnLogout);
		leftPanel.add(btnExit);
		leftPanel.setBackground(MyDesign.color2);
		
		btnA.setBackground(MyDesign.backgroundColor);
		btnB.setBackground(MyDesign.color2);
		btnC.setBackground(MyDesign.color2);
		btnD.setBackground(MyDesign.color2);
		btnE.setBackground(MyDesign.color2);
		//btnLogout.setBackground(Color.decode("#3B4255"));
		btnExit.setBackground(MyDesign.color2);
		
		btnA.setFont(MyDesign.subheaderFont);
		
		btnA.addActionListener(new ButtonActionListener());
		btnB.addActionListener(new ButtonActionListener());
		btnC.addActionListener(new ButtonActionListener());
		btnD.addActionListener(new ButtonActionListener());
		btnE.addActionListener(new ButtonActionListener());
		btnExit.addActionListener(new ButtonActionListener());
		
		
		
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch (e.getActionCommand()) {
			case "Dashboard":
				setRightComponent(dashboardPanel);
				break;
			case "BBBB":
				setRightComponent(bPanel);
				break;
			case "CCCC":
				setRightComponent(cPanel);
				break;
			case "DDDD":
				setRightComponent(dPanel);
				break;
			case "EEEE":
				setRightComponent(ePanel);
				break;
			default:
				System.exit(0);
				break;
			}
			//setRightComponent(aPanel);
			mainSplitPane.setDividerLocation(200);
			
		}
		
		
	}
	
	public void setRightComponent(JPanel panel) {
		mainSplitPane.setRightComponent(panel);
	}
	
	public void setRightComponent(JLayeredPane panel) {
		mainSplitPane.setRightComponent(panel);
	}

}

*/

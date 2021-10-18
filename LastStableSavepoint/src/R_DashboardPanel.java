import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class R_DashboardPanel extends JPanel{
	
	JPanel parentPanel;
	CardLayout parentLayout;
	
	JPanel headerTitle;
	JLabel title;
	
	JPanel panelBoxes;
	GridBagConstraints c;
	
	JPanel totalBkPanel;
	JPanel totalMemPanel;
	JButton btnViewBk;
	JButton btnViewMem;
	JButton btnRequests;
	JButton btnAbout;
	
	RequestDialog request;
	
	public R_DashboardPanel(JPanel parentPnl){
		parentPanel = parentPnl;
		parentLayout = (CardLayout)parentPanel.getLayout();
		
		this.setLayout(new BorderLayout());
		
		initializeHeader();
		
		initializeContent();
		
		
	}
	
	private void initializeHeader() {
		headerTitle = new JPanel(new FlowLayout(FlowLayout.LEADING));
		title = new JLabel("Dashboard");
		title.setFont(new Font("Arial", 1, 30)); // header title font here
		
		headerTitle.add(Box.createRigidArea(new Dimension(5,75)));
		headerTitle.add(title);
		headerTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLACK)); // border color here
		this.add(headerTitle, BorderLayout.PAGE_START);
	}
	
	private void initializeContent() {
		panelBoxes = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		
		totalBkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tlBk = new JLabel("Total Books: "+"0"); totalBkPanel.setBackground(Color.RED);
		totalBkPanel.add(tlBk);
		
		totalMemPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tlMem = new JLabel("Total Members: "+"0"); totalMemPanel.setBackground(Color.BLUE);
		totalMemPanel.add(tlMem);
		
		btnViewMem = new JButton("View Members");
		btnViewBk = new JButton("View Books");
		btnRequests = new JButton("Requests");
		btnAbout = new JButton("About");
		
		btnViewMem.addActionListener(new R_DashboardHandler());
		btnViewBk.addActionListener(new R_DashboardHandler());
		btnRequests.addActionListener(new R_DashboardHandler());
		btnAbout.addActionListener(new R_DashboardHandler());
		
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 0; // row
		c.weighty = 0.5;
		c.weightx = 0.5;
		c.insets = new Insets(20,20,10,10);
		panelBoxes.add(totalBkPanel,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 0; // row
		//c.insets = new Insets(10,10,10,10);
		panelBoxes.add(totalMemPanel,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 1; // row
		//c.insets = new Insets(10,10,10,10);
		panelBoxes.add(btnViewBk,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 1; // row
		//c.insets = new Insets(10,10,10,10);
		panelBoxes.add(btnViewMem,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 2; // row
		//c.insets = new Insets(10,10,10,10);
		panelBoxes.add(btnRequests,c);
		
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 2; // row
		//c.insets = new Insets(10,10,10,10);
		panelBoxes.add(btnAbout,c);
		
		
		this.add(panelBoxes, BorderLayout.CENTER);
	}
	
	private class R_DashboardHandler implements ActionListener{
		JButton source;
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			source = (JButton)evt.getSource();
			
			switch (source.getActionCommand()) {
			case "View Books":
				parentLayout.show(parentPanel, "VIEWBOOK");
				break;
			case "View Members":
				parentLayout.show(parentPanel, "VIEWMEMBER");
				break;
			case "Requests":
				request = new RequestDialog((JFrame)SwingUtilities.getWindowAncestor(parentPanel));
				request.open();
				break;
			case "About":
				System.out.println("Not implemented yet");
				break;
			default:
				System.exit(0);
				break;
			}
			
		}
		
	}

}

package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controller.R_DashboardController;

public class R_DashboardPanel extends JPanel{
	
	JPanel parentPanel;
	CardLayout parentLayout;
	
	HeaderPanel header;
	
	JPanel panelBoxes;
	
	JPanel totalBkPanel;
	JLabel tlBk;
	JPanel totalMemPanel;
	JLabel tlMem;
	JButton btnViewBk;
	JButton btnViewMem;
	JButton btnRequests;
	JButton btnAbout;
	
	private RequestDialog request;
	private ViewBkTableCard viewBookTablePane;
	private ViewMbrTableCard viewMemberTablePane;
	private Component rigidArea;
	private Component rigidArea_1;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component horizontalStrut_3;
	private Component horizontalStrut_4;
	private Component verticalStrut_2;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private Component verticalStrut_1;
	private Component verticalStrut_3;
	private Component horizontalStrut_2;
	private Component horizontalStrut_5;
	private Component verticalStrut;
	private Component verticalStrut_4;
	private R_DashboardController controller;
	
	public R_DashboardPanel(JPanel parentPnl){
		setBorder(null);
		setBackground(new Color(100, 149, 237));
		parentPanel = parentPnl;
		parentLayout = (CardLayout)parentPanel.getLayout();
		controller = new R_DashboardController();
		this.setLayout(new BorderLayout());
		
		initializeHeader();
		
		initializeContent();
	}
	
	private void initializeHeader() {
		header = new HeaderPanel("Dashboard",false);
		this.add(header, BorderLayout.PAGE_START);
	}
	
	private void initializeContent() {
		panelBoxes = new JPanel();
		panelBoxes.setBorder(null);
		panelBoxes.setBackground(new Color(255, 250, 250));
		GridBagLayout gbl_panelBoxes = new GridBagLayout();
		gbl_panelBoxes.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panelBoxes.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelBoxes.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelBoxes.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panelBoxes.setLayout(gbl_panelBoxes);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.gridwidth = 3;
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 0;
		panelBoxes.add(verticalStrut_2, gbc_verticalStrut_2);

		rigidArea = Box.createRigidArea(new Dimension(20, 0));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 1;
		panelBoxes.add(rigidArea, gbc_rigidArea);

		rigidArea_1 = Box.createRigidArea(new Dimension(20, 0));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_1.gridx = 4;
		gbc_rigidArea_1.gridy = 1;
		panelBoxes.add(rigidArea_1, gbc_rigidArea_1);

		totalBkPanel = new JPanel();
		totalBkPanel.setMaximumSize(new Dimension(380, 170));
		totalBkPanel.setMinimumSize(new Dimension(380, 170));
		totalBkPanel.setPreferredSize(new Dimension(380, 180));
		tlBk = new JLabel("Total Books:0");
		tlBk.setForeground(new Color(255, 250, 250));
		tlBk.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		tlBk.setIcon(new ImageIcon(R_DashboardPanel.class.getResource("/res/books_fix.png")));
		totalBkPanel.setBackground(new Color(100, 149, 237));
		totalBkPanel.setLayout(new BorderLayout(0, 0));
		totalBkPanel.add(tlBk, BorderLayout.CENTER);
		GridBagConstraints gbc_totalBkPanel = new GridBagConstraints();
		gbc_totalBkPanel.fill = GridBagConstraints.BOTH;
		gbc_totalBkPanel.insets = new Insets(0, 0, 5, 5);
		gbc_totalBkPanel.gridx = 1;
		gbc_totalBkPanel.gridy = 2;
		panelBoxes.add(totalBkPanel, gbc_totalBkPanel);
		
		horizontalStrut_3 = Box.createHorizontalStrut(70);
		totalBkPanel.add(horizontalStrut_3, BorderLayout.WEST);

		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 2;
		gbc_horizontalStrut.gridy = 2;
		panelBoxes.add(horizontalStrut, gbc_horizontalStrut);

		totalMemPanel = new JPanel();
		totalMemPanel.setMaximumSize(new Dimension(380, 170));
		totalMemPanel.setMinimumSize(new Dimension(380, 170));
		totalMemPanel.setPreferredSize(new Dimension(380, 180));
		tlMem = new JLabel("Total Members: " + "0");
		tlMem.setForeground(new Color(255, 250, 250));
		tlMem.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		tlMem.setIcon(new ImageIcon(R_DashboardPanel.class.getResource("/res/members_fix.png")));
		totalMemPanel.setBackground(new Color(100, 149, 237));
		totalMemPanel.setLayout(new BorderLayout(0, 0));
		totalMemPanel.add(tlMem);
		GridBagConstraints gbc_totalMemPanel = new GridBagConstraints();
		gbc_totalMemPanel.fill = GridBagConstraints.BOTH;
		gbc_totalMemPanel.insets = new Insets(0, 0, 5, 5);
		gbc_totalMemPanel.gridx = 3;
		gbc_totalMemPanel.gridy = 2;
		panelBoxes.add(totalMemPanel, gbc_totalMemPanel);
		
		horizontalStrut_4 = Box.createHorizontalStrut(70);
		totalMemPanel.add(horizontalStrut_4, BorderLayout.WEST);

		horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 2;
		gbc_horizontalStrut_1.gridy = 3;
		panelBoxes.add(horizontalStrut_1, gbc_horizontalStrut_1);

		this.add(panelBoxes, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 4;
		panelBoxes.add(panel, gbc_panel);
						panel.setLayout(new GridLayout(1, 2, 0, 0));
						
						panel_1 = new JPanel();
						panel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
						panel_1.setOpaque(false);
						panel.add(panel_1);
						panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
						
						horizontalStrut_2 = Box.createHorizontalStrut(10);
						panel_1.add(horizontalStrut_2);
						btnViewBk = new JButton("View Books");
						btnViewBk.setAlignmentX(Component.CENTER_ALIGNMENT);
						panel_1.add(btnViewBk);
						btnViewBk.setFocusPainted(false);
						btnViewBk.setIconTextGap(10);
						btnViewBk.setFont(new Font("Lucida Sans", Font.BOLD, 15));
						btnViewBk.setIcon(new ImageIcon(R_DashboardPanel.class.getResource("/res/viewbooks_fix.png")));
						btnViewBk.setBackground(new Color(100, 149, 237));
						btnViewBk.setOpaque(false);
						btnViewBk.setBorder(new LineBorder(new Color(100, 149, 237)));
						btnViewBk.setMaximumSize(new Dimension(340, 140));
						btnViewBk.setMinimumSize(new Dimension(340, 140));
						btnViewBk.setPreferredSize(new Dimension(380, 170));
						
						verticalStrut_1 = Box.createVerticalStrut(20);
						panel_1.add(verticalStrut_1);
						btnRequests = new JButton("Requests");
						btnRequests.setAlignmentX(Component.CENTER_ALIGNMENT);
						panel_1.add(btnRequests);
						btnRequests.setFocusPainted(false);
						btnRequests.setFont(new Font("Lucida Sans", Font.BOLD, 15));
						btnRequests.setIconTextGap(10);
						btnRequests.setIcon(new ImageIcon(R_DashboardPanel.class.getResource("/res/request_fix.png")));
						btnRequests.setBackground(new Color(100, 149, 237));
						btnRequests.setOpaque(false);
						btnRequests.setBorder(new LineBorder(new Color(100, 149, 237)));
						btnRequests.setMaximumSize(new Dimension(340, 140));
						btnRequests.setMinimumSize(new Dimension(340, 140));
						btnRequests.setPreferredSize(new Dimension(380, 170));
						
						verticalStrut = Box.createVerticalStrut(20);
						panel_1.add(verticalStrut);
						btnRequests.addMouseListener(new R_DashboardHandler());
						btnViewBk.addMouseListener(new R_DashboardHandler());
								
								panel_2 = new JPanel();
								panel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
								panel_2.setOpaque(false);
								panel.add(panel_2);
								panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
								
								horizontalStrut_5 = Box.createHorizontalStrut(10);
								panel_2.add(horizontalStrut_5);
						
								btnViewMem = new JButton("View Members");
								btnViewMem.setAlignmentX(Component.CENTER_ALIGNMENT);
								panel_2.add(btnViewMem);
								btnViewMem.setFocusPainted(false);
								btnViewMem.setFont(new Font("Lucida Sans", Font.BOLD, 15));
								btnViewMem.setIconTextGap(10);
								btnViewMem.setIcon(new ImageIcon(R_DashboardPanel.class.getResource("/res/viewmembers_fix.png")));
								btnViewMem.setBackground(new Color(100, 149, 237));
								btnViewMem.setOpaque(false);
								btnViewMem.setBorder(new LineBorder(new Color(100, 149, 237)));
								btnViewMem.setMaximumSize(new Dimension(340, 140));
								btnViewMem.setMinimumSize(new Dimension(340, 140));
								btnViewMem.setPreferredSize(new Dimension(380, 170));
								
								verticalStrut_3 = Box.createVerticalStrut(20);
								panel_2.add(verticalStrut_3);
								btnAbout = new JButton("About");
								btnAbout.setAlignmentX(Component.CENTER_ALIGNMENT);
								panel_2.add(btnAbout);
								btnAbout.setFocusPainted(false);
								btnAbout.setIconTextGap(10);
								btnAbout.setHorizontalTextPosition(SwingConstants.RIGHT);
								btnAbout.setFont(new Font("Lucida Sans", Font.BOLD, 15));
								btnAbout.setIcon(new ImageIcon(R_DashboardPanel.class.getResource("/res/about_fix.png")));
								btnAbout.setBackground(new Color(100, 149, 237));
								btnAbout.setOpaque(false);
								btnAbout.setBorder(new LineBorder(new Color(100, 149, 237)));
								btnAbout.setMaximumSize(new Dimension(340, 140));
								btnAbout.setMinimumSize(new Dimension(340, 140));
								btnAbout.setPreferredSize(new Dimension(380, 170));
								
								verticalStrut_4 = Box.createVerticalStrut(20);
								panel_2.add(verticalStrut_4);
								btnAbout.addMouseListener(new R_DashboardHandler());
								
										btnViewMem.addMouseListener(new R_DashboardHandler());

		rigidArea_2 = Box.createRigidArea(new Dimension(20, 0));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_2.gridx = 0;
		gbc_rigidArea_2.gridy = 6;
		panelBoxes.add(rigidArea_2, gbc_rigidArea_2);

		rigidArea_3 = Box.createRigidArea(new Dimension(20, 0));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.gridx = 4;
		gbc_rigidArea_3.gridy = 6;
		panelBoxes.add(rigidArea_3, gbc_rigidArea_3);
		
		this.loadCount();
	}
	
	private void loadCount() {
		HashMap<String, Integer> BkMemValue = controller.getBkMem();
		
		tlBk.setText("Total Books: "+BkMemValue.get("Books"));
		tlMem.setText("Total Members: "+BkMemValue.get("Members"));
	}
	
	private class R_DashboardHandler extends MouseAdapter{
		JButton btnSource;
		
		@Override
		public void mouseClicked(MouseEvent e) {
			btnSource = (JButton)e.getSource();
			
			switch (btnSource.getActionCommand()) {
			case "View Books":
				viewBookTablePane = new ViewBkTableCard(parentPanel);
				parentPanel.add(viewBookTablePane, "VIEWBOOK");
				parentLayout.show(parentPanel, "VIEWBOOK");
				break;
			case "View Members":
				viewMemberTablePane = new ViewMbrTableCard(parentPanel);
				parentPanel.add(viewMemberTablePane, "VIEWMEMBER");
				parentLayout.show(parentPanel, "VIEWMEMBER");
				break;
			case "Requests":
				request = new RequestDialog((JFrame)SwingUtilities.getWindowAncestor(parentPanel));
				request.open();
				break;
			case "About":
				MessageDialog.showDialog((JFrame)SwingUtilities.getWindowAncestor(parentPanel), "Created by Louie Jay F. Lomibao<br>Icons from: logomakr.com", "Info");
				break;
			default:
				System.exit(0);
				break;
			}
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(100, 149, 237));
			btnSource.setOpaque(true);
			btnSource.setForeground(new Color(255, 250, 250));
			btnSource.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(255, 250, 250)));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(100, 149, 237));
			btnSource.setOpaque(false);
			btnSource.setForeground(new Color(0, 0, 0));
			btnSource.setBorder(new LineBorder(new Color(100, 149, 237)));
		}
		
	}

}

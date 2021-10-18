package view;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.SearchMbrTableController;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;


public class SearchMbrTableCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	HeaderPanel header;
	
	JPanel contentPanel;
	JTextField txtSearch;
	JButton btnSearch;
	
	JRadioButton rbtnID;
	JRadioButton rbtnFirstName;
	JRadioButton rbtnLastName;
	JRadioButton rbtnAddress;
	JRadioButton rbtnSex;
	JRadioButton rbtnEmail;
	JRadioButton rbtnContact;
	
	ButtonGroup btnGroup;
	
	JPanel footerPanel;
	Table srchResultTable;
	
	SearchMbrInfoCard srchMemberPane;
	private SearchMbrTableController controller;
	private HashMap<Integer, JComponent> searchComponents;
	private Component verticalStrut;
	private Component horizontalStrut;
	
	
	public SearchMbrTableCard(JPanel parentPnl) {
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BoxLayout((JPanel)this,BoxLayout.PAGE_AXIS));
		this.controller = new SearchMbrTableController();
		
		loadHeader();
		loadContent();
		loadFooterTable();
		
	}
	
	private void loadHeader() {
		header = new HeaderPanel("Search Members",true);
		
		header.setBackActionListener(new SearchMemFormPopUpHandler());
		
		this.add(header);
	}
	
	private void loadContent() {
		contentPanel = new JPanel(new GridLayout(2,1,10,0));
		
		JPanel searchBar = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		searchBar.setBackground(new Color(255, 250, 250));
		txtSearch = new JTextField("",70);
		txtSearch.setPreferredSize(new Dimension(400, 25));
		txtSearch.setBorder(new LineBorder(new Color(100, 149, 237)));
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		btnSearch = new JButton("Search");
		btnSearch.setMaximumSize(new Dimension(67, 25));
		btnSearch.setMinimumSize(new Dimension(67, 25));
		btnSearch.setPreferredSize(new Dimension(67, 25));
		btnSearch.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnSearch.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnSearch.setContentAreaFilled(false);
		btnSearch.addActionListener(new SearchMemFormPopUpHandler());
		btnSearch.addMouseListener(new MouseHandler());
		
		verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 50));
		searchBar.add(verticalStrut);
		searchBar.add(txtSearch);
		
		horizontalStrut = Box.createHorizontalStrut(10);
		searchBar.add(horizontalStrut);
		searchBar.add(btnSearch);
		
		JPanel searchOpt = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		searchOpt.setBackground(new Color(255, 250, 250));
		
		btnGroup = new ButtonGroup();
		
		rbtnID = new JRadioButton("ID",true);
		rbtnID.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnID.setOpaque(false);
		rbtnFirstName = new JRadioButton("FirstName");
		rbtnFirstName.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnFirstName.setOpaque(false);
		rbtnLastName = new JRadioButton("LastName");
		rbtnLastName.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnLastName.setOpaque(false);
		rbtnAddress = new JRadioButton("Address");
		rbtnAddress.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnAddress.setOpaque(false);
		rbtnSex = new JRadioButton("Sex");
		rbtnSex.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnSex.setOpaque(false);
		rbtnEmail = new JRadioButton("Email");
		rbtnEmail.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnEmail.setOpaque(false);
		rbtnContact = new JRadioButton("ContactNo");
		rbtnContact.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnContact.setOpaque(false);
		
		btnGroup.add(rbtnID);
		btnGroup.add(rbtnFirstName);
		btnGroup.add(rbtnLastName);
		btnGroup.add(rbtnAddress);
		btnGroup.add(rbtnSex);
		btnGroup.add(rbtnEmail);
		btnGroup.add(rbtnContact);
		
		searchOpt.add(rbtnID);
		searchOpt.add(rbtnFirstName);
		searchOpt.add(rbtnLastName);
		searchOpt.add(rbtnAddress);
		searchOpt.add(rbtnSex);
		searchOpt.add(rbtnEmail);
		searchOpt.add(rbtnContact);
		
		searchComponents = new HashMap<Integer, JComponent>();
		searchComponents.put(0, rbtnID);
		searchComponents.put(1, rbtnFirstName);
		searchComponents.put(2, rbtnLastName);
		searchComponents.put(3, rbtnAddress);
		searchComponents.put(4, rbtnSex);
		searchComponents.put(5, rbtnEmail);
		searchComponents.put(6, rbtnContact);
		searchComponents.put(7, txtSearch);
		
		contentPanel.add(searchBar);
		contentPanel.add(searchOpt);
		searchOpt.setPreferredSize(new Dimension(0,20));
		this.add(contentPanel);
		
	}
	
	private void loadFooterTable() {
		footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		footerPanel.setBackground(new Color(255, 250, 250));
		srchResultTable = new Table();
		
		footerPanel.add(srchResultTable.getTablePane());
		
		srchResultTable.addMouseListener(new SearchMemFormPopUp_TableHandler());
		this.loadTable();
		
		searchComponents.put(8, srchResultTable);
		
		this.add(footerPanel);
		
	}
	
	private void loadTable() {
		srchResultTable.setModel(controller.loadDefaultTable());
		
		srchResultTable.getColumnModel().getColumn(8).setMinWidth(0);
		srchResultTable.getColumnModel().getColumn(8).setMaxWidth(0);
		srchResultTable.getColumnModel().getColumn(8).setWidth(0);
	}
	
	private class SearchMemFormPopUpHandler implements ActionListener{
		JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(parentPanel);
		JButton source;
		@Override
		public void actionPerformed(ActionEvent evt) {
			source = (JButton)evt.getSource();
			switch (source.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "MAIN");
				break;
			case "Search":
				if(controller.search(searchComponents)) {}
				else {
					ErrorDialog.showErrorDialog(parent, controller.getErrorMsg());
				}
				break;
			default:
				break;
			}
		}
		
	}
	
	
	private class SearchMemFormPopUp_TableHandler extends MouseAdapter{
		
		public void mouseClicked(MouseEvent mEvt) {
			
			ArrayList<String> cellKeys = new ArrayList<String>();
			
			cellKeys.add("ID");
			cellKeys.add("FName");
			cellKeys.add("MName");
			cellKeys.add("LName");
			cellKeys.add("Sex");
			cellKeys.add("BDate");
			cellKeys.add("Address");
			cellKeys.add("Email");
			cellKeys.add("Img");
			cellKeys.add("ContactNo");
			
			srchResultTable.setCellValueKeys(cellKeys);
			
			if(mEvt.getClickCount() == 1) {
				
				srchMemberPane = new SearchMbrInfoCard(parentPanel, srchResultTable.getCellValues());
				parentPanel.add(srchMemberPane, "INFOSEARCHMEMBER");
				parentLayout.show(parentPanel, "INFOSEARCHMEMBER");
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
			btnSource.setBorder(new LineBorder(new Color(30, 144, 255)));
		}
		
	}
	
	

}

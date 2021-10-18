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
import java.util.LinkedHashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import controller.SearchBkTableController;
import java.awt.Color;
import java.awt.Component;
import javax.swing.SwingConstants;


public class SearchBkTableCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	HeaderPanel header;
	
	JPanel contentPanel;
	JTextField txtSearch;
	JButton btnSearch;
	ButtonGroup radioGroup;
	JRadioButton rbtnId;
	JRadioButton rbtnTitle;
	JRadioButton rbtnAuthor;
	JRadioButton rbtnWriter;
	JRadioButton rbtnPublisher;
	JRadioButton rbtnISBN;
	JRadioButton rbtnType;
	JRadioButton rbtnGenre;
	JRadioButton rbtnQuantity;
	
	JPanel footerPanel;
	Table srchResultTable;
	
	SearchBkInfoCard srchBookPane;
	SearchBkTableController controller;
	LinkedHashMap<String, Object> inputComp;
	private Component verticalStrut;
	private Component horizontalStrut;
	
	public SearchBkTableCard(JPanel parentPnl) {
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BoxLayout((JPanel)this,BoxLayout.PAGE_AXIS));
		this.controller = new SearchBkTableController();
		loadHeader();
		loadContent();
		loadFooterTable();
		loadTable();
		
	}
	
	private void loadHeader() {
		header = new HeaderPanel("Search Books",true);
		
		header.setBackActionListener(new SearchBkFormPopUpHandler());
		
		this.add(header);
	}
	
	private void loadContent() {
		contentPanel = new JPanel(new GridLayout(2,1,10,0));
		
		JPanel searchBar = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		searchBar.setBackground(new Color(255, 250, 250));
		txtSearch = new JTextField("",70);
		txtSearch.setBorder(new LineBorder(new Color(100, 149, 237)));
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setPreferredSize(new Dimension(400, 25));
		txtSearch.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(255, 250, 250));
		btnSearch.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnSearch.setMinimumSize(new Dimension(67, 25));
		btnSearch.setMaximumSize(new Dimension(67, 25));
		btnSearch.setPreferredSize(new Dimension(67, 25));
		btnSearch.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnSearch.addActionListener(new SearchBkFormPopUpHandler());
		btnSearch.addMouseListener(new MouseHandler());
		
		verticalStrut = Box.createVerticalStrut(50);
		searchBar.add(verticalStrut);
		searchBar.add(txtSearch);
		
		horizontalStrut = Box.createHorizontalStrut(10);
		searchBar.add(horizontalStrut);
		searchBar.add(btnSearch);
		
		JPanel searchOpt = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		searchOpt.setBackground(new Color(255, 250, 250));
		
		radioGroup = new ButtonGroup();
		rbtnId = new JRadioButton("ID");
		rbtnId.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnId.setOpaque(false);
		rbtnTitle = new JRadioButton("Title",true);
		rbtnTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnTitle.setOpaque(false);
		rbtnAuthor = new JRadioButton("Author");
		rbtnAuthor.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnAuthor.setOpaque(false);
		rbtnWriter = new JRadioButton("Writer");
		rbtnWriter.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnWriter.setOpaque(false);
		rbtnPublisher = new JRadioButton("Publisher");
		rbtnPublisher.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnPublisher.setOpaque(false);
		rbtnISBN = new JRadioButton("ISBN");
		rbtnISBN.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnISBN.setOpaque(false);
		rbtnType = new JRadioButton("Type");
		rbtnType.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnType.setOpaque(false);
		rbtnGenre = new JRadioButton("Genre");
		rbtnGenre.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnGenre.setOpaque(false);
		rbtnQuantity = new JRadioButton("Quantity");
		rbtnQuantity.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		rbtnQuantity.setOpaque(false);
		
		radioGroup.add(rbtnId);
		radioGroup.add(rbtnTitle);
		radioGroup.add(rbtnAuthor);
		radioGroup.add(rbtnWriter);
		radioGroup.add(rbtnPublisher);
		radioGroup.add(rbtnISBN);
		radioGroup.add(rbtnType);
		radioGroup.add(rbtnGenre);
		radioGroup.add(rbtnQuantity);
		
		inputComp = new LinkedHashMap<String, Object>();
		
		searchOpt.add(rbtnId,true);
		searchOpt.add(rbtnTitle,true);
		searchOpt.add(rbtnAuthor);
		searchOpt.add(rbtnWriter);
		searchOpt.add(rbtnPublisher);
		searchOpt.add(rbtnISBN);
		searchOpt.add(rbtnType);
		searchOpt.add(rbtnGenre);
		searchOpt.add(rbtnQuantity);
		
		inputComp.put("Search", txtSearch);
		inputComp.put("ID", rbtnId);
		inputComp.put("Title", rbtnTitle);
		inputComp.put("Author", rbtnAuthor);
		inputComp.put("Writer", rbtnWriter);
		inputComp.put("Publisher", rbtnPublisher);
		inputComp.put("ISBN", rbtnISBN);
		inputComp.put("Type", rbtnType);
		inputComp.put("Genre", rbtnGenre);
		inputComp.put("Quantity", rbtnQuantity);
		
		contentPanel.add(searchBar);
		contentPanel.add(searchOpt);
		searchOpt.setPreferredSize(new Dimension(0,20));
		this.add(contentPanel);
		
	}
	
	private void loadFooterTable() {
		footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		footerPanel.setBackground(new Color(255, 250, 250));
		srchResultTable = new Table();
		srchResultTable.setModel(controller.getDefaultTableModel());
		footerPanel.add(srchResultTable.getTablePane());
		
		srchResultTable.addMouseListener(new SearchBkFormPopUp_TableHandler());
		this.add(footerPanel);
		
	}
	
	private void loadTable() {
		srchResultTable.setModel(controller.getDefaultTableModel());
		
		srchResultTable.getColumnModel().getColumn(0).setMinWidth(50);
		srchResultTable.getColumnModel().getColumn(0).setMaxWidth(50);
		srchResultTable.getColumnModel().getColumn(0).setWidth(50);
		
		srchResultTable.getColumnModel().getColumn(1).setMinWidth(300);
		srchResultTable.getColumnModel().getColumn(1).setMaxWidth(300);
		srchResultTable.getColumnModel().getColumn(1).setWidth(300);
		
		srchResultTable.getColumnModel().getColumn(7).setMinWidth(0);
		srchResultTable.getColumnModel().getColumn(7).setMaxWidth(0);
		srchResultTable.getColumnModel().getColumn(7).setWidth(0);
	}
	
	private class SearchBkFormPopUpHandler implements ActionListener{
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
				
				if(controller.searchBook(inputComp)) {
					srchResultTable.setModel(controller.getTableModel());
					
					srchResultTable.getColumnModel().getColumn(0).setMinWidth(50);
					srchResultTable.getColumnModel().getColumn(0).setMaxWidth(50);
					srchResultTable.getColumnModel().getColumn(0).setWidth(50);
					
					srchResultTable.getColumnModel().getColumn(1).setMinWidth(300);
					srchResultTable.getColumnModel().getColumn(1).setMaxWidth(300);
					srchResultTable.getColumnModel().getColumn(1).setWidth(300);
					
					srchResultTable.getColumnModel().getColumn(7).setMinWidth(0);
					srchResultTable.getColumnModel().getColumn(7).setMaxWidth(0);
					srchResultTable.getColumnModel().getColumn(7).setWidth(0);
				}else {
					ErrorDialog.showErrorDialog(parent, controller.getErrorMsg());
				}
				break;
			default:
				break;
			}
		}
	}
	
	private class SearchBkFormPopUp_TableHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent mEvt) {
			if(mEvt.getClickCount() == 1) {
				ArrayList<String> cellKeys = new ArrayList<String>();
				
				cellKeys.add("ID");
				cellKeys.add("Title");
				cellKeys.add("Author");
				cellKeys.add("Writer");
				cellKeys.add("Publisher");
				cellKeys.add("ISBN");
				cellKeys.add("Type");
				cellKeys.add("Img");
				cellKeys.add("Genre");
				cellKeys.add("Quantity");
				
				srchResultTable.setCellValueKeys(cellKeys);
				
				srchBookPane = new SearchBkInfoCard(parentPanel, srchResultTable.getCellValues());
				parentPanel.add(srchBookPane, "INFOSEARCHBOOK");
				parentLayout.show(parentPanel, "INFOSEARCHBOOK");
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

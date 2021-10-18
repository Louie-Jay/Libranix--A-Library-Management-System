package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.ViewBkTableController;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Component;

public class ViewBkTableCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	HeaderPanel header;
	
	//content center
	JPanel content;
	Table viewBkTable; //test datas over here
	
	// footer buttons
	JPanel optionsPane;
	JCheckBox chkTitle;
	TitleTextField txtTitle;
	JCheckBox chkBorrowed;
	JCheckBox chkGenre;
	GenreComboBox<String> cbxGenre;
	JButton btnFind;
	
	ViewBkInfoCard viewBookPane;
	ViewBkTableController controller;
	LinkedHashMap<String,JComponent> inputOption;
	
	public ViewBkTableCard(JPanel parentPnl) {
		setBackground(new Color(255, 250, 250));
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		this.controller = new ViewBkTableController();
		
		loadHeader();
		loadContentTable();
		loadFooterOptions();
		
	}
	
	private void loadHeader() {
		header = new HeaderPanel("View Books",true);
		
		header.setBackActionListener(new ViewBkTableHandler());
		
		this.add(header,BorderLayout.PAGE_START);
	}
	
	private void loadContentTable() {
		
		JPanel formOuterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		formOuterPanel.setBackground(new Color(255, 250, 250));
		content = new JPanel(new FlowLayout(FlowLayout.CENTER));
		content.setBackground(new Color(255, 250, 250));
		viewBkTable = new Table();
		viewBkTable.addMouseListener(new ViewBkTable_TableHandler());
		this.loadTable();
		content.add(viewBkTable.getTablePane());
		formOuterPanel.add(content);
		
		this.add(formOuterPanel,BorderLayout.CENTER);
		
	}
	
	public void loadTable() {
		viewBkTable.setModel(controller.getDefaultTableModel());
		
		viewBkTable.getColumnModel().getColumn(0).setMinWidth(50);
		viewBkTable.getColumnModel().getColumn(0).setMaxWidth(50);
		viewBkTable.getColumnModel().getColumn(0).setWidth(50);
		
		viewBkTable.getColumnModel().getColumn(1).setMinWidth(300);
		viewBkTable.getColumnModel().getColumn(1).setMaxWidth(300);
		viewBkTable.getColumnModel().getColumn(1).setWidth(300);
		
		viewBkTable.getColumnModel().getColumn(7).setMinWidth(0);
		viewBkTable.getColumnModel().getColumn(7).setMaxWidth(0);
		viewBkTable.getColumnModel().getColumn(7).setWidth(0);
	}
	
	private void loadFooterOptions() {
		
		optionsPane = new JPanel();
		optionsPane.setBackground(new Color(255, 250, 250));
		
		optionsPane.setLayout(new FlowLayout(FlowLayout.LEADING));
		//this.setBorder(new LineBorder(Color.BLACK));
		inputOption = new LinkedHashMap<String,JComponent>();
		
		
		chkTitle = new JCheckBox("Title:");
		chkTitle.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkTitle.setOpaque(false);
		txtTitle = new TitleTextField("",30);
		chkBorrowed = new JCheckBox("Borrowed");
		chkBorrowed.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkBorrowed.setOpaque(false);

		chkGenre = new JCheckBox("Genre:");
		chkGenre.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkGenre.setOpaque(false);
		cbxGenre = new GenreComboBox<String>(controller.getGenreData());
		btnFind = new JButton("Find");
		btnFind.setContentAreaFilled(false);
		btnFind.setPreferredSize(new Dimension(55, 25));
		btnFind.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnFind.setMinimumSize(new Dimension(55, 25));
		btnFind.setMaximumSize(new Dimension(55, 25));
		btnFind.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnFind.setOpaque(false);
		
		chkTitle.addActionListener(new ViewBkTableChksHandler());
		chkBorrowed.addActionListener(new ViewBkTableChksHandler());
		chkGenre.addActionListener(new ViewBkTableChksHandler());
		btnFind.addActionListener(new ViewBkTableHandler());
		btnFind.addMouseListener(new MouseHandler());
		txtTitle.setEnabled(false);
		cbxGenre.setEnabled(false);
		
		optionsPane.add(chkTitle);
		optionsPane.add(txtTitle);
		optionsPane.add(chkBorrowed);
		optionsPane.add(chkGenre);
		optionsPane.add(cbxGenre);
		optionsPane.add(btnFind);
		
		inputOption.put("chkTitle", chkTitle);
		inputOption.put("Title",txtTitle);
		inputOption.put("Borrowed",chkBorrowed);
		inputOption.put("chkGenre", chkGenre);
		inputOption.put("Genre",cbxGenre);
		
		this.add(optionsPane,BorderLayout.PAGE_END);
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
	
	private class ViewBkTableChksHandler implements ActionListener{
		JCheckBox source;
		
		@Override
		public void actionPerformed(ActionEvent chkEvt) {
			source = (JCheckBox) chkEvt.getSource();
			
			switch (source.getActionCommand()) {
			case "Title:":
				if(source.isSelected()) {
					txtTitle.setText("");
					txtTitle.setEnabled(true);
				}else {
					txtTitle.setText("");
					txtTitle.setEnabled(false);
					txtTitle.setDefaultBorder();
				}
				break;
			case "Genre:":
				if(source.isSelected()) {
					//cbxGenre.setSelectedIndex(0);
					cbxGenre.setEnabled(true);
				}else {
					//cbxGenre.setSelectedIndex(0);
					cbxGenre.setEnabled(false);
					cbxGenre.setDefaultBorder();
				}
				break;

			default:
				break;
			}
		}
	}
	
	private class ViewBkTableHandler implements ActionListener{
		JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(parentPanel);
		JButton source;
		@Override
		public void actionPerformed(ActionEvent btnEvt) {
			source = (JButton)btnEvt.getSource();
					
			switch (source.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "MAIN");
				break;
			case "Find":
				if(controller.findBook(inputOption)) {
					viewBkTable.setModel(controller.getTableModelRequest(inputOption));
					
					viewBkTable.getColumnModel().getColumn(0).setMinWidth(50);
					viewBkTable.getColumnModel().getColumn(0).setMaxWidth(50);
					viewBkTable.getColumnModel().getColumn(0).setWidth(50);
					
					viewBkTable.getColumnModel().getColumn(1).setMinWidth(300);
					viewBkTable.getColumnModel().getColumn(1).setMaxWidth(300);
					viewBkTable.getColumnModel().getColumn(1).setWidth(300);
					
					viewBkTable.getColumnModel().getColumn(7).setMinWidth(0);
					viewBkTable.getColumnModel().getColumn(7).setMaxWidth(0);
					viewBkTable.getColumnModel().getColumn(7).setWidth(0);
				}else {
					ErrorDialog.showErrorDialog(parent, controller.getErrorMsg());
				}
				break;
			default:
				break;
			}
		}
	}
	
	
	private class ViewBkTable_TableHandler extends MouseAdapter{
		
		public void mouseClicked(MouseEvent mEvt) {
			
			if(mEvt.getClickCount() == 1) {
				ArrayList<String> cellKeys = new ArrayList<String>();
				
				if(controller.isBorrowed()) {
					
					cellKeys.add("BorrowID");
					cellKeys.add("ID");
					
					viewBkTable.setCellValueKeys(cellKeys);
					
				}else {
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
					
					viewBkTable.setCellValueKeys(cellKeys);
				}
				
				viewBookPane = new ViewBkInfoCard(parentPanel,viewBkTable.getCellValues(),controller.isBorrowed());
				parentPanel.add(viewBookPane, "INFOBOOK");
				parentLayout.show(parentPanel, "INFOBOOK");
			}
		}
	}
}

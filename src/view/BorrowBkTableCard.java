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
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import controller.BorrowBkTableController;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class BorrowBkTableCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	HeaderPanel header;
	
	//content center
	JPanel content;
	private Table borrowBkTable; //test datas over here
	
	// footer buttons
	JPanel optionsPane;
	JCheckBox chkId;
	IDTextField txtId;
	JCheckBox chkTitle;
	TitleTextField txtTitle;
	JCheckBox chkGenre;
	GenreComboBox<String> cbxGenre;
	JButton btnFind;
	
	
	BorrowBkInfoCard borrowBookPane;
	private BorrowBkTableController controller;
	LinkedHashMap<String,JComponent> inputComp;
	LinkedHashMap<String, Object> cellValues;
	
	public BorrowBkTableCard(JPanel parentPnl) {
		setBackground(new Color(255, 250, 250));
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		this.controller = new BorrowBkTableController();
		this.inputComp = new LinkedHashMap<String,JComponent>();
		
		loadHeader();
		loadContentTable();
		loadFooterOptions();
		loadTable();
		
	}
	
	private void loadHeader() {
		header = new HeaderPanel("Borrow Books",true);
		
		header.setBackActionListener(new BorrowBkTableHandler());
		
		this.add(header,BorderLayout.PAGE_START);
	}
	
	private void loadContentTable() {
		
		JPanel formOuterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		formOuterPanel.setBackground(new Color(255, 250, 250));
		content = new JPanel(new FlowLayout(FlowLayout.CENTER));
		content.setBackground(new Color(255, 250, 250));
		borrowBkTable = new Table();
		borrowBkTable.addMouseListener(new BorrowBkTable_TableHandler());
		this.loadTable();
		content.add(borrowBkTable.getTablePane());
		formOuterPanel.add(content);
		this.add(formOuterPanel,BorderLayout.CENTER);
		
	}
	
	public void loadTable() {
		borrowBkTable.setModel(controller.getDefaultTableModel());
		
		borrowBkTable.getColumnModel().getColumn(0).setMinWidth(50);
		borrowBkTable.getColumnModel().getColumn(0).setMaxWidth(50);
		borrowBkTable.getColumnModel().getColumn(0).setWidth(50);
		
		borrowBkTable.getColumnModel().getColumn(1).setMinWidth(300);
		borrowBkTable.getColumnModel().getColumn(1).setMaxWidth(300);
		borrowBkTable.getColumnModel().getColumn(1).setWidth(300);
		
		borrowBkTable.getColumnModel().getColumn(7).setMinWidth(0);
		borrowBkTable.getColumnModel().getColumn(7).setMaxWidth(0);
		borrowBkTable.getColumnModel().getColumn(7).setWidth(0);
	}
	
	private void loadFooterOptions() {
		
		optionsPane = new JPanel();
		optionsPane.setBackground(new Color(255, 250, 250));
		
		optionsPane.setLayout(new FlowLayout(FlowLayout.LEADING));
		//this.setBorder(new LineBorder(Color.BLACK));
		
		
		chkId = new JCheckBox("ID:");
		chkId.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkId.setOpaque(false);
		txtId = new IDTextField("",5);
		chkTitle = new JCheckBox("Title:");
		chkTitle.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkTitle.setOpaque(false);
		txtTitle = new TitleTextField("",10);
		chkGenre = new JCheckBox("Genre:");
		chkGenre.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkGenre.setOpaque(false);
		cbxGenre = new GenreComboBox<String>(controller.getGenreData());
		btnFind = new JButton("Find");
		btnFind.setMinimumSize(new Dimension(55, 25));
		btnFind.setMaximumSize(new Dimension(55, 25));
		btnFind.setPreferredSize(new Dimension(55, 25));
		btnFind.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnFind.setBackground(new Color(255, 250, 250));
		btnFind.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnFind.setOpaque(false);
		
		chkId.addActionListener(new BorrowBkTableChksHandler());
		chkTitle.addActionListener(new BorrowBkTableChksHandler());
		chkGenre.addActionListener(new BorrowBkTableChksHandler());
		btnFind.addActionListener(new BorrowBkTableHandler());
		btnFind.addMouseListener(new MouseHandler());
		
		optionsPane.add(chkId);
		optionsPane.add(txtId);
		optionsPane.add(chkTitle);
		optionsPane.add(txtTitle);
		optionsPane.add(chkGenre);
		optionsPane.add(cbxGenre);
		optionsPane.add(btnFind);
		
		txtId.setEnabled(false);
		txtTitle.setEnabled(false);
		cbxGenre.setEnabled(false);
		
		inputComp.put("chkID", chkId);
		inputComp.put("ID", txtId);
		inputComp.put("chkTitle", chkTitle);
		inputComp.put("Title", txtTitle);
		inputComp.put("chkGenre", chkGenre);
		inputComp.put("Genre", cbxGenre);
		
		this.add(optionsPane,BorderLayout.PAGE_END);
	}
	
	private class BorrowBkTableChksHandler implements ActionListener{
		JCheckBox source;
		
		@Override
		public void actionPerformed(ActionEvent chkEvt) {
			source = (JCheckBox) chkEvt.getSource();
			switch (source.getActionCommand()) {
			case "ID:":
				if(source.isSelected()) {
					txtId.setText("");
					txtId.setEnabled(true);
				}else {
					txtId.setText("");
					txtId.setEnabled(false);
					txtId.setDefaultBorder();
				}
				break;
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
					cbxGenre.setSelectedIndex(0);
					cbxGenre.setEnabled(true);
				}else {
					cbxGenre.setSelectedIndex(0);
					cbxGenre.setEnabled(false);
					cbxGenre.setDefaultBorder();
				}
				break;
			default:
				break;
			}
		}
	}
	
	private class BorrowBkTableHandler implements ActionListener{
		JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(parentPanel);
		JButton source;
		@Override
		public void actionPerformed(ActionEvent evt) {
			source = (JButton) evt.getSource();
			
			switch (source.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "MAIN");
				break;
			case "Find":
				
				if(controller.checkInputs(inputComp)) {
					borrowBkTable.setModel(controller.getTableModelRequest(inputComp));
					
					borrowBkTable.getColumnModel().getColumn(0).setMinWidth(50);
					borrowBkTable.getColumnModel().getColumn(0).setMaxWidth(50);
					borrowBkTable.getColumnModel().getColumn(0).setWidth(50);
					
					borrowBkTable.getColumnModel().getColumn(1).setMinWidth(300);
					borrowBkTable.getColumnModel().getColumn(1).setMaxWidth(300);
					borrowBkTable.getColumnModel().getColumn(1).setWidth(300);
					
					borrowBkTable.getColumnModel().getColumn(7).setMinWidth(0);
					borrowBkTable.getColumnModel().getColumn(7).setMaxWidth(0);
					borrowBkTable.getColumnModel().getColumn(7).setWidth(0);
				}else {
					ErrorDialog.showErrorDialog(parent, controller.getErrorMsg());
				}
				
				break;
			default:
				break;
			}
			
		}
		
	}
	
	
	private class BorrowBkTable_TableHandler extends MouseAdapter{
		
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
				
				borrowBkTable.setCellValueKeys(cellKeys);
				
				borrowBookPane = new BorrowBkInfoCard(parentPanel,borrowBkTable.getCellValues());
				parentPanel.add(borrowBookPane, "INFOBORROWBOOK");
				parentLayout.show(parentPanel, "INFOBORROWBOOK");
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

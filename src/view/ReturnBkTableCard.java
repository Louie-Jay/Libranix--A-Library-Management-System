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
import javax.swing.border.LineBorder;

import controller.ReturnBkTableController;
import java.awt.Color;

public class ReturnBkTableCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	HeaderPanel header;
	
	//content center
	JPanel content;
	private Table returnBkTable; //test datas over here
	
	// footer buttons
	JPanel optionsPane;
	JCheckBox chkBookId;
	IDTextField txtBookId;
	JCheckBox chkMemberId;
	IDTextField txtMemberId;
	JCheckBox chkBookTitle;
	TitleTextField txtBookTitle;
	JCheckBox chkBookIsbn;
	ISBNTextField txtBookIsbn;
	JButton btnFind;
	
	
	ReturnBkTransactCard returnBookTransactPane;
	private ReturnBkTableController controller;
	private LinkedHashMap<String,Object> cellValues;
	private LinkedHashMap<String,JComponent> inputComp;
	
	public ReturnBkTableCard(JPanel parentPnl) {
		setBackground(new Color(255, 250, 250));
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		this.controller = new ReturnBkTableController();
		
		loadHeader();
		loadContentTable();
		loadTable();
		loadFooterOptions();
		
		
		
	}
	
	private void loadHeader() {
		header = new HeaderPanel("Return Books",true);
		
		header.setBackActionListener(new ReturnBkTableHandler());
		
		this.add(header,BorderLayout.PAGE_START);
	}
	
	private void loadContentTable() {
		
		JPanel formOuterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		formOuterPanel.setBackground(new Color(255, 250, 250));
		content = new JPanel(new FlowLayout(FlowLayout.CENTER));
		content.setBackground(new Color(255, 250, 250));
		returnBkTable = new Table();
		this.loadTable();
		returnBkTable.addMouseListener(new ReturnBkTable_TableHandler());

		
		content.add(returnBkTable.getTablePane());
		formOuterPanel.add(content);
		
		this.add(formOuterPanel,BorderLayout.CENTER);
		this.loadTable();
	}
	
	public void loadTable() {
		returnBkTable.setModel(controller.getDefaultTableModel());
		
		returnBkTable.getColumnModel().getColumn(0).setMinWidth(0);
		returnBkTable.getColumnModel().getColumn(0).setMaxWidth(0);
		returnBkTable.getColumnModel().getColumn(0).setWidth(0);
	}
	
	private void loadFooterOptions() {
		optionsPane = new JPanel();
		optionsPane.setBackground(new Color(255, 250, 250));
		
		optionsPane.setLayout(new FlowLayout(FlowLayout.LEADING));
		//this.setBorder(new LineBorder(Color.BLACK));
		
		
		chkBookId = new JCheckBox("Book ID:");
		chkBookId.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkBookId.setOpaque(false);
		txtBookId = new IDTextField("",6);
		chkMemberId = new JCheckBox("Member ID:");
		chkMemberId.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkMemberId.setOpaque(false);
		txtMemberId = new IDTextField("",6);
		chkBookTitle = new JCheckBox("Book Title:");
		chkBookTitle.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkBookTitle.setOpaque(false);
		txtBookTitle = new TitleTextField("",20);
		chkBookIsbn = new JCheckBox("Book ISBN:");
		chkBookIsbn.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkBookIsbn.setOpaque(false);
		txtBookIsbn = new ISBNTextField("",12);
		btnFind = new JButton("Find");
		btnFind.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnFind.setMaximumSize(new Dimension(60, 25));
		btnFind.setMinimumSize(new Dimension(60, 25));
		btnFind.setPreferredSize(new Dimension(60, 25));
		btnFind.setOpaque(false);
		btnFind.setBackground(new Color(255, 250, 250));
		btnFind.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		
		inputComp = new LinkedHashMap<String,JComponent>();
		
		inputComp.put("BookID", txtBookId);
		inputComp.put("MemberID", txtMemberId);
		inputComp.put("BookTitle", txtBookTitle);
		inputComp.put("BookISBN", txtBookIsbn);
		
		inputComp.put("chkBookID", chkBookId);
		inputComp.put("chkMemberID", chkMemberId);
		inputComp.put("chkBookTitle", chkBookTitle);
		inputComp.put("chkBookISBN", chkBookIsbn);

		
		txtBookId.setEnabled(false);
		txtMemberId.setEnabled(false);
		txtBookTitle.setEnabled(false);
		txtBookIsbn.setEnabled(false);
		
		chkBookId.addActionListener(new ReturnBkTableChkHandler());
		chkMemberId.addActionListener(new ReturnBkTableChkHandler());
		chkBookTitle.addActionListener(new ReturnBkTableChkHandler());
		chkBookIsbn.addActionListener(new ReturnBkTableChkHandler());
		btnFind.addActionListener(new ReturnBkTableHandler());
		btnFind.addMouseListener(new MouseHandler());
		
		optionsPane.add(chkBookId);
		optionsPane.add(txtBookId);
		optionsPane.add(chkMemberId);
		optionsPane.add(txtMemberId);
		optionsPane.add(chkBookTitle);
		optionsPane.add(txtBookTitle);
		optionsPane.add(chkBookIsbn);
		optionsPane.add(txtBookIsbn);
		optionsPane.add(btnFind);
		
		this.add(optionsPane,BorderLayout.PAGE_END);
	}
	
	private class ReturnBkTableChkHandler implements ActionListener{
		JCheckBox source;
		@Override
		public void actionPerformed(ActionEvent chkEvt) {
			source = (JCheckBox)chkEvt.getSource();
			
			switch (source.getActionCommand()) {
			case "Book ID:":
				if(chkBookId.isSelected()) {
					txtBookId.setEnabled(true);
				}else {
					txtBookId.setEnabled(false);
				}
				txtBookId.setText("");
				txtBookId.setDefaultBorder();
				break;
			case "Member ID:":
				if (chkMemberId.isSelected()) {
					txtMemberId.setEnabled(true);
				}else {
					txtMemberId.setEnabled(false);
				}
				txtMemberId.setText("");
				txtMemberId.setDefaultBorder();
				break;
			case "Book Title:":
				if (chkBookTitle.isSelected()) {
					txtBookTitle.setEnabled(true);
				}else {
					txtBookTitle.setEnabled(false);
				}
				txtBookTitle.setText("");
				txtBookTitle.setDefaultBorder();
				break;
			case "Book ISBN:":
				if (chkBookIsbn.isSelected()) {
					txtBookIsbn.setEnabled(true);
				} else {
					txtBookIsbn.setEnabled(false);
				}
				txtBookIsbn.setText("");
				txtBookIsbn.setDefaultBorder();
				break;
			default:
				break;
			}
			
		}
		
	}
	
	private class ReturnBkTableHandler implements ActionListener{
		JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(parentPanel);
		JButton source;
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			source = (JButton)evt.getSource();
			
			switch (source.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "MAIN");
				break;
			case "Find":
				if(controller.find(inputComp,returnBkTable)) {}
				else {
					ErrorDialog.showErrorDialog(parent, controller.getErrorMsg());
				}
				break;
			default:
				break;
			}	
		}
	}
	
	
	private class ReturnBkTable_TableHandler extends MouseAdapter{
		JTable source;
		public void mouseClicked(MouseEvent mEvt) {
			cellValues = new LinkedHashMap<String,Object>();
			if(mEvt.getClickCount() == 1) {
				source = (JTable) mEvt.getSource();
				int row = source.getSelectedRow();

				cellValues.put("BorrowID", source.getValueAt(row, 0));
				cellValues.put("BookID", source.getValueAt(row, 1));
				cellValues.put("MemberID", source.getValueAt(row, 2));
				cellValues.put("OrderCount", source.getValueAt(row, 8));
				
				returnBookTransactPane = new ReturnBkTransactCard(parentPanel,cellValues);
				parentPanel.add(returnBookTransactPane, "RETURNTRANSACT");
				parentLayout.show(parentPanel, "RETURNTRANSACT");
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

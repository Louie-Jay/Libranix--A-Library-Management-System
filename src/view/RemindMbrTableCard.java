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

import controller.RemindMbrTableController;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Component;

public class RemindMbrTableCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	HeaderPanel header;
	
	//content center
	JPanel content;
	Table remindMbrTable;
	
	// footer buttons
	JPanel optionsPane;
	JCheckBox chkBkId;
	IDTextField txtBkId;
	JCheckBox chkMbrId;
	IDTextField txtMbrId;
	JCheckBox chkFName;
	FNameTextField txtFName;
	JCheckBox chkISBN;
	ISBNTextField txtISBN;
	JCheckBox chkNo;
	ContactTextField txtNo;
	JButton btnFind;
	
	RemindMbrMssgrCard remindMemberPane;
	
	private RemindMbrTableController controller;
	private LinkedHashMap<String, JComponent> inputComp;
	
	
	public RemindMbrTableCard(JPanel parentPnl) {
		setBackground(new Color(255, 250, 250));
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		this.controller = new RemindMbrTableController();
		
		loadHeader();
		loadContentTable();
		loadFooterOptions();
		
		
	}
	
	private void loadHeader() {
		header = new HeaderPanel("Remind Members",true);
		
		header.setBackActionListener(new RemindMbrTableHandler());
		
		this.add(header,BorderLayout.PAGE_START);
	}
	
	private void loadContentTable() {
		inputComp = new LinkedHashMap<String, JComponent>();
		
		JPanel formOuterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		formOuterPanel.setBackground(new Color(255, 250, 250));
		content = new JPanel(new FlowLayout(FlowLayout.CENTER));
		content.setBackground(new Color(255, 250, 250));
		remindMbrTable = new Table();
		inputComp.put("Table", remindMbrTable);
		remindMbrTable.addMouseListener(new RemindMbrTable_TableHandler());
		
		content.add(remindMbrTable.getTablePane());
		formOuterPanel.add(content);
		this.loadTable();
		this.add(formOuterPanel,BorderLayout.CENTER);
		
	}
	
	private void loadTable() {
		remindMbrTable.setModel(controller.loadDefaultTable());
		
		remindMbrTable.getColumnModel().getColumn(0).setMinWidth(0);
		remindMbrTable.getColumnModel().getColumn(0).setMaxWidth(0);
		remindMbrTable.getColumnModel().getColumn(0).setWidth(0);
		
		remindMbrTable.getColumnModel().getColumn(8).setMinWidth(0);
		remindMbrTable.getColumnModel().getColumn(8).setMaxWidth(0);
		remindMbrTable.getColumnModel().getColumn(8).setWidth(0);
	}
	
	private void loadFooterOptions() {
		
		optionsPane = new JPanel();
		optionsPane.setBackground(new Color(255, 250, 250));
		
		optionsPane.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		chkBkId = new JCheckBox("Book ID:");
		chkBkId.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkBkId.setOpaque(false);
		txtBkId = new IDTextField("",5);
		txtBkId.setAlignmentX(Component.LEFT_ALIGNMENT);
		chkMbrId = new JCheckBox("Member ID:");
		chkMbrId.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkMbrId.setOpaque(false);
		txtMbrId = new IDTextField("",5);
		txtMbrId.setAlignmentX(Component.LEFT_ALIGNMENT);
		chkFName = new JCheckBox("First Name:");
		chkFName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkFName.setOpaque(false);
		txtFName = new FNameTextField("",10);
		txtFName.setAlignmentX(Component.LEFT_ALIGNMENT);
		chkISBN = new JCheckBox("ISBN:");
		chkISBN.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkISBN.setOpaque(false);
		txtISBN = new ISBNTextField("",10);
		txtISBN.setAlignmentX(Component.LEFT_ALIGNMENT);
		chkNo = new JCheckBox("Contact No:");
		chkNo.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkNo.setOpaque(false);
		txtNo = new ContactTextField("",10);
		txtNo.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnFind = new JButton("Find");
		btnFind.setMaximumSize(new Dimension(55, 25));
		btnFind.setMinimumSize(new Dimension(55, 25));
		btnFind.setPreferredSize(new Dimension(55, 25));
		btnFind.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnFind.setBackground(new Color(255, 250, 250));
		btnFind.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		
		chkBkId.addActionListener(new RemindMbrTableChkHandler());
		chkMbrId.addActionListener(new RemindMbrTableChkHandler());
		chkFName.addActionListener(new RemindMbrTableChkHandler());
		chkISBN.addActionListener(new RemindMbrTableChkHandler());
		chkNo.addActionListener(new RemindMbrTableChkHandler());
		btnFind.addActionListener(new RemindMbrTableHandler());
		btnFind.addMouseListener(new MouseHandler());
		
		inputComp.put("txtBkId", txtBkId);
		inputComp.put("txtMbrId", txtMbrId);
		inputComp.put("txtFName", txtFName);
		inputComp.put("txtISBN", txtISBN);
		inputComp.put("txtNo", txtNo);
		
		inputComp.put("chkBkId", chkBkId);
		inputComp.put("chkMbrId", chkMbrId);
		inputComp.put("chkFName", chkFName);
		inputComp.put("chkISBN", chkISBN);
		inputComp.put("chkNo", chkNo);
		
		txtBkId.setEnabled(false);
		txtMbrId.setEnabled(false);
		txtFName.setEnabled(false);
		txtISBN.setEnabled(false);
		txtNo.setEnabled(false);
		
		optionsPane.add(chkBkId);
		optionsPane.add(txtBkId);
		optionsPane.add(chkMbrId);
		optionsPane.add(txtMbrId);
		optionsPane.add(chkFName);
		optionsPane.add(txtFName);
		optionsPane.add(chkISBN);
		optionsPane.add(txtISBN);
		optionsPane.add(chkNo);
		optionsPane.add(txtNo);
		optionsPane.add(btnFind);
		
		this.add(optionsPane,BorderLayout.PAGE_END);
	}
	
	private class RemindMbrTableChkHandler implements ActionListener{
		JCheckBox source;
		@Override
		public void actionPerformed(ActionEvent chkEvt) {
			source = (JCheckBox)chkEvt.getSource();
			
			switch (source.getActionCommand()) {
			case "Book ID:":
				if(chkBkId.isSelected()) {
					txtBkId.setEnabled(true);
				}else {
					txtBkId.setEnabled(false);
				}
				txtBkId.setText("");
				txtBkId.setDefaultBorder();
				break;
			case "Member ID:":
				if (chkMbrId.isSelected()) {
					txtMbrId.setEnabled(true);
				}else {
					txtMbrId.setEnabled(false);
				}
				txtMbrId.setText("");
				txtMbrId.setDefaultBorder();
				break;
			case "First Name:":
				if (chkFName.isSelected()) {
					txtFName.setEnabled(true);
				}else {
					txtFName.setEnabled(false);
				}
				txtFName.setText("");
				txtFName.setDefaultBorder();
				break;
			case "ISBN:":
				if (chkISBN.isSelected()) {
					txtISBN.setEnabled(true);
				} else {
					txtISBN.setEnabled(false);
				}
				txtISBN.setText("");
				txtISBN.setDefaultBorder();
				break;
			case "Contact No:":
				if (chkNo.isSelected()) {
					txtNo.setEnabled(true);
				} else {
					txtNo.setEnabled(false);
				}
				txtNo.setText("");
				txtNo.setDefaultBorder();
				break;
			default:
				break;
			}
			
		}
		
	}
	
	private class RemindMbrTableHandler implements ActionListener{
		JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(parentPanel);
		JButton source;

		@Override
		public void actionPerformed(ActionEvent btnEvt) {
			source = (JButton) btnEvt.getSource();
			
			switch (source.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "MAIN");
				break;
			case "Find":
				
				if(controller.find(inputComp)) {}
				else {
					ErrorDialog.showErrorDialog(parent, controller.getErrorMsg());
				}
				break;
			default:
				break;
			}
		}
		
	}
	
	
	private class RemindMbrTable_TableHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent mEvt) {
			ArrayList<String> cellKeys = new ArrayList<String>();
			
			cellKeys.add("Borrow ID");
			cellKeys.add("Book ID");
			cellKeys.add("Member ID");
			cellKeys.add("Book Title");
			cellKeys.add("Book ISBN");
			cellKeys.add("First Name");
			cellKeys.add("Last Name");
			cellKeys.add("Contact");
			cellKeys.add("Quantity");
			
			remindMbrTable.setCellValueKeys(cellKeys);
			
			
			if(mEvt.getClickCount() == 1) {
				
				remindMemberPane = new RemindMbrMssgrCard(parentPanel, remindMbrTable.getCellValues());
				parentPanel.add(remindMemberPane, "REMINDMEMBER");
				parentLayout.show(parentPanel, "REMINDMEMBER");
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

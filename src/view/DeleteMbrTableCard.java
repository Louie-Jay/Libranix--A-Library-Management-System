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

import controller.DeleteMbrTableController;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Component;

public class DeleteMbrTableCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	HeaderPanel header;
	
	//content center
	JPanel content;
	Table deleteMbrTable; 
	
	// footer buttons
	JPanel optionsPane;
	JCheckBox chkId;
	IDTextField txtId;
	JCheckBox chkFName;
	FNameTextField txtFName;
	JCheckBox chkLName;
	LNameTextField txtLName;
	JCheckBox chkNo;
	ContactTextField txtNo;
	JButton btnFind;
	
	DeleteMbrInfoCard deleteMemberPane;
	private LinkedHashMap<String, JComponent> optContainer;
	private DeleteMbrTableController controller;
	
	
	public DeleteMbrTableCard(JPanel parentPnl) {
		setBackground(new Color(255, 250, 250));
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		this.controller = new DeleteMbrTableController();
		loadHeader();
		loadContentTable();
		loadFooterOptions();
		
		
	}
	
	private void loadHeader() {
		header = new HeaderPanel("Delete Members", true);
		
		header.setBackActionListener(new DeleteMbrTableHandler());
		
		this.add(header,BorderLayout.PAGE_START);
	}
	
	private void loadContentTable() {
		
		optContainer = new LinkedHashMap<String, JComponent>();
		
		JPanel formOuterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		formOuterPanel.setBackground(new Color(255, 250, 250));
		content = new JPanel(new FlowLayout(FlowLayout.CENTER));
		content.setBackground(new Color(255, 250, 250));
		deleteMbrTable = new Table();
		deleteMbrTable.addMouseListener(new DeleteMbrTable_TableHandler());
		optContainer.put("Table", deleteMbrTable);
		
		content.add(deleteMbrTable.getTablePane());
		formOuterPanel.add(content);
		this.loadTable();
		this.add(formOuterPanel,BorderLayout.CENTER);
		
	}
	
	private void loadTable() {
		deleteMbrTable.setModel(controller.loadDefaultTable());
		
		deleteMbrTable.getColumnModel().getColumn(8).setMinWidth(0);
		deleteMbrTable.getColumnModel().getColumn(8).setMaxWidth(0);
		deleteMbrTable.getColumnModel().getColumn(8).setWidth(0);
	}
	
	private void loadFooterOptions() {
		
		optionsPane = new JPanel();
		optionsPane.setBackground(new Color(255, 250, 250));
		
		optionsPane.setLayout(new FlowLayout(FlowLayout.LEADING));
		//this.setBorder(new LineBorder(Color.BLACK));
		
		
		chkId = new JCheckBox("ID:");
		chkId.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkId.setOpaque(false);
		txtId = new IDTextField("",10);
		txtId.setAlignmentX(Component.LEFT_ALIGNMENT);
		chkFName = new JCheckBox("First Name:");
		chkFName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkFName.setOpaque(false);
		txtFName = new FNameTextField("",13);
		txtFName.setAlignmentX(Component.LEFT_ALIGNMENT);
		chkLName = new JCheckBox("Last Name:");
		chkLName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkLName.setOpaque(false);
		txtLName = new LNameTextField("",13);
		txtLName.setAlignmentX(Component.LEFT_ALIGNMENT);
		chkNo = new JCheckBox("Contact No:");
		chkNo.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkNo.setOpaque(false);
		txtNo = new ContactTextField("",10);
		txtNo.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnFind = new JButton("Find");
		btnFind.setBackground(new Color(255, 250, 250));
		btnFind.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnFind.setMaximumSize(new Dimension(55, 25));
		btnFind.setMinimumSize(new Dimension(55, 25));
		btnFind.setPreferredSize(new Dimension(55, 25));
		btnFind.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnFind.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		
		chkId.addActionListener(new DeleteMbrTableChkHandler());
		chkFName.addActionListener(new DeleteMbrTableChkHandler());
		chkLName.addActionListener(new DeleteMbrTableChkHandler());
		chkNo.addActionListener(new DeleteMbrTableChkHandler());
		btnFind.addActionListener(new DeleteMbrTableHandler());
		btnFind.addMouseListener(new MouseHandler());
		
		txtId.setEnabled(false);
		txtFName.setEnabled(false);
		txtLName.setEnabled(false);
		txtNo.setEnabled(false);
		
		optionsPane.add(chkId);
		optionsPane.add(txtId);
		optionsPane.add(chkFName);
		optionsPane.add(txtFName);
		optionsPane.add(chkLName);
		optionsPane.add(txtLName);
		optionsPane.add(chkNo);
		optionsPane.add(txtNo);
		optionsPane.add(btnFind);
		
		optContainer.put("chkId", chkId);
		optContainer.put("txtId", txtId);
		
		optContainer.put("chkFName", chkFName);
		optContainer.put("txtFName", txtFName);
		
		optContainer.put("chkLName", chkLName);
		optContainer.put("txtLName", txtLName);
		
		optContainer.put("chkNo", chkNo);
		optContainer.put("txtNo", txtNo);
		
		
		this.add(optionsPane,BorderLayout.PAGE_END);
	}
	
	private class DeleteMbrTableChkHandler implements ActionListener{
		JCheckBox source;
		@Override
		public void actionPerformed(ActionEvent chkEvt) {
			source = (JCheckBox) chkEvt.getSource();
			String option = source.getActionCommand();
			switch (option) {
			case "ID:":
				if(txtId.isEnabled()) {
					txtId.setEnabled(false);
				}else {
					txtId.setEnabled(true);
				}
				
				txtId.setText("");
				txtId.setDefaultBorder();
				break;
			case "First Name:":
				if(txtFName.isEnabled()) {
					txtFName.setEnabled(false);
				}else {
					txtFName.setEnabled(true);
				}
				txtFName.setText("");
				txtFName.setDefaultBorder();
				break;
			case "Last Name:":
				if(txtLName.isEnabled()) {
					txtLName.setEnabled(false);
				}else {
					txtLName.setEnabled(true);
				}
				txtLName.setText("");
				txtLName.setDefaultBorder();
				break;
			case "Contact No:":
				if(txtNo.isEnabled()) {
					txtNo.setEnabled(false);
				}else {
					txtNo.setEnabled(true);
				}
				txtNo.setText("");
				txtNo.setDefaultBorder();
				break;
			default:
				break;
			}
		}
	}
	
	private class DeleteMbrTableHandler implements ActionListener{
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
				
				if(chkId.isSelected() || chkFName.isSelected() || chkLName.isSelected() || chkNo.isSelected()) {
					if(controller.applyTableChange(optContainer)) {
					}else {
						ErrorDialog.showErrorDialog(parent, controller.getErrorMsg());
					}
				}else {
					ErrorDialog.showErrorDialog(parent, controller.getErrorMsg());	
				}
				
				break;
			default:
				break;
			}
			
			
		}
		
	}
	
	
	private class DeleteMbrTable_TableHandler extends MouseAdapter{
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
			
			deleteMbrTable.setCellValueKeys(cellKeys);
			
			if(mEvt.getClickCount() == 1) {
				
				deleteMemberPane = new DeleteMbrInfoCard(parentPanel, deleteMbrTable.getCellValues());
				parentPanel.add(deleteMemberPane, "DELETEMEMBER");
				parentLayout.show(parentPanel, "DELETEMEMBER");
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

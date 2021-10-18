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

import controller.ViewMbrTableController;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.LineBorder;

public class ViewMbrTableCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	HeaderPanel header;
	
	//content center
	JPanel content;
	Table viewMbrTable; //test datas over here
	
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
	
	private ViewMbrInfoCard viewMemberPane;
	private ViewMbrTableController controller;
	private LinkedHashMap<String, JComponent> optContainer;
	
	public ViewMbrTableCard(JPanel parentPnl) {
		setBackground(new Color(255, 250, 250));
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		this.controller = new ViewMbrTableController();

		loadHeader();
		loadContentTable();
		loadFooterOptions();
		
		
	}
	
	private void loadHeader() {
		header = new HeaderPanel("View Members",true);
		
		header.setBackActionListener(new ViewMbrTableHandler());
		
		this.add(header,BorderLayout.PAGE_START);
	}
	
	private void loadContentTable() {
		
		optContainer = new LinkedHashMap<String, JComponent>();
		
		JPanel formOuterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		formOuterPanel.setBackground(new Color(255, 250, 250));
		content = new JPanel(new FlowLayout(FlowLayout.CENTER));
		content.setBackground(new Color(255, 250, 250));
		viewMbrTable = new Table();
		
		viewMbrTable.addMouseListener(new ViewMbrTable_TableHandler());
		optContainer.put("Table", viewMbrTable);
		
		content.add(viewMbrTable.getTablePane());
		formOuterPanel.add(content);
		this.loadTable();
		this.add(formOuterPanel,BorderLayout.CENTER);
		
	}
	
	private void loadTable() {
		viewMbrTable.setModel(controller.loadDefaultTable());
		
		viewMbrTable.getColumnModel().getColumn(8).setMinWidth(0);
		viewMbrTable.getColumnModel().getColumn(8).setMaxWidth(0);
		viewMbrTable.getColumnModel().getColumn(8).setWidth(0);
	}
	
	private void loadFooterOptions() {
		
		optionsPane = new JPanel();
		optionsPane.setBackground(new Color(255, 250, 250));
		
		optionsPane.setLayout(new FlowLayout(FlowLayout.LEADING));
		//this.setBorder(new LineBorder(Color.BLACK));
		
		
		chkId = new JCheckBox("ID:");
		chkId.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkId.setOpaque(false);
		txtId = new IDTextField("",6);
		txtId.setAlignmentX(Component.LEFT_ALIGNMENT);
		chkFName = new JCheckBox("First Name: ");
		chkFName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkFName.setOpaque(false);
		txtFName = new FNameTextField("",12);
		txtFName.setAlignmentX(Component.LEFT_ALIGNMENT);
		chkLName = new JCheckBox("Last Name: ");
		chkLName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkLName.setOpaque(false);
		txtLName = new LNameTextField("",12);
		txtLName.setAlignmentX(Component.LEFT_ALIGNMENT);
		chkNo = new JCheckBox("Contact No: ");
		chkNo.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkNo.setOpaque(false);
		txtNo = new ContactTextField("",12);
		txtNo.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnFind = new JButton("Find");
		btnFind.setMaximumSize(new Dimension(55, 25));
		btnFind.setMinimumSize(new Dimension(55, 25));
		btnFind.setPreferredSize(new Dimension(55, 25));
		btnFind.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnFind.setBackground(new Color(255, 250, 250));
		btnFind.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		
		txtId.setEnabled(false);
		txtFName.setEnabled(false);
		txtLName.setEnabled(false);
		txtNo.setEnabled(false);
		
		chkId.addActionListener(new ViewMbrTableChkHandler());
		chkFName.addActionListener(new ViewMbrTableChkHandler());
		chkLName.addActionListener(new ViewMbrTableChkHandler());
		chkNo.addActionListener(new ViewMbrTableChkHandler());
		btnFind.addActionListener(new ViewMbrTableHandler());
		btnFind.addMouseListener(new MouseHandler());
		
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
	
	private class ViewMbrTableChkHandler implements ActionListener{
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
	
	private class ViewMbrTableHandler implements ActionListener{
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
	
	
	private class ViewMbrTable_TableHandler extends MouseAdapter{
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
			
			viewMbrTable.setCellValueKeys(cellKeys);
			if(mEvt.getClickCount() == 1) {
				
				viewMemberPane = new ViewMbrInfoCard(parentPanel,viewMbrTable.getCellValues());
				parentPanel.add(viewMemberPane, "INFOVIEWMEMBER");
				parentLayout.show(parentPanel, "INFOVIEWMEMBER");
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

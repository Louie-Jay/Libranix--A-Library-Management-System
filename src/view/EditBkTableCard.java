package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.EditBkTableController;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.Insets;

public class EditBkTableCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	private EditBkTableController controller;
	
	//header
	HeaderPanel header;
	
	//content center
	JPanel content;
	private Table editBkTable;
	
	private LinkedHashMap<String, JComponent> optContainer;
	// footer buttons
	JPanel optionsPane;
	JCheckBox chkId;
	IDTextField txtId;
	JCheckBox chkIsbn;
	ISBNTextField txtIsbn;
	JCheckBox chkGenre;
	GenreComboBox<String> cbxGenre;
	JButton btnFind;
	
	EditBkFormCard editBookPane;
	
	
	public EditBkTableCard(JPanel parentPnl) {
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		this.controller = new EditBkTableController();
		loadHeader();
		loadContentTable();
		loadFooterOptions();
		loadTable();
	}
	
	private void loadHeader() {
		header = new HeaderPanel("Edit Books", true);
		
		header.setBackActionListener(new EditBkTableHandler());
		
		this.add(header,BorderLayout.PAGE_START);
	}
	
	private void loadContentTable() {
		
		optContainer = new LinkedHashMap<String, JComponent>();
		JPanel formOuterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		formOuterPanel.setBackground(new Color(255, 250, 250));
		content = new JPanel(new FlowLayout(FlowLayout.CENTER));
		content.setBackground(new Color(255, 250, 250));
		editBkTable = new Table();
		optContainer.put("Table", editBkTable);
		
		editBkTable.addMouseListener(new EditBkTable_TableHandler());
		
		content.add(editBkTable.getTablePane());
		formOuterPanel.add(content);
		this.add(formOuterPanel,BorderLayout.CENTER);
		this.loadTable();
		
	}
	
	public void loadTable() {
		editBkTable.setModel(controller.loadCustomTable());
		
		editBkTable.getColumnModel().getColumn(0).setMinWidth(0);
		editBkTable.getColumnModel().getColumn(0).setMaxWidth(0);
		editBkTable.getColumnModel().getColumn(0).setWidth(0);
		
		editBkTable.getColumnModel().getColumn(1).setMinWidth(300);
		editBkTable.getColumnModel().getColumn(1).setMaxWidth(300);
		editBkTable.getColumnModel().getColumn(1).setWidth(300);
		
		editBkTable.getColumnModel().getColumn(7).setMinWidth(0);
		editBkTable.getColumnModel().getColumn(7).setMaxWidth(0);
		editBkTable.getColumnModel().getColumn(7).setWidth(0);
		
	}
	
	private void loadFooterOptions() {
		
		optionsPane = new JPanel();
		optionsPane.setBackground(new Color(255, 250, 250));
		
		optionsPane.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		chkId = new JCheckBox("ID:"); 
		chkId.setForeground(new Color(0, 0, 0));
		chkId.setOpaque(false);
		chkId.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtId = new IDTextField("",6); txtId.setEnabled(false);
		chkIsbn = new JCheckBox("ISBN:");
		chkIsbn.setOpaque(false);
		chkIsbn.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtIsbn = new ISBNTextField("",12); txtIsbn.setEnabled(false);
		chkGenre = new JCheckBox("Genre:");
		chkGenre.setOpaque(false);
		chkGenre.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		cbxGenre = new GenreComboBox<String>(controller.getAllGenreData()); cbxGenre.setEnabled(false);
		btnFind = new JButton("Find");
		btnFind.setMinimumSize(new Dimension(55, 25));
		btnFind.setMaximumSize(new Dimension(55, 25));
		btnFind.setPreferredSize(new Dimension(55, 25));
		btnFind.setMargin(new Insets(2, 20, 2, 14));
		btnFind.setSize(new Dimension(55, 25));
		btnFind.setFocusPainted(false);
		btnFind.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnFind.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnFind.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnFind.setBackground(new Color(255, 250, 250));
		
		chkId.addActionListener(new EditBkTableChkHandler());
		chkIsbn.addActionListener(new EditBkTableChkHandler());
		chkGenre.addActionListener(new EditBkTableChkHandler());
		btnFind.addActionListener(new EditBkTableHandler());
		btnFind.addMouseListener(new MouseHandler());
		
		optionsPane.add(chkId);
		optionsPane.add(txtId);
		optionsPane.add(chkIsbn);
		optionsPane.add(txtIsbn);
		optionsPane.add(chkGenre);
		optionsPane.add(cbxGenre);
		optionsPane.add(btnFind);
		
		optContainer.put("chkID",chkId);
		optContainer.put("ID", txtId);
		optContainer.put("chkISBN",chkIsbn);
		optContainer.put("ISBN", txtIsbn);
		optContainer.put("chkGenre",chkGenre);
		optContainer.put("Genre", cbxGenre);
		
		this.add(optionsPane,BorderLayout.PAGE_END);
	}
	
	private class EditBkTableChkHandler implements ActionListener{
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
			case "ISBN:":
				if(txtIsbn.isEnabled()) {
					txtIsbn.setEnabled(false);
				}else {
					txtIsbn.setEnabled(true);
				}
				txtId.setText("");
				txtIsbn.setDefaultBorder();
				break;
			case "Genre:":
				if(cbxGenre.isEnabled()) {
					cbxGenre.setEnabled(false);
				}else {
					cbxGenre.setEnabled(true);
				}
				cbxGenre.setSelectedIndex(0);
				cbxGenre.setDefaultBorder();
				break;
			default:
				break;
			}
		}
	}
	
	private class EditBkTableHandler implements ActionListener{
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
				
				if(chkId.isSelected() || chkIsbn.isSelected() || chkGenre.isSelected()) {
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
	
	private class EditBkTable_TableHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent mEvt) {
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
			
			editBkTable.setCellValueKeys(cellKeys);
			
			if(mEvt.getClickCount() == 1) {
				
				editBookPane = new EditBkFormCard(parentPanel, editBkTable.getCellValues());
				parentPanel.add(editBookPane, "EDITBOOK");
				parentLayout.show(parentPanel, "EDITBOOK");
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

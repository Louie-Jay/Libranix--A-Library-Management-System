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

import controller.DeleteBkTableController;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Component;

public class DeleteBkTableCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	HeaderPanel header;
	
	//content center
	JPanel content;
	private Table deleteViewBkTable;
	
	// footer buttons
	JPanel optionsPane;
	JCheckBox chkId;
	IDTextField txtId;
	JCheckBox chkIsbn;
	ISBNTextField txtIsbn;
	JCheckBox chkGenre;
	GenreComboBox<String> cbxGenre;
	JButton btnFind;
	
	
	DeleteBkInfoCard deleteBookPane;
	private DeleteBkTableController controller;
	private LinkedHashMap<String,JCheckBox> chkComponents;
	private LinkedHashMap<String,JComponent> inputComponents;
	
	public DeleteBkTableCard(JPanel parentPnl) {
		setBackground(new Color(255, 250, 250));
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		this.controller = new DeleteBkTableController();
		
		loadHeader();
		loadContentTable();
		loadTableCell();
		loadFooterOptions();
		
	}
	
	private void loadHeader() {
		header = new HeaderPanel("Delete Book",true);
		
		header.setBackActionListener(new DeleteBkTableHandler());
		
		this.add(header,BorderLayout.PAGE_START);
	}
	
	private void loadContentTable() {
		
		JPanel formOuterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		content = new JPanel(new FlowLayout(FlowLayout.CENTER));
		content.setBackground(new Color(255, 250, 250));
		deleteViewBkTable = new Table();
		deleteViewBkTable.setModel(controller.getDefaultTableModel());
		//JScrollPane tableScrollPane = new JScrollPane(deleteViewBkTable);
		//tableScrollPane.setPreferredSize(new Dimension(1000,560));
		deleteViewBkTable.addMouseListener(new DeleteBkTable_TableHandler());
		//deleteViewBkTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		content.add(deleteViewBkTable.getTablePane());
		formOuterPanel.add(content);
		
		this.add(formOuterPanel,BorderLayout.CENTER);
		
	}
	
	private void loadTableCell() {
		deleteViewBkTable.setModel(controller.getDefaultTableModel());
		
		deleteViewBkTable.getColumnModel().getColumn(0).setMinWidth(0);
		deleteViewBkTable.getColumnModel().getColumn(0).setMaxWidth(0);
		deleteViewBkTable.getColumnModel().getColumn(0).setWidth(0);
		
		deleteViewBkTable.getColumnModel().getColumn(1).setMinWidth(300);
		deleteViewBkTable.getColumnModel().getColumn(1).setMaxWidth(300);
		deleteViewBkTable.getColumnModel().getColumn(1).setWidth(300);
		
		deleteViewBkTable.getColumnModel().getColumn(7).setMinWidth(0);
		deleteViewBkTable.getColumnModel().getColumn(7).setMaxWidth(0);
		deleteViewBkTable.getColumnModel().getColumn(7).setWidth(0);
	}
	
	private void loadFooterOptions() {
		
		optionsPane = new JPanel();
		optionsPane.setBackground(new Color(255, 250, 250));
		
		optionsPane.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		chkId = new JCheckBox("ID:");
		chkId.setAlignmentX(Component.CENTER_ALIGNMENT);
		chkId.setOpaque(false);
		chkId.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtId = new IDTextField("",10);
		chkIsbn = new JCheckBox("ISBN:");
		chkIsbn.setAlignmentX(Component.CENTER_ALIGNMENT);
		chkIsbn.setOpaque(false);
		chkIsbn.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtIsbn = new ISBNTextField("",10);
		chkGenre = new JCheckBox("Genre:");
		chkGenre.setAlignmentX(Component.CENTER_ALIGNMENT);
		chkGenre.setOpaque(false);
		chkGenre.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		cbxGenre = new GenreComboBox<String>(controller.getAllGenreData());
		btnFind = new JButton("Find");
		btnFind.setMaximumSize(new Dimension(55, 25));
		btnFind.setMinimumSize(new Dimension(55, 25));
		btnFind.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnFind.setPreferredSize(new Dimension(55, 25));
		btnFind.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnFind.setBackground(new Color(255, 250, 250));
		btnFind.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		
		optionsPane.add(chkId);
		optionsPane.add(txtId);
		optionsPane.add(chkIsbn);
		optionsPane.add(txtIsbn);
		optionsPane.add(chkGenre);
		optionsPane.add(cbxGenre);
		optionsPane.add(btnFind);
		
		chkComponents = new LinkedHashMap<String,JCheckBox>();
		inputComponents = new LinkedHashMap<String, JComponent>();
		
		chkComponents.put("ID", chkId);
		inputComponents.put("ID",txtId);
		chkComponents.put("ISBN", chkIsbn);
		inputComponents.put("ISBN",txtIsbn);
		chkComponents.put("Genre", chkGenre);
		inputComponents.put("Genre",cbxGenre);
		
		chkId.addActionListener(new DeleteBkTableChkHandler());
		chkIsbn.addActionListener(new DeleteBkTableChkHandler());
		chkGenre.addActionListener(new DeleteBkTableChkHandler());
		
		btnFind.addActionListener(new DeleteBkTableHandler());
		btnFind.addMouseListener(new MouseHandler());
		controller.loadOption(chkComponents, inputComponents);
		
		this.add(optionsPane,BorderLayout.PAGE_END);
	}
	
	private class DeleteBkTableChkHandler implements ActionListener{
		JCheckBox source;

		@Override
		public void actionPerformed(ActionEvent chkEvt) {
			source = (JCheckBox)chkEvt.getSource();
			
			switch (source.getActionCommand()) {
			case "ID:":
				if (chkId.isSelected()) {
					txtId.setEnabled(true);
				}else {
					txtId.setEnabled(false);
				}
				txtId.setText("");
				txtId.setDefaultBorder();
				break;
			case "ISBN:":
				if (chkIsbn.isSelected()) {
					txtIsbn.setEnabled(true);
				}else {
					txtIsbn.setEnabled(false);
				}
				txtIsbn.setText("");
				break;
			case "Genre:":
				if (chkGenre.isSelected()) {
					cbxGenre.setEnabled(true);
					cbxGenre.setSelectedIndex(0);
				}else {
					cbxGenre.setEnabled(false);
				}
				cbxGenre.setSelectedIndex(0);
				cbxGenre.setDefaultBorder();
				break;
			default:
				break;
			}
			
		}
		
	}
	
	private class DeleteBkTableHandler implements ActionListener{
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
				
				if(chkId.isSelected() || chkIsbn.isSelected() || chkGenre.isSelected()) {
					if(controller.findBook()) {
						deleteViewBkTable.setModel(controller.getTableModel());
						
						deleteViewBkTable.getColumnModel().getColumn(0).setMinWidth(0);
						deleteViewBkTable.getColumnModel().getColumn(0).setMaxWidth(0);
						deleteViewBkTable.getColumnModel().getColumn(0).setWidth(0);
						
						deleteViewBkTable.getColumnModel().getColumn(1).setMinWidth(300);
						deleteViewBkTable.getColumnModel().getColumn(1).setMaxWidth(300);
						deleteViewBkTable.getColumnModel().getColumn(1).setWidth(300);
						
						deleteViewBkTable.getColumnModel().getColumn(7).setMinWidth(0);
						deleteViewBkTable.getColumnModel().getColumn(7).setMaxWidth(0);
						deleteViewBkTable.getColumnModel().getColumn(7).setWidth(0);
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
	
	
	private class DeleteBkTable_TableHandler extends MouseAdapter{
		LinkedHashMap<String,Object> cellValues;
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
				
				deleteViewBkTable.setCellValueKeys(cellKeys);
				
				deleteBookPane = new DeleteBkInfoCard(parentPanel, deleteViewBkTable.getCellValues());
				parentPanel.add(deleteBookPane, "INFODELETEBOOK");
				parentLayout.show(parentPanel, "INFODELETEBOOK");
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

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controller.TableController;

public class Table extends JTable{
	
	private TableController controller;
	
	public Table() {
		setFont(new Font("Lucida Sans", Font.BOLD, 11));
		this.getTableHeader().setReorderingAllowed(false);
		this.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setBackground(new Color(30, 144, 255));
		this.getTableHeader().setFont(new Font("Lucida Sans", Font.BOLD, 13));
		this.getTableHeader().setForeground(new Color(255, 250, 250));
		
		this.controller = new TableController(this);
	}
	
	public JScrollPane getTablePane() {
		JScrollPane tableScrollPane = new JScrollPane(this);
		tableScrollPane.getVerticalScrollBar().setUI(new CustomScrollBarProperties());
		tableScrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarProperties());
		tableScrollPane.setPreferredSize(new Dimension(1000,560));
		return tableScrollPane;
	}
	
	public void setCellValueKeys(ArrayList<String> paramKeys) {
		controller.applyCellValueKeys(paramKeys);
	}
	
	public LinkedHashMap<String,Object> getCellValues(){
		return controller.getCellValues();
	}

}

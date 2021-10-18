package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JTable;

import view.EditBkFormCard;
import view.Table;

public class TableController {
	
	private Table viewTable;
	private ArrayList<String> cellValueKeys;
	private LinkedHashMap<String,Object> cellValues;
	
	public TableController(Table paramTable) {
		this.viewTable = paramTable;
		this.cellValueKeys = new ArrayList<String>();
		this.cellValues = new LinkedHashMap<String, Object>();
	}
	
	public void applyCellValueKeys(ArrayList<String> paramKeys) {
		this.cellValueKeys = paramKeys;
	}
	
	public LinkedHashMap<String,Object> getCellValues(){
		
		if (cellValueKeys.isEmpty()) {
			System.out.println("Cell keys not applied yet");
			return null;
		}else {
			int row = viewTable.getSelectedRow();
			
			for(int col = 0; col <= (cellValueKeys.size()-1); col++) {
				cellValues.put(cellValueKeys.get(col), viewTable.getValueAt(row, col));
			}
		}
		
		return cellValues;
	}

}

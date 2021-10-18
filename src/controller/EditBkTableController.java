package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import model.EditBkTableModel;
import model.FileDataModel;
import view.GenreComboBox;
import view.IDTextField;
import view.ISBNTextField;

public class EditBkTableController {
	
	private FileDataModel filedata;
	private EditBkTableModel model;
	private String errorMsg;
	private HashMap<Integer,String> inputs;
	
	public EditBkTableController() {
		filedata = new FileDataModel("allGenre.data");
		model = new EditBkTableModel();
		errorMsg = "Cannot search without input.";
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public boolean applyTableChange(LinkedHashMap<String, JComponent> paramComp) {
		JCheckBox chkId = (JCheckBox)paramComp.get("chkID");
		JCheckBox chkIsbn = (JCheckBox)paramComp.get("chkISBN");
		JCheckBox chkGenre = (JCheckBox)paramComp.get("chkGenre");
		JTable tempTable = (JTable) paramComp.get("Table");
		
		inputs = new HashMap<Integer,String>();
		
		if(chkId.isSelected()) {
			IDTextField tempId = (IDTextField)paramComp.get("ID");
			if(tempId.valid()) {
				inputs.put(0, tempId.getText());
			}else {
				errorMsg = "Invalid ID";
				return false;
			}
		}
		
		if(chkIsbn.isSelected()) {
			ISBNTextField tempIsbn = (ISBNTextField)paramComp.get("ISBN");
			if(tempIsbn.valid()) {
				inputs.put(1, tempIsbn.getText());
			}else {
				errorMsg = "Invalid ISBN";
				return false;
			}
		}
		
		if(chkGenre.isSelected()) {
			GenreComboBox tempGenre = (GenreComboBox)paramComp.get("Genre");
			if(tempGenre.valid()) {
				inputs.put(2,(String) tempGenre.getSelectedItem());
			}else {
				errorMsg = "Invalid Genre";
				return false;
			}
		}
		
		if(model.applyTableModel(inputs)) {
			tempTable.setModel(model.getTableModel());
		}
		else {
			errorMsg = "Search failed";
			tempTable.setModel(model.loadDefaultTable());
			return false;
		}
		

		tempTable.getColumnModel().getColumn(0).setMinWidth(0);
		tempTable.getColumnModel().getColumn(0).setMaxWidth(0);
		tempTable.getColumnModel().getColumn(0).setWidth(0);
		
		tempTable.getColumnModel().getColumn(1).setMinWidth(300);
		tempTable.getColumnModel().getColumn(1).setMaxWidth(300);
		tempTable.getColumnModel().getColumn(1).setWidth(300);
		
		tempTable.getColumnModel().getColumn(7).setMinWidth(0);
		tempTable.getColumnModel().getColumn(7).setMaxWidth(0);
		tempTable.getColumnModel().getColumn(7).setWidth(0);
		
		return true;
	}
	
	
	public String[] getAllGenreData() {
		return filedata.getArrayStringData();
	}
	
	public TableModel loadCustomTable() {
		return model.getTableModel();
	}
	

}

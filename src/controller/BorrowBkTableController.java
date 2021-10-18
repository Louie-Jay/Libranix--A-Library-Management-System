package controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import model.BorrowBkTableModel;
import view.GenreComboBox;
import view.IDTextField;
import view.ISBNTextField;
import view.TitleTextField;

public class BorrowBkTableController {
	
	private BorrowBkTableModel model;
	private HashMap<Integer, String> inputs;
	private String errorMsg;
	
	public BorrowBkTableController() {
		model = new BorrowBkTableModel();
		errorMsg = "Cannot find without input.";
	}
	
	public boolean checkInputs(LinkedHashMap<String,JComponent> inputComp) {
		
		JCheckBox chkId = (JCheckBox) inputComp.get("chkID");
		IDTextField txtId = (IDTextField) inputComp.get("ID");
		JCheckBox chkTitle = (JCheckBox) inputComp.get("chkTitle");
		TitleTextField txtTitle = (TitleTextField) inputComp.get("Title");
		JCheckBox chkGenre = (JCheckBox) inputComp.get("chkGenre");
		GenreComboBox<String> cbxGenre  = (GenreComboBox<String>) inputComp.get("Genre");
		
		boolean boolId = chkId.isSelected();
		boolean boolTitle = chkTitle.isSelected();
		boolean boolGenre = chkGenre.isSelected();
		inputs = new HashMap<Integer,String>();
		
		if(boolId || boolTitle || boolGenre) {
			
			if(chkId.isSelected()) {
				IDTextField tempId = (IDTextField)inputComp.get("ID");
				if(tempId.valid()) {
					inputs.put(0, tempId.getText());
				}else {
					errorMsg = "Invalid ID";
					return false;
				}
			}
			
			if(chkTitle.isSelected()) {
				TitleTextField tempTitle = (TitleTextField)inputComp.get("Title");
				if(tempTitle.valid()) {
					inputs.put(1, tempTitle.getText());
				}else {
					errorMsg = "Invalid ISBN";
					return false;
				}
			}
			
			if(chkGenre.isSelected()) {
				GenreComboBox tempGenre = (GenreComboBox)inputComp.get("Genre");
				if(tempGenre.valid()) {
					inputs.put(2,(String) tempGenre.getSelectedItem());
				}else {
					errorMsg = "Invalid Genre";
					return false;
				}
			}
			
		}else {
			return false;
		}
		
		return true;
	}
	
	public TableModel getTableModelRequest(LinkedHashMap<String,JComponent> inputComp) {
		
		JCheckBox chkId = (JCheckBox) inputComp.get("chkId");
		JTextField txtId = (JTextField) inputComp.get("ID");
		JCheckBox chkTitle = (JCheckBox) inputComp.get("chkTitle");
		JTextField txtTitle = (JTextField) inputComp.get("Title");
		JCheckBox chkGenre = (JCheckBox) inputComp.get("chkGenre");
		JComboBox<String> cbxGenre  = (JComboBox<String>) inputComp.get("Genre");
		
		if(this.checkInputs(inputComp)) {
			return model.getTableRequest(inputs);
		}else {
			return model.getDefaultTableModel();
		}
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	
	public TableModel getDefaultTableModel() {
		return model.getDefaultTableModel();
	}
	
	
	public String[] getGenreData() {
		return model.getGenreData();
	}

}

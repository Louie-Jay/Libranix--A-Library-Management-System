package controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import model.ViewBkTableModel;
import view.GenreComboBox;
import view.ISBNTextField;
import view.TitleTextField;

public class ViewBkTableController {
	
	private ViewBkTableModel model;
	private LinkedHashMap<String,Object> inputQuery;
	private String errorMsg;
	private HashMap<Integer,String> inputs;
	private boolean borrowed;
	
	public ViewBkTableController() {
		model = new ViewBkTableModel();
		errorMsg = "Cannot find without input.";
	}
	
	public boolean findBook(LinkedHashMap<String,JComponent> inputOption) {
		
		JCheckBox chkTitle = (JCheckBox) inputOption.get("chkTitle");
		JCheckBox chkBorrowed = (JCheckBox) inputOption.get("Borrowed");
		JCheckBox chkGenre = (JCheckBox) inputOption.get("chkGenre");
		
		if(chkTitle.isSelected() || chkBorrowed.isSelected() || chkGenre.isSelected()) {
			
			inputs = new HashMap<Integer,String>();
			boolean blBorrowed = chkBorrowed.isSelected();
			
			this.setBorrowed(blBorrowed);
			
			if(chkTitle.isSelected()) {
				TitleTextField tempTitle = (TitleTextField) inputOption.get("Title");
				if(tempTitle.valid()) {
					System.out.println(tempTitle.getText());
					inputs.put(0, tempTitle.getText());
				}else {
					errorMsg = "Invalid ID";
					return false;
				}
			}
			
			if(chkGenre.isSelected()) {
				GenreComboBox<String> tempGenre = (GenreComboBox) inputOption.get("Genre");
				if(tempGenre.valid()) {
					inputs.put(1,(String) tempGenre.getSelectedItem());
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
	
	private void setBorrowed(boolean paramB) {
		borrowed = paramB;
	}
	
	public boolean isBorrowed() {
		return borrowed;
	}
	
	public TableModel getTableModelRequest(LinkedHashMap<String,JComponent> inputOption) {
		
		
		
		if(this.findBook(inputOption)) {
			return model.requestTableModel(inputs, borrowed);
		}else {
			errorMsg = "Invalid inputs.";
			return this.getDefaultTableModel();
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

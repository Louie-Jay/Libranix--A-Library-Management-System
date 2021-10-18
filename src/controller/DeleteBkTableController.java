package controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import model.DeleteBkTableModel;
import model.FileDataModel;
import view.GenreComboBox;
import view.IDTextField;
import view.ISBNTextField;

public class DeleteBkTableController {
	
	private FileDataModel filedata;
	private DeleteBkTableModel model;
	private LinkedHashMap<String,JComponent> inputComponents;
	private LinkedHashMap<String,JCheckBox> chksComponents;
	private String errorMsg;
	
	public DeleteBkTableController() {
		filedata = new FileDataModel("allGenre.data");
		model = new DeleteBkTableModel();
		errorMsg =  "Cannot find without input.";
	}
	
	public void loadOption(LinkedHashMap<String,JCheckBox> paramChks, LinkedHashMap<String, JComponent> paramComps) {
		chksComponents = paramChks;
		inputComponents = paramComps;
		inputComponents.get("ID").setEnabled(false);
		inputComponents.get("ISBN").setEnabled(false);
		inputComponents.get("Genre").setEnabled(false);
	}
	
	public String[] getAllGenreData() {
		return filedata.getArrayStringData();
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public boolean findBook() {
		HashMap<Integer, String> inputs = new LinkedHashMap<Integer, String>();
		
		JCheckBox chkId = (JCheckBox)chksComponents.get("ID");
		JCheckBox chkIsbn = (JCheckBox)chksComponents.get("ISBN");
		JCheckBox chkGenre = (JCheckBox)chksComponents.get("Genre");
		
		if(chkId.isSelected()) {
			IDTextField tempId = (IDTextField)inputComponents.get("ID");
			if(tempId.valid()) {
				inputs.put(0, tempId.getText());
			}else {
				errorMsg = "Invalid ID";
				return false;
			}
		}
		
		if(chkIsbn.isSelected()) {
			ISBNTextField tempIsbn = (ISBNTextField)inputComponents.get("ISBN");
			if(tempIsbn.valid()) {
				inputs.put(1, tempIsbn.getText());
			}else {
				errorMsg = "Invalid ISBN";
				return false;
			}
		}
		
		if(chkGenre.isSelected()) {
			GenreComboBox tempGenre = (GenreComboBox)inputComponents.get("Genre");
			if(tempGenre.valid()) {
				inputs.put(2,(String) tempGenre.getSelectedItem());
			}else {
				errorMsg = "Invalid Genre";
				return false;
			}
		}
		
		model.loadTableQuery(inputs);
		
		clearInputs();
		
		return true;
	}
	
	
	public void clearInputs() {
		IDTextField txtid = (IDTextField)inputComponents.get("ID");
		ISBNTextField txtisbn = (ISBNTextField)inputComponents.get("ISBN");
		GenreComboBox<String> cbxgenre = (GenreComboBox<String>)inputComponents.get("Genre");
		txtid.setText("");
		txtisbn.setText("");
		cbxgenre.setSelectedIndex(0);
		txtid.setDefaultBorder();
		txtisbn.setDefaultBorder();
		cbxgenre.setDefaultBorder();
	}
	
	public TableModel getTableModel() {
		return model.getTableModel();
	}
	
	public TableModel getDefaultTableModel() {
		return model.getDefaultTableModel();
	}

}

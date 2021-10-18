package controller;

import java.util.LinkedHashMap;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import model.SearchBkTableModel;

public class SearchBkTableController {
	
	private SearchBkTableModel model;
	private InputValidator verifier;
	private String errorMsg;
	
	public SearchBkTableController() {
		model = new SearchBkTableModel();
		errorMsg = "Unknown error occurred.";
	}
	
	public boolean searchBook(LinkedHashMap<String, Object> paramInput) {
		
		JRadioButton radioSource = this.findRadioSource(paramInput);
		String radioCommand = radioSource.getActionCommand();
		JTextField txtSearch = (JTextField)paramInput.get("Search");
		String searchStr = txtSearch.getText();
		
		verifier = new InputValidator();
		
		if(verifier.hasIllegalCharacters(searchStr)) {
			errorMsg = "Search input invalid!";
			return false;
		}else {
			if(model.searchBook(radioCommand,searchStr)) {}
			else {
				errorMsg = "Database search error occured!";
				return false;
			}
		}
		
		return true;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	private JRadioButton findRadioSource(LinkedHashMap<String, Object> paramInput) {
		JRadioButton rbtnId = (JRadioButton)paramInput.get("ID");
		JRadioButton rbtnTitle = (JRadioButton)paramInput.get("Title");
		JRadioButton rbtnAuthor = (JRadioButton)paramInput.get("Author");
		JRadioButton rbtnWriter = (JRadioButton)paramInput.get("Writer");
		JRadioButton rbtnPublisher = (JRadioButton)paramInput.get("Publisher");
		JRadioButton rbtnISBN = (JRadioButton)paramInput.get("ISBN");
		JRadioButton rbtnType = (JRadioButton)paramInput.get("Type");
		JRadioButton rbtnGenre = (JRadioButton)paramInput.get("Genre");
		JRadioButton rbtnQuantity = (JRadioButton)paramInput.get("Quantity");
		JRadioButton radioSource;

		
		if(rbtnId.isSelected()) {
			radioSource = rbtnId;
			System.out.println(radioSource.getActionCommand());
			return radioSource;
		}
		
		if(rbtnTitle.isSelected()) {
			radioSource = rbtnTitle;
			return radioSource;
		}
		
		if(rbtnAuthor.isSelected()) {
			radioSource = rbtnAuthor;
			return radioSource;
		}
		
		if(rbtnWriter.isSelected()) {
			radioSource = rbtnWriter;
			return radioSource;
		}
		
		if(rbtnPublisher.isSelected()) {
			radioSource = rbtnPublisher;
			return radioSource;
		}
		
		if(rbtnISBN.isSelected()) {
			radioSource = rbtnISBN;
			return radioSource;
		}
		
		if(rbtnType.isSelected()) {
			radioSource = rbtnType;
			return radioSource;
		}
		
		if(rbtnGenre.isSelected()) {
			radioSource = rbtnGenre;
			return radioSource;
		}
		
		if(rbtnQuantity.isSelected()) {
			radioSource = rbtnQuantity;
			return radioSource;
		}
		return null;
	}
	
	public TableModel getTableModel() {
		return model.getTableModel();
	}
	
	public TableModel getDefaultTableModel() {
		return model.getDefaultTableModel();
	}

}

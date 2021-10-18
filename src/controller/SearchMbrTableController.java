package controller;

import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import model.SearchMbrTableModel;
import view.Table;

public class SearchMbrTableController {
	
	private SearchMbrTableModel model;
	private String errorMsg;
	private InputValidator verifier;
	
	public SearchMbrTableController() {
		model = new SearchMbrTableModel();
		errorMsg = "Cannot search without a valid input.";
		verifier = new InputValidator();
	}
	
	
	public boolean search(HashMap<Integer,JComponent> paramComp) {
		
		if(this.valid(paramComp)) {
			Table srchTable = (Table) paramComp.get(8);
			String strSearch = ((JTextField)paramComp.get(7)).getText();
			
			srchTable.setModel(model.search((getCommand(paramComp)), strSearch));
			
			srchTable.getColumnModel().getColumn(8).setMinWidth(0);
			srchTable.getColumnModel().getColumn(8).setMaxWidth(0);
			srchTable.getColumnModel().getColumn(8).setWidth(0);
			return true;
		}
		else {
			errorMsg = "Search input cannot contain special characters";
			return false;
		}
	}
	
	private String getCommand(HashMap<Integer,JComponent> paramComp) {
		JRadioButton rbtn;
		for(int r = 0; r <= 6; r++) {
			rbtn = (JRadioButton) paramComp.get(r);
			if(rbtn.isSelected()) {
				System.out.println(rbtn.getActionCommand());
				return rbtn.getActionCommand();
			}
		}
		return "ID";
	}
	
	private boolean valid(HashMap<Integer,JComponent> paramComp) {
		JTextField txtSearch = (JTextField) paramComp.get(7);
		JRadioButton rbtnAddress = (JRadioButton) paramComp.get(3);
		JRadioButton rbtnEmail = (JRadioButton) paramComp.get(5);
		String strSearch = txtSearch.getText();
		
		if(rbtnEmail.isSelected() || rbtnAddress.isSelected()) {
			if(verifier.invalidEmailCharacters(strSearch)) {
				return false;
			}
		}
		
		if(verifier.hasIllegalCharacters((txtSearch.getText()))) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public TableModel loadDefaultTable() {
		return model.loadDefaultTable();
	}
}

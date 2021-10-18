package controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import model.EditMbrTableModel;
import view.ContactTextField;
import view.FNameTextField;
import view.IDTextField;
import view.LNameTextField;


public class EditMbrTableController {
	
	private EditMbrTableModel model;
	private String errorMsg;
	private HashMap<Integer,String> inputs;

	public EditMbrTableController() {
		model = new EditMbrTableModel();
		errorMsg = "Cannot search without input.";
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public boolean applyTableChange(LinkedHashMap<String, JComponent> paramComp) {
		JCheckBox chkId = (JCheckBox)paramComp.get("chkId");
		JCheckBox chkFName = (JCheckBox)paramComp.get("chkFName");
		JCheckBox chkLName = (JCheckBox)paramComp.get("chkLName");
		JCheckBox chkNo = (JCheckBox)paramComp.get("chkNo");
		JTable tempTable = (JTable) paramComp.get("Table");
		
		inputs = new HashMap<Integer,String>();
		
		if(chkId.isSelected()) {
			IDTextField tempId = (IDTextField)paramComp.get("txtId");
			if(tempId.valid()) {
				inputs.put(0, tempId.getText());
			}else {
				errorMsg = "Invalid ID";
				return false;
			}
		}
		
		if(chkFName.isSelected()) {
			FNameTextField tempFName = (FNameTextField)paramComp.get("txtFName");
			if(tempFName.valid()) {
				inputs.put(1, tempFName.getText());
			}else {
				errorMsg = "Invalid FirstName";
				return false;
			}
		}
		
		if(chkLName.isSelected()) {
			LNameTextField tempLName = (LNameTextField)paramComp.get("txtLName");
			if(tempLName.valid()) {
				inputs.put(2, tempLName.getText());
			}else {
				errorMsg = "Invalid LastName";
				return false;
			}
		}
		
		if(chkNo.isSelected()) {
			ContactTextField tempContact = (ContactTextField)paramComp.get("txtNo");
			if(tempContact.valid()) {
				inputs.put(3, tempContact.getText());
			}else {
				errorMsg = "Invalid Contact No.";
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
		
		tempTable.getColumnModel().getColumn(8).setMinWidth(0);
		tempTable.getColumnModel().getColumn(8).setMaxWidth(0);
		tempTable.getColumnModel().getColumn(8).setWidth(0);
		
		return true;
	}
	
	public TableModel loadDefaultTable() {
		return model.loadDefaultTable();
	}
	
}

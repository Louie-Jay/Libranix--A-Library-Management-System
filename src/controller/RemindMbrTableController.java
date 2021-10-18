package controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.table.TableModel;

import model.RemindMbrTableModel;
import view.ContactTextField;
import view.FNameTextField;
import view.IDTextField;
import view.ISBNTextField;
import view.Table;

public class RemindMbrTableController {
	
	private RemindMbrTableModel model;
	private String errorMsg;
	
	public RemindMbrTableController() {
		this.model = new RemindMbrTableModel();
		this.errorMsg = "Cannot find without input";
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public boolean find(LinkedHashMap<String,JComponent> inputComp) {
		HashMap<Integer,String> inputs = new HashMap<Integer,String>();
		
		Table remindMbrTable = (Table) inputComp.get("Table");
		
		JCheckBox chkBkId = (JCheckBox)inputComp.get("chkBkId");
		JCheckBox chkMbrId = (JCheckBox)inputComp.get("chkMbrId");
		JCheckBox chkFName = (JCheckBox)inputComp.get("chkFName");
		JCheckBox chkISBN = (JCheckBox)inputComp.get("chkISBN");
		JCheckBox chkNo = (JCheckBox)inputComp.get("chkNo");
		
		if(chkBkId.isSelected() || chkMbrId.isSelected() || 
				chkFName.isSelected() || chkISBN.isSelected() || chkNo.isSelected()) {
			
			if(chkBkId.isSelected()) {
				IDTextField txtBkId = (IDTextField)inputComp.get("txtBkId");
				if(txtBkId.valid()) {
					inputs.put(0, txtBkId.getText());
				}else {
					errorMsg = "Invalid Book ID";
					return false;
				}
			}
			
			if(chkMbrId.isSelected()) {
				IDTextField txtMbrId = (IDTextField)inputComp.get("txtMbrId");
				if(txtMbrId.valid()) {
					inputs.put(1, txtMbrId.getText());
				}else {
					errorMsg = "Invalid Member ID";
					return false;
				}
			}
			
			if(chkFName.isSelected()) {
				FNameTextField txtFName = (FNameTextField)inputComp.get("txtFName");
				if(txtFName.valid()) {
					inputs.put(2, txtFName.getText());
				}else {
					errorMsg = "Invalid First Name";
					return false;
				}
			}
			
			if(chkISBN.isSelected()) {
				ISBNTextField txtISBN = (ISBNTextField)inputComp.get("txtISBN");
				if(txtISBN.valid()) {
					inputs.put(3, txtISBN.getText());
				}else {
					errorMsg = "Invalid ISBN";
					return false;
				}
			}
			
			if(chkNo.isSelected()) {
				ContactTextField txtNo = (ContactTextField)inputComp.get("txtNo");
				if(txtNo.valid()) {
					inputs.put(4, txtNo.getText());
				}else {
					errorMsg = "Invalid Contact No.";
					return false;
				}
			}
			
			remindMbrTable.setModel(this.getTableModel(inputs));
			
			remindMbrTable.getColumnModel().getColumn(0).setMinWidth(0);
			remindMbrTable.getColumnModel().getColumn(0).setMaxWidth(0);
			remindMbrTable.getColumnModel().getColumn(0).setWidth(0);
			
			remindMbrTable.getColumnModel().getColumn(8).setMinWidth(0);
			remindMbrTable.getColumnModel().getColumn(8).setMaxWidth(0);
			remindMbrTable.getColumnModel().getColumn(8).setWidth(0);
			
		}else {
			return false;
		}
		
		return true;
	}
	
	public TableModel loadDefaultTable() {
		return model.loadDefaultTableModel();
	}
	
	private TableModel getTableModel(HashMap<Integer,String> paramInput) {
		return model.getTableModel(paramInput);
	}

}

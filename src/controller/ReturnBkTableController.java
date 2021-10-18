package controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import model.ReturnBkTableModel;
import view.GenreComboBox;
import view.IDTextField;
import view.ISBNTextField;
import view.Table;
import view.TitleTextField;

public class ReturnBkTableController {
	
	private ReturnBkTableModel model;
	private String errorMsg;
	
	public ReturnBkTableController() {
		model = new ReturnBkTableModel();
		errorMsg = "Cannot find without input";
	}
	
	public TableModel getDefaultTableModel() {
		return model.getDefaultTableModel();
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public boolean find(LinkedHashMap<String,JComponent> inputComp, Table paramTable) {
		HashMap<Integer,String> inputs = new HashMap<Integer,String>();
		
		JCheckBox chkBookId = (JCheckBox)inputComp.get("chkBookID");
		JCheckBox chkMemberId = (JCheckBox)inputComp.get("chkMemberID");
		JCheckBox chkBookTitle = (JCheckBox)inputComp.get("chkBookTitle");
		JCheckBox chkBookIsbn = (JCheckBox)inputComp.get("chkBookISBN");
		
		if(chkBookId.isSelected() || chkMemberId.isSelected() || 
			chkBookTitle.isSelected() || chkBookIsbn.isSelected()) {
			
			if(chkBookId.isSelected()) {
				IDTextField txtBookID = (IDTextField)inputComp.get("BookID");
				if(txtBookID.valid()) {
					inputs.put(0, txtBookID.getText());
				}else {
					errorMsg = "Invalid Book ID";
					return false;
				}
			}
			
			if(chkMemberId.isSelected()) {
				IDTextField txtMemberID = (IDTextField)inputComp.get("MemberID");
				if(txtMemberID.valid()) {
					inputs.put(1, txtMemberID.getText());
				}else {
					errorMsg = "Invalid Member ID";
					return false;
				}
			}
			
			if(chkBookTitle.isSelected()) {
				TitleTextField txtBookTitle = (TitleTextField)inputComp.get("BookTitle");
				if(txtBookTitle.valid()) {
					inputs.put(2, txtBookTitle.getText());
				}else {
					errorMsg = "Invalid Book Title";
					return false;
				}
			}
			
			if(chkBookIsbn.isSelected()) {
				ISBNTextField txtBookIsbn = (ISBNTextField)inputComp.get("BookISBN");
				if(txtBookIsbn.valid()) {
					inputs.put(3, txtBookIsbn.getText());
				}else {
					errorMsg = "Invalid ISBN";
					return false;
				}
			}
			
			
			
			paramTable.setModel(this.getTableModel(inputs));
			paramTable.getColumnModel().getColumn(0).setMinWidth(0);
			paramTable.getColumnModel().getColumn(0).setMaxWidth(0);
			paramTable.getColumnModel().getColumn(0).setWidth(0);
			
		}else {
			return false;
		}
		
		return true;
	}
	
	private TableModel getTableModel(HashMap<Integer,String> paramInput) {
		return model.getTableModel(paramInput);
	}

}

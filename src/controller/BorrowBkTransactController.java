package controller;

import java.util.LinkedHashMap;

import javax.swing.table.TableModel;

import model.BorrowBkTransactModel;
import view.IDTextField;

public class BorrowBkTransactController {
	
	private BorrowBkTransactModel model;
	private String errorMsg;
	
	public BorrowBkTransactController() {
		this.model = new BorrowBkTransactModel();
	}
	
	public TableModel getDefaultTableModel() {
		return model.getDefaultTableModel();
	}
	
	public TableModel getRequestTableModel(String srchId,IDTextField inputComp) {
		
		if(this.isValid(inputComp)) {
			return model.getRequestTableModel(srchId);
		}else {
			return model.getDefaultTableModel();
		}
	}
	
	public boolean isValid(IDTextField inputComp) {
		
		if(inputComp.valid()) {
			return true;
		}else {
			errorMsg = inputComp.getToolTipText();
			return false;
		}
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public boolean borrowBook(Object paramMbrID, Object paramBkID, Object paramQuantity, int paramCount) {
		LinkedHashMap<String, Integer> borrowTransact;
		
		if(paramCount != 0) {
			if(paramCount < (int)paramQuantity) {
				int bkQuantity = ((int)paramQuantity) - paramCount;
				
				borrowTransact = new LinkedHashMap<String,Integer>();
				borrowTransact.put("MemberID", (Integer) paramMbrID);
				borrowTransact.put("BookID", (Integer) paramBkID);
				borrowTransact.put("BookQuantity", (Integer) bkQuantity);
				borrowTransact.put("OrderCount", (Integer) paramCount);
				
				model.linkBorrower(borrowTransact);
				return true;
			}
		}
		
		
		return false;
		
	}

}

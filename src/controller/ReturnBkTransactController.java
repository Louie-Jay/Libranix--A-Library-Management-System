package controller;

import java.util.LinkedHashMap;

import model.ReturnBkTransactModel;
import view.QuantityTextField;

public class ReturnBkTransactController {
	
	private ReturnBkTransactModel model;
	private String errorMsg;
	
	public ReturnBkTransactController() {
		model = new ReturnBkTransactModel();
		errorMsg = "";
	}
	
	public LinkedHashMap<String, String> getBookFormValues(LinkedHashMap<String,Object> cellValues){
		LinkedHashMap<String, String> formValues = new LinkedHashMap<String, String>();
		LinkedHashMap<String, Object> requestValues;
		
		int bookId = (int) cellValues.get("BookID");
		requestValues = model.getBookRequestValues(bookId);
		formValues.put("BookTitle", (String) requestValues.get("BookTitle"));
		formValues.put("BookAuthor", (String) requestValues.get("BookAuthor"));
		formValues.put("BookWriter", (String) requestValues.get("BookWriter"));
		formValues.put("BookPublisher", (String) requestValues.get("BookPublisher"));
		formValues.put("BookISBN", (String) requestValues.get("BookISBN"));
		formValues.put("BookType", (String) requestValues.get("BookType"));
		formValues.put("BookImg", (String) requestValues.get("BookImg"));
		formValues.put("BookGenre", (String) requestValues.get("BookGenre"));
		
		return formValues;
	}
	
	public LinkedHashMap<String, String> getMemberFormValues(LinkedHashMap<String,Object> cellValues){
		LinkedHashMap<String, String> formValues = new LinkedHashMap<String, String>();
		LinkedHashMap<String, Object> requestValues;
		
		int memberId = (int) cellValues.get("MemberID");
		requestValues = model.getMemberRequestValues(memberId);
		formValues.put("FirstName", (String) requestValues.get("FirstName"));
		formValues.put("MiddleName", (String) requestValues.get("MiddleName"));
		formValues.put("LastName", (String) requestValues.get("LastName"));
		formValues.put("BirthDate", (String) requestValues.get("BirthDate"));
		formValues.put("Address", (String) requestValues.get("Address"));
		formValues.put("Email", (String) requestValues.get("Email"));
		formValues.put("ContactNo", (String) requestValues.get("ContactNo"));
		
		return formValues;
	}
	
	public boolean returnBook(LinkedHashMap<String,Object> cellValues, QuantityTextField paramTxtQuantity) {
		int bookId;
		int borrowId;
		long orderCount;
		int returnCount;
		
		boolean fullReturn;
		
		if(paramTxtQuantity.valid()) {
			bookId = (int) cellValues.get("BookID");
			borrowId = (int) cellValues.get("BorrowID");
			orderCount = (long) cellValues.get("OrderCount");
			returnCount = Integer.valueOf((String) cellValues.get("ReturnCount"));
			
			
			if(returnCount > orderCount) {
				errorMsg = "Cannot return more than you borrowed";
				return false;
			}else if(returnCount <= 0){
				errorMsg = "Invalid quantity";
				return false;
			}else {
				if(returnCount == orderCount) {
					fullReturn = true;
				}else {
					fullReturn = false;
				}
				
				model.returnBook(bookId, borrowId, returnCount, fullReturn);
			}
			
		}else {
			errorMsg = "Invalid quantity.";
			return false;
		}
		
		return true;
		
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

}

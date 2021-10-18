package model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.TableModel;

public class RemindMbrTableModel {
	
	CustomTableModel tableModel;
	
	private ArrayList<String> loadCustomColumns(){
		ArrayList<String> customColumns = new ArrayList<String>();
		customColumns.add("ID");
		customColumns.add("Book ID");
		customColumns.add("Member ID");
		customColumns.add("Book Title");
		customColumns.add("Book ISBN");
		customColumns.add("Borrower First Name");
		customColumns.add("Borrower Last Name");
		customColumns.add("Borrower Contact");
		customColumns.add("Book Quantity");
		return customColumns;
	}
	
	public TableModel loadDefaultTableModel() {
		String query = "SELECT tbl_borrowedbooks.col_BorrowId, tbl_borrowedbooks.col_BookId, \r\n" + 
				"tbl_borrowedbooks.col_MemberId, tbl_bookdetails.col_BookTitle, \r\n" + 
				"tbl_bookdetails.col_BookIsbn, tbl_memberdetails.col_MemberFirstName, \r\n" + 
				"tbl_memberdetails.col_MemberLastName, tbl_membercontacts.col_MemberContactNo,\r\n" + 
				"tbl_borrowedbooks.col_BookQuantity\r\n" + 
				"FROM librarydatabase.tbl_borrowedbooks \r\n" + 
				"INNER JOIN librarydatabase.tbl_bookdetails ON\r\n" + 
				"tbl_borrowedbooks.col_BookId = tbl_bookdetails.col_BookId \r\n" + 
				"INNER JOIN librarydatabase.tbl_memberdetails ON\r\n" + 
				"tbl_borrowedbooks.col_MemberId = tbl_memberdetails.col_MemberId\r\n" + 
				"INNER JOIN librarydatabase.tbl_membercontacts ON\r\n" + 
				"tbl_borrowedbooks.col_MemberId = tbl_membercontacts.col_MemberId;";
		
		tableModel = new CustomTableModel(this.loadCustomColumns(),query);
		
		return tableModel;
	}
	
	public TableModel getTableModel(HashMap<Integer,String> paramInput) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT tbl_borrowedbooks.col_BorrowId, tbl_borrowedbooks.col_BookId, tbl_borrowedbooks.col_MemberId, tbl_bookdetails.col_BookTitle, tbl_bookdetails.col_BookIsbn, tbl_memberdetails.col_MemberFirstName, tbl_memberdetails.col_MemberLastName, tbl_membercontacts.col_MemberContactNo, tbl_borrowedbooks.col_BookQuantity FROM librarydatabase.tbl_borrowedbooks INNER JOIN librarydatabase.tbl_bookdetails ON tbl_borrowedbooks.col_BookId = tbl_bookdetails.col_BookId INNER JOIN librarydatabase.tbl_memberdetails ON tbl_borrowedbooks.col_MemberId = tbl_memberdetails.col_MemberId INNER JOIN librarydatabase.tbl_membercontacts ON tbl_borrowedbooks.col_MemberId = tbl_membercontacts.col_MemberId");
		query.append(" WHERE");
		
		if(paramInput.get(0) != null) {
			query.append(" tbl_bookdetails.col_BookId = "+paramInput.get(0));
		}
		
		if(paramInput.get(1) != null) {
			if(paramInput.get(0) != null) {
				query.append(" ||  tbl_memberdetails.col_MemberId = "+paramInput.get(1)+"");
			}else {
				query.append(" tbl_memberdetails.col_MemberId = "+paramInput.get(1)+"");
			}
		}
		
		if(paramInput.get(2) != null) {
			if(paramInput.get(0) != null || paramInput.get(1) != null) {
				query.append(" ||  tbl_memberdetails.col_MemberFirstName = \""+paramInput.get(2)+"\"");
			}else {
				query.append(" tbl_memberdetails.col_MemberFirstName = \""+paramInput.get(2)+"\"");
			}
		}
		
		if(paramInput.get(3) != null) {
			if(paramInput.get(0) != null || paramInput.get(1) != null || paramInput.get(2) != null) {
				query.append(" ||  tbl_bookdetails.col_BookIsbn = \""+paramInput.get(3)+"\"");
			}else {
				query.append(" tbl_bookdetails.col_BookIsbn = \""+paramInput.get(3)+"\"");
			}
		}
		
		if(paramInput.get(4) != null) {
			if(paramInput.get(0) != null || paramInput.get(1) != null || paramInput.get(2) != null || paramInput.get(3) != null) {
				query.append(" ||  tbl_membercontacts.col_MemberContactNo = "+paramInput.get(4)+"");
			}else {
				query.append(" tbl_membercontacts.col_MemberContactNo = "+paramInput.get(4)+"");
			}
		}
		
		query.append(";");
		
		tableModel = new CustomTableModel(this.loadCustomColumns(),query.toString());
		return tableModel;
	}

}

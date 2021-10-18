package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.table.TableModel;

public class BorrowBkTransactModel {
	
	CustomTableModel tableModel;
	DatabaseConnection db;
	
	public BorrowBkTransactModel() {
	}
	
	public void linkBorrower(LinkedHashMap<String, Integer> paramTransact) {
		
		db = new DatabaseConnection();
		db.connectDatabase();
		ArrayList<String> queries = new ArrayList<String>();
		
		queries.add("INSERT INTO librarydatabase.tbl_borrowedbooks(col_BookId,col_MemberId,col_BookQuantity)\r\n" + 
				"VALUES ("+paramTransact.get("BookID")+","+paramTransact.get("MemberID")+","+paramTransact.get("OrderCount")+");");
		queries.add("UPDATE librarydatabase.tbl_bookquantity SET\r\n" + 
				"col_BookQuantity = "+paramTransact.get("BookQuantity")+" WHERE col_BookId = "+paramTransact.get("BookID")+";");
		
		db.executeMultiQuery(queries);
		db.closeDatabase();
	}
	
	private ArrayList<String> loadCustomColumns(){
		ArrayList<String> customColumns = new ArrayList<String>();
		customColumns.add("ID");
		customColumns.add("FirstName");
		customColumns.add("LastName");
		customColumns.add("Birth Date");
		customColumns.add("Address");
		customColumns.add("Email Address");
		customColumns.add("Img");
		return customColumns;
	}
	
	public TableModel getDefaultTableModel() {
		String str = "SELECT tbl_memberdetails.col_MemberId, tbl_memberdetails.col_MemberFirstName,\r\n" + 
				"tbl_memberdetails.col_MemberLastName, tbl_memberdetails.col_MemberBirthDate, tbl_memberdetails.col_MemberAddress, \r\n" + 
				"tbl_memberdetails.col_MemberEmail, tbl_memberdetails.col_MemberImg FROM librarydatabase.tbl_memberdetails;";
		tableModel = new CustomTableModel(loadCustomColumns(),str);
		return tableModel;
	}
	
	public TableModel getRequestTableModel(String srchId) {
		String str = "SELECT tbl_memberdetails.col_MemberId, tbl_memberdetails.col_MemberFirstName,\r\n" + 
				"tbl_memberdetails.col_MemberLastName, tbl_memberdetails.col_MemberBirthDate, tbl_memberdetails.col_MemberAddress, \r\n" + 
				"tbl_memberdetails.col_MemberEmail, tbl_memberdetails.col_MemberImg FROM librarydatabase.tbl_memberdetails WHERE col_MemberId = "+srchId+"";
		tableModel = new CustomTableModel(loadCustomColumns(),str);
		return tableModel;
	}

}

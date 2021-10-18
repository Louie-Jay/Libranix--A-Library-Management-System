package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ReturnBkTransactModel {
	
	DatabaseConnection db;
	
	public ReturnBkTransactModel() {
		db = new DatabaseConnection();
	}
	
	public LinkedHashMap<String, Object> getBookRequestValues(int paramBookId) {
		db.connectDatabase();
		LinkedHashMap<String, Object> bookValues;
		String query = "SELECT tbl_bookdetails.*, \r\n" + 
				"tbl_bookgenre.col_BookGenre, \r\n" + 
				"tbl_bookquantity.col_BookQuantity\r\n" + 
				" FROM librarydatabase.tbl_bookdetails\r\n" + 
				"INNER JOIN librarydatabase.tbl_bookgenre ON \r\n" + 
				"librarydatabase.tbl_bookgenre.col_BookId = librarydatabase.tbl_bookdetails.col_BookId\r\n" + 
				"INNER JOIN librarydatabase.tbl_bookquantity ON\r\n" + 
				"librarydatabase.tbl_bookquantity.col_BookId = librarydatabase.tbl_bookdetails.col_BookId WHERE tbl_bookdetails.col_BookId = "+paramBookId+";";
		db.setQuery(query);
		db.executeQuery();
		
		bookValues = new LinkedHashMap<String, Object>();
		ResultSet result = db.getResult();
		
		try {
			
			while(result.next()) {
				bookValues.put("BookID", result.getInt("col_BookId"));
				bookValues.put("BookTitle", result.getString("col_BookTitle"));
				bookValues.put("BookAuthor", result.getString("col_BookAuthor"));
				bookValues.put("BookWriter", result.getString("col_BookWriter"));
				bookValues.put("BookPublisher", result.getString("col_BookPublisher"));
				bookValues.put("BookISBN", result.getString("col_BookIsbn"));
				bookValues.put("BookType", result.getString("col_BookType"));
				bookValues.put("BookImg", result.getString("col_BookImg"));
				bookValues.put("BookGenre", result.getString("col_BookGenre"));
				bookValues.put("BookQuantity", result.getInt("col_BookQuantity"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		db.closeDatabase();
		return bookValues;
	}
	
	public LinkedHashMap<String, Object> getMemberRequestValues(int paramMemberId) {
		db.connectDatabase();
		LinkedHashMap<String, Object> memberValues;
		String query = "SELECT tbl_memberdetails.*,\r\n" + 
				" tbl_membercontacts.col_MemberContactNo\r\n" + 
				"FROM librarydatabase.tbl_memberdetails\r\n" + 
				"INNER JOIN librarydatabase.tbl_membercontacts ON\r\n" + 
				"librarydatabase.tbl_membercontacts.col_MemberId = \r\n" + 
				"librarydatabase.tbl_memberdetails.col_MemberId \r\n" + 
				"WHERE tbl_memberdetails.col_MemberId = "+paramMemberId+";";
		db.setQuery(query);
		db.executeQuery();
		
		memberValues = new LinkedHashMap<String, Object>();
		ResultSet result = db.getResult();
		
		try {
			
			while(result.next()) {
				memberValues.put("MemberID", result.getInt("col_MemberId"));
				memberValues.put("FirstName", result.getString("col_MemberFirstName"));
				memberValues.put("MiddleName", result.getString("col_MemberMiddleName"));
				memberValues.put("LastName", result.getString("col_MemberLastName"));
				memberValues.put("BirthDate", result.getString("col_MemberBirthDate"));
				memberValues.put("Address", result.getString("col_MemberAddress"));
				memberValues.put("Email", result.getString("col_MemberEmail"));
				memberValues.put("ContactNo", result.getString("col_MemberContactNo"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		db.closeDatabase();
		return memberValues;
	}
	
	public void returnBook(int paramBookId,int paramBorrowId,int paramReturnCount, boolean paramReturnedAll) {
		db.connectDatabase();
		
		ArrayList<String> queries = new ArrayList<String>();
		if(paramReturnedAll) {
			queries.add("UPDATE librarydatabase.tbl_bookquantity SET col_BookQuantity = (col_BookQuantity + "+paramReturnCount+") WHERE col_BookId = "+paramBookId+";");
			queries.add("DELETE FROM librarydatabase.tbl_borrowedbooks WHERE col_BorrowId = "+paramBorrowId+";");
		}else {
			queries.add("UPDATE librarydatabase.tbl_bookquantity SET col_BookQuantity = (col_BookQuantity + "+paramReturnCount+") WHERE col_BookId = "+paramBookId+";");
			queries.add("UPDATE librarydatabase.tbl_borrowedbooks SET col_BookQuantity = (col_BookQuantity - "+paramReturnCount+") WHERE col_BorrowId = "+paramBorrowId+";");
		}
		
		db.executeMultiQuery(queries);
		db.closeDatabase();
		
	}

}

package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.table.TableModel;

public class ViewBkTableModel {
	
	FileDataModel fGenre;
	CustomTableModel tableModel;
	
	public ViewBkTableModel() {
		this.fGenre = new FileDataModel("allGenre.data");
		this.loadDefaultTableModel();
		
	}
	
	private ArrayList<String> loadCustomColumns(){
		ArrayList<String> customColumns = new ArrayList<String>();
		customColumns.add("ID");
		customColumns.add("Title");
		customColumns.add("Author");
		customColumns.add("Writer");
		customColumns.add("Publisher");
		customColumns.add("ISBN");
		customColumns.add("Type");
		customColumns.add("Img");
		customColumns.add("Genre");
		customColumns.add("Quantity");
		return customColumns;
	}
	
	private ArrayList<String> loadBorrowColumns(){
		ArrayList<String> borrowColumns = new ArrayList<String>();
		borrowColumns.add("Borrow ID");
		borrowColumns.add("Book ID");
		borrowColumns.add("Borrower ID");
		borrowColumns.add("Book Title");
		borrowColumns.add("Book ISBN");
		borrowColumns.add("Book Genre");
		borrowColumns.add("Member FirstName");
		borrowColumns.add("Member LastName");
		borrowColumns.add("Member ContactNo");
		borrowColumns.add("Book Quantity");
		return borrowColumns;
	}
	
	public TableModel requestTableModel(HashMap<Integer,String> paramInput, boolean paramBorrowed) {	
		StringBuilder query = new StringBuilder();
		if(paramBorrowed) {
			query.append("SELECT tbl_borrowedbooks.col_BorrowId, tbl_borrowedbooks.col_BookId,\r\n" + 
					"tbl_borrowedbooks.col_MemberId, tbl_bookdetails.col_BookTitle,\r\n" + 
					"tbl_bookdetails.col_BookIsbn, tbl_bookgenre.col_BookGenre, \r\n" + 
					"tbl_memberdetails.col_MemberFirstName, tbl_memberdetails.col_MemberLastName, \r\n" + 
					"tbl_membercontacts.col_MemberContactNo, tbl_borrowedbooks.col_BookQuantity\r\n" + 
					"FROM librarydatabase.tbl_borrowedbooks \r\n" + 
					"INNER JOIN librarydatabase.tbl_bookdetails ON\r\n" + 
					"tbl_borrowedbooks.col_BookId = tbl_bookdetails.col_BookId\r\n" + 
					"INNER JOIN librarydatabase.tbl_bookgenre ON\r\n" + 
					"tbl_borrowedbooks.col_BookId = tbl_bookgenre.col_BookId\r\n" + 
					"INNER JOIN librarydatabase.tbl_memberdetails ON\r\n" + 
					"tbl_borrowedbooks.col_MemberId = tbl_memberdetails.col_MemberId\r\n" + 
					"INNER JOIN librarydatabase.tbl_membercontacts ON\r\n" + 
					"tbl_borrowedbooks.col_MemberId = tbl_membercontacts.col_MemberId");
			
			if(paramInput.get(0) == null && paramInput.get(1) == null) {}
			else {
				query.append(" WHERE");
				if(paramInput.get(0) != null) {
					query.append(" tbl_bookdetails.col_BookTitle LIKE \""+paramInput.get(0)+"%\" || "+" \"%"+paramInput.get(0)+"\"");
				}
				
				if(paramInput.get(1) != null) {
					if(paramInput.get(0) != null) {
						query.append(" &&  tbl_bookgenre.col_BookGenre = \""+paramInput.get(1)+"\"");
					}else {
						query.append(" tbl_bookgenre.col_Bookgenre = \""+paramInput.get(1)+"\"");
					}
				}
			}
			
		}else {
			query.append("SELECT tbl_bookdetails.*, tbl_bookgenre.col_BookGenre, tbl_bookquantity.col_BookQuantity\r\n" + 
					"FROM librarydatabase.tbl_bookdetails INNER JOIN librarydatabase.tbl_bookgenre\r\n" + 
					"ON tbl_bookgenre.col_BookId = tbl_bookdetails.col_BookId\r\n" + 
					"INNER JOIN librarydatabase.tbl_bookquantity\r\n" + 
					"ON tbl_bookquantity.col_BookId = tbl_bookdetails.col_BookId");
			query.append(" WHERE");
			if(paramInput.get(0) != null) {
				query.append(" tbl_bookdetails.col_BookTitle LIKE \""+paramInput.get(0)+"%\" || "+" \"%"+paramInput.get(0)+"\"");
			}
			
			if(paramInput.get(1) != null) {
				if(paramInput.get(0) != null) {
					query.append(" &&  tbl_bookgenre.col_BookGenre = \""+paramInput.get(1)+"\"");
				}else {
					query.append(" tbl_bookgenre.col_Bookgenre = \""+paramInput.get(1)+"\"");
				}
			}
			
		}
		query.append(";");
		
		if(paramBorrowed) {
			return this.tableModel = new CustomTableModel(this.loadBorrowColumns(),query.toString());
		}else {
			return this.tableModel = new CustomTableModel(this.loadCustomColumns(),query.toString());
		}
		
	}
	
	public void loadDefaultTableModel() {
		String str = "SELECT tbl_bookdetails.*, tbl_bookgenre.col_BookGenre, tbl_bookquantity.col_BookQuantity FROM librarydatabase.tbl_bookdetails INNER JOIN librarydatabase.tbl_bookgenre ON tbl_bookgenre.col_BookId = tbl_bookdetails.col_BookId INNER JOIN librarydatabase.tbl_bookquantity ON tbl_bookquantity.col_BookId = tbl_bookdetails.col_BookId;";
		this.tableModel = new CustomTableModel(this.loadCustomColumns(),str);
		
	}
	
	public TableModel getDefaultTableModel() {
		return tableModel;
	}
	
	public String[] getGenreData() {
		return fGenre.getArrayStringData();
	}

}

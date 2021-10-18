package model;

import java.util.ArrayList;

import javax.swing.table.TableModel;

public class SearchBkTableModel {
	
	CustomTableModel tableModel;

	public SearchBkTableModel() {
		tableModel = new CustomTableModel();
	}
	
	public boolean searchBook(String paramCol, String paramSearch) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT tbl_bookdetails.*, tbl_bookgenre.col_BookGenre,tbl_bookquantity.col_BookQuantity FROM librarydatabase.tbl_bookdetails INNER JOIN librarydatabase.tbl_bookgenre ON tbl_bookgenre.col_BookId = tbl_bookdetails.col_BookId INNER JOIN librarydatabase.tbl_bookquantity ON tbl_bookquantity.col_BookId = tbl_bookdetails.col_BookId");
		query.append(" WHERE"); 
		
		switch (paramCol) {
		case "ID":
			query.append(" tbl_bookdetails."+getQueryColumn(paramCol)+" = "); 
			query.append(Integer.valueOf(paramSearch)+";");
			break;
		case "Quantity":
			query.append(" "+getQueryColumn(paramCol)+" <= ");
			query.append(Integer.valueOf(paramSearch)+";");
			break;

		default:
			query.append(" "+getQueryColumn(paramCol)); 
			query.append(" LIKE"); 
			query.append(" \'%"+paramSearch+"%\'"); 
			query.append(";");
			break;
		}
		System.out.println(query.toString());
		
		tableModel = new CustomTableModel(this.loadCustomColumns(),query.toString());
		
		return true;
	}
	
	private String getQueryColumn(String paramCol) {
		
		switch (paramCol) {
		case "ID":
			return "col_BookId";
		case "Title":
			return "col_BookTitle";
		case "Author":
			return "col_BookAuthor";
		case "Writer":
			return "col_BookWriter";
		case "Publisher":
			return "col_BookPublisher";
		case "ISBN":
			return "col_BookIsbn";
		case "Type":
			return "col_BookType";
		case "Genre":
			return "col_BookGenre";
		case "Quantity":
			return "col_BookQuantity";
		default:
			return "col_BookId";
		}
	}
	
	public TableModel getDefaultTableModel() {
		String str = "SELECT tbl_bookdetails.*, tbl_bookgenre.col_BookGenre, tbl_bookquantity.col_BookQuantity FROM librarydatabase.tbl_bookdetails INNER JOIN librarydatabase.tbl_bookgenre ON tbl_bookgenre.col_BookId = tbl_bookdetails.col_BookId INNER JOIN librarydatabase.tbl_bookquantity ON tbl_bookquantity.col_BookId = tbl_bookdetails.col_BookId;";
		tableModel = new CustomTableModel(this.loadCustomColumns(), str);
		return tableModel;
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
	
	public TableModel getTableModel() {
		return tableModel;
	}
}

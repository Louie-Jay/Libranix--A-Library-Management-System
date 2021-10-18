package model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.TableModel;

public class DeleteBkTableModel {
	
	private CustomTableModel tableModel;
	
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
	
	
	public TableModel getDefaultTableModel() {
		String str = "SELECT tbl_bookdetails.*, tbl_bookgenre.col_BookGenre, tbl_bookquantity.col_BookQuantity FROM librarydatabase.tbl_bookdetails INNER JOIN librarydatabase.tbl_bookgenre ON tbl_bookgenre.col_BookId = tbl_bookdetails.col_BookId INNER JOIN librarydatabase.tbl_bookquantity ON tbl_bookquantity.col_BookId = tbl_bookdetails.col_BookId;";
		tableModel = new CustomTableModel(loadCustomColumns(),str);
		return tableModel;
	}
	
	public void loadTableQuery(HashMap<Integer,String> paramInput) {
		
		StringBuilder query = new StringBuilder();
		ArrayList<String> conditionQuery = new ArrayList<String>(3);
		query.append("SELECT tbl_bookdetails.*, tbl_bookgenre.col_BookGenre, tbl_bookquantity.col_BookQuantity FROM librarydatabase.tbl_bookdetails INNER JOIN librarydatabase.tbl_bookgenre ON tbl_bookgenre.col_BookId = tbl_bookdetails.col_BookId INNER JOIN librarydatabase.tbl_bookquantity ON tbl_bookquantity.col_BookId = tbl_bookdetails.col_BookId");
		query.append(" WHERE");
		
		if(paramInput.get(0) != null) {
			query.append(" tbl_bookdetails.col_BookId = "+paramInput.get(0));
		}
		
		if(paramInput.get(1) != null) {
			if(paramInput.get(0) != null) {
				query.append(" ||  tbl_bookdetails.col_BookIsbn = \""+paramInput.get(1)+"\"");
			}else {
				query.append(" tbl_bookdetails.col_BookIsbn = \""+paramInput.get(1)+"\"");
			}
		}
		
		if(paramInput.get(2) != null) {
			if(paramInput.get(0) != null || paramInput.get(1) != null) {
				query.append(" ||  tbl_bookgenre.col_Bookgenre = \""+paramInput.get(2)+"\"");
			}else {
				query.append(" tbl_bookgenre.col_Bookgenre = \""+paramInput.get(2)+"\"");
			}
		}
		query.append(";");
		
		tableModel = new CustomTableModel(loadCustomColumns(),query.toString());
		
		/*String query = "SELECT tbl_bookdetails.*, tbl_bookgenre.col_BookGenre, tbl_bookquantity.col_BookQuantity FROM librarydatabase.tbl_bookdetails INNER JOIN librarydatabase.tbl_bookgenre ON tbl_bookgenre.col_BookId = tbl_bookdetails.col_BookId INNER JOIN librarydatabase.tbl_bookquantity ON tbl_bookquantity.col_BookId = tbl_bookdetails.col_BookId";
		String conditionQuery = "";
		
		conditionQuery += " WHERE tbl_bookdetails.col_BookId = "+ paramInput.get("ID") + " || tbl_bookdetails.col_BookIsbn = '"+paramInput.get("ISBN")+"' || tbl_bookgenre.col_Bookgenre = '"+ paramInput.get("Genre")+"'";
		
		tableModel = new CustomTableModel(loadCustomColumns(), query+conditionQuery);*/
	}
	
	public TableModel getTableModel() {
		return tableModel;
	}

}

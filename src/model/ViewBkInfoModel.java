package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ViewBkInfoModel {
	
	private HashMap<Integer,Object> values;
	private DatabaseConnection db;
	
	public ViewBkInfoModel() {}
	
	public HashMap<Integer,Object> getValues(int paramId){
		db = new DatabaseConnection();
		db.connectDatabase();
		values = new HashMap<Integer, Object>();
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT tbl_bookdetails.*, tbl_bookgenre.col_BookGenre, tbl_bookquantity.col_BookQuantity FROM librarydatabase.tbl_bookdetails INNER JOIN librarydatabase.tbl_bookgenre ON tbl_bookgenre.col_BookId = tbl_bookdetails.col_BookId INNER JOIN librarydatabase.tbl_bookquantity ON tbl_bookquantity.col_BookId = tbl_bookdetails.col_BookId");
		query.append(" WHERE");
		query.append(" tbl_bookdetails.col_BookId = "+paramId+";");
		
		db.setQuery(query.toString());
		
		db.executeQuery();
		try {
			ResultSet rs = db.getResult();
			while (rs.next()) {
				int id = rs.getInt("col_BookId");
				String bkTitle = rs.getString("col_BookTitle");
				String bkAuthor = rs.getString("col_BookAuthor");
				String bkWriter = rs.getString("col_BookWriter");
				String bkPublisher = rs.getString("col_BookPublisher");
				String bkIsbn = rs.getString("col_BookIsbn");
				String bkType = rs.getString("col_BookType");
				String bkImg = rs.getString("col_BookImg");
				String bkGenre = rs.getString("col_BookGenre");
				int bkQuantity = rs.getInt("col_BookQuantity");
				
				values.put(0, id);
				values.put(1, bkTitle);
				values.put(2, bkAuthor);
				values.put(3, bkWriter);
				values.put(4, bkPublisher);
				values.put(5, bkIsbn);
				values.put(6, bkType);
				values.put(7, bkImg);
				values.put(8, bkGenre);
				values.put(9, bkQuantity);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		db.closeDatabase();
		
		return values;
	}

}

package model;

import java.io.File;

public class DeleteBkInfoModel {
	
	private DatabaseConnection db;
	
	public DeleteBkInfoModel() {
		db = new DatabaseConnection();
	}
	
	public boolean deleteBook(int paramId, String prmImg) {
		String query = "DELETE FROM librarydatabase.tbl_bookdetails WHERE col_BookId = "+paramId+";";
		File img = new File(prmImg);
		try {
			img.delete();
			db.connectDatabase();
			db.setQuery(query);
			db.executeQuery();
			db.closeDatabase();
			
		} catch (Exception e) {
			db.closeDatabase();
			return false;
		}
		
		return true;
	}

}

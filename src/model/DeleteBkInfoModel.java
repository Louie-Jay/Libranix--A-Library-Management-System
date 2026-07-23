package model;

import java.io.File;

public class DeleteBkInfoModel {
	
	private DatabaseConnection db;
	
	public DeleteBkInfoModel() {
		db = new DatabaseConnection();
	}
	
	public boolean deleteBook(int paramId, String prmImg) {
		String query = "DELETE FROM librarydatabase.tbl_bookdetails WHERE col_BookId = "+paramId+";";
		File img = new File("images", prmImg);
		try {
			// Delete the image file if it exists (ignore failure)
			if (img.exists()) {
				img.delete();
			}
			db.connectDatabase();
			db.setQuery(query);
			if (!db.executeQuery()) {
				System.err.println("Delete book failed for ID=" + paramId);
				db.closeDatabase();
				return false;
			}
			db.closeDatabase();
			
		} catch (Exception e) {
			db.closeDatabase();
			System.err.println("Delete book exception: " + e.getMessage());
			return false;
		}
		
		return true;
	}

}

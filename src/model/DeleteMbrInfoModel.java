package model;

import java.io.File;

public class DeleteMbrInfoModel {
	
	DatabaseConnection db;
	
	public DeleteMbrInfoModel() {
		db = new DatabaseConnection();
	}
	
	public boolean delete(int paramId, String prmImg) {
		String query = "DELETE FROM librarydatabase.tbl_memberdetails WHERE col_MemberId = "+paramId+";";
		File img = new File("images", prmImg);
		
		try {
			// Delete the image file if it exists (ignore failure)
			if (img.exists()) {
				img.delete();
			}
			db.connectDatabase();
			db.setQuery(query);
			if (!db.executeQuery()) {
				System.err.println("Delete member failed for ID=" + paramId);
				db.closeDatabase();
				return false;
			}
			db.closeDatabase();
			
		} catch (Exception e) {
			db.closeDatabase();
			System.err.println("Delete member exception: " + e.getMessage());
			return false;
		}
		
		return true;
	}

}

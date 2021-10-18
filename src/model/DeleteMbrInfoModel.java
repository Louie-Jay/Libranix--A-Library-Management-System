package model;

import java.io.File;

public class DeleteMbrInfoModel {
	
	DatabaseConnection db;
	
	public DeleteMbrInfoModel() {
		db = new DatabaseConnection();
	}
	
	public boolean delete(int paramId, String prmImg) {
		String query = "DELETE FROM librarydatabase.tbl_memberdetails WHERE col_MemberId = "+paramId+";";
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

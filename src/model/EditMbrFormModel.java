package model;

import java.util.HashMap;

public class EditMbrFormModel {
	
	FileDataModel filedata;
	DatabaseConnection db;
	
	public EditMbrFormModel() {
		this.db = new DatabaseConnection();
	}
	
	public String[] getSexData() {
		filedata = new FileDataModel("sex.data");
		return filedata.getArrayStringData();
		
	}
	
	public boolean update(int paramId,HashMap<Integer, String> paramInputs) {
		
		String query = "UPDATE librarydatabase.tbl_memberdetails, librarydatabase.tbl_membercontacts SET tbl_memberdetails.col_MemberFirstName = \""+paramInputs.get(0)+"\", tbl_memberdetails.col_MemberMiddleName = \""+paramInputs.get(1)+"\", tbl_memberdetails.col_MemberLastName = \""+paramInputs.get(2)+"\", tbl_memberdetails.col_MemberSex = \""+paramInputs.get(3)+"\", tbl_memberdetails.col_MemberBirthDate = \""+paramInputs.get(4)+"\", tbl_memberdetails.col_MemberAddress = \""+paramInputs.get(5)+"\", tbl_memberdetails.col_MemberEmail = \""+paramInputs.get(6)+"\", tbl_memberdetails.col_MemberImg = \""+paramInputs.get(7)+"\", tbl_membercontacts.col_MemberContactNo = \""+paramInputs.get(8)+"\" WHERE tbl_memberdetails.col_MemberId = "+paramId+" && tbl_membercontacts.col_MemberId = "+paramId+";";
		
		try {
			db.connectDatabase();
			db.setQuery(query);
			db.executeQuery();
			db.closeDatabase();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			db.closeDatabase();
			return false;
		}
		
		
	}

}

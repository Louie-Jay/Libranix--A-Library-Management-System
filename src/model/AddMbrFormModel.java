package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class AddMbrFormModel {
	
	private DatabaseConnection db;
	private ArrayList<String> queries;
	private FileDataModel filedata;
	
	public AddMbrFormModel() {
		
	}
	
	public String[] getSexData() {
		this.filedata = new FileDataModel("sex.data");
		return this.filedata.getArrayStringData();
	}
	
	
	public boolean toDatabase(LinkedHashMap<String,String> inputs) {
		queries = new ArrayList<String>();
		db = new DatabaseConnection();
		db.connectDatabase();
		queries.add("INSERT INTO `librarydatabase`.`tbl_memberdetails` (`col_MemberFirstName`, `col_MemberMiddleName`, `col_MemberLastName`, `col_MemberSex`, `col_MemberBirthDate`, `col_MemberAddress`, `col_MemberEmail`, `col_MemberImg`) VALUES ('"+inputs.get("FName")+"', '"+inputs.get("MName")+"', '"+inputs.get("LName")+"', '"+inputs.get("MSex")+"', '"+inputs.get("BDate")+"', '"+inputs.get("Address")+"', '"+inputs.get("Email")+"', '"+inputs.get("Img")+"');");
		queries.add("INSERT INTO `librarydatabase`.`tbl_membercontacts` (`col_MemberContactNo`) VALUES ('"+inputs.get("ContactNo")+"');");
		
		if(db.executeMultiQuery(queries)) {
			db.closeDatabase();
			return true;
		}else {
			db.closeDatabase();
		}
		return false;
	}

}

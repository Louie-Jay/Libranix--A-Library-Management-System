package model;

import java.util.ArrayList;
import java.util.HashMap;

public class DeleteMbrTableModel {
	
	private CustomTableModel tableModel;
	
	public DeleteMbrTableModel() {
		String str = "SELECT tbl_memberdetails.*, tbl_membercontacts.col_MemberContactNo FROM librarydatabase.tbl_memberdetails INNER JOIN librarydatabase.tbl_membercontacts ON tbl_membercontacts.col_MemberId = tbl_memberdetails.col_MemberId;";
		tableModel = new CustomTableModel(loadCustomColumns(), str);
	}
	
	public boolean applyTableModel(HashMap<Integer,String> paramInput) {
		StringBuilder query = new StringBuilder();
		//ArrayList<String> conditionQuery = new ArrayList<String>(3);
		query.append("SELECT tbl_memberdetails.*, tbl_membercontacts.col_MemberContactNo FROM librarydatabase.tbl_memberdetails INNER JOIN librarydatabase.tbl_membercontacts ON tbl_membercontacts.col_MemberId = tbl_memberdetails.col_MemberId");
		query.append(" WHERE");
		
		if(paramInput.get(0) != null) {
			query.append(" tbl_memberdetails.col_MemberId = "+paramInput.get(0));
		}
		
		if(paramInput.get(1) != null) {
			if(paramInput.get(0) != null) {
				query.append(" ||  tbl_memberdetails.col_MemberFirstName = \""+paramInput.get(1)+"\"");
			}else {
				query.append(" tbl_memberdetails.col_MemberFirstName = \""+paramInput.get(1)+"\"");
			}
		}
		
		if(paramInput.get(2) != null) {
			if(paramInput.get(0) != null || paramInput.get(1) != null) {
				query.append(" ||  tbl_memberdetails.col_MemberLastName = \""+paramInput.get(2)+"\"");
			}else {
				query.append(" tbl_memberdetails.col_MemberLastName = \""+paramInput.get(2)+"\"");
			}
		}
		
		if(paramInput.get(3) != null) {
			if(paramInput.get(0) != null || paramInput.get(1) != null || paramInput.get(2) != null) {
				query.append(" ||  tbl_membercontacts.col_MemberContactNo = \""+paramInput.get(3)+"\"");
			}else {
				query.append(" tbl_membercontacts.col_MemberContactNo = \""+paramInput.get(3)+"\"");
			}
		}
		query.append(";");
		
		//System.out.println(query);
		
		tableModel = new CustomTableModel(loadCustomColumns(),query.toString());
		
		return true;
	}
	
	public CustomTableModel getTableModel(){
		return tableModel;
	}
	
	public CustomTableModel loadDefaultTable() {
		String str = "SELECT tbl_memberdetails.*, tbl_membercontacts.col_MemberContactNo FROM librarydatabase.tbl_memberdetails INNER JOIN librarydatabase.tbl_membercontacts ON tbl_membercontacts.col_MemberId = tbl_memberdetails.col_MemberId;";
		tableModel = new CustomTableModel(loadCustomColumns(), str);
		return tableModel;
	}
	
	private ArrayList<String> loadCustomColumns(){
		ArrayList<String> customColumns = new ArrayList<String>();
		customColumns.add("ID");
		customColumns.add("FirstName");
		customColumns.add("MiddleName");
		customColumns.add("LastName");
		customColumns.add("Sex");
		customColumns.add("BirthDate");
		customColumns.add("Address");
		customColumns.add("Email");
		customColumns.add("Img");
		customColumns.add("ContactNo");
		return customColumns;
	}
}

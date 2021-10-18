package model;

import java.util.ArrayList;

public class SearchMbrTableModel {
	
	private CustomTableModel tableModel;
	
	public SearchMbrTableModel() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomTableModel search(String paramCommand, String paramValue) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT tbl_memberdetails.*, tbl_membercontacts.col_MemberContactNo FROM librarydatabase.tbl_memberdetails INNER JOIN librarydatabase.tbl_membercontacts ON tbl_membercontacts.col_MemberId = tbl_memberdetails.col_MemberId");
		switch (paramCommand) {
		case "ID":
			query.append(" WHERE");
			query.append(" tbl_memberdetails.col_MemberId ="+paramValue);
			break;
		case "FirstName":
			query.append(" WHERE");
			query.append(" tbl_memberdetails.col_MemberFirstName LIKE '"+paramValue+"%'");
			break;
		case "LastName":
			query.append(" WHERE");
			query.append(" tbl_memberdetails.col_MemberLastName LIKE '"+paramValue+"%'");
			break;
		case "Sex":
			query.append(" WHERE");
			query.append(" tbl_memberdetails.col_MemberSex LIKE '"+paramValue+"%'");
			break;
		case "Address":
			query.append(" WHERE");
			query.append(" tbl_memberdetails.col_MemberAddress LIKE '"+paramValue+"%'");
			break;
		case "Email":
			query.append(" WHERE");
			query.append(" tbl_memberdetails.col_MemberEmail LIKE '"+paramValue+"%'");
			break;
		case "ContactNo":
			query.append(" WHERE");
			query.append(" tbl_membercontacts.col_MemberContactNo LIKE '"+paramValue+"%'");
			break;
		default:
			break;
		}
		query.append(";");
		
		System.out.println(query.toString());
		
		tableModel = new CustomTableModel(loadCustomColumns(), query.toString());
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

package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class RemindMbrMssgrModel {
	
	private DatabaseConnection db;
	private MailAPI mailSrv;
	private SmsAPI smsSrv;
	
	public RemindMbrMssgrModel() {
		db = new DatabaseConnection();
		mailSrv = new MailAPI();
		smsSrv = new SmsAPI();
	}
	
	public void sendSMS(String prmTo, StringBuilder prmMessage) {
		smsSrv.sendSMS(prmTo, prmMessage);
	}
	
	public void sendMail(String prmTo, StringBuilder prmMessage) {
		mailSrv.sendMail(prmTo, prmMessage);
	}
	
	public HashMap<Integer, String> getMemberValues(int paramId){
		HashMap<Integer, String> memberValues = new HashMap<Integer, String>();
		db.connectDatabase();
		String query = "SELECT tbl_memberdetails.*, tbl_membercontacts.col_MemberContactNo FROM librarydatabase.tbl_memberdetails INNER JOIN librarydatabase.tbl_membercontacts ON tbl_membercontacts.col_MemberId = tbl_memberdetails.col_MemberId WHERE tbl_memberdetails.col_MemberId = "+paramId+";";
		db.setQuery(query);
		db.executeQuery();
		
		ResultSet result = db.getResult();
		
		try {
			result.next();
			memberValues.put(0, String.valueOf(result.getInt("col_MemberId")));
			memberValues.put(1, result.getString("col_MemberFirstName"));
			memberValues.put(2, result.getString("col_MemberMiddleName"));
			memberValues.put(3, result.getString("col_MemberLastName"));
			memberValues.put(4, result.getString("col_MemberSex"));
			memberValues.put(5, (result.getDate("col_MemberBirthDate")).toString());
			memberValues.put(6, result.getString("col_MemberAddress"));
			memberValues.put(7, result.getString("col_MemberEmail"));
			memberValues.put(8, result.getString("col_MemberImg"));
			memberValues.put(9, result.getString("col_MemberContactNo"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeDatabase();
		return memberValues;
	}

}

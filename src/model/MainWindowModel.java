package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainWindowModel {

	DatabaseConnection db;
	AESEncryption aes;
	ReadFile read;
	public MainWindowModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public char[] getPassword() {
		db = new DatabaseConnection();
		String query = "SELECT col_AccountPassword FROM `systemdatabase`.`tbl_accountlogin`;";
		db.connectDatabase();
		db.setQuery(query);
		db.executeQuery();
		
		ResultSet rs = db.getResult();
		char[] rawPassword = null;
		try {
			rs.next();
			rawPassword = rs.getString("col_AccountPassword").toCharArray();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeDatabase();
		return rawPassword;
	}
	
	public char[] getSaltInput(char[] prmInputPwd) {
		aes = new AESEncryption();
		this.loadAES();
		
		String strInput = "";
		
		try {
			strInput = aes.encrypt(String.valueOf(prmInputPwd));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return strInput.toCharArray();
	}
	
	private void loadAES() {
		read = new ReadFile("Libranix.data");
		String key = read.readProperties();
		aes.setKey(aes.loadKey(key));
	}
}

package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
	
	private AESEncryption aes;
	private DatabaseConnection db;
	private ReadFile read;
	private MailAPI mailer;
	private String securityCode;
	public LoginModel() {
		aes = new AESEncryption();
		db = new DatabaseConnection();
	}
	
	public boolean updatePassword(char[] prmNewPassword) {
		this.loadAES();
		String newPassword = "";
		try {
			newPassword = aes.encrypt(String.valueOf(prmNewPassword));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		this.initializeDatabase();
		db = new DatabaseConnection();
		db.connectDatabase();
		db.setQuery("UPDATE `systemdatabase`.`tbl_accountlogin` SET `col_AccountPassword`='"+newPassword+"';");
		db.executeQuery();
		
		return true;
	}
	
	public void sendCode() {
		mailer = new MailAPI();
		this.initializeDatabase();
		ResultSet rsData = db.getResult();
		
		String to = "";
		try {
			rsData.next();
			to = rsData.getString(4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.generateSecurityCode();
		
		StringBuilder sbMsg = new StringBuilder();
		sbMsg.append("Your security code: "+ securityCode);
		mailer.sendMail(to, sbMsg);
	}
	
	public char[] getSecurityCode() {
		return securityCode.toCharArray();
	}
	
	private void generateSecurityCode() {
		securityCode = String.valueOf((int)(Math.random()*9999));
	}
	
	public char[] getSaltInput(char[] prmInputPwd) {
		this.loadAES();
		
		String strInput = "";
		
		try {
			strInput = aes.encrypt(String.valueOf(prmInputPwd));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return strInput.toCharArray();
	}
	
	public String getUser() {
		
		initializeDatabase();
		ResultSet rsData = db.getResult();
		
		String user = "";
		try {
			rsData.next();
			user = rsData.getString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeDatabase();
		return user;
	}
	
	public char[] getPassword() {
		char[] password = null;
		String saltpassword = "";
		initializeDatabase();
		ResultSet rsData = db.getResult();
		
		try {
			rsData.next();
			saltpassword = rsData.getString(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeDatabase();
		
		return saltpassword.toCharArray();
	}
	
	private void loadAES() {
		read = new ReadFile("Libranix.data");
		String key = read.readProperties();
		aes.setKey(aes.loadKey(key));
	}
	
	private void initializeDatabase() {
		db = new DatabaseConnection();
		db.connectDatabase();
		db.setQuery("SELECT * FROM systemdatabase.tbl_accountlogin");
		db.executeQuery();
	}
	
}

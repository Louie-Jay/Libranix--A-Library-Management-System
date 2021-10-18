package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class SettingsModel {
	
	private DatabaseConnection db;
	private AESEncryption aes;
	private ReadFile read;
	private WriteFile write;
	private String errorMsg;
	private MailAPI mailer;
	private String securityCode;
	
	public SettingsModel() {
	}
	
	public HashMap<String, String> getSender(){
		HashMap<String, String> senderCredentials = new HashMap<String, String>();
		aes = new AESEncryption();
		this.loadAES();
		try {
			read = new ReadFile("Data_4SID.data");
			senderCredentials.put("SID", (aes.decrypt(read.readProperties())));
			
			read = new ReadFile("Data_5ATK.data");
			senderCredentials.put("AuthToken", (aes.decrypt(read.readProperties())));
			
			read = new ReadFile("Data_6PN.data");
			senderCredentials.put("PhoneNumber", (aes.decrypt(read.readProperties())));
			
		} catch (Exception e) {
			errorMsg = "Unknown Error: Program data corrupted";
			senderCredentials.put("SID", "Blank");
			return senderCredentials;
		}
		
		return senderCredentials;
	}
	
	public boolean applySender(String prmSID, String prmAuthToken, String prmPhoneNumber) {
		this.loadAES();
		
		try {
			write = new WriteFile("Data_4SID.data");
			String saltSID = aes.encrypt(prmSID);
			write.writeProperties(saltSID);
			
			write = new WriteFile("Data_5ATK.data");
			String saltAuthToken = aes.encrypt(prmAuthToken);
			write.writeProperties(saltAuthToken);
			
			write = new WriteFile("Data_6PN.data");
			String saltPhoneNumber = aes.encrypt(prmPhoneNumber);
			write.writeProperties(saltPhoneNumber);
			return true;
		} catch (Exception e) {
			errorMsg = e.getMessage();
			return false;
		}
	}
	
	public boolean applyMailer(String prmEmail, String prmHost, String prmPort, char[] prmPassword) {
		this.loadAES();
		
		write = new WriteFile("Data_0ME.data");
		String saltEmail;
		try {
			saltEmail = aes.encrypt(prmEmail);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			return false;
		}
		write.writeProperties(saltEmail);
		
		write = new WriteFile("Data_1MH.data");
		String saltHost;
		try {
			saltHost = aes.encrypt(prmHost);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			return false;
		}
		write.writeProperties(saltHost);
		
		write = new WriteFile("Data_2MP.data");
		String saltPort;
		try {
			saltPort = aes.encrypt(prmPort);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			return false;
		}
		write.writeProperties(saltPort);
		
		write = new WriteFile("Data_3MP.data");
		String saltPassword;
		try {
			saltPassword = aes.encrypt((String.valueOf(prmPassword)));
		} catch (Exception e) {
			errorMsg = e.getMessage();
			return false;
		}
		write.writeProperties(saltPassword);
		return true;
	}
	
	
	public boolean changePassword(char[] prmNewPassword){
		db = new DatabaseConnection();
		String query = "UPDATE `systemdatabase`.`tbl_accountlogin` SET `col_AccountPassword`='"+(String.valueOf(prmNewPassword))+"'";
		
		try {
			db.connectDatabase();
			db.setQuery(query);
			db.executeQuery();
			db.closeDatabase();
		} catch (Exception e) {
			errorMsg = "Password change operation failed.";
			return false;
		}
		
		return true;
	}
	
	public boolean sendCode() {
		mailer = new MailAPI();
		
		db = new DatabaseConnection();
		String query = "SELECT col_AccountEmail FROM `systemdatabase`.`tbl_accountlogin`;";
		db.connectDatabase();
		db.setQuery(query);
		db.executeQuery();
		
		ResultSet rs = db.getResult();
		String to = "";
		try {
			rs.next();
			to = rs.getString("col_AccountEmail");
		} catch (SQLException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
			return false;
		}
		db.closeDatabase();
		
		this.generateSecurityCode();
		
		StringBuilder sbMsg = new StringBuilder();
		sbMsg.append("Your security code: "+ securityCode);
		mailer.sendMail(to, sbMsg);
		
		return true;
	}
	
	public char[] getSecurityCode() {
		return securityCode.toCharArray();
	}
	
	private void generateSecurityCode() {
		securityCode = String.valueOf((int)(Math.random()*9999));
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
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public boolean changeEmail(String prmEmailInput) {
		db = new DatabaseConnection();
		String query = "UPDATE `systemdatabase`.`tbl_accountlogin` SET `col_AccountEmail`='"+prmEmailInput+"'";
		
		try {
			db.connectDatabase();
			db.setQuery(query);
			db.executeQuery();
			db.closeDatabase();
		} catch (Exception e) {
			errorMsg = "Email change operation failed.";
			return false;
		}
		return true;
	}
	
	public HashMap<String, String> getMailer(){
		HashMap<String, String> mailerCredentials = new HashMap<String, String>();
		aes = new AESEncryption();
		this.loadAES();
		try {
			read = new ReadFile("Data_0ME.data");
			mailerCredentials.put("Email", (aes.decrypt(read.readProperties())));
			
			read = new ReadFile("Data_1MH.data");
			mailerCredentials.put("Host", (aes.decrypt(read.readProperties())));
			
			read = new ReadFile("Data_2MP.data");
			mailerCredentials.put("Port", (aes.decrypt(read.readProperties())));
			
		} catch (Exception e) {
			errorMsg = "Unknown Error: Program data corrupted";
			mailerCredentials.put("Email", "Blank");
			return mailerCredentials;
		}
		
		return mailerCredentials;
	}
	
	public String getEmail() {
		db = new DatabaseConnection();
		String query = "SELECT col_AccountEmail FROM `systemdatabase`.`tbl_accountlogin`;";
		String email = "Blank";
		try {
			db.connectDatabase();
			db.setQuery(query);
			db.executeQuery();
			ResultSet dbResult = db.getResult();
			dbResult.next();
			email = dbResult.getString("col_AccountEmail");
			db.closeDatabase();
		} catch (Exception e) {
			errorMsg = "Unknown Error: Couldn't retrive email.";
			return "";
		}
		
		return email;
	}
	
	private void loadAES() {
		read = new ReadFile("Libranix.data");
		String key = read.readProperties();
		aes.setKey(aes.loadKey(key));
	}
}

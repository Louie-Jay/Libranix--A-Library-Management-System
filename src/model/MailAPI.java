package model;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailAPI {
	
	private String to;
	private String from;
	private char[] pwd;
	private String host;
	private String port;
	private StringBuilder msg;
	
	private Properties prop;
	private Session sess;
	
	private ReadFile read;
	private AESEncryption aes;
	
	public MailAPI() {
		this.initializeSettings();
		this.initializeAPI();

	}
	
	public MailAPI(String prmHost, String prmPort, String prmFrom, char[] prmPwd) {
		this.initializeSettings();
		this.initializeAPI(prmHost, prmPort);
		this.setFrom(prmFrom);
		this.setPwd(prmPwd);
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public char[] getPwd() {
		return pwd;
	}

	public void setPwd(char[] pwd) {
		this.pwd = pwd;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	private void initializeSettings() {
		aes = new AESEncryption();

		this.loadAES();
		
		to = "";

		try {
			read = new ReadFile("Data_0ME.data");
			from = aes.decrypt(read.readProperties());
			
			read = new ReadFile("Data_1MH.data");
			host = aes.decrypt(read.readProperties());
			
			read = new ReadFile("Data_2MP.data");
			port = aes.decrypt(read.readProperties());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void loadAES() {
		read = new ReadFile("Libranix.data");
		String key = read.readProperties();
		aes.setKey(aes.loadKey(key));
	}
	
	public void sendMail(String prmTo, StringBuilder prmMsg) {
		
		this.to = prmTo;
		this.msg = prmMsg;
		try {
			Message message = new MimeMessage(sess);
			System.out.println("From: "+from);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Libranix");
			message.setText(msg.toString());
			
			Transport.send(message);
		}catch(MessagingException mEx) {
			mEx.printStackTrace();
		}
	}
	
	private void initializeAPI() {
		prop = new Properties();
		prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
        sess = Session.getInstance(prop,new APIAuth());
	}
	
	private void initializeAPI(String prmHost, String prmPort) {
		prop = new Properties();
		prop.put("mail.smtp.host", prmHost);
        prop.put("mail.smtp.port", prmPort);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
        sess = Session.getInstance(prop,new APIAuth());
	}
	
	private class APIAuth extends Authenticator {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			if (pwd == null) {
				//pwd = new char[] { 't', 'e', 's', 't', 'm', 'a', 'i', 'l', '2', '0', '0', '!' };

				try {
					aes = new AESEncryption();
					MailAPI.this.loadAES();
					read = new ReadFile("Data_3MP.data");
					pwd = aes.decrypt(read.readProperties()).toCharArray();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return new PasswordAuthentication(from, String.valueOf(pwd));
		}
	}
}

package model;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsAPI {
	
	private String ACCOUNT_SID;
	private String AUTH_TOKEN;
	private String from;
	
	public SmsAPI() {
		ACCOUNT_SID = "AC18da56f86d2082f489f6b22ce16241bb";
		AUTH_TOKEN = "ee8e63fcf50a3780acf23821deb56c24";
		from = "+18312915427";
	}
	
	public SmsAPI(String prmSID, String prmAToken, String prmFrom) {
		ACCOUNT_SID = prmSID;
		AUTH_TOKEN = prmAToken;
		from = prmFrom;
	}
	
	public void setSID(String prmSID) {
		ACCOUNT_SID = prmSID;
	}
	
	public void setAToken(String prmAToken) {
		AUTH_TOKEN = prmAToken;
	}
	
	public void setFromNo(String prmFrom) {
		from = prmFrom;
	}
	
	public String getSID() {
		return ACCOUNT_SID;
	}
	
	public String getAToken() {
		return AUTH_TOKEN;
	}
	
	public String getFromNo() {
		return from;
	}
	
	public void sendSMS(String prmTo, StringBuilder prmMsg) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		System.out.println("To: "+prmTo);
	    Message message = Message.creator(new PhoneNumber("+"+prmTo),
	        new PhoneNumber(from),
	        prmMsg.toString()).create(); // parameter .creator(To,From,Message)

	    System.out.println(message.getSid()); //returns SMS SID if sent successfully.
	}

}

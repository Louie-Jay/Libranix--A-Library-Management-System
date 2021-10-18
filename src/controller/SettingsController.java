package controller;

import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.SettingsModel;
import view.ContactTextField;
import view.EmailTextField;
import view.HostTextField;
import view.PortTextField;

public class SettingsController {
	
	private SettingsModel model;
	private String errorMsg;
	
	public SettingsController(JPanel prmParent) {
		model = new SettingsModel();
	}
	
	public boolean applySender(JTextField prmSID, JTextField prmAuthToken, ContactTextField prmPhoneNumber, char[] prmPasswordInput) {
		char[] saltedInput = model.getSaltInput(prmPasswordInput);
		if(Arrays.equals(saltedInput, model.getPassword())) {
			if (model.applySender(prmSID.getText(), prmAuthToken.getText(), prmPhoneNumber.getText())) {
				return true;
			}else {
				errorMsg = "Critical Error:<br>"+model.getErrorMsg();
				return false;
			}
		}else {
			errorMsg = "Wrong password!";
			return false;
		}
	}
	
	public void initializeSettings(HashMap<String, JComponent> prmComponent) {
		EmailTextField txtEmail = (EmailTextField) prmComponent.get("Email");

		
		EmailTextField txtMailerEmail = (EmailTextField) prmComponent.get("MailerEmail");
		HostTextField txtHost = (HostTextField) prmComponent.get("MailerHost");
		PortTextField txtPort = (PortTextField) prmComponent.get("MailerPort");
		
		JTextField txtSID = (JTextField) prmComponent.get("SenderSID");
		JTextField txtAuthToken = (JTextField) prmComponent.get("SenderAuthToken");
		ContactTextField txtPhoneNumber = (ContactTextField) prmComponent.get("SenderPhoneNumber");
		
		txtEmail.setText(model.getEmail());
		
		HashMap<String, String> mailerValue = model.getMailer();
		txtMailerEmail.setText(mailerValue.get("Email"));
		txtHost.setText(mailerValue.get("Host"));
		txtPort.setText(mailerValue.get("Port"));
		
		HashMap<String, String> senderValue = model.getSender();
		txtSID.setText(senderValue.get("SID"));
		txtAuthToken.setText(senderValue.get("AuthToken"));
		txtPhoneNumber.setText(senderValue.get("PhoneNumber"));
	}
	
	public boolean applyMailer(EmailTextField prmEmail, HostTextField prmHost, PortTextField prmPort, JPasswordField prmPassword, char[] prmPasswordInput) {
		char[] saltedInput = model.getSaltInput(prmPasswordInput);
		if (Arrays.equals(saltedInput, model.getPassword())) {
			if (model.applyMailer(prmEmail.getText(), prmHost.getText(), prmPort.getText(), prmPassword.getPassword())) {
				return true;
			}else {
				errorMsg = "Critical Error:<br>"+model.getErrorMsg();
				return false;
			}
		}else {
			errorMsg = "Wrong password!";
			return false;
		}
	}
	
	public boolean sendSecurityCode() {
		if(model.sendCode()) {
			return true;
		}else {
			errorMsg = model.getErrorMsg();
			return false;
		}
	}
	
	public boolean isValidSecurityCode(String prmInputCode) { 
		char[] input = prmInputCode.toCharArray();
		if (Arrays.equals(input, model.getSecurityCode())) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validPassword(JPasswordField prmPasswordField) {
		char[] inputPassword = prmPasswordField.getPassword();
		if (inputPassword.length <= 8) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean changePassword(JPasswordField prmPasswordField, char[] prmPassword) { 
		char[] inputPassword = model.getSaltInput(prmPassword);
		char[] newPassword = model.getSaltInput(prmPasswordField.getPassword());
		
		if (Arrays.equals(inputPassword, model.getPassword())) {
			if (model.changePassword(newPassword)) {
				return true;
			}else {
				errorMsg = "Critical Error:<br>"+model.getErrorMsg();
				return false;
			}
		}else {
			errorMsg = "Wrong password!";
			return false;
		}
	}
	
	public boolean changeEmail(EmailTextField prmEmailField, char[] prmPassword) {

		if (Arrays.equals(model.getSaltInput(prmPassword), model.getPassword())) {
			if (model.changeEmail(prmEmailField.getText())) {
				return true;
			} else {
				errorMsg = model.getErrorMsg();
			}
		} else {
			errorMsg = "Wrong password!";
		}

		return false;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
}

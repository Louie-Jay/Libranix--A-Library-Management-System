package controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.RemindMbrMssgrModel;

public class RemindMbrMssgrController {
	
	private RemindMbrMssgrModel model;
	private String errorMsg;
	private StringBuilder msgContent;
	
	public RemindMbrMssgrController() {
		this.model = new RemindMbrMssgrModel();
		this.errorMsg = "";
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public boolean remindMember(LinkedHashMap<String, JComponent> prmComponents) {
		JCheckBox chkSMS = (JCheckBox) prmComponents.get("chkSMS");
		JCheckBox chkEmail = (JCheckBox) prmComponents.get("chkEmail");
		JEditorPane txtMessage = (JEditorPane) prmComponents.get("txtMessage");
		JLabel txtEmail = (JLabel) prmComponents.get("txtEmail");
		JLabel txtCNo = (JLabel) prmComponents.get("txtCNo");
		
		msgContent = new StringBuilder(txtMessage.getText());
		
		if ((chkSMS.isSelected()) || (chkEmail.isSelected())) {
			if ((msgContent.length()) > 1) {
				
				if ((chkSMS.isSelected())) {
					model.sendSMS(txtCNo.getText(),msgContent);
				}
				
				if((chkEmail.isSelected())) {
					model.sendMail(txtEmail.getText(),msgContent);
				}
				
				if((chkSMS.isSelected()) && (chkEmail.isSelected())) {
					model.sendSMS(txtCNo.getText(),msgContent);
					model.sendMail(txtEmail.getText(),msgContent);
				}
				return true;
				
			}else {
				errorMsg = "\nInvalid message, cannot send empty messages";
				return false;
			}
			
		}else {
			errorMsg = "\nPlease select remind operation, SMS or Email";
			return false;
		}
		
	}
	
	public HashMap<Integer, String> getMemberValues(int paramId){
		return model.getMemberValues(paramId);
	}

}

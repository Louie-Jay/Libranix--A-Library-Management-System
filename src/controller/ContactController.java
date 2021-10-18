package controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.ContactTextField;

public class ContactController {
	
	private InputValidator verifier;
	private boolean valid;
	private ContactTextField viewTextField;
	private String errorStr;
	private String defaultStr;
	
	public ContactController(ContactTextField paramTextField) {
		viewTextField = paramTextField;
		viewTextField.getDocument().addDocumentListener(new ChangeHandler());
		viewTextField.addFocusListener(new FocusHandler());
		viewTextField.setHoverText("Input valid Contact No.");
		errorStr = "";
		defaultStr = "";
	}
	
	
	public boolean isValid() {
		return valid;
	}
	
	public void textAlert(){
		if(valid) {
			viewTextField.setToolTipText(defaultStr);
			viewTextField.setValidBorder();
			
		}else {
			viewTextField.setToolTipText(errorStr);
			viewTextField.setInvalidBorder();
		}
	}
	
	public void validate() {
		verifier = new InputValidator();
		String inputTxt = viewTextField.getText();
		valid = true;
		
		if(verifier.isEmpty(inputTxt)) {
			errorStr = "Cannot be empty";
			valid = false;
		}
		
		if(verifier.isNumeric(inputTxt)) {
			valid = true;
		}else {
			errorStr = "Cannot contains letters A-Z";
			valid = false;
		}
		
		if(verifier.overlapsCharLimit(inputTxt, 15)) {
			errorStr = "Length up-to 15 only";
			valid = false;
		}
		
		if(verifier.hasIllegalCharacters(inputTxt)) {
			errorStr = "Cannot contain special characters";
			valid = false;
		}
		
		textAlert();
	}
	
	private class ChangeHandler implements DocumentListener{
		@Override
		public void changedUpdate(DocumentEvent cEvt) {}
		@Override
		public void insertUpdate(DocumentEvent cEvt) { validate(); }
		@Override
		public void removeUpdate(DocumentEvent cEvt) { validate(); }
	}
	
	private class FocusHandler implements FocusListener{
		@Override
		public void focusGained(FocusEvent fEvt) { validate(); }
		@Override
		public void focusLost(FocusEvent fEvt) { validate(); }
	}
	
}
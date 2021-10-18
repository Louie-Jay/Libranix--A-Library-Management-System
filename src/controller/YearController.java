package controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.YearTextField;

public class YearController {
	
	private InputValidator verifier;
	private boolean valid;
	private YearTextField viewTextField;
	private String errorStr;
	private String defaultStr;
	
	public YearController(YearTextField paramTextField) {
		viewTextField = paramTextField;
		viewTextField.getDocument().addDocumentListener(new ChangeHandler());
		viewTextField.addFocusListener(new FocusHandler());
		viewTextField.setHoverText("Input valid Year");
		errorStr = "";
		defaultStr = "🗸";
		this.validate();
	}
	
	
	public boolean isValid() {
		this.validate();
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
		
		if(verifier.isAlphabetic(inputTxt)) {
			errorStr = "Cannot contain Letters";
			valid = false;
		}
		
		if(verifier.overlapsCharLimit(inputTxt, 4)) {
			errorStr = "Length up-to 4 only";
			valid = false;
		}
		
		if(verifier.underlapsCharLimit(inputTxt, 4)) {
			errorStr = "Length up-to 4 only";
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

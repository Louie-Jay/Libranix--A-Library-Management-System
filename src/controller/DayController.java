package controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import view.DayComboBox;

public class DayController {
	
	private InputValidator verifier;
	private boolean valid;
	private DayComboBox<String> viewComboBox;
	private String errorStr;
	private String defaultStr;
	
	public DayController(DayComboBox paramTextField) {
		viewComboBox = paramTextField;
		viewComboBox.addItemListener(new ChangeHandler());
		viewComboBox.addFocusListener(new FocusHandler());
		viewComboBox.setHoverText("Input valid Day");
		errorStr = "";
		defaultStr = "🗸";
		
		this.validate();
	}
	
	
	public boolean isValid() {
		this.validate();
		return valid;
	}
	
	public void textAlert(){
		
		if (viewComboBox.isEnabled()) {
			viewComboBox.setHoverText("Select Day");
		}
		
		if(valid) {
			viewComboBox.setToolTipText(defaultStr);
			viewComboBox.setValidBorder();
			
		}else {
			viewComboBox.setToolTipText(errorStr);
			viewComboBox.setInvalidBorder();
		}
		
	}
	
	public void validate() {
		verifier = new InputValidator();
		String inputTxt = (String) viewComboBox.getSelectedItem();
		valid = true;
		
		if(verifier.isEmpty(inputTxt)) {
			errorStr = "Cannot be empty";
			valid = false;
		}
		
		if(verifier.overlapsCharLimit(inputTxt, 2)) {
			errorStr = "Length up-to 2 only";
			valid = false;
		}
		
		if(verifier.isAlphabetic(inputTxt)) {
			errorStr = "Cannot contain Letters";
			valid = false;
		}
		
		if(verifier.hasIllegalCharacters(inputTxt)) {
			errorStr = "Cannot contain special characters";
			valid = false;
		}
		
		
		textAlert();
		
	}
	
	private class ChangeHandler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent cEvt) { validate(); }
	}
	
	private class FocusHandler implements FocusListener{
		@Override
		public void focusGained(FocusEvent fEvt) { validate(); }
		@Override
		public void focusLost(FocusEvent fEvt) { validate(); }
	}
	
}

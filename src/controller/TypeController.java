package controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.event.DocumentEvent;

import view.TypeComboBox;

public class TypeController {
	
	private InputValidator verifier;
	private boolean valid;
	private TypeComboBox<String> viewComboBox;
	private String errorStr;
	private String defaultStr;
	
	public TypeController(TypeComboBox paramComboBox) {
		viewComboBox = paramComboBox;
		viewComboBox.addItemListener(new ChangeHandler());
		viewComboBox.addFocusListener(new FocusHandler());
		viewComboBox.setHoverText("Input valid BookType");
		errorStr = "";
		defaultStr = "";
		validate();
	}
	
	
	public boolean isValid() {
		return valid;
	}
	
	public void textAlert(){
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
		
		if(verifier.overlapsCharLimit(inputTxt, 11)) {
			errorStr = "Length up-to 11 only";
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
		public void itemStateChanged(ItemEvent cEvt) {
			validate();
		}
	}
	
	private class FocusHandler implements FocusListener{
		@Override
		public void focusGained(FocusEvent fEvt) { validate(); }
		@Override
		public void focusLost(FocusEvent fEvt) { validate(); }
	}
	
}

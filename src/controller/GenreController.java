package controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import view.GenreComboBox;

public class GenreController {
	
	private InputValidator verifier;
	private boolean valid;
	private GenreComboBox<String> viewComboBox;
	private String errorStr;
	private String defaultStr;
	
	public GenreController(GenreComboBox paramTextField) {
		viewComboBox = paramTextField;
		viewComboBox.addItemListener(new ChangeHandler());
		viewComboBox.addFocusListener(new FocusHandler());
		viewComboBox.setHoverText("Input valid BookGenre");
		errorStr = "";
		defaultStr = "🗸";
	}
	
	
	public boolean isValid() {
		return valid;
	}
	
	public void textAlert(){
		
		if (viewComboBox.isEnabled()) {
			viewComboBox.setHoverText("Select BookType first");
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
		
		if(verifier.overlapsCharLimit(inputTxt, 35)) {
			errorStr = "Length up-to 35 only";
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

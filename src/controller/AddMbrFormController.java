package controller;

import java.util.LinkedHashMap;

import javax.swing.JComponent;

import model.AddMbrFormModel;
import view.AddressTextField;
import view.ContactTextField;
import view.Date;
import view.EmailTextField;
import view.FNameTextField;
import view.Img;
import view.LNameTextField;
import view.MNameTextField;
import view.SexComboBox;

public class AddMbrFormController {
	
	private AddMbrFormModel model;
	private String errorMsg;
	
	private LinkedHashMap<String,String> inputs;
	
	public AddMbrFormController() {
		this.model = new AddMbrFormModel();
	}
	
	
	public String[] getSexData() {
		return model.getSexData();
	}
	
	public boolean processInput(LinkedHashMap<String,JComponent> paramComp) {
		inputs = new LinkedHashMap<String, String>();
		inputs.put("FName", ((FNameTextField)paramComp.get("FName")).getText());
		inputs.put("MName", ((MNameTextField)paramComp.get("MName")).getText());
		inputs.put("LName", ((LNameTextField)paramComp.get("LName")).getText());
		inputs.put("MSex", (String) ((SexComboBox<String>)paramComp.get("MSex")).getSelectedItem());
		inputs.put("BDate", ((Date)paramComp.get("BDate")).getText());
		inputs.put("Address", ((AddressTextField)paramComp.get("Address")).getText());
		inputs.put("ContactNo", ((ContactTextField)paramComp.get("ContactNo")).getText());
		inputs.put("Email", ((EmailTextField)paramComp.get("Email")).getText());
		inputs.put("Img", ((Img)paramComp.get("Img")).getImg());
		
		this.model = new AddMbrFormModel();
		
		if(this.validate(paramComp)) {
			model.toDatabase(inputs);
			return true;
		}else {
			return false;
		}
	}
	
	private boolean validate(LinkedHashMap<String,JComponent> paramComp) {
		errorMsg = "";
		
		if(((FNameTextField)paramComp.get("FName")).valid()) {
			
		}else {
			errorMsg = "Please input a valid FirstName";
			return false;
		}
		
		if(((MNameTextField)paramComp.get("MName")).valid()) {
			
		}else {
			errorMsg = "Please input a valid MiddleName";
			return false;
		}
		
		if(((LNameTextField)paramComp.get("LName")).valid()) {
			
		}else {
			errorMsg = "Please input a valid LastName";
			return false;
		}
		
		if(((SexComboBox<String>)paramComp.get("MSex")).valid()) {
			
		}else {
			errorMsg = "Please input a valid Sex";
			return false;
		}
		
		System.out.println("Date valid = " + ((Date)paramComp.get("BDate")).valid());
		
		if(((Date)paramComp.get("BDate")).valid()) {
			
		}else {
			errorMsg = "Please input a valid BirthDate";
			return false;
		}
		
		if(((AddressTextField)paramComp.get("Address")).valid()) {
			
		}else {
			errorMsg = "Please input a valid Address";
			return false;
		}
		
		if(((ContactTextField)paramComp.get("ContactNo")).valid()) {
			
		}else {
			errorMsg = "Please input a valid Contact No.";
			return false;
		}
		
		if(((EmailTextField)paramComp.get("Email")).valid()) {
			
		}else {
			errorMsg = "Please input a valid Email";
			return false;
		}
		
		return true;
	}
	
	private void writeErrorMsg(String err) {
		errorMsg += err+"\n";
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

}

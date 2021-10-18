package controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JComponent;

import model.EditMbrFormModel;
import view.AddressTextField;
import view.ContactTextField;
import view.Date;
import view.EmailTextField;
import view.FNameTextField;
import view.Img;
import view.LNameTextField;
import view.MNameTextField;
import view.SexComboBox;

public class EditMbrFormController {
	
	private EditMbrFormModel model;
	private String errorMsg;
	private HashMap<Integer,String> inputs;
	
	public EditMbrFormController() {
		model = new EditMbrFormModel();
	}
	
	
	public String[] getSexData() {
		return model.getSexData();
	}
	
	public boolean update(int paramId, LinkedHashMap<String, JComponent> paramComp) {
		
		if(this.validInput(paramComp)) {
			return model.update(paramId, inputs);
		}else {
			errorMsg = "Invalid input.";
			return false;
		}
	}
	
	private boolean validInput(LinkedHashMap<String, JComponent> paramComp) {
		inputs = new HashMap<Integer,String>();
		FNameTextField txtFName = (FNameTextField)paramComp.get("txtFName");
		MNameTextField txtMName = (MNameTextField)paramComp.get("txtMName");
		LNameTextField txtLName = (LNameTextField)paramComp.get("txtLName");
		SexComboBox<String> cbxSex = (SexComboBox<String>)paramComp.get("cbxSex");
		Date dtDate = (Date)paramComp.get("dtBDate");
		AddressTextField txtAddr = (AddressTextField)paramComp.get("txtAddr");
		EmailTextField txtEmail = (EmailTextField)paramComp.get("txtEmail");
		Img pic = (Img)paramComp.get("Img");
		ContactTextField txtCNo = (ContactTextField)paramComp.get("txtCNo");
		
		
		if(txtFName.valid()) {}
		else {
			errorMsg = "Invalid First Name.";
			return false;
		}
		
		if(txtMName.valid()) {}
		else {
			errorMsg = "Invalid Middle Name.";
			return false;
		}
		
		if(txtLName.valid()) {}
		else {
			errorMsg = "Invalid Last Name.";
			return false;
		}
		
		if(cbxSex.valid()) {}
		else {
			errorMsg = "Invalid Sex.";
			return false;
		}
		
		if(dtDate.valid()) {}
		else {
			errorMsg = "Invalid Date.";
			return false;
		}
		
		if(txtAddr.valid()) {}
		else {
			errorMsg = "Invalid Address.";
			return false;
		}
		
		if(txtEmail.valid()) {}
		else {
			errorMsg = "Invalid Email.";
			return false;
		}
		
		if(txtCNo.valid()) {}
		else {
			errorMsg = "Invalid Contact No.";
			return false;
		}
		
		inputs.put(0, txtFName.getText());
		inputs.put(1, txtMName.getText());
		inputs.put(2, txtLName.getText());
		inputs.put(3, (String)cbxSex.getSelectedItem());
		inputs.put(4, dtDate.getText());
		inputs.put(5, txtAddr.getText());
		inputs.put(6, txtEmail.getText());
		inputs.put(7, pic.getImg());
		inputs.put(8, txtCNo.getText());
		
		return true;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

}

package controller;

import java.util.Arrays;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.LoginModel;

public class LoginController {
	
	private String errorMsg;
	private JTextField txtUser;
	private JPasswordField txtPwd;
	private LoginModel model;
	
	public LoginController(JTextField prmUser, JPasswordField prmPwd) {
		
		txtUser = prmUser;
		txtPwd = prmPwd;
		model = new LoginModel();
		
	}
	
	public LoginController() {
		model = new LoginModel();
	}
	
	public boolean changePassword(char[] prmNewPassword) {
		return model.updatePassword(prmNewPassword);
	}
	
	public void sendCode() {
		model.sendCode();
	}
	
	public boolean validCode(char[] prmInputCode) {
		return Arrays.equals(model.getSecurityCode(), prmInputCode);
	}
	
	private boolean validPassword(char[] prmInputPwd) {
		char[] inputPwd = prmInputPwd;
		char[] password = model.getPassword();
		
		if(Arrays.equals(inputPwd, password)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean login() {
		String user = txtUser.getText();
		char[] pwd = txtPwd.getPassword();
		if(user.equals(model.getUser())) {
			
			if(this.validPassword(model.getSaltInput(pwd))) {
				return true;
			}else {
				errorMsg = "Invalid password.";
				return false;
			}
			
		}else {
			errorMsg = "Invalid username.";
			return false;
		}
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
}

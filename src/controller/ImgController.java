package controller;

import java.awt.Component;
import java.io.IOException;

import javax.swing.JLabel;

import model.ImgModel;

public class ImgController {
	
	private ImgModel model;
	private InputValidator verifier;
	
	public ImgController(JLabel prmParent, String prmName) {
		this.validateName(prmParent, prmName);
	}
	
	public void setImg(String prmName) {
		model.setImg(prmName);
	}
	
	public void setTransactImg(String prmName) {
		model.setTransactImg(prmName);
	}
	
	public String getImgName() {
		return model.getImgName();
	}
	
	public void validateName(JLabel prmParent, String prmName) {
		verifier = new InputValidator();
		
		if(verifier.invalidFileName(prmName)) {
			this.model = new ImgModel(prmParent ,"error");
		}else {
			this.model = new ImgModel(prmParent ,prmName);
		}
	}
	
	public void showFileChooser() {
		try {
			model.showFileChooser();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

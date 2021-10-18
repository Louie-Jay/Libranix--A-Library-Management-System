package controller;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;

import model.RequestModel;

public class RequestController {
	
	private RequestModel model;
	
	public RequestController() {
		model = new RequestModel();
	}
	
	public void saveRequest(JTextArea prmRequestArea) {
		try {
			prmRequestArea.write(model.saveRequest());
			model.closeWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadRequest(JTextArea prmRequestArea) {
		try {
			prmRequestArea.read(model.loadRequest(), null);
			model.closeReader();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadRequest(JEditorPane prmRequestArea) {
		try {
			prmRequestArea.read(model.loadRequest(), null);
			model.closeReader();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

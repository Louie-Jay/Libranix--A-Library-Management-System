package controller;

import java.util.LinkedHashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import model.AddBkFormModel;
import model.FileDataModel;
import view.AuthorTextField;
import view.GenreComboBox;
import view.ISBNTextField;
import view.Img;
import view.PublisherTextField;
import view.QuantityTextField;
import view.TitleTextField;
import view.TypeComboBox;
import view.WriterTextField;

public class AddBkFormController {
	private FileDataModel genreData;
	private FileDataModel nfGenre;
	private FileDataModel fGenre;
	private InputValidator validate;
	private AddBkFormModel model;
	String errorMsg;
	
	private LinkedHashMap<String,String> inputs;
	
	public AddBkFormController() {
		
		model = new AddBkFormModel();
		validate = new InputValidator();
		inputs = new LinkedHashMap<String,String>();
	}
	
	
	
	public String[] getGenreData() {
		return model.getGenreData();
	}
	
	
	public void loadCbxData(String type, JComboBox<String> cbx) {
		switch(type) {
			case "Fiction":
				for(String item: model.getfData()) {
					cbx.addItem(item);
				}
			break;
			case "Non-fiction":
				for(String item: model.getnfData()) {
					cbx.addItem(item);
				}
			break;
		}
	}
	
	public boolean processInput(LinkedHashMap<String,JComponent> paramComp) {
		inputs.put("Title", ((JTextField)paramComp.get("Title")).getText());
		inputs.put("Author", ((JTextField)paramComp.get("Author")).getText());
		inputs.put("Writer", ((JTextField)paramComp.get("Writer")).getText());
		inputs.put("Publisher", ((JTextField)paramComp.get("Publisher")).getText());
		inputs.put("ISBN", ((JTextField)paramComp.get("ISBN")).getText());
		inputs.put("Type", (String) ((JComboBox<String>)paramComp.get("Type")).getSelectedItem());
		inputs.put("Genre", (String) ((JComboBox<String>)paramComp.get("Genre")).getSelectedItem());
		inputs.put("Quantity", ((JTextField)paramComp.get("Quantity")).getText());
		inputs.put("Img", ((Img)paramComp.get("Img")).getImg());
		
		model = new AddBkFormModel();
		
		if(this.validate(paramComp)) {
			model.toDatabase(inputs);
		}else {
			return false;
		}
		
		return true;
	}
	
	private boolean validate(LinkedHashMap<String,JComponent> paramComp) {
		errorMsg = "";
		
		if(((TitleTextField)paramComp.get("Title")).valid()) {
			
		}else {
			errorMsg = "Please input a valid Title";
			return false;
		}
		
		if(((AuthorTextField)paramComp.get("Author")).valid()) {
			
		}else {
			errorMsg = "Please input a valid Author";
			return false;
		}
		
		if(((WriterTextField)paramComp.get("Writer")).valid()) {
			
		}else {
			errorMsg = "Please input a valid Writer";
			return false;
		}
		
		if(((PublisherTextField)paramComp.get("Publisher")).valid()) {
			
		}else {
			errorMsg = "Please input a valid Publisher";
			return false;
		}
		
		if(((ISBNTextField)paramComp.get("ISBN")).valid()) {
			
		}else {
			errorMsg = "Please input a valid ISBN";
			return false;
		}
		
		if(((TypeComboBox<String>)paramComp.get("Type")).valid()) {
			
		}else {
			errorMsg = "Please input a valid Type";
			return false;
		}
		
		if(((GenreComboBox<String>)paramComp.get("Genre")).valid()) {
			
		}else {
			errorMsg = "Please input a valid Genre";
			return false;
		}
		
		if(((QuantityTextField)paramComp.get("Quantity")).valid()) {
			
		}else {
			errorMsg = "Please input a valid Quantity";
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

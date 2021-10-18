package controller;

import java.util.LinkedHashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import model.EditBkFormModel;
import view.AuthorTextField;
import view.GenreComboBox;
import view.ISBNTextField;
import view.Img;
import view.PublisherTextField;
import view.QuantityTextField;
import view.TitleTextField;
import view.TypeComboBox;
import view.WriterTextField;

public class EditBkFormController {
	
	private EditBkFormModel model;
	
	private JTextField txttitle;
	private JTextField txtauthor;
	private JTextField txtwriter;
	private JTextField txtpublisher;
	private JTextField txtisbn;
	private JComboBox<String> cbxtype;
	private Img pic;
	private JComboBox<String> cbxgenre;
	private JTextField txtquantity;
	private String errorMsg;

	
	public EditBkFormController() {
		model = new EditBkFormModel();
	}
	
	public boolean applyEdit(int paramId,LinkedHashMap<String, JComponent> paramComp) {
		
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
		
		model = new EditBkFormModel();
		
		initializeInputComponents(paramComp);
		if(model.editData(paramId,getInputs())) {
			return true;
		}else {
			errorMsg = "Error occurred on database";
			return false;
		}
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void initializeInputComponents(LinkedHashMap<String, JComponent> paramComp) {
		
		txttitle = (JTextField)paramComp.get("Title");
		txtauthor = (JTextField)paramComp.get("Author");
		txtwriter = (JTextField)paramComp.get("Writer");
		txtpublisher = (JTextField)paramComp.get("Publisher");
		txtisbn = (JTextField)paramComp.get("ISBN");
		cbxtype = (JComboBox<String>)paramComp.get("Type");
		pic = (Img)paramComp.get("Img");
		cbxgenre = (JComboBox<String>)paramComp.get("Genre");
		txtquantity = (JTextField)paramComp.get("Quantity");
		
	}
	
	public LinkedHashMap<String, String> getInputs() {
		LinkedHashMap<String, String> inputs = new LinkedHashMap<String, String>();
		
		
		inputs.put("Title",txttitle.getText());
		inputs.put("Author",txtauthor.getText());
		inputs.put("Writer",txtwriter.getText());
		inputs.put("Publisher",txtpublisher.getText());
		inputs.put("ISBN",txtisbn.getText());
		inputs.put("Type",cbxtype.getSelectedItem().toString());
		inputs.put("Img",pic.getImg());
		inputs.put("Genre",cbxgenre.getSelectedItem().toString());
		inputs.put("Quantity", txtquantity.getText());
		
		return inputs;
	}
	
	public void loadValues(LinkedHashMap<String,JComponent> paramComp, LinkedHashMap<String,Object> paramInput) {
		
		txttitle = (JTextField)paramComp.get("Title");
		txtauthor = (JTextField)paramComp.get("Author");
		txtwriter = (JTextField)paramComp.get("Writer");
		txtpublisher = (JTextField)paramComp.get("Publisher");
		txtisbn = (JTextField)paramComp.get("ISBN");
		cbxtype = (JComboBox<String>)paramComp.get("Type");
		pic = (Img)paramComp.get("Img");
		cbxgenre = (JComboBox<String>)paramComp.get("Genre");
		txtquantity = (JTextField)paramComp.get("Quantity");
		
		txttitle.setText((String)paramInput.get("Title").toString());
		txtauthor.setText((String)paramInput.get("Author").toString());
		txtwriter.setText((String)paramInput.get("Writer").toString());
		txtpublisher.setText((String)paramInput.get("Publisher").toString());
		txtisbn.setText((String)paramInput.get("ISBN").toString());
		cbxtype.setSelectedItem(paramInput.get("Type").toString());
		pic.setImg((String)paramInput.get("Img"));
		cbxgenre.setSelectedItem(paramInput.get("Genre").toString());
		txtquantity.setText(paramInput.get("Quantity").toString());
	}
	
	public String[] getGenreData() {
		return model.getGenreData();
	}
	
	
	public String[] getnfData() {
		return model.getnfData();
	}
	
	public String[] getfData() {
		return model.getfData();
	}
	
	
	public void loadCbxData(String type, JComboBox<String> cbx) {
		switch(type) {
			case "Fiction":
				for(String item: getfData()) {
					cbx.addItem(item);
				}
			break;
			case "Non-fiction":
				for(String item: getnfData()) {
					cbx.addItem(item);
				}
			break;
		}
	}

}

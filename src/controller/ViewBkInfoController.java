package controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import model.ViewBkInfoModel;

public class ViewBkInfoController {
	
	private ViewBkInfoModel model;
	private LinkedHashMap<String, Object> values;
	public ViewBkInfoController() {
		model = new ViewBkInfoModel();
		
	}
	
	public HashMap<Integer, Object> getValues(int paramId){
		return model.getValues(paramId);
	}
	
	public LinkedHashMap<String, Object> processFormValues(HashMap<Integer, Object> paramInput){
		values = new LinkedHashMap<String, Object>();
		
		values.put("ID", paramInput.get(0));
		values.put("Title", paramInput.get(1));
		values.put("Author", paramInput.get(2));
		values.put("Writer", paramInput.get(3));
		values.put("Publisher", paramInput.get(4));
		values.put("ISBN", paramInput.get(5));
		values.put("Type", paramInput.get(6));
		values.put("Type", paramInput.get(7));
		values.put("Img", paramInput.get(8));
		values.put("Quantity", paramInput.get(9));
		
		return values;
	}
	

}

package controller;

import java.util.LinkedHashMap;

import model.DeleteBkInfoModel;

public class DeleteBkInfoController {
	
	private DeleteBkInfoModel model;
	
	public DeleteBkInfoController() {
		model = new DeleteBkInfoModel();
	}
	
	public boolean deleteBook(LinkedHashMap<String,Object> paramCell) {
		int id = (int) paramCell.get("ID");
		String img = (String) paramCell.get("Img");
		return model.deleteBook(id,img);
		
	}

}

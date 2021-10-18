package controller;

import java.util.LinkedHashMap;

import model.DeleteMbrInfoModel;

public class DeleteMbrInfoController {
	
	private DeleteMbrInfoModel model;
	private String errorMsg;
	
	public DeleteMbrInfoController() {
		model = new DeleteMbrInfoModel();
		errorMsg = "Abnormal operation...";
	}
	
	public boolean delete(int paramId, String prmImg) {
		if(model.delete(paramId,prmImg)) {
			return true;
		}else {
			errorMsg = "Failed, problem occured on database.";
			return false;
		}
		
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

}

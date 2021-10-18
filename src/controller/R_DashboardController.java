package controller;

import java.util.HashMap;

import model.R_DashboardModel;

public class R_DashboardController {
	
	private R_DashboardModel model;
	
	public R_DashboardController() {
		model = new R_DashboardModel();
	}
	
	public HashMap<String, Integer> getBkMem(){
		HashMap<String,Integer> BkMemValue = new HashMap<String,Integer>();
		
		BkMemValue.put("Books", model.getBkCount());
		BkMemValue.put("Members", model.getMbrCount());
		
		return BkMemValue;
	}
}

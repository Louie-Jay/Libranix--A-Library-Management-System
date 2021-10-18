package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import model.R_ReportsModel;
import view.CustomChart;

public class R_ReportsController {
	
	private R_ReportsModel model;
	private ArrayList<FileInputStream> chartPics;
	private String errorMsg;
	
	public R_ReportsController() {
		model = new R_ReportsModel();
	}
	
	public boolean generateReport(File prmPath,HashMap<String, CustomChart> prmCharts){
		chartPics = new ArrayList<FileInputStream>();
		
		chartPics.add(((CustomChart)prmCharts.get("P1")).getImg());
		chartPics.add(((CustomChart)prmCharts.get("B1")).getImg());
		chartPics.add(((CustomChart)prmCharts.get("B2")).getImg());
		chartPics.add(((CustomChart)prmCharts.get("P2")).getImg());
		
		errorMsg = "";
		
		try {
			model.writeReport(prmPath, chartPics);
		} catch (FileNotFoundException fnfex) {
			errorMsg = "Folder path error, couldn't find path.";
			return false;
		} catch (Exception ex) {
			errorMsg = "Critical error while generating file";
			return false;
		}
			
		return true;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public int getBorrowedCount() {
		return model.getBorrowCount();
	}	
	
	public int getBookCount() {
		return model.getBkCount();
	}
	
	public int getMembersCount() {
		return model.getMbrCount();
	}
	
	public Map<Integer, List<String>> getBkQuantity(){
		return model.getBkQuantity();
	}
	
	public Map<Integer, List<String>> getMostBorrowed(){
		return model.getMostBorrowed();
	}
	
	public Map<Integer, List<String>> getBkMbr(){
		Map<Integer, List<String>> data;
		
		List<String> dtBook = new ArrayList<String>();
		dtBook.add("Total Books");
		dtBook.add(String.valueOf(model.getBkCount()));
		
		List<String> dtMbr = new ArrayList<String>();
		dtMbr.add("Total Members");
		dtMbr.add(String.valueOf(model.getMbrCount()));
		
		data = new HashMap<Integer, List<String>>();
		data.put(0, dtBook);
		data.put(1, dtMbr);
		
		return data;
	}
	
	public Map<Integer, List<String>> getBrwBk(){
		Map<Integer, List<String>> data;
		
		List<String> dtBrwBk = new ArrayList<String>();
		dtBrwBk.add("Borrow Count");
		dtBrwBk.add(String.valueOf(model.getBorrowCount()));
		
		List<String> dtBook = new ArrayList<String>();
		dtBook.add("Total Books");
		dtBook.add(String.valueOf(model.getBkCount()));
		
		data = new HashMap<Integer, List<String>>();
		data.put(0, dtBrwBk);
		data.put(1, dtBook);
		
		return data;
	}
	
}

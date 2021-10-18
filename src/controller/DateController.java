package controller;

import java.util.HashMap;

import javax.swing.JComponent;

import model.DateModel;
import view.DayComboBox;
import view.MonthComboBox;
import view.YearTextField;

public class DateController {
	
	private DateModel model;
	private String errorMsg;
	private StringBuilder strDate;
	private MonthComboBox<String> month;
	private DayComboBox<String> day;
	private YearTextField year;
	private HashMap<Integer,JComponent> dateComponents;
	private boolean valid;
	
	public DateController() {
		model = new DateModel();
		errorMsg = new String();
	}
	
	public void allocateComponents(HashMap<Integer, JComponent> prmComponents) {
		this.dateComponents = prmComponents;
		year = (YearTextField) dateComponents.get(0);
		day = (DayComboBox<String>) dateComponents.get(1);
		month = (MonthComboBox<String>) dateComponents.get(2);
	}
	
	public String[] getMonthData() {
		return this.model.getMonthData();
	}
	
	public String[] getDayData() {
		return this.model.getDayData();
	}
	

	public boolean valid() {
		
		if(month.valid()) {}
		else {
			errorMsg = "Invalid month: "+ month.getToolTipText();
			return false;
		}
		
		if(day.valid()) {}
		else {
			errorMsg = "Invalid day: "+day.getToolTipText();
			return false;
		}
		
		if(year.valid()) {}
		else {
			errorMsg = "Invalid year: "+year.getToolTipText();
			return false;
		}
		
		return true;
	}
	
	public String getErrorMsg(){
		return errorMsg;
	}
	
	public String getText() {
		
		strDate = new StringBuilder();
		
		String strYear = (String)year.getText();
		String strDay = (String)day.getSelectedItem().toString();
		String strMonth = (String)month.getSelectedItem().toString();
		
		
		strDate.append(strYear);
		strDate.append("-");
		strDate.append(strMonth);
		strDate.append("-");
		strDate.append(strDay);
		
		return strDate.toString();
	}
	
}

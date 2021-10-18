package view;

import java.awt.GridLayout;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.text.DateFormat;

import controller.DateController;

public class Date extends JPanel{
	
	private MonthComboBox<String> month;
	private DayComboBox<String> day;
	private YearTextField year;
	private DateController controller;
	private HashMap<Integer,JComponent> dateComponents;
	
	
	public Date() {
		super();
		this.setLayout(new GridLayout(0,3));
		controller = new DateController();
		this.month = new MonthComboBox<String>(controller.getMonthData());
		this.day = new DayComboBox<String>(controller.getDayData());
		this.year = new YearTextField("Year",4);
		
		this.add(month);
		this.add(day);
		this.add(year);
		this.allocateComponents();
		
		
	}
	
	private void allocateComponents() {
		dateComponents = new HashMap<Integer, JComponent>();
		dateComponents.put(0, year);
		dateComponents.put(1, day);
		dateComponents.put(2, month);
		controller.allocateComponents(dateComponents);
		
	}
	
	public boolean valid() {
		
		return controller.valid();
	}
	
	public String getErrorMsg() {
		return controller.getErrorMsg();
	}
	
	public void reset() {
		year.setText("");
		month.setSelectedIndex(0);
		day.setSelectedIndex(0);
	}
	
	public void setText(Object paramDate) {
		String rawDate = paramDate.toString();
		String[] date = rawDate.split("-");
		
		year.setText(date[0]);
		month.setSelectedItem(date[1]);
		day.setSelectedItem(date[2]);
		
	}
	
	public String getText() {
		return controller.getText();
	}
	
	public void setDefaultBorder() {
		month.setDefaultBorder();
		day.setDefaultBorder();
		year.setDefaultBorder();
	}

}

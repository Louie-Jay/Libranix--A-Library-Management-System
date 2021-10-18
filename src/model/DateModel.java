package model;

public class DateModel {

	
	FileDataModel filedata;
	
	public DateModel() {
		
	}
	
	public String[] getMonthData() {
		this.filedata = new FileDataModel("month.data");
		return this.filedata.getArrayStringData();
	}
	
	public String[] getDayData() {
		this.filedata = new FileDataModel("day.data");
		return this.filedata.getArrayStringData();
	}
	
}

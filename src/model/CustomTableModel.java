package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel{
	
	private DatabaseConnection db;
	private String defaultquery;
	private ResultSet rsData;
	private ResultSetMetaData rsmd;
	
	private Vector<Object> row;
	
	public CustomTableModel() {
		defaultquery = "SELECT * FROM librarydatabase.tbl_bookdetails";
		initializeDatabase();
		rsData = db.getResult();
		try {
			rsmd = rsData.getMetaData();
			
			//set table column
			int columnCount = rsmd.getColumnCount();
			for (int col = 1; col <= columnCount; col++) {
				this.addColumn(rsmd.getColumnName(col));
			}
			
			//set table row
			while (rsData.next()) {
				row = new Vector<Object>();
				for (int col = 1; col <= columnCount; col++) {
					row.add(rsData.getObject(col));
				}
				this.addRow(row);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		
		this.closeDatabase();
	}
	
	public CustomTableModel(String paramQuery) {
		initializeDatabase(paramQuery);
		rsData = db.getResult();
		try {
			rsmd = rsData.getMetaData();
			
			//set table column
			int columnCount = rsmd.getColumnCount();
			for (int col = 1; col <= columnCount; col++) {
				this.addColumn(rsmd.getColumnName(col));
			}
			
			//set table row
			while (rsData.next()) {
				row = new Vector<Object>();
				for (int col = 1; col <= columnCount; col++) {
					row.add(rsData.getObject(col));
				}
				this.addRow(row);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		
		this.closeDatabase();
	}
	
	public CustomTableModel(ArrayList<String> paramCol) {
		defaultquery = "SELECT * FROM librarydatabase.tbl_bookdetails";
		initializeDatabase(defaultquery);
		rsData = db.getResult();
		try {
			rsmd = rsData.getMetaData();
			
			//set table column
			int columnCount = rsmd.getColumnCount();
			for (int col = 1; col <= columnCount; col++) {
				this.addColumn(paramCol.get(col-1));
			}
			
			//set table row
			while (rsData.next()) {
				row = new Vector<Object>();
				for (int col = 1; col <= columnCount; col++) {
					row.add(rsData.getObject(col));
				}
				this.addRow(row);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		
		this.closeDatabase();
	}
	
	public CustomTableModel(ArrayList<String> paramCol,String paramQuery) {
		initializeDatabase(paramQuery);
		rsData = db.getResult();
		try {
			rsmd = rsData.getMetaData();
			
			//set table column
			int columnCount = rsmd.getColumnCount();
			for (int col = 1; col <= columnCount; col++) {
				this.addColumn(paramCol.get(col-1));
			}
			
			//set table row
			while (rsData.next()) {
				row = new Vector<Object>();
				for (int col = 1; col <= columnCount; col++) {
					row.add(rsData.getObject(col));
				}
				this.addRow(row);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		
		this.closeDatabase();
	}
	
	public void initializeDatabase() {
		db = new DatabaseConnection();
		db.connectDatabase();
		db.setQuery(defaultquery);
		db.executeQuery();
	}
	
	public void initializeDatabase(String query) {
		db = new DatabaseConnection();
		db.connectDatabase();
		db.setQuery(query);
		db.executeQuery();
	}
	
	public void closeDatabase() {
		db.closeDatabase();
	}
	

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

}

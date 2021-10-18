package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class R_DashboardModel {
	
	private DatabaseConnection db;
	
	public R_DashboardModel() {
		db = new DatabaseConnection();
	}
	
	public int getBkCount() {
		db = new DatabaseConnection();
		String sql = "SELECT tbl_bookquantity.col_BookQuantity FROM librarydatabase.tbl_bookquantity;";// total books
		db.connectDatabase();
		
		db.setQuery(sql);
		
		db.executeQuery();
		ResultSet rs = db.getResult();
		int count = 0;
		try {
			while(rs.next()) {
				count += rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getMbrCount() {
		db = new DatabaseConnection();
		String sql = "SELECT COUNT(1) FROM librarydatabase.tbl_memberdetails INNER JOIN librarydatabase.tbl_membercontacts ON tbl_memberdetails.col_MemberId = tbl_membercontacts.col_MemberId;"; // membercount
		
		db.connectDatabase();
		
		db.setQuery(sql);
		
		db.executeQuery();
		ResultSet rs = db.getResult();
		int rows = 0;
		try {
			rs.next();
			rows = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
}

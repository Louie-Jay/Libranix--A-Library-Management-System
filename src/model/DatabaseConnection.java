package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnection {
	
	static final String user = "root";
	static final String pass = "1234";
	static final String dbURL = "jdbc:mysql://localhost:3333/librarydatabase"; // port: 3333
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "";
	
	public DatabaseConnection() {}
	
	public void connectDatabase() {
		try {
			conn = DriverManager.getConnection(dbURL, user, pass);
			System.out.println("Connection Established...");
			
		} catch (SQLException e) {
			System.out.println("Connection Error: " + e.getMessage());
		}
	}
	
	public void setQuery(String query) {
		this.sql = query;
	}
	
	public boolean executeQuery() {
		try {
			this.stmt = conn.createStatement();
			this.rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			try {
				
				this.stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				
			} catch (SQLException e1) {
				System.out.println("Query Execution failed. "+e1.getMessage());
				return false;
			}
			
		}
		return true;
	}
	
	public ResultSet getResult() {
		
		return this.rs;
	}
	
	public boolean executeMultiQuery(ArrayList<String> queries) {
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			
			for(String query: queries) {
				stmt.executeUpdate(query);
			}
			conn.commit();
		} catch (SQLException sqlEx1) {
			try {
				conn.rollback();
			} catch (SQLException sqlEx2) {
				System.out.println("DB: Rollback failed. Code 2:\n"+sqlEx2.getMessage());
				return false;
			}
			System.out.println("DB: Multi commit failed. Code 1:\n"+sqlEx1.getMessage());
			return false;
		}
		
		try {
			if(!conn.getAutoCommit()) {
				conn.setAutoCommit(true);
			}
		} catch (SQLException sqlEx3) {
			System.out.println("DB: Multi commit failed. Code 3:\n"+sqlEx3.getMessage());
			return false;
		}
		return true;
	}
	
	
	public void closeDatabase() {
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Closing ResultSet failed."+e.getMessage());;
			}
		}
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Closing Statement failed"+e.getMessage());
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Closing Connection failed"+e.getMessage());
			}
		}
		System.out.println("Connection Closed.");
	}

}

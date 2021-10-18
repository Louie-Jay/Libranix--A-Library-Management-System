package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class DatabaseConnection {
	
	static final String user = "root";
	static final String pass = "root";
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
	
	public void executeQuery() {
		try {
			this.stmt = conn.createStatement();
			this.rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			//System.out.println("Query Execution failed. "+e.getMessage());
			try {
				
				this.stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				
			} catch (SQLException e1) {
				System.out.println("Query Execution failed. "+e1.getMessage());
			}
			
		}
		//closeDatabase();
	}
	
	public ResultSet getResult() {
		
		return this.rs;
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

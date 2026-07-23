package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnection {
	
	// Cross-platform: credentials loaded from data/db.properties with sensible defaults
	private static String user = "root";
	private static String pass = "123456";
	private static String dbURL = "jdbc:mysql://localhost:3306/librarydatabase?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private static boolean configLoaded = false;
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "";
	
	public DatabaseConnection() {
		loadConfig();
	}
	
	/**
	 * Load database configuration from data/db.properties.
	 * Falls back to hardcoded defaults if the file is missing or unreadable.
	 */
	private static void loadConfig() {
		if (configLoaded) return;
		configLoaded = true;
		
		java.io.File configFile = new java.io.File("data", "db.properties");
		if (!configFile.exists()) {
			System.out.println("DB Config: data/db.properties not found, using defaults.");
			return;
		}
		
		try (java.io.FileInputStream fis = new java.io.FileInputStream(configFile)) {
			java.util.Properties props = new java.util.Properties();
			props.load(fis);
			
			String url = props.getProperty("db.url");
			String usr = props.getProperty("db.user");
			String pwd = props.getProperty("db.password");
			
			if (url != null && !url.trim().isEmpty()) dbURL = url.trim();
			if (usr != null && !usr.trim().isEmpty()) user = usr.trim();
			if (pwd != null && !pwd.trim().isEmpty()) pass = pwd.trim();
			
			System.out.println("DB Config: loaded from data/db.properties");
		} catch (Exception e) {
			System.out.println("DB Config: failed to read data/db.properties, using defaults. (" + e.getMessage() + ")");
		}
	}
	
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
			// Detect query type: use executeQuery for SELECT, executeUpdate for INSERT/UPDATE/DELETE
			String trimmedSql = sql.trim().toUpperCase();
			if (trimmedSql.startsWith("SELECT")) {
				this.rs = stmt.executeQuery(sql);
			} else {
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			System.out.println("Query Execution failed. " + e.getMessage());
			return false;
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

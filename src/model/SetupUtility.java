package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * One-time setup utility to:
 * 1. Read the existing AES key from data/Libranix.data
 * 2. Encrypt a default password
 * 3. Create tbl_accountlogin table and insert default admin user
 * 
 * Run this once before launching the main application.
 */
public class SetupUtility {

    // ---------- CONFIGURE THESE ----------
    static final String DEFAULT_USERNAME = "admin";
    static final String DEFAULT_PASSWORD = "admin";    // <-- change if you want
    static final String DEFAULT_EMAIL    = "admin@libranix.com";

    // MySQL connection — loaded from data/db.properties (matches DatabaseConnection)
    private static String DB_USER = "root";
    private static String DB_PASS = "123456";
    private static String DB_URL  = "jdbc:mysql://localhost:3306/librarydatabase?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    
    static {
        java.io.File configFile = new java.io.File("data", "db.properties");
        if (configFile.exists()) {
            try (java.io.FileInputStream fis = new java.io.FileInputStream(configFile)) {
                java.util.Properties props = new java.util.Properties();
                props.load(fis);
                String url = props.getProperty("db.url");
                String usr = props.getProperty("db.user");
                String pwd = props.getProperty("db.password");
                if (url != null && !url.trim().isEmpty()) DB_URL = url.trim();
                if (usr != null && !usr.trim().isEmpty()) DB_USER = usr.trim();
                if (pwd != null && !pwd.trim().isEmpty()) DB_PASS = pwd.trim();
            } catch (Exception e) {
                System.out.println("SetupUtility: using default DB config (" + e.getMessage() + ")");
            }
        }
    }
    // -------------------------------------

    public static void main(String[] args) {
        try {
            // 1. Load the AES key from the local data file
            System.out.println("=== Libranix Login Setup ===");
            ReadFile read = new ReadFile("Libranix.data");
            String hexKey = read.readProperties();
            System.out.println("AES Key loaded from data/Libranix.data: " + hexKey);

            // 2. Encrypt the default password
            AESEncryption aes = new AESEncryption();
            aes.setKey(aes.loadKey(hexKey));
            String encryptedPassword = aes.encrypt(DEFAULT_PASSWORD);
            System.out.println("Username       : " + DEFAULT_USERNAME);
            System.out.println("Plain password : " + DEFAULT_PASSWORD);
            System.out.println("Encrypted      : " + encryptedPassword);

            // 3. Print SQL (fallback for manual execution)
            String createTableSQL =
                "CREATE TABLE IF NOT EXISTS `tbl_accountlogin` (\n" +
                "  `col_AccountId`       INT NOT NULL AUTO_INCREMENT,\n" +
                "  `col_AccountUsername` VARCHAR(50) NOT NULL,\n" +
                "  `col_AccountPassword` VARCHAR(255) NOT NULL,\n" +
                "  `col_AccountEmail`    VARCHAR(254) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`col_AccountId`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

            String insertSQL =
                "INSERT INTO `tbl_accountlogin` " +
                "(`col_AccountUsername`, `col_AccountPassword`, `col_AccountEmail`) " +
                "VALUES ('" + DEFAULT_USERNAME + "', '" + encryptedPassword + "', '" + DEFAULT_EMAIL + "');";

            System.out.println("\n--- SQL (run manually if auto-insert fails) ---");
            System.out.println(createTableSQL);
            System.out.println(insertSQL);

            // 4. Try to execute directly via JDBC
            System.out.println("\n--- Attempting direct database insert ---");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                Statement stmt = conn.createStatement();

                stmt.executeUpdate(createTableSQL);
                System.out.println("Table 'tbl_accountlogin' created (or already exists).");

                stmt.executeUpdate(insertSQL);
                System.out.println("Default user inserted successfully!");

                stmt.close();
                conn.close();
                System.out.println("Database setup complete. You can now log in with:");
                System.out.println("  Username: " + DEFAULT_USERNAME);
                System.out.println("  Password: " + DEFAULT_PASSWORD);

            } catch (Exception dbEx) {
                System.out.println("Direct insert failed: " + dbEx.getMessage());
                System.out.println("Please run the SQL above manually in your MySQL client.");
                dbEx.printStackTrace();
            }

        } catch (Exception e) {
            System.err.println("Setup failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

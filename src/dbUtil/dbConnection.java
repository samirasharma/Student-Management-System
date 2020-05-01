/*
package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnection {
//	private static final String USERNAME = "dbuser";
//	private static final String PASSWORD = "dbpassword";
	private static final String CONN = "jdbc:sqlserver://LAPTOP-SAMU\\MSSQLSERVER;databaseName=schoolsystem;integratedSecurity=true;";
		
	public static void getConnection() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("command completed successfully");
			DriverManager.getConnection(CONN);
			//Statement stmt  = CONN.createStatement();
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
				
	}
}
*/
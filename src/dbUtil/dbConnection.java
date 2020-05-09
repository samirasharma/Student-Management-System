
package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class dbConnection {
	final static String url = "jdbc:sqlserver://LAPTOP-SAMU\\MSSQLSERVER:1433;" + "databaseName=SCHOOLDB;integratedSecurity=true;";		
	public static Connection getConnection() throws SQLException {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("command completed successfully");
			Connection connection1 = DriverManager.getConnection(url,"","");
			System.out.println("Connection made!");
            System.out.println("Schema Name:"+connection1.getSchema()+"\n");
            return connection1;
//			try {
//				System.out.println("inside try--------");		
//				Connection connection = DriverManager.getConnection(url,"","");
//				//JOptionPane.showMessageDialog(null, "Connected");
//
//				Statement stmt = connection.createStatement();
//				ResultSet rs = stmt.executeQuery("SELECT * from SCHOOLDB.dbo.Student");
//				while (rs.next()) {
//					  String lastName = rs.getString("S_name");
//					  System.out.println(lastName + "\n");
//					}
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace(); 
//			}
			
			//Statement stmt  = CONN.createStatement();
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
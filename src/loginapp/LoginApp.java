package loginapp;

import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = (Parent)FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("School Management System");
		stage.show();
	}
	
	public static void main(String [] args) {
		//launch (args);
		final String url = "jdbc:sqlserver://LAPTOP-SAMU\\MSSQLSERVER:1433;" + "databaseName=schoolsystem;integratedSecurity=true;";
//        String CONN = "jdbc:sqlserver://LAPTOP-LPQE1URE;";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("command completed successfully");
			try {
				System.out.println("inside try--------");
//				Connection con = DriverManager.getConnection(CONN);
				
				Connection connection = DriverManager.getConnection(url,"","");
				JOptionPane.showMessageDialog(null, "Connected");

				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * from testdb.dbo.Person");
				while (rs.next()) {
					  String lastName = rs.getString("LastName");
					  System.out.println(lastName + "\n");
					}
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
			
			//Statement stmt  = CONN.createStatement();
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
	}
	

}

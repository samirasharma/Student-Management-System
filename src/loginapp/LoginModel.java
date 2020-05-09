package loginapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbUtil.dbConnection;

public class LoginModel {
	Connection connection;
	
	public LoginModel() {
		try {
			this.connection = dbConnection.getConnection();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
		if(this.connection== null) {
			System.out.println("inside null----------------");
			System.exit(1);
		}
		
	}
	
	public boolean isDatabaseConnected() {
		System.out.println("inside isdatabaseconnected");
		return this.connection !=null;
	}
	
	public boolean isLogin(String user, String pass, String opt) throws Exception
	{
		System.out.println("inside islogin");
		
//		try {
//		System.out.println("inside try--------");		
//		Connection connection = DriverManager.getConnection(url,"","");
//		//JOptionPane.showMessageDialog(null, "Connected");
//
//		Statement stmt = connection.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * from SCHOOLDB.dbo.Student");
//		while (rs.next()) {
//			  String lastName = rs.getString("S_name");
//			  System.out.println(lastName + "\n");
//			}
//		connection.close();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace(); 
//	}
		PreparedStatement pr = null;
		ResultSet rs = null;
		String sql = "SELECT * from login where username = ? and password = ? and level = ?";
		try {
			System.out.println("inside try");
			//Statement stmt = this.connection.createStatement();
			pr = this.connection.prepareStatement(sql);
			pr.setString( 1, user);
			pr.setString(2, pass);
			pr.setString(3, opt);
			
			rs = pr.executeQuery();
			boolean bool1;
//			while (rs.next()) {
//				  String lastName = rs.getString("username");
//				  System.out.println(lastName + "\n");
//				}
			if(rs.next()) {
				System.out.println("inside rs next");
				return true;
			}
//				return false;
		}catch(SQLException ex) {
			return false;
		}
		finally {
			pr.close();
			rs.close();
		}
		return false;
	}
	

}

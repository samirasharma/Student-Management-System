package loginapp;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		//Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("loggin.fxml"));
//		getClass().getClassLoader().getResource("ui_layout.fxml")

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("School Management System");
		stage.show();
	}
	
	public static void main(String [] args) {
		launch (args);
		
		
	}
	

}

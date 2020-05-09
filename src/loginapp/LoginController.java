package loginapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import admin.AdminController;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import students.StudentController;

public class LoginController implements Initializable{
	LoginModel loginModel = new LoginModel();

	@FXML
	private Label dbstatus; 
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private ComboBox<option> combobox;
	@FXML
	private Button loginbutton;
	@FXML
	private Label loginstatus;
	
	public void initialize(URL url, ResourceBundle rb) {
		
		if(this.loginModel.isDatabaseConnected()) {
			this.dbstatus.setText("Connected to Database");
		}else {
			this.dbstatus.setText("Not Connected to Database");
		}
		this.combobox.setItems(FXCollections.observableArrayList(option.values()));
		
	}
	@FXML
	public void Login(ActionEvent event) {
		try {
			if(this.loginModel.isLogin(this.username.getText(),this.password.getText(),((option)this.combobox.getValue()).toString()))
			{
				Stage stage = (Stage)this.loginbutton.getScene().getWindow();
				stage.close();
				switch(((option)this.combobox.getValue()).toString()) {
				case "Admin":
					System.out.println("inside admin"+this.combobox.getValue().toString());
					adminLogin();
					break;
				case "Student":
					System.out.println("inside student"+this.combobox.getValue().toString());
					studentLogin();
					break;
				}
			}
			else {
				this.loginstatus.setText("Wrong Credentials");
			}
		}catch(Exception localException) {
			
		}
		
	}
	public void studentLogin() {
		try {
//			System.out.println("inside student login");
//			Stage userstage = new Stage();
//			FXMLLoader loader = new FXMLLoader();
//			Pane root = (Pane)loader.load(getClass().getClassLoader().getResource("/students/studentFXML.fxml").openStream());
//			StudentController studentController = (StudentController)loader.getController();
//			Scene scene = new Scene(root);
//			userstage.setScene(scene);
//			userstage.setTitle("Student Dashboard");
//			userstage.setResizable(false);
//			userstage.show();
			System.out.println("inside student login");
			Stage userstage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/students/studentFXML.fxml"));
			FXMLLoader studentloader = new FXMLLoader();
			StudentController adminController = (StudentController)studentloader.getController();
			Scene scene = new Scene(root);
			userstage.setScene(scene);
			userstage.setTitle("Student Dashboard");
			userstage.setResizable(false);
			userstage.show();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
	public void adminLogin() {
		try {
//			System.out.println("inside admin login");
//			Stage adminstage = new Stage();
//			FXMLLoader adminLoader = new FXMLLoader();
//			Parent adminroot = adminLoader.load(getClass().getClassLoader().getResource("/admin/admin.fxml").openStream());
//			AdminController adminController = (AdminController)adminLoader.getController();
//			Scene scene = new Scene(adminroot);
//			adminstage.setScene(scene);
//			adminstage.setTitle("Admin Dashboard");
//			adminstage.setResizable(false);
//			adminstage.show();
			
			
			
			System.out.println("inside admin login");
			Stage adminstage = new Stage();
			Parent adminroot = FXMLLoader.load(getClass().getResource("/admin/admin.fxml"));
			FXMLLoader adminLoader = new FXMLLoader();
			AdminController adminController = (AdminController)adminLoader.getController();
			Scene scene = new Scene(adminroot);
			adminstage.setScene(scene);
			adminstage.setTitle("Admin Dashboard");
			adminstage.setResizable(false);
			adminstage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}

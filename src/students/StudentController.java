package students;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import students.CourseData;
import dbUtil.dbConnection;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class StudentController implements Initializable {
	@FXML
	private TableView<CourseData>coursetable;
	@FXML
	private TableColumn<CourseData,String> coursenocolumn;
	@FXML
	private TableColumn<CourseData,String> secnocolumn;
	@FXML
	private TableColumn<CourseData,String> capacitycolumn;
	@FXML
	private TableColumn<CourseData,String> registeredcolumn;
	@FXML
	private TableColumn<CourseData,String> remainingcolumn;
	@FXML
	private TableColumn<CourseData,String> classdaycolumn;
	@FXML
	private TableColumn<CourseData,String> classtimecolumn;
	@FXML
	private TableColumn<CourseData,String> instructorcolumn;

	private dbConnection dc;
	private ObservableList<CourseData> data;	
	int Registered = 0;
	int registeredtotalno=0;
	int remainingno;
	public void initialize(URL url, ResourceBundle rb) {
		this.dc = new dbConnection();
	}
	
	@FXML
	private void loadStudentData(ActionEvent event) throws SQLException{
		//loaddatafromdb();
		try {
			System.out.println("inside try of load data from dab============");
			String sql = "Select Se.Sec_no,Se.Course_code, Se.Max_enroll,Se.Weekday,Se.Class_time,St.Staff_name from Section Se, Staff St where Se.Instructor_ssn = St.Staff_ssn;";
			System.out.println("inside load student data in student tab");
			Connection conn = dbConnection.getConnection();
			this.data = FXCollections.observableArrayList();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			//remainingno = Integer.parseInt(rs.getString(3)) - registeredtotalno;
			while(rs.next()) {
				System.out.println(rs.getString(2)+rs.getString(1)+rs.getString(3)+String.valueOf(registeredtotalno)+rs.getString(3)+rs.getString(4)+rs.getString(5)+rs.getString(6));
				remainingno = Integer.parseInt(rs.getString(3)) - registeredtotalno;
				this.data.add(new CourseData(rs.getString(2),rs.getString(1),rs.getString(3),String.valueOf(registeredtotalno),String.valueOf(remainingno),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
			
		}catch(SQLException ex){
			
			System.err.println("Error"+ex);
			
		}
		
		this.coursenocolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("coursecode"));
		this.secnocolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("seccode"));
		this.capacitycolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("capacity"));
		this.registeredcolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("registered"));
		this.remainingcolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("remaining"));
		this.classdaycolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("classday"));
		this.classtimecolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("classtime"));
		this.instructorcolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("instructor"));
		this.coursetable.setItems(this.data);
		
		
		
	}
	@FXML
	private void registerCourse(ActionEvent event) throws SQLException{
		String dbcoursecode,dbsectionno,studentname, registeredcourseno;
		ObservableList<CourseData> coursedata1;
		coursedata1 = coursetable.getSelectionModel().getSelectedItems();
		System.out.println(coursedata1.get(0).getCoursecode());
		dbcoursecode = coursedata1.get(0).getCoursecode();
		dbsectionno = coursedata1.get(0).getSeccode();
		//registeredtotalno= Integer.parseInt(coursedata1.get(0).getRegistered());
		//remainingno= Integer.parseInt(coursedata1.get(0).getRemaining());
		studentname="62967203";
		String sqlinsert = "Insert into Registration(S_id,Sec_no,Course_code) VALUES (?,?,?)";
		if(Registered<=3) {
		
			try {
				Connection c = dbConnection.getConnection();
				PreparedStatement stmt = c.prepareStatement(sqlinsert);
				stmt.setString(1, studentname);
				stmt.setString(2, dbsectionno);
				stmt.setString(3, dbcoursecode);
				stmt.execute();
				Registered++;
				System.out.println("registered course number ="+Registered);
				registeredtotalno++;
				//remainingno--;
				Alert alert = new Alert(AlertType.INFORMATION);
				String contentText = String.format("Registration Successful");
				alert.setContentText(contentText);
		        alert.showAndWait();
				c.close();	
				//loaddatafromdb();
					
				
				}catch(SQLException ex) {
				
					System.err.println("SQL Error"+ex);
					alertErrorMessage("User cannot register same course multiple times");			
				}
		}else {
			alertErrorMessage("User cannot register more than 3 courses");
		}
		
	}
	
	public void alertErrorMessage(String s) {
		Alert alert = new Alert(AlertType.ERROR);
		String contentText = String.format(s);
		alert.setContentText(contentText);
                  alert.showAndWait();

	}
	
	public void loaddatafromdb() {
		System.out.println("inside load data from db========================");
		
		try {
			System.out.println("inside try of load data from dab============");
			String sql = "Select Se.Sec_no,Se.Course_code, Se.Max_enroll,Se.Weekday,Se.Class_time,St.Staff_name from Section Se, Staff St where Se.Instructor_ssn = St.Staff_ssn;";
			System.out.println("inside load student data in student tab");
			Connection conn = dbConnection.getConnection();
			this.data = FXCollections.observableArrayList();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			System.out.println("values of rs------------------------------------");
			System.out.println(rs.toString());
			remainingno = Integer.parseInt(rs.getString(3)) - registeredtotalno;
			while(rs.next()) {
				System.out.println("inside rs next");
				System.out.println(rs.getString(2)+rs.getString(1)+rs.getString(3)+String.valueOf(registeredtotalno)+rs.getString(3)+rs.getString(4)+rs.getString(5)+rs.getString(6));
				this.data.add(new CourseData(rs.getString(2),rs.getString(1),rs.getString(3),String.valueOf(registeredtotalno),String.valueOf(remainingno),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
			
		}catch(SQLException ex){
			
			System.err.println("Error"+ex);
			
		}
		
		this.coursenocolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("coursecode"));
		this.secnocolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("seccode"));
		this.capacitycolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("capacity"));
		this.registeredcolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("registered"));
		this.remainingcolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("remaining"));
		this.classdaycolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("classday"));
		this.classtimecolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("classtime"));
		this.instructorcolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("instructor"));
		this.coursetable.setItems(this.data);
		
		
	}
	

}

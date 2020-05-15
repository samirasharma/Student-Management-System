package admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import students.CourseData;

public class AdminController implements Initializable{
	
	@FXML
	private TableView<StudentData>studenttable;
	@FXML
	private TableColumn<StudentData,String> coursecodecolumn;
	@FXML
	private TableColumn<StudentData,String> seccodecolumn;
	@FXML
	private TableColumn<StudentData,String> coursenamecolumn;
	@FXML
	private TableColumn<StudentData,String> timecolumn;
	@FXML
	private TableColumn<StudentData,String> placecolumn;
	@FXML
	private TableColumn<StudentData,String> weekdaycolumn;
	@FXML
	private TableColumn<StudentData,String> instructorcolumn;
	
	@FXML
	private TableView<StudentRecordData>studentrecordtable;
	@FXML
	private TableColumn<StudentRecordData,String> lastnamecolumn;
	@FXML
	private TableColumn<StudentRecordData,String> firstnamecolumn;
	@FXML
	private TableColumn<StudentRecordData,String> idcolumn;
	@FXML
	private TableColumn<StudentRecordData,String> majorcolumn;
	@FXML
	private TableColumn<StudentRecordData,String> yearcolumn;

	private dbConnection dc;
	private ObservableList<StudentData> data;	
	private ObservableList<StudentRecordData> studentrecord;	

	private String sql = "Select Sr.Course_code,Sr.Sec_no, Course_name,Sr.Time,Sr.Building_id, Sr.Build_room_no, Sr.Weekday,St.Staff_name\r\n" + 
			"from SectionRoom Sr, Course C,Section Se, Staff St \r\n" + 
			"where Sr.Course_code = Se.Course_code and Sr.Sec_no=Se.Sec_no and Se.Course_code = C.Course_code and Se.Instructor_ssn = St.Staff_ssn;";
	
	public void initialize(URL url, ResourceBundle rb) {
		this.dc = new dbConnection();
	}
	
	@FXML
	private void loadStudentData(ActionEvent event) throws SQLException{
		try {
			System.out.println("inside load student data in admin tab");
			Connection conn = dbConnection.getConnection();
			this.data = FXCollections.observableArrayList();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				System.out.println("Query result is---------------");
				System.out.println(rs.getString(1)+ rs.getString(2)+ rs.getString(3)+ rs.getString(4)+ rs.getString(5)+ rs.getString(6));
				this.data.add(new StudentData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)+rs.getString(6),rs.getString(7),rs.getString(8)));
			}
		
		}catch(SQLException ex){
			
			System.err.println("Error"+ex);
			
		}
		
		this.coursecodecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("coursecode"));
		this.seccodecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("seccode"));
		this.coursenamecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("coursename"));
		this.timecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("time"));
		this.placecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("place"));
		this.weekdaycolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("weekday"));
		this.instructorcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("instructor"));
		this.studenttable.setItems(this.data);
		
	}
	
	@FXML
	private void loadStudentsforCourse(ActionEvent event) throws SQLException{
				
		ObservableList<StudentData> studenttable1;
		studenttable1 = studenttable.getSelectionModel().getSelectedItems();
		String selectedcoursecode = studenttable1.get(0).getCoursecode();
		String selectedsectionno = studenttable1.get(0).getSeccode();
		System.out.println(studenttable1.get(0).getCoursecode());
		String dbcoursecode, dbsectionno,dbcoursesection,uicoursesection;
		uicoursesection = selectedcoursecode.concat(selectedsectionno);
		//this.studentrecord = FXCollections.observableArrayList();
		String sqlquery = "Select * from Student, Registration where Student.Student_id = Registration.S_id; ";
		
		try {
				System.out.println("inside load student data for course");
				Connection conn = dbConnection.getConnection();
				this.studentrecord = FXCollections.observableArrayList();
				ResultSet rs = conn.createStatement().executeQuery(sqlquery);
				while(rs.next()) {
					dbcoursesection = rs.getString(10).concat(rs.getString(9));
					System.out.println("Printing result-----after concating data from db----------"+dbcoursesection+"-------------------"+uicoursesection);

					if(uicoursesection.equalsIgnoreCase(dbcoursesection)) {				
						 int spaceBetweenFirstAndLastName = rs.getString(3).indexOf(" ");
						 String firstName = rs.getString(3).substring(0, spaceBetweenFirstAndLastName);
						 String lastName = rs.getString(3).substring(spaceBetweenFirstAndLastName+1);
						 
						 //Now, swap the first and last name and put it back into the array
						 System.out.println("inside swap last name and first name"+lastName+firstName);	
						 System.out.println("final test before putting into table"+"-------"+lastName+firstName+rs.getString(1)+rs.getString(7)+rs.getString(4));
						 this.studentrecord.add(new StudentRecordData(lastName,firstName,rs.getString(1),rs.getString(7),rs.getString(4)));				
						 }
			}
		
		}catch(SQLException ex){
			
			System.err.println("Error"+ex);
			
		}
		
		this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory<StudentRecordData, String>("lastname"));
		this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory<StudentRecordData, String>("firstname"));
		this.idcolumn.setCellValueFactory(new PropertyValueFactory<StudentRecordData, String>("id"));
		this.majorcolumn.setCellValueFactory(new PropertyValueFactory<StudentRecordData, String>("major"));
		this.yearcolumn.setCellValueFactory(new PropertyValueFactory<StudentRecordData, String>("year"));
		this.studentrecordtable.setItems(this.studentrecord);

		
	}
	
	
	
}

	


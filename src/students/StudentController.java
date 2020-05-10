package students;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import students.CourseData;
import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
	private TableColumn<CourseData,String> instructorcolumn;
//	@FXML
//	private TableColumn<StudentData,String> studentcolumn;

	private dbConnection dc;
	private ObservableList<CourseData> data;	
	private String sql = "SELECT * FROM SCHOOLDB.dbo.SectionRoom";

	
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
				//this.data.add(new StudentData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
				this.data.add(new CourseData(rs.getString(4),rs.getString(3),rs.getString(6),rs.getString(2),rs.getString(5),"vincent"));

			}
			
		}catch(SQLException ex){
			
			System.err.println("Error"+ex);
			
		}
		
		this.coursenocolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("coursecode"));
		this.secnocolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("seccode"));
		this.capacitycolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("coursename"));
		this.registeredcolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("time"));
		this.remainingcolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("place"));
		this.instructorcolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("instructor"));
//		this.studentcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("student"));
		
		//this.studenttable.setItems(null);
		this.coursetable.setItems(this.data);
		
	}

}

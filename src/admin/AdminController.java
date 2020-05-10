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

	private dbConnection dc;
	private ObservableList<StudentData> data;	
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
				this.data.add(new StudentData(rs.getString(4),rs.getString(3),"abc",rs.getString(6),rs.getString(2),rs.getString(5),"vincent"));
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

	
}

package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentRecordData {
	private final StringProperty lastname;
	private final StringProperty firstname;
	private final StringProperty id;
	private final StringProperty major;
	private final StringProperty year;


	public StringProperty LastnameProperty() {
		return lastname;
	}

	public StringProperty FirstnameProperty() {
		return firstname;
	}

	public StringProperty IdProperty() {
		return id;
	}

	public StringProperty MajorProperty() {
		return major;
	}

	public StringProperty YearProperty() {
		return year;
	}
	
	public void setLastname(String lastname) {
		this.lastname.set(lastname);
	}
	
	public void setFirstname(String firstname) {
		this.firstname.set(firstname);
		}

	public void setId(String id) {
		this.id.set(id);
	}

	public void setMajor(String major) {
		this.major.set(major);
	}

	public void setYear(String year) {
		this.year.set(year);
	}
	
	public String getLastname() {
		return lastname.get();
	}
	
	public String getFirstname() {
		return firstname.get();
	}

	public String getId() {
		return id.get();
	}

	public String getMajor() {
		return major.get();
	}

	public String getYear() {
		return year.get();
	}

	public StudentRecordData(String lastname, String firstname,String id, String major, String year) {
		
		this.lastname = new SimpleStringProperty(lastname);
		this.firstname = new SimpleStringProperty(firstname);

		this.id = new SimpleStringProperty(id);

		this.major = new SimpleStringProperty(major);

		this.year = new SimpleStringProperty(year);


	}

}

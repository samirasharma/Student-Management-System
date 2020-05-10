package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentData {
	
	private final StringProperty coursecode;
	private final StringProperty seccode;
	private final StringProperty coursename;
	private final StringProperty time;
	private final StringProperty place;
	private final StringProperty weekday;
	private final StringProperty instructor;
//	private final StringProperty student;
	
	public StringProperty CoursecodeProperty() {
		return coursecode;
	}

	public StringProperty SeccodeProperty() {
		return seccode;
	}

	public StringProperty CoursenameProperty() {
		return coursename;
	}

	public StringProperty TimeProperty() {
		return time;
	}

	public StringProperty PlaceProperty() {
		return place;
	}

	public StringProperty WeekdayProperty() {
		return weekday;
	}

	public StringProperty InstructorProperty() {
		return instructor;
	}
	
	public void setCoursecode(String coursecode) {
		this.coursecode.set(coursecode);
	}
	
	public void setSeccode(String seccode) {
		this.seccode.set(seccode);
		}

	public void setCoursename(String coursename) {
		this.coursename.set(coursename);
	}

	public void setTime(String time) {
		this.time.set(time);
	}

	public void setPlace(String place) {
		this.place.set(place);
	}

	public void setWeekday(String weekday) {
		this.weekday.set(weekday);
	}

	public void setInstructor(String instructor) {
		this.instructor.set(instructor);
	}
	
	public String getCoursecode() {
		return coursecode.get();
	}
	
	public String getSeccode() {
		return seccode.get();
	}

	public String getCoursename() {
		return coursename.get();
	}

	public String getTime() {
		return time.get();
	}

	public String getPlace() {
		return place.get();
	}

	public String getWeekday() {
		return weekday.get();
	}

	public String getInstructor() {
		return instructor.get();
	}
//	public StringProperty getStudent() {
//		return student;
//	}
//	
//	public StudentData(String coursecode, String seccode,String coursename, String time, String place, String weekday, String instructor, String student) {
	public StudentData(String coursecode, String seccode,String coursename, String time, String place, String weekday, String instructor) {
	
		this.coursecode = new SimpleStringProperty(coursecode);
		this.seccode = new SimpleStringProperty(seccode);

		this.coursename = new SimpleStringProperty(coursename);

		this.time = new SimpleStringProperty(time);

		this.place = new SimpleStringProperty(place);

		this.weekday = new SimpleStringProperty(weekday);

		this.instructor = new SimpleStringProperty(instructor);

//		this.student = new SimpleStringProperty(student);

	}


}

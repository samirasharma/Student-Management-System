package students;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CourseData {
	private final StringProperty coursecode;
	private final StringProperty seccode;
	private final StringProperty capacity;
	private final StringProperty registered;
	private final StringProperty remaining;
	private final StringProperty instructor;
//	private final StringProperty student;
	
	public StringProperty CoursecodeProperty() {
		return coursecode;
	}

	public StringProperty SeccodeProperty() {
		return seccode;
	}

	public StringProperty CapacityProperty() {
		return capacity;
	}

	public StringProperty RegisteredProperty() {
		return registered;
	}

	public StringProperty RemainingProperty() {
		return remaining;
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

	public void setCapacity(String capacity) {
		this.capacity.set(capacity);
	}

	public void setRegistered(String registered) {
		this.registered.set(registered);
	}

	public void setRemaining(String remaining) {
		this.remaining.set(remaining);
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

	public String getCapacity() {
		return capacity.get();
	}

	public String getRegistered() {
		return registered.get();
	}

	public String getRemaining() {
		return remaining.get();
	}

	public String getInstructor() {
		return instructor.get();
	}
	
//	public StudentData(String coursecode, String seccode,String coursename, String time, String place, String weekday, String instructor, String student) {
	public CourseData(String coursecode, String seccode,String capacity, String registered, String remaining, String instructor) {
	
		this.coursecode = new SimpleStringProperty(coursecode);
		this.seccode = new SimpleStringProperty(seccode);

		this.capacity = new SimpleStringProperty(capacity);

		this.registered = new SimpleStringProperty(registered);

		this.remaining = new SimpleStringProperty(remaining);

		this.instructor = new SimpleStringProperty(instructor);

//		this.student = new SimpleStringProperty(student);

	}

}

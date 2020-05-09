package loginapp;

public enum option {
	Admin, Student;
	
	private option() {}
	
	private String value(){
		return name();
	}
	
	private static option fromvalue(String v) {
		return valueOf(v);
	}

}

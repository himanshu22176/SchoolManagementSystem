package model;

public class Teacher extends Person{
	
	private String subject;

	public String getsubject() {
		return subject;
	}

	public void setsubject(String subject) {
		this.subject = subject;
	}	
	
	@Override
	public String display() {
		
		return "ID: "+getId()+" Name: "+getName()+" subject: "+getsubject();

	}

}

package model;

public class Student extends Person{
	
	private double marks;

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	@Override
	public String display() {
		
		return "ID: "+getId()+" Name: "+getName()+" Marks: "+getMarks();

	}

}

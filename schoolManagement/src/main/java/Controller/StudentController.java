package Controller;

import java.util.ArrayList;


import Repositiry.StudentRepo;
import model.Student;

public class StudentController implements Controller <Student, Double> {
	private static StudentRepo sr= new StudentRepo();
	
	@Override
	public int add(int id, String name, Double marks) {
		Student s= new Student();
		s.setId(id);
		s.setName(name);
		s.setMarks(marks);
		
		if(marks<0 || marks>100)return 2;
		
		if(sr.getCountById(id)==0) {
			sr.add(s);
			return 0;
		}
		return sr.getCountById(id);
	}
	
	@Override
	public ArrayList<Student> getall() {
		return sr.getAll();
	}
	
	@Override
	public int delete(int id) {
		if(sr.getCountById(id)==0)return 1;
		else if(sr.getCountById(id)==1) {
			sr.delete(id);
			return 0;
		}
		else return-1;
	}
	
	@Override
	public Student findById(int id) {
		if(sr.getCountById(id)==1){
			return sr.findById(id);
		}
		return null;
	}
	
	@Override
	public int getCount() {
		return sr.getCount();
	}
	
	

}

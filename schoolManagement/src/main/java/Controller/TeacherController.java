package Controller;

import java.util.ArrayList;

import Repositiry.TeacherRepo;
import model.Teacher;

public class TeacherController implements Controller <Teacher , String>{
	private static TeacherRepo sr= new TeacherRepo();
	
	@Override
	public int add(int id, String name, String subject) {
		Teacher s= new Teacher();
		s.setId(id);
		s.setName(name);
		s.setsubject(subject);
		
		if(sr.getCountById(id)==0) {
			sr.add(s);
			return 0;
		}
		return sr.getCountById(id);
	}
	
	@Override
	public ArrayList<Teacher> getall() {
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
	public Teacher findById(int id) {
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

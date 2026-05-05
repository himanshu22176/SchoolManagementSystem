package Repositiry;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connPool.ConnectionPool;
import model.Student;

public class StudentRepo implements Repo<Student>{
	
	public static Connection con= ConnectionPool.getConnection();
	@Override
	public boolean add(Student s) {
		try{
			PreparedStatement ps= con.prepareStatement("Insert INTO STUDENT VALUES(?,?,?)");
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setDouble(3, s.getMarks());
			ps.execute();
			return true;
			
			
		}
		catch(SQLException e) {
			return false;
		}
	}
	
	@Override
	public ArrayList<Student> getAll(){
		try {
		Statement pr= con.createStatement();
		ResultSet rs= pr.executeQuery("SELECT * FROM STUDENT");
		ArrayList<Student> res= new ArrayList<Student>();
		while(rs.next()){
			Student s= new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setMarks(rs.getDouble(3));
			res.add(s);
		}
		return res;
		}
		catch (SQLException e) {
			return null;
		}
	}
	
	@Override
	public boolean delete(int id) {
		try {
		PreparedStatement pr= con.prepareStatement("DELETE from STUDENT where id= ? ");
		pr.setInt(1, id);
		pr.execute();
		return true;
		}
		catch (SQLException e) {
			return false;
		}
	}
	
	@Override
	public Student findById(int id) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("SELECT * from STUDENT where id= ? ");
			pr.setInt(1, id);
			ResultSet rs= pr.executeQuery();
			rs.next();
			Student s= new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setMarks(rs.getDouble(3));
			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int getCount() {
		try {
			CallableStatement cs= con.prepareCall("SELECT count_student()");
			ResultSet rs= cs.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}
	
	public int getCountById(int id) {
		
		try {
			CallableStatement cs= con.prepareCall("SELECT count_student_by_id(?)");
			cs.setInt(1, id);
			ResultSet r= cs.executeQuery();
			r.next();
			return r.getInt(1);
		} catch (SQLException e) {
			System.out.println("Idhar MC");
			e.printStackTrace();
			return -1;
		
		}
		
	}
	
	

}

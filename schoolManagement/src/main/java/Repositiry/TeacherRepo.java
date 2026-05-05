package Repositiry;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connPool.ConnectionPool;
import model.Teacher;

public class TeacherRepo implements Repo<Teacher>{
	
	public static Connection con= ConnectionPool.getConnection();
	@Override
	public boolean add(Teacher s) {
		try{
			PreparedStatement ps= con.prepareStatement("Insert INTO Teacher VALUES(?,?,?)");
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getsubject());
			ps.execute();
			return true;
			
			
		}
		catch(SQLException e) {
			return false;
		}
	}
	
	@Override
	public ArrayList<Teacher> getAll(){
		try {
		Statement pr= con.createStatement();
		ResultSet rs= pr.executeQuery("SELECT * FROM Teacher");
		ArrayList<Teacher> t= new ArrayList<Teacher>();
		while(rs.next()) {
			Teacher tr= new Teacher();
			tr.setId(rs.getInt(1));
			tr.setName(rs.getString(2));
			tr.setsubject(rs.getString(3));
			t.add(tr);
		}
		return t;
		}
		catch (SQLException e) {
			return null;
		}
	}
	
	@Override
	public boolean delete(int id) {
		try {
		PreparedStatement pr= con.prepareStatement("DELETE from Teacher where id= ? ");
		pr.setInt(1, id);
		pr.execute();
		return true;
		}
		catch (SQLException e) {
			return false;
		}
	}
	
	@Override
	public Teacher findById(int id) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("SELECT * from Teacher where id= ? ");
			pr.setInt(1, id);
			ResultSet rs= pr.executeQuery();
			rs.next();
			Teacher s= new Teacher();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setsubject(rs.getString(3));
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
			CallableStatement cs= con.prepareCall("SELECT count_teacher()");
			ResultSet rs= cs.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
	public int getCountById(int id) {
		
		try {
			CallableStatement cs= con.prepareCall("SELECT count_teacher_by_id(?)");
			cs.setInt(1, id);
			ResultSet rs= cs.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			return -1;
		
		}
		
	}
	
	

}

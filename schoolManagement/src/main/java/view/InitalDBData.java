package view;

import java.sql.Connection;
import java.sql.SQLException;

import connPool.ConnectionPool;

public class InitalDBData {
	
	
	static Connection con= ConnectionPool.getConnection();
	static {
		try {
			String sql1= "Insert into Student Values(101, 'Tejas',54)";
			con.createStatement().execute(sql1);
		} catch (SQLException e) {
			
		}
	}
	static {
		try {
			String sql1= "Insert into Teacher Values(101, 'Dhanish','SQL')";
			con.createStatement().execute(sql1);
		} catch (SQLException e) {
			
		}
	}
	static {
		try {
			String sql1= "Insert into Student Values(102, 'Atharva', 84)";
			con.createStatement().execute(sql1);
		} catch (SQLException e) {
			
		}
	}
	static {
		try {
			String sql1= "Insert into Teacher Values(102, 'Raghuvir', 'Advance Java')";
			con.createStatement().execute(sql1);
		} catch (SQLException e) {
			
		}
	}
	static {
		try {
			String sql1= "Insert into Student Values(103,'Balakoti', 23)";
			con.createStatement().execute(sql1);
		} catch (SQLException e) {
			
		}
	}
	static {
		try {
			String sql1= "Insert into Teacher Values(103, 'Himanshu','Core Java')";
			con.createStatement().execute(sql1);
		} catch (SQLException e) {
			
		}
	}
	
	static {
		ConnectionPool.reciveConnectionObject(con);
	}

}

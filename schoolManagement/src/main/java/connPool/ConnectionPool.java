package connPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

	static List<Connection> connectionPool=new ArrayList<Connection>();
	private static String driverPath="org.postgresql.Driver";
	private static String URL= "jdbc:postgresql://localhost:5432/school";
	private static String user= "postgres";
	private static String password= "admin";
	
	private static final int POOL_SIZE= 5;
	
	static {
		try {
		Class.forName(driverPath);	
		for(int i=0; i<POOL_SIZE; i++) {
			Connection connection= createConnection();
			connectionPool.add(connection);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private static Connection createConnection(){
		Connection connection= null;
		
		try {
			connection= DriverManager.getConnection(URL,user, password);	
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return connection;
		
	}
	
	public static Connection getConnection() {
		if(!connectionPool.isEmpty()) {
			return connectionPool.remove(0);
		}
		else {
			return createConnection();
		}
	}
	
	public static void reciveConnectionObject( Connection con ) {
		if(connectionPool.size()<POOL_SIZE) {
			connectionPool.add(con);
		}
		else {
			try {
				con.close();
			}	
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}

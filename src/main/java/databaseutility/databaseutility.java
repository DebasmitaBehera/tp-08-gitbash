package databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class databaseutility {

	
		// TODO Auto-generated method stub
		Connection con;

		
		
		public void getDBConnection(String url,String username,String password) throws SQLException
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
				try {
					con=DriverManager.getConnection(url, username, password);
				
				}
		catch (SQLException e) {
			}
			
			
		}
	public void closeDBConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ResultSet executeselectquery(String query)
	{
		 ResultSet result =null;
		 Statement stat = null;
		try {
			stat = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			result=stat.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return result;
		
	}
		
	public int executenonselectquery2(String query)
	{
		int result=0;
		 Statement stat = null;
		try {
			stat = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			result=stat.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return result;
		
	}

	}



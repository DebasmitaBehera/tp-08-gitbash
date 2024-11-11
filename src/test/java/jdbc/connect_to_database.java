package jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class connect_to_database {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// load the database
		Driver driverref = new Driver();
				DriverManager.registerDriver(driverref);

				// connect to the database
				Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/ninza_hrm", "root@%", "root");
				System.out.println("connected");
				// create the sql 
				Statement stat = conn.createStatement();
				// execute the command
				ResultSet resultSet = stat.executeQuery("Select * from employee");
				
				while(resultSet.next()) {
					
					System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" + resultSet.getString(4));
					
				}
				
				// close the connection
		conn.close();
			}
	}



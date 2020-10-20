package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	 Connection con;
	 Statement stm;
	 ResultSet res;
	 public ConnectDB() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management_system","root","");
		}catch(Exception ex){
			System.out.println("Error : "+ex);
		      }
		}
	 public Connection getConnection() {
				 return con;
	 }
	}

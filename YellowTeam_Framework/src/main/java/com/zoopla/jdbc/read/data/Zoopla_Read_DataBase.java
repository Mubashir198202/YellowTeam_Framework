package com.zoopla.jdbc.read.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Zoopla_Read_DataBase {
	
	public static ArrayList<String> getDataTable(String SQLQuery, String result) throws ClassNotFoundException, SQLException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); // JDBC Location
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "hr", "hr");
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("SQL Query");
		ArrayList<String> columnValue = new ArrayList<>();
		while (rs.next()) {
			columnValue.add(rs.getString("FIRST_NAME"));
		}
		System.out.println(columnValue);
		connection.close();
		
		return columnValue;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

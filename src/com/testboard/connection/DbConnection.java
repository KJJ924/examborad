package com.testboard.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getInstance() throws SQLException, ClassNotFoundException{
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "1234";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn;
		
		conn=DriverManager.getConnection(url, user, password);
		
		return conn;
		
		
	}
}

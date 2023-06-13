package com.bhiawdatabasepkg.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	public Connection con;
	public Statement stmt;
	
	public Statement getStatement() throws ClassNotFoundException {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String connection = "jdbc:mysql://localhost:3306/seleniumdb";
			String userName = "root";
			String password = "Mysqlbhi@7";
			Class.forName(driver);
			con = DriverManager.getConnection(connection, userName, password);
			stmt = con.createStatement();
			return stmt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	public void insertData(String query) throws ClassNotFoundException, SQLException, InterruptedException {
		Statement sta = getStatement();
		Thread.sleep(2000);
		sta.executeUpdate(query);
	}
	
	public ResultSet getData(String query) throws ClassNotFoundException, SQLException{
		ResultSet data = getStatement().executeQuery(query);
		return data;
	}
	
	public void updateData(String query) throws ClassNotFoundException, SQLException {
		getStatement().executeUpdate(query);
		
	}

}

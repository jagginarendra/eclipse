package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC {

	private static String dbURL = "jdbc:derby://localhost:1527/Tescomart;create=true";
	private static String tableName = "users";

	private static Connection conn = null;
	private static Statement stmt = null;

	public static void main(String[] args) {

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			// Get a connection
			conn = DriverManager.getConnection(dbURL);
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from users");

			while(rs.next()){
				
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " "+ rs.getString(3));
				
				
			}
			rs.close();
			stmt.close();
			
			conn.close();

		} catch (Exception except) {
			except.printStackTrace();
		}

	}
}

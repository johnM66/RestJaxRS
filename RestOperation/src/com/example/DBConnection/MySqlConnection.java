package com.example.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	private static String dbUrl = "jdbc:mysql://localhost:3306/rmi";
	private static String dbUsername = "root";
	private static String dbPassword = "root";

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	}

}

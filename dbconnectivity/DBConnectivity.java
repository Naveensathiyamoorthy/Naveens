package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectivity {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "");
		Statement statement = connection.createStatement();
		statement.executeUpdate("insert into details(id) values(11)");
		ResultSet rs = statement.executeQuery("select *from details");
		while (rs.next()) {
			System.out.println(rs.getInt(1));
		}

	}

}

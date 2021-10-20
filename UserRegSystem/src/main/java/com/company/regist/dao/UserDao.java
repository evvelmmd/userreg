package com.company.regist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.regist.model.User;

public class UserDao {
	public int registerUser(User u) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "Insert into users " + "(first_name,last_name,username,password,adress,contact) VALUES" 
	+ "(?,?,?,?,?,?) ";
		int result = 0;
		String dbUrl="jdbc:mysql://localhost:3306/mysql_database?useSSL=false";
		String dbUrl2="jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
		String dbUsername ="root";
		String dbPassword="";
		Class.forName("com.mysql.jdbc.Driver");
		
		try {Connection connection = DriverManager.getConnection(dbUrl2,dbUsername,dbPassword);
		
		PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL);
		
		 
		preparedStatement.setString(1, u.getFirstName());
		preparedStatement.setString(2, u.getLastName());
		preparedStatement.setString(3, u.getUsername());
		preparedStatement.setString(4, u.getPassword());
		preparedStatement.setString(5, u.getAdress());
		preparedStatement.setString(6, u.getContact());
		
		System.out.println(preparedStatement);
		result=preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

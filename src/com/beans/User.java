package com.beans;
import javax.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class User {
	private int id;
	private String username;
	private String password;
	private int dateCreated;
	
	
	public User(){
		
	}
	
	public static String isValidUser(DataSource data,String username,String password) throws SQLException{
		Connection connection = null;
		connection = data.getConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM TradingPlatform.user WHERE username='"+username+"' AND password=sha2('"+password+"',256)");
		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return resultSet.getString(1);
		
	}
}

package com.beans;
import javax.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class User {


	private String username;
	private String password;
	private int dateCreated;
	private int type;
	
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
	
	public String getType(DataSource data,String username,String password) throws SQLException{
		Connection connection = null;
		connection = data.getConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement("SELECT type FROM TradingPlatform.user WHERE username='"+username+"' AND password=sha2('"+password+"',256)");
		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return resultSet.getString(1);	
	}
	
	
	
	
	
	
	
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(int dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}

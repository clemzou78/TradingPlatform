package com.beans;
import javax.sql.*;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.List;

import javax.sql.DataSource;

import org.hibernate.*;
//
import com.connection.HibernateUtil;

public class User {


	private String username;
	private String password;
	private int dateCreated;
	private int type;

	public User(){

	}

	public static User recupByName(String username){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM User u WHERE u.username = '"+username+"'";
		Query query = session.createQuery(hql);
		List results = query.list();
		if (results.size()==0) return null;
		return (User) results.get(0);
	}

	public String checkPw(String password) {



		try{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			String hash = digest.digest(password.getBytes("UTF-8")).toString();
			if (this.getPassword()==hash) return 1+"";
			return 0+"";
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		return 0+"";
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

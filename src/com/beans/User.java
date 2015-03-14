package com.beans;
import javax.sql.*;

import org.apache.*;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.*;

//
import com.connection.HibernateUtil;
import com.util.Hash;




public class User {

	private int id;
	private String username;
	private String password;
	private Date dateCreated;
	private UserType type;
	
	
	public User(){

	}
	
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}




	public String checkPw(String password) {
		try{
			String sha256hex = Hash.sha256(password);
			if (this.getPassword().equals(sha256hex)) return 1+"";
			else return 0+"";
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		return 0+"";
	}

	public void update(){
		
	}

	
	







	
}

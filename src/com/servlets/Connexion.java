package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.beans.User;
/* TEST GIT */
// TEST MOI
// DEUXIEME TEST
/* CLEM */
public class Connexion extends HttpServlet {
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		DataSource dataSource = null;
		InitialContext initialContext = null;
		try {
			initialContext = new InitialContext();
			dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/DsMysql");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String username = request.getParameter("username" );
        String motDePasse = request.getParameter("password");
        PrintWriter out = response.getWriter();
		try {
			out.println(User.isValidUser(dataSource, username, motDePasse));
		} catch (SQLException e) {
			out.println(e);
		}
		
	}
}
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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.beans.User;
/* TEST GIT */
// TEST MOI
// DEUXIEME TEST
/* CLEM */
public class Connexion extends HttpServlet {
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

		String username = request.getParameter("name" );
		String motDePasse = request.getParameter("password");
		PrintWriter out = response.getWriter();       

		if (username=="" || motDePasse==""){
			out.println("2");
			return;
		}

		User u=User.recupByName(username);
		if(u!=null){
			String b=u.checkPw(motDePasse);
			out.println(b);
			if( b.equals("1")) {
				HttpSession session = request.getSession();
				session.setAttribute( "sessionUser", u);
			}
		}
		else out.println("0");
	}
}
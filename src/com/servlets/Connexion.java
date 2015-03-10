package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* TEST GIT */
public class Connexion extends HttpServlet {
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		String email = request.getParameter("username" );
        String motDePasse = request.getParameter("password");
        PrintWriter out=response.getWriter();
        out.println(email);
	}
}
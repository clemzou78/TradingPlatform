package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Societe;
import com.ejb.ServiceSociete;
import com.util.RandomStringGenerator;

public class ValidateSociete extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		int idSoc = Integer.parseInt(request.getParameter("idSoc"));
		String pass=RandomStringGenerator.generateRandomString(10, RandomStringGenerator.Mode.ALPHANUMERIC);
		ServiceSociete ss = new ServiceSociete();
		Societe soc=ss.valider(idSoc, pass);
		
		HttpSession s=request.getSession();
		s.setAttribute("societe", soc);
		s.setAttribute("pass",pass);
		request.getRequestDispatcher("confirmSocieteAdd.jsp").forward(request, response);
	}
}
package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Societe;
import com.ejb.ServiceSociete;
import com.util.RandomStringGenerator;

/**
 * Servlet implementation class SocieteAdd
 */
@WebServlet("/SocieteAdd")
public class SocieteAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocieteAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom" );
		String mnemo = request.getParameter("mnemo");
		String description = request.getParameter("description");
		String email=request.getParameter("email");
		String pass=RandomStringGenerator.generateRandomString(10, RandomStringGenerator.Mode.ALPHANUMERIC);
		ServiceSociete ss=new ServiceSociete();
		Societe soc=ss.createSociete(nom, mnemo, description,email,pass);
		
		HttpSession s=request.getSession();
		s.setAttribute("societe", soc);
		s.setAttribute("pass",pass);
		request.getRequestDispatcher("confirmSocieteAdd.jsp").forward(request, response);
		
	}

}

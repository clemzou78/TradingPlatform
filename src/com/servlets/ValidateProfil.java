package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.ServiceInvestisseur;

/**
 * Servlet implementation class ValidateProfil
 */
public class ValidateProfil extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idInv=Integer.parseInt(request.getParameter("id"));
		ServiceInvestisseur si=new ServiceInvestisseur();
		si.validateProfile(idInv);
		request.getRequestDispatcher("/admin/listeUsers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

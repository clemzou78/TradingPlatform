package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.ServiceInvestisseur;

/**
 * Servlet implementation class ValidProfile
 */
@WebServlet("/ValidProfile")
public class ValidProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidProfile() {
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
		String prenom=request.getParameter("prenom");
		String nom=request.getParameter("nom");
		String tel=request.getParameter("tel");
		String adresse=request.getParameter("adresse");
		String cp=request.getParameter("cp");
		String pays=request.getParameter("pays");
		String ville=request.getParameter("ville");
		int idInvest=Integer.parseInt(request.getParameter("idInvest"));
		ServiceInvestisseur si=new ServiceInvestisseur();
		si.modifyProfile(idInvest, nom, prenom, adresse, ville, cp, pays, tel);
	}

}

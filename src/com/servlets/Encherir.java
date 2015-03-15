package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Investisseur;
import com.ejb.ServiceContrat;
import com.ejb.ServiceInvestisseur;
import com.exceptions.EnchereInvalide;
import com.exceptions.OffrePerime;

/**
 * Servlet implementation class Encherir
 */
@WebServlet("/Encherir")
public class Encherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encherir() {
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
		
		int idce=Integer.parseInt(request.getParameter("idContrat"));
		double montant=Double.parseDouble(request.getParameter("montant"));
		
		ServiceInvestisseur si=new ServiceInvestisseur();
		Investisseur encherisseur = si.getByIdUser(Integer.parseInt(request.getParameter("sessionUser")));
		
		
		ServiceContrat sc=new ServiceContrat();

		HttpSession s=request.getSession();

		try {
			sc.encherir(idce, montant, encherisseur);
		} catch (OffrePerime e) {

	
			
		} catch (EnchereInvalide e) {
			
			e.printStackTrace();
		}

	}

}

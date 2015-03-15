package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Investisseur;
import com.beans.User;
import com.ejb.ServiceContrat;
import com.ejb.ServiceInvestisseur;
import com.exceptions.EnchereInvalide;
import com.exceptions.OffrePerime;

/**
 * Servlet implementation class Encherir
 */
@WebServlet("/AchatDirect")
public class AchatDirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AchatDirect() {
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
		
		int idcd=Integer.parseInt(request.getParameter("idContrat"));
		double montant=Double.parseDouble(request.getParameter("montant"));
		HttpSession s=request.getSession();
		Investisseur encherisseur = (new ServiceInvestisseur()).getByIdUser(  ((User) s.getAttribute("sessionUser")).getId());
		
		
		ServiceContrat sc=new ServiceContrat();


		try {
			sc.fin(idcd, encherisseur.getIdInvestisseur());
		} catch (OffrePerime e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

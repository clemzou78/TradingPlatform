package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.Investisseur;
import com.beans.Societe;
import com.beans.User;
import com.beans.contrat.Actif;
import com.beans.contrat.Contrat;
import com.beans.contrat.ContratDirect;
import com.beans.contrat.ContratEnchere;
import com.beans.contrat.NegoType;
import com.connection.HibernateUtil;
import com.ejb.ServiceContrat;
import com.ejb.ServiceInvestisseur;
import com.ejb.ServiceSociete;
import com.util.RandomStringGenerator;

/**
 * Servlet implementation class SocieteAdd
 */
@WebServlet("/SocieteAdd")
public class OffreAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OffreAdd() {
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
		HttpSession s=request.getSession();
		Investisseur initiateur = (new ServiceInvestisseur()).getByIdUser(  ((User) s.getAttribute("sessionUser")).getId());


		String soc = request.getParameter("idSociete");
		NegoType n=NegoType.parse(request.getParameter("nego"));
		
		
		String typeContrat=request.getParameter("typeContrat");

		String prix=request.getParameter("prix1").equals("") ? request.getParameter("prix2") : request.getParameter("prix1");
		String qte=request.getParameter("quantite1").equals("") ? request.getParameter("quantite2") : request.getParameter("quantite1");

		String typeActif=request.getParameter("typeActif");

		



		ServiceContrat sc=new ServiceContrat();
		Actif a;
		// creation de l'actif
		
		if(typeActif.equals("Action")){
			a=sc.creationAction(Integer.parseInt(soc), Double.parseDouble(prix));
		}
		else{
			String maturite=request.getParameter("maturite");
			String strike=request.getParameter("strike");

			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
			Date maturiteDate = null;
			try {
				maturiteDate = formatter2.parse(maturite);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			a=sc.creationOption(Integer.parseInt(soc),maturiteDate, Double.parseDouble(strike));
		}
		Contrat c=null;
		if(typeContrat.equals("direct"))
			c = sc.creationContratDirect(initiateur, a, Integer.parseInt(qte), Double.parseDouble(prix), n);
		else{
			String finDate=request.getParameter("date");
			String finTime=request.getParameter("time");

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date dateLimite = null;
			try {
				dateLimite = formatter.parse(finDate + " "+ finTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			c= sc.creationContratEnchere(initiateur, a, dateLimite, Integer.parseInt(qte), Double.parseDouble( prix), n);
		}

		/*HttpSession s=request.getSession();
		s.setAttribute("societe", soc);
		s.setAttribute("pass",pass);
		request.getRequestDispatcher("confirmSocieteAdd.jsp").forward(request, response);*/

	}

}

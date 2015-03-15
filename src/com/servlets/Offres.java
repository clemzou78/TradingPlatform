package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.beans.contrat.Actif;
import com.beans.contrat.Action;
import com.beans.contrat.Contrat;
import com.beans.contrat.ContratEnchere;
import com.connection.HibernateUtil;
import com.ejb.ServiceContrat;


/**
 * Servlet implementation class SocieteAdd
 */
@WebServlet("/SocieteAdd")
public class Offres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Offres() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServiceContrat sc=new ServiceContrat();
		List<Contrat> lc=sc.getOffreEnCours();
		ArrayList< ArrayList <String> > l =new ArrayList< ArrayList <String >>();
		for(int i=0;i<lc.size();i++){
			ArrayList<String> l2=new ArrayList<String>();
			l.add(l2);
			Contrat c = lc.get(i);
			l2.add(c.getActif().getSoc().getNom());
			l2.add(c.getActif().getSoc().getMnemo());
			l2.add(c.getActif() instanceof Action?"Action":"Option" );
			l2.add(c.getQuantite()+"");
			l2.add(c.getTypeN().toString());
			l2.add(c instanceof ContratEnchere?"Enchere":"Direct");
			l2.add(c.getPrix()+"");
			l2.add(c.getProposeUser().getNom()+" "+c.getProposeUser().getPrenom());
			
		}
		request.setAttribute( "listContrats", l);
		this.getServletContext().getRequestDispatcher( "/invest/offres.jsp" ).forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

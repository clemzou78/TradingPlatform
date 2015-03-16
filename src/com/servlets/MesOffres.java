package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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

import com.beans.Investisseur;
import com.beans.User;
import com.beans.contrat.Actif;
import com.beans.contrat.Action;
import com.beans.contrat.Contrat;
import com.beans.contrat.ContratEnchere;
import com.connection.HibernateUtil;
import com.ejb.ServiceContrat;
import com.ejb.ServiceInvestisseur;
import com.util.DateDiff;


/**
 * Servlet implementation class SocieteAdd
 */
@WebServlet("/MesOffres")
public class MesOffres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MesOffres() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ServiceContrat sc=new ServiceContrat();
		HttpSession s=request.getSession();
		Investisseur initiateur = (new ServiceInvestisseur()).getByIdUser(  ((User) s.getAttribute("sessionUser")).getId());

		List<Contrat> lc=sc.getOffreByInvestor(initiateur.getIdInvestisseur(),0);
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
			l2.add(c instanceof ContratEnchere?"Enchère":"Direct");
			DecimalFormat formatter = new DecimalFormat("###,###,###.00");
			String moneyString = formatter.format(c.getPrix());
			l2.add(moneyString);
			l2.add(c.getProposeUser().getNom()+" "+c.getProposeUser().getPrenom());
			
			if (c instanceof ContratEnchere) {
				String s1=DateDiff.format(((ContratEnchere) c).getDateFin());
				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String formate=formatter2.format( ((ContratEnchere) c).getDateFin() );
				l2.add(formate);
				l2.add( s1 );
			}
			else{
				l2.add("");
				l2.add("");
			}
			l2.add(c.getIdContrat()+"");
		}


		request.setAttribute( "listContrats", l);
		this.getServletContext().getRequestDispatcher( "/invest/mesOffres.jsp" ).forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

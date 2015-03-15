package com.ejb;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.*;
import com.beans.contrat.*;
import com.connection.HibernateUtil;
import com.exceptions.EnchereInvalide;
import com.exceptions.OffrePerime;

/**
 * Session Bean implementation class ServiceContrat
 */
@Stateless
@LocalBean
public class ServiceContrat {

	/**
	 * Default constructor. 
	 */

	

	public ServiceContrat() {
		// TODO Auto-generated constructor stub
	}

	public Actif creationActif(Societe s, String type){

		Actif a=(new ActifFactory()).getActif(type);
		a.setSoc(s);
		return a;

	}

	public Action creationAction(int idsoc, double prix){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Societe soc=(Societe) session.get(com.beans.Societe.class,idsoc);
		Action a=(Action) creationActif(soc,"Action");
		a.setPrix(prix);
		session.save(a);
		tx.commit();
		session.close();
		return a;
	}

	public StockOption creationOption(int idsoc, Date maturite, double strike){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Societe soc=(Societe) session.get(com.beans.Societe.class,idsoc);
		StockOption s1=(StockOption) creationActif(soc,"StockOption");
		s1.setMaturite(maturite);
		s1.setStrike(strike);
		s1.setSoc(soc);
		session.save(s1);
		tx.commit();
		session.close();
		return s1;
	}


	public ContratDirect creationContratDirect(Investisseur initiateur, Actif a, int qte, double prix, NegoType n){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		ContratDirect cd=new ContratDirect();
		cd.setActif(a);
		cd.setProposeUser(initiateur);
		cd.setAccepteUser(null);
		cd.setQuantite(qte);
		cd.setTypeN(n);
		cd.setPrix(prix);
		cd.setCreation(Calendar.getInstance().getTime());

		session.save(cd);
		tx.commit();
		session.close();
		return cd;
	}

	public ContratEnchere creationContratEnchere(Investisseur initiateur, Actif a,Date dateLimite, int qte, double prixDepart, NegoType n){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		ContratEnchere ce=new ContratEnchere();
		ce.setActif(a);
		ce.setProposeUser(initiateur);
		ce.setAccepteUser(null);
		ce.setDateFin(dateLimite);
		ce.setPrixDepart(prixDepart);
		ce.setQuantite(qte);
		ce.setTypeN(n);
		ce.setCreation(Calendar.getInstance().getTime());

		


		session.save(ce);
		tx.commit();
		session.close();

		InitialContext initialContext;
		try {
			Properties properties = new Properties();
            properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            initialContext = new InitialContext(properties);
			EnchereRemote er = (EnchereRemote) initialContext.lookup("java:global/ApplicationTrading/FinEnchere!com.ejb.EnchereRemote");
            //EnchereRemote servicesCompte = (EnchereRemote) initialContext.lookup("java:global/EJB/Enchere!com.timer.EnchereRemote");

 
			er.createTimer(ce.getDateFin(),ce.getIdContrat());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		return ce;
	}

	public PropositionEnchere encherir(int idce, double montant, Investisseur encherisseur) throws OffrePerime, EnchereInvalide{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		ContratEnchere ce=(ContratEnchere) session.get(com.beans.contrat.ContratEnchere.class,idce);
		// Check la validité de l'enchère
		if(ce.isFini()){
			session.close();
			throw new OffrePerime();
		}
		PropositionEnchere pmax=valeurGagnanteEnchere(ce);
		if(pmax==null || (ce.getTypeN()==NegoType.Achat?montant>pmax.getMontant():montant<pmax.getMontant())){


			PropositionEnchere pe=new PropositionEnchere();
			pe.setContrat(ce);
			pe.setMontant(montant);
			pe.setDateEnchere(Calendar.getInstance().getTime());
			pe.setEncherisseur(encherisseur);
			session.save(pe);
			tx.commit();

			session.close();
			return pe;
		}
		else{
			session.close();
			throw new EnchereInvalide(pmax.getMontant()+"");
		}
	}

	public PropositionEnchere valeurGagnanteEnchere(ContratEnchere ce){
		PropositionEnchere m=null;
		double c=ce.getPrixDepart();
		System.out.println("SIZE LISTE "+ ce.getPropEnc().size());
		for(int i=0;i<ce.getPropEnc().size();i++){
			PropositionEnchere tmp=ce.getPropEnc().get(i);
			if(ce.getTypeN()==NegoType.Achat){
				if(tmp.getMontant()>c){
					m=tmp;
					c=tmp.getMontant();
				}
			}
			else{
				if(tmp.getMontant()<c){
					m=tmp;
					c=tmp.getMontant();
				}
			}

		}
		return m;
	}
	
	public ContratDirect fin(int idcd,int iduser) throws OffrePerime{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
		ContratDirect ce=(ContratDirect) session.get(com.beans.contrat.ContratDirect.class,idcd);
		
		if(ce.isFini()){
			session.close();
			throw new OffrePerime();
		}
		
		ce.setFini(true);
		ce.setAccepteUser((Investisseur) session.get(com.beans.Investisseur.class, iduser));
		tx.commit();
		session.close();
		
		return ce;
	}

	public List<Contrat> getOffreEnCours(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Contrat c where c.fini=0";
		Query query = session.createQuery(hql);
		List<Contrat> results = query.list();
		session.close();
		return results;
	}
	
	public ContratEnchere fin(int idce){

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		ContratEnchere ce=(ContratEnchere) session.get(com.beans.contrat.ContratEnchere.class,idce);
		if (ce.getPropEnc().size()!=0){
			PropositionEnchere pe = valeurGagnanteEnchere(ce);
			ce.setAccepteUser(pe.getEncherisseur());
		}
		ce.setFini(true);
		tx.commit();
		session.close();
		return ce;

	}

}
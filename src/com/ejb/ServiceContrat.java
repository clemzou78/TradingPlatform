package com.ejb;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.*;
import com.beans.contrat.*;
import com.connection.HibernateUtil;

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
    
    public Action creationAction(Societe s, double prix){
       	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Action a=(Action) (new ActifFactory()).getActif("Action");
    	a.setPrix(prix);
    	session.save(a);
    	tx.commit();
    	session.close();
    	return a;
    }
    
    public StockOption creationOption(Societe s, Date maturite, double strike){
       	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = session.beginTransaction();
    	
    	StockOption s1=(StockOption) (new ActifFactory()).getActif("Option");
    	s1.setMaturite(maturite);
    	s1.setStrike(strike);
    	session.save(s1);
    	tx.commit();
    	session.close();
    	return s1;
    }
    
    
    public ContratDirect creationContratDirect(Investisseur initiateur, Actif a, int qte, NegoType n){
     	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = session.beginTransaction();
 
    	ContratDirect cd=new ContratDirect();
    	cd.setActif(a);
    	cd.setProposeUser(initiateur);
    	cd.setAccepteUser(null);
    	cd.setQuantite(qte);
    	cd.setTypeN(n);
    	cd.setCreation(Calendar.getInstance().getTime());
    	
    	session.save(cd);
    	tx.commit();
    	session.close();
    	return cd;
    }
    
    public ContratEnchere creationContratEnchere(Investisseur initiateur,Date dateLimite, Actif a, int qte, NegoType n){
     	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = session.beginTransaction();
 
    	ContratEnchere ce=new ContratEnchere();
    	ce.setActif(a);
    	ce.setProposeUser(initiateur);
    	ce.setAccepteUser(null);
    	ce.setDateFin(dateLimite);
    	ce.setQuantite(qte);
    	ce.setTypeN(n);
    	ce.setCreation(Calendar.getInstance().getTime());
    	
    	session.save(ce);
    	tx.commit();
    	session.close();
    	
    	return ce;
    }

}

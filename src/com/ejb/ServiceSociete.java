package com.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.*;
import com.connection.HibernateUtil;
import com.util.Hash;

/**
 * Session Bean implementation class ServiceSociete
 */
@Stateless
@LocalBean
public class ServiceSociete {

    /**
     * Default constructor. 
     */
    public ServiceSociete() {
        // TODO Auto-generated constructor stub
    }
    
    public List getAllSociete(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Societe s";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.close();
		return results;

	}
    
	public Societe createSocieteStandBy(String societe, String mnemo,
			String description, String mail) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Societe s=new Societe();
		s.setDescription(description);
		s.setMnemo(mnemo);
		s.setNom(societe);
		s.setEmail(mail);
		s.setValidate(false);
		session.save(s);
		tx.commit();

		return s;
	}

	public  List getSocieteAValider(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Societe s where s.validate=0";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.close();
		return results;
	}

	public Societe valider(int id,String pass){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Societe s =  (Societe) session.get(Societe.class, id);

		User u=new User();
		u.setUsername(s.getEmail());
		u.setType(UserType.Societe);
		u.setPassword(Hash.sha256(pass));
		session.save(u);

		s.setValidate(true);
		s.setUserSociety(u);
		tx.commit();

		return s;
	}
	
	public Societe createSociete(String nom, String mnemo, String description, String email,String pass){ // avec un compte associé
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		User u=new User();
		u.setUsername(email);
		u.setType(UserType.Societe);
		u.setPassword(Hash.sha256(pass));
		session.save(u);

		Societe s=new Societe();
		s.setDescription(description);
		s.setMnemo(mnemo);
		
		s.setNom(nom);
		s.setEmail(email);
		s.setValidate(true);
		s.setUserSociety(u);
		session.save(s);
		tx.commit();

		return s;
	}
    
   


}

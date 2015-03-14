package com.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.Investisseur;
import com.beans.User;
import com.beans.UserType;
import com.connection.HibernateUtil;
import com.util.Hash;

/**
 * Session Bean implementation class ServiceUser
 */
@Stateless
@LocalBean
public class ServiceInvestisseur {

    /**
     * Default constructor. 
     */
    public ServiceInvestisseur() {
        // TODO Auto-generated constructor stub
    }
    
	public Investisseur createInvestissor(String nom, String prenom, String mail, String pass){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		User u=new User();
		u.setUsername(mail);
		u.setType(UserType.Investisseur);
		u.setPassword(Hash.sha256(pass));
		session.save(u);

		Investisseur s=new Investisseur();
		s.setPrenom(prenom);
		s.setNom(nom);
		s.setUserInvestor(u);
		s.setValidate(false);
		session.save(s);
		tx.commit();
		session.close();
		return s;
	}
	public Investisseur getById(int idInvestisseur){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
	
		Investisseur s=(Investisseur) session.get(com.beans.Investisseur.class,idInvestisseur);
		
		tx.commit();
		session.close();
		return s;
	}
	
	public Investisseur getByIdUser(int idUser){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Investisseur i WHERE i.userInvestor = "+idUser;
		Query query = session.createQuery(hql);
		List results = query.list();
		
		tx.commit();
		session.close();
		return (Investisseur)results.get(0);
	}
    
	public Investisseur modifyProfile(int idInvestisseur,String nom, String prenom, String adresse, String ville, String codePostal, String pays,
			 String telephone){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Investisseur s=(Investisseur) session.get(com.beans.Investisseur.class,idInvestisseur);
		s.setPrenom(prenom);
		s.setNom(nom);
		s.setAdresse(adresse);
		s.setVille(ville);
		s.setCodePostal(codePostal);
		s.setPays(pays);
		s.setTelephone(telephone);
		tx.commit();
		session.close();
		return s;
	}
	
	public Investisseur validateProfile(int idInvestisseur){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
	
		Investisseur s=(Investisseur) session.get(com.beans.Investisseur.class,idInvestisseur);
		
		s.setValidate(true);
		tx.commit();
		session.close();
		return s;
	}
    
    

}

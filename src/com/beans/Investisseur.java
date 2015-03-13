package com.beans;





import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connection.HibernateUtil;

public class Investisseur {
	private int idInvestisseur;
	private String nom;
	private String prenom;
	private User userInvestor;

	
	String getNom() {
		return nom;
	}
	void setNom(String nom) {
		this.nom = nom;
	}
	String getPrenom() {
		return prenom;
	}
	void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	private User getUserInvestor() {
		return userInvestor;
	}
	private void setUserInvestor(User userInvestor) {
		this.userInvestor = userInvestor;
	}

	public static Investisseur createInvestissor(String nom, String prenom, String mail, String pass){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		User u=new User();
		u.setUsername(mail);
		u.setType(UserType.Investisseur);
		u.setPassword(User.sha256(pass));
		session.save(u);

		Investisseur s=new Investisseur();
		s.setPrenom(prenom);
		s.setNom(nom);
		s.setUserInvestor(u);
		session.save(s);
		tx.commit();
		
		return s;
	}
	

	
}

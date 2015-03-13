package com.beans;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connection.HibernateUtil;
import com.util.RandomStringGenerator;

public class Societe {
	private int idSociete; 
	private User userSociety;
	private String description;
	private String nom;
	private String mnemo;
	private boolean validate;
	private String email;

	public Societe(){

	}

	public Societe(String description, String nom, String mnemo){
		this.description=description;
		this.nom=nom;
		this.mnemo=mnemo;

	}

	public int getIdSociete() {
		return idSociete;
	}
	public void setIdSociete(int idSociete) {
		this.idSociete = idSociete;
	}

	public User getUserSociety() {
		return userSociety;
	}

	public void setUserSociety(User userSociety) {
		this.userSociety = userSociety;
	}



	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMnemo() {
		return mnemo;
	}
	public void setMnemo(String mnemo) {
		this.mnemo = mnemo;
	}

	private boolean isValidate() {
		return validate;
	}

	private void setValidate(boolean validate) {
		this.validate = validate;
	}

	private String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public static  List getAllSociete(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Societe s";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.close();
		return results;

	}

	public static Societe createSociete(String nom, String mnemo, String description, String pass){ // avec un compte associé
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		User u=new User();
		u.setUsername(mnemo);
		u.setType(UserType.Societe);
		u.setPassword(User.sha256(pass));
		session.save(u);

		Societe s=new Societe();
		s.setDescription(description);
		s.setMnemo(mnemo);
		s.setNom(nom);
		s.setValidate(true);
		s.setUserSociety(u);
		session.save(s);
		tx.commit();

		return s;
	}

	public User compteDeLaSociete(int idUser){
		//TODO 
		return null;
	}

	public static Societe createSocieteStandBy(String societe, String mnemo,
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

	public static  List getSocieteAValider(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Societe s where s.validate=0";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.close();
		return results;
	}

	public static Societe valider(int id,String pass){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Societe s =  (Societe) session.get(Societe.class, id);

		User u=new User();
		u.setUsername(s.getEmail());
		u.setType(UserType.Societe);
		u.setPassword(User.sha256(pass));
		session.save(u);

		s.setValidate(true);
		s.setUserSociety(u);
		tx.commit();

		return s;
	}


}
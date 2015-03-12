package com.beans;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connection.HibernateUtil;

public class Societe {
	private int idSociete; 
	private User userSociety;
	private String description;
	private String nom;
	private String mnemo;
	
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


	static public List getAllSociete(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Societe s";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.close();
		return results;

	}
	
	public User compteDeLaSociete(int idUser){
		//TODO 
			return null;
		}


		

}
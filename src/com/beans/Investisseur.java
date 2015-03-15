package com.beans;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connection.HibernateUtil;
import com.util.Hash;

public class Investisseur {
	private int idInvestisseur;
	private String nom;
	private String prenom;
	private User userInvestor;

	private boolean validate;
	

	private String adresse;
	private String codePostal;

	private String ville;
	private String pays;
	private String telephone;
	
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public User getUserInvestor() {
		return userInvestor;
	}
	public void setUserInvestor(User userInvestor) {
		this.userInvestor = userInvestor;
	}
	
	public int getIdInvestisseur() {
		return idInvestisseur;
	}
	public void setIdInvestisseur(int idInvestisseur) {
		this.idInvestisseur = idInvestisseur;
	}
	
	public boolean isValidate() {
		return validate;
	}
	public void setValidate(boolean validate) {
		this.validate = validate;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	


	

	
}

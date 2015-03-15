package com.beans;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connection.HibernateUtil;
import com.util.*;

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

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public User compteDeLaSociete(int idUser){
		//TODO 
		return null;
	}




}
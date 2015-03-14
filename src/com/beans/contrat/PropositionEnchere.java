package com.beans.contrat;

import java.util.Date;

import com.beans.Investisseur;

public class PropositionEnchere {
	int idProposition;
	Investisseur encherisseur;
	double montant;
	private Date dateEnchere;
	
	public PropositionEnchere(){
		
	}
	public int getIdProposition() {
		return idProposition;
	}
	public void setIdProposition(int idProposition) {
		this.idProposition = idProposition;
	}
	public Investisseur getEncherisseur() {
		return encherisseur;
	}
	public void setEncherisseur(Investisseur encherisseur) {
		this.encherisseur = encherisseur;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	
	
}

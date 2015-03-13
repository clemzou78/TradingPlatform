package com.beans.contrat;

import com.beans.Investisseur;

public class PropositionEnchere {
	int idProposition;
	Investisseur encherisseur;
	double montant;
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
	
	
}

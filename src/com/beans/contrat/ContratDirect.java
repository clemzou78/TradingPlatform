package com.beans.contrat;

import java.util.Date;

import com.beans.User;

public class ContratDirect extends Contrat {

	private Date dateTransaction;
	private double prix;
	

	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

}

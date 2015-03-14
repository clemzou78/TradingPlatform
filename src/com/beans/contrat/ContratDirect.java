package com.beans.contrat;

import java.util.Date;

import com.beans.User;

public class ContratDirect extends Contrat {

	Date dateTransaction;
	double prix;
	
	public NegoType getTypeN() {
		return typeN;
	}
	public void setTypeN(NegoType typeN) {
		this.typeN = typeN;
	}
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

}

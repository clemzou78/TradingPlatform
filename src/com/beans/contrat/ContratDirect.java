package com.beans.contrat;

import java.sql.Date;

import com.beans.User;

public class ContratDirect {
	int idContratDirect;
	Actif actif;
	NegoType typeN;
	int nombre;
	Date dateTransaction;
	User proposeUser;
	User accepteUser;
	
	public int getIdContratDirect() {
		return idContratDirect;
	}
	public void setIdContratDirect(int idContratDirect) {
		this.idContratDirect = idContratDirect;
	}
	public Actif getActif() {
		return actif;
	}
	public void setActif(Actif actif) {
		this.actif = actif;
	}
	public NegoType getTypeN() {
		return typeN;
	}
	public void setTypeN(NegoType typeN) {
		this.typeN = typeN;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	public User getProposeUser() {
		return proposeUser;
	}
	public void setProposeUser(User proposeUser) {
		this.proposeUser = proposeUser;
	}
	public User getAccepteUser() {
		return accepteUser;
	}
	public void setAccepteUser(User accepteUser) {
		this.accepteUser = accepteUser;
	}
}

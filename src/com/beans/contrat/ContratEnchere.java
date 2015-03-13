package com.beans.contrat;

import java.sql.Date;
import java.util.List;

import com.beans.User;

public class ContratEnchere {
	int idContratEnchere;
	Actif actif;
	List<PropositionEnchere> propEnc;
	NegoType typeN;
	Date dateFin;

	User proposeUser;
	User accepteUser;
	public int getIdContratEnchere() {
		return idContratEnchere;
	}
	public void setIdContratEnchere(int idContratEnchere) {
		this.idContratEnchere = idContratEnchere;
	}
	public Actif getActif() {
		return actif;
	}
	public void setActif(Actif actif) {
		this.actif = actif;
	}
	public List<PropositionEnchere> getPropEnc() {
		return propEnc;
	}
	public void setPropEnc(List<PropositionEnchere> propEnc) {
		this.propEnc = propEnc;
	}
	public NegoType getTypeN() {
		return typeN;
	}
	public void setTypeN(NegoType typeN) {
		this.typeN = typeN;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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

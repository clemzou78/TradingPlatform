package com.beans.contrat;

import java.util.Date;

import com.beans.Investisseur;
import com.beans.User;

public class Contrat {
	protected int idContrat;
	protected Actif actif;
	private int quantite;
	protected NegoType typeN;
	protected Investisseur proposeUser;
	protected Investisseur accepteUser;
	protected Date creation;
	protected boolean fini;
	
	public int getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}
	
	public Actif getActif() {
		return actif;
	}

	public void setActif(Actif actif) {
		this.actif = actif;
	}
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public NegoType getTypeN() {
		return typeN;
	}

	public void setTypeN(NegoType typeN) {
		this.typeN = typeN;
	}

	public Investisseur getProposeUser() {
		return proposeUser;
	}

	public void setProposeUser(Investisseur proposeUser) {
		this.proposeUser = proposeUser;
	}

	public Investisseur getAccepteUser() {
		return accepteUser;
	}

	public void setAccepteUser(Investisseur accepteUser) {
		this.accepteUser = accepteUser;
	}

	
	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}
	
	public boolean isFini() {
		return fini;
	}

	public void setFini(boolean fini) {
		this.fini = fini;
	}	
	
	public Contrat() {
		super();
	}
	
	public double getPrix(){return 0;}



	

}
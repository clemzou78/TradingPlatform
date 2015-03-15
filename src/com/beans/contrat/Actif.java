package com.beans.contrat;

import java.util.Date;

import com.beans.Investisseur;
import com.beans.Societe;


public abstract class Actif {
	private int idActif;
	private Societe soc;
	public int getIdActif() {
		return idActif;
	}
	public void setIdActif(int idActif) {
		this.idActif = idActif;
	}
	public Societe getSoc() {
		return soc;
	}
	public void setSoc(Societe soc) {
		this.soc = soc;
	}
}



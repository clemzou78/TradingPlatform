package com.beans.contrat;

import java.sql.Date;

import com.beans.Investisseur;
import com.beans.Societe;


public abstract class Actif {
	private int idActif;
	private Societe soc;
	int getIdActif() {
		return idActif;
	}
	void setIdActif(int idActif) {
		this.idActif = idActif;
	}
	Societe getSoc() {
		return soc;
	}
	void setSoc(Societe soc) {
		this.soc = soc;
	}
}


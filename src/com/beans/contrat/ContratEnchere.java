package com.beans.contrat;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.beans.User;
import com.ejb.ServiceContrat;

public class ContratEnchere extends Contrat {
	List<PropositionEnchere> propEnc;
	private double prixDepart; //borne min ou max selon NegoType
	Date dateFin;

	public ContratEnchere(){
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
	public double getPrixDepart() {
		return prixDepart;
	}
	public void setPrixDepart(double prixDepart) {
		this.prixDepart = prixDepart;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public double getPrix(){
		PropositionEnchere pe= (new ServiceContrat().valeurGagnanteEnchere(this));
		return (pe==null?prixDepart:pe.getMontant());
	}
	

	
	

}



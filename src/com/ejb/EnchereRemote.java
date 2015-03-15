package com.ejb;

import java.util.Date;

import javax.ejb.Remote;

import com.beans.contrat.ContratEnchere;

@Remote
public interface EnchereRemote {
	public void createTimer(Date fin, int idCe);
}

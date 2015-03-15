package com.ejb;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

import com.beans.contrat.ContratEnchere;

@Stateless
public class FinEnchere {
	
	@Resource
	private SessionContext context;

	ContratEnchere ce;
	public FinEnchere(ContratEnchere ce) {
		this.ce=ce;
	}
	
	public void createTimer(Date dateFinEnchere) {
		   context.getTimerService().createTimer(dateFinEnchere, "Cretion timer enchère "+ce);
		}


	@Timeout
	public void timeOutHandler(Timer timer){
	   System.out.println("Fin enchère : " + ce);        
	   timer.cancel();
	   ServiceContrat sc=new ServiceContrat();
	   sc.fin(ce.getIdContrat());
	}
}
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

import javax.ejb.Remote;


@Stateless
public class FinEnchere implements FinEnchereInterface{
	
	@Resource
	private SessionContext context;

	ContratEnchere ce;
	
	public FinEnchere(){
	}
	
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
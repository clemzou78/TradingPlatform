package com.ejb;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import com.beans.contrat.ContratEnchere;

import javax.ejb.Remote;


@Stateless
public class FinEnchere{
	
	@Resource
    TimerService timerService;

	public ContratEnchere ce;
	
	public FinEnchere(){
	}
	

	
	public void createTimer(Date dateFinEnchere) {
		
		timerService.createTimer(dateFinEnchere, "Cretion timer enchère "+ce);
		}


	@Timeout
	public void timeOutHandler(Timer timer){
	   System.out.println("Fin enchère : " + ce);        
	   timer.cancel();
	   ServiceContrat sc=new ServiceContrat();
	   sc.fin(ce.getIdContrat());
	}
}
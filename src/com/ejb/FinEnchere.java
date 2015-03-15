package com.ejb;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.beans.contrat.ContratEnchere;

@Singleton
@Startup
@LocalBean
public class FinEnchere {
	
	@Resource
	TimerService timerService;
	
	ContratEnchere ce;
	public FinEnchere(){}
	public FinEnchere(ContratEnchere ce) {
		this.ce=ce;
	}
	
	public void createTimer(Date dateFinEnchere) {		
		Timer timer = timerService.createTimer(dateFinEnchere, "Cretion timer enchère "+ce);
	}


	@Timeout
	public void timeOutHandler(Timer timer){
	   System.out.println("Fin enchère : " + ce);        
	   timer.cancel();
	   ServiceContrat sc=new ServiceContrat();
	   sc.fin(ce.getIdContrat());
	}
}
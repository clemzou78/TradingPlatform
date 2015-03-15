package com.ejb;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import javax.annotation.*;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import com.beans.contrat.ContratEnchere;



@Stateless
public class FinEnchere implements EnchereRemote{
	
	@Resource
    TimerService timerService;
	@Resource
	private SessionContext context;


	public int idce;
	
	public FinEnchere(){
	}


	
	public void createTimer(Date dateFinEnchere, int id) {

		timerService.createTimer(dateFinEnchere, id);
		}


	@Timeout
	public void timeOutHandler(Timer timer){
		System.out.println(timer.getInfo()); 
	   (new ServiceContrat()).fin(Integer.parseInt(timer.getInfo().toString()));
	   timer.cancel();
	
	}







}
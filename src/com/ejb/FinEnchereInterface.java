package com.ejb;

import java.util.Date;

import javax.ejb.Remote; 
@Remote 
public interface FinEnchereInterface { 
    void createTimer(Date d); 
}
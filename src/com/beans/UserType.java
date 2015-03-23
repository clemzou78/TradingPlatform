package com.beans;

public enum UserType {
	  	Administrateur("Administrateur"),
	  	Investisseur("Investisseur"),
	  	Societe("Societe");
	  	
	  	private String type;
	  	UserType(String type){
	  		this.type=type;
	  	}
	  	
	    public String toString(){
	        return type;
	     }

}

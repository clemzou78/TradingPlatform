package com.beans;

public enum UserType {
	  	Administrateur("Administrateur"),
	  	Investisseur("Investisseur"),
	  	Societe("Societ�");
	  	
	  	private String type;
	  	UserType(String type){
	  		this.type=type;
	  	}
	  	
	    public String toString(){
	        return type;
	     }

}

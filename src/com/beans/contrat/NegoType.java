package com.beans.contrat;

public enum NegoType {
	Achat("Achat"),
  	Vente("Vente");
  	
  	private String type;
  	NegoType(String type){
  		this.type=type;
  	}
  	
    public String toString(){
        return type;
     }
}

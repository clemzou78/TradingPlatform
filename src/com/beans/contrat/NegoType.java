package com.beans.contrat;

public enum NegoType {
	Achat("Achat"),
  	Vente("Vente");
  	
  	private String type;
  	NegoType(String type){
  		this.type=type;
  	}
  	
  	public static NegoType parse(String s){
  		if (s.equals(Achat)) return Achat;
  		else return Vente;
  	}
    public String toString(){
        return type;
     }
}

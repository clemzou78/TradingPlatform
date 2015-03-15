package com.beans.contrat;

public class ActifFactory{

	public Actif getActif(String type) {
		if ("Action".equals(type)) {
			return new Action();
		} else {
			return new StockOption();
		}
	}

}
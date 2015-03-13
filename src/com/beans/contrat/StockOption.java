package com.beans.contrat;

import java.sql.Date;

public class StockOption extends Actif{
	Date maturite;
	double strike;
	public Date getMaturite() {
		return maturite;
	}
	public void setMaturite(Date maturite) {
		this.maturite = maturite;
	}
	public double getStrike() {
		return strike;
	}
	public void setStrike(double strike) {
		this.strike = strike;
	}
	
	
}

package com.ep.diodiAndStabilitroni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Given implements Serializable{
	private double tok;
	private double naprWihodnoe;
	private double deltaNaprWihodnoe;
	private int var;
	private boolean shema;
	
	
	public Given(double tok, double napr, double delta, int var, boolean shema){
		this.tok = tok;
		this.deltaNaprWihodnoe = delta;
		this.naprWihodnoe = napr;
		this.var = var;
		this.setShema(shema);
	}
	
	public double getTok(){
		return tok;
	}
	
	public double getNaprWihodnoe(){
		return naprWihodnoe;
	}
	
	public double getDeltaNaprWihodnoe(){
		return deltaNaprWihodnoe;
	}
	
	public int getVar(){
		return var;
	}

	public boolean isShema() {
		return shema;
	}

	public void setShema(boolean shema) {
		this.shema = shema;
	}
	
}

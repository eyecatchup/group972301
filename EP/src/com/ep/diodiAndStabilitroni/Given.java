package com.ep.diodiAndStabilitroni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Given implements Serializable{
	private float tok;
	private float naprWihodnoe;
	private float deltaNaprWihodnoe;
	private int var;
	
	
	public Given(float tok, float napr, float delta, int var){
		this.tok = tok;
		this.deltaNaprWihodnoe = delta;
		this.naprWihodnoe = napr;
		this.var = var;
	}
	
	public float getTok(){
		return tok;
	}
	
	public float getNaprWihodnoe(){
		return naprWihodnoe;
	}
	
	public float getDeltaNaprWihodnoe(){
		return deltaNaprWihodnoe;
	}
	
	public int getVar(){
		return var;
	}
	
}

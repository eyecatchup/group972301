package com.ep.diodiAndStabilitroni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Diod implements Serializable{
	private double tok_maks;
	private double tok_i_maks;
	private double napr_maks;
	private double t_obr;
	private String name;
	
	Diod(String name, double tak_maks, double tok_i_maks, double napr_maks, double t_obr){
		this.name = name;
		this.tok_maks = tak_maks;
		this.tok_i_maks = tok_i_maks;
		this.napr_maks = napr_maks;
		this.t_obr = t_obr;
	}
	
	static public Diod getDiod(double tok, double napr){
		if(napr < 100){
			
			return new Diod("йд226ю", 1.7, 10 , 100, 0.25);
		} else if (napr < 200){
			return new Diod("йд226а", 1.7, 10 , 200, 0.25);
		} else if (napr < 400) {
			return new Diod("йд226б",  1.7, 10 , 400, 0.25);
		} else if (napr < 600) {
			return new Diod("йд226ц", 1.7, 10 , 600, 0.25);
		} else if (napr < 800) {
			return new Diod("йд226д",  1.7, 10 , 800, 0.25);
		}
	
		return null;
	}

	public double getTok_maks() {
		return tok_maks;
	}

	public void setTok_maks(double tok_maks) {
		this.tok_maks = tok_maks;
	}

	public double getTok_i_maks() {
		return tok_i_maks;
	}

	public void setTok_i_maks(double tok_i_maks) {
		this.tok_i_maks = tok_i_maks;
	}

	public double getNapr_maks() {
		return napr_maks;
	}

	public void setNapr_maks(double napr_maks) {
		this.napr_maks = napr_maks;
	}

	public double getT_obr() {
		return t_obr;
	}

	public void setT_obr(double t_obr) {
		this.t_obr = t_obr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Object[][] getDiodData(){
		Object[][] data = new Object[1][5];
		
		data [0][0] = getName();
		data [0][1] = getTok_maks();
		data [0][2] = getTok_i_maks();
		data [0][3] = getNapr_maks();
		data [0][4] = getT_obr();
		
		return data;
	}
}

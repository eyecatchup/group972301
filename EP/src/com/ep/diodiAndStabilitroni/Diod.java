package com.ep.diodiAndStabilitroni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Diod implements Serializable{
	
	static public String getDiod(double tok, double napr){
		if(napr < 100){
			return "��226�";
		} else if (napr < 200){
			return "��226�";
		} else if (napr < 400) {
			return "��226�";
		} else if (napr < 600) {
			return "��226�";
		} else if (napr < 800) {
			return "��226�";
		}
	
		return null;
	}
}

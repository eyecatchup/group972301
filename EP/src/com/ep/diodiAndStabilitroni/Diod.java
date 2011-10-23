package com.ep.diodiAndStabilitroni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Diod implements Serializable{
	
	static public String getDiod(double tok, double napr){
		if(napr < 100){
			return "йд226ю";
		} else if (napr < 200){
			return "йд226а";
		} else if (napr < 400) {
			return "йд226б";
		} else if (napr < 600) {
			return "йд226ц";
		} else if (napr < 800) {
			return "йд226д";
		}
	
		return null;
	}
}

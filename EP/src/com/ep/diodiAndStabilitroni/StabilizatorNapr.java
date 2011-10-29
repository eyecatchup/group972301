package com.ep.diodiAndStabilitroni;


//POJO for stabilitron
public class StabilizatorNapr {
	private int CoefStabiliz;
	private double amplitudaPuls;
	private double soprotGosResis;
	private double rabTokStabilit;
	private double tokGosResistora;
	private double soprNagruzki;
	private double postNaprNaWhodeStabilizatora;
	private double temperUhod;
	
	public void setTemperUhod(double temp){
		temperUhod = temp;
	}
	
	public double getTemperUhod(){
		return temperUhod;
	}
	
	public void setPostNagrNaWhodeStabilizatora(double post){
		postNaprNaWhodeStabilizatora = post;
	}
	
	public double getPostNagrNaWhodeStabilizatora(){
		return postNaprNaWhodeStabilizatora;
	}
	
	public void setSoprNagr(double sopr){
		soprNagruzki = sopr;
	}
	
	public double getSoprNagruzki(){
		return soprNagruzki;
	}
	
	public void setTokGosResistora(double tok){
		tokGosResistora = tok;
	}
	
	public double getTokGosResistora(){
		return tokGosResistora;
	}
	
	public void setRabTokStabilitrona(double tok){
		rabTokStabilit = tok;
	}
	
	public double getRabTokStabilitrona(){
		return rabTokStabilit;
	}
	
	public void setCoefStabliz(double tokNagruzki){
		if(tokNagruzki > 0.08){
			CoefStabiliz = 30;
		} else if(tokNagruzki < 0.08) {
			CoefStabiliz = 60;
		}
	}
	
	public int getCoefStabiliz(){
		return CoefStabiliz;
	}
	
	public void setAmplitudePuls(double amplPuls){
		this.amplitudaPuls = amplPuls;
	}
	
	public double getAmplitudePuls(){
		return amplitudaPuls;
	}
	
	public void setSoprotGosResis(double sopr){
		this.soprotGosResis = sopr;
	}
	
	public double getSoprotGosResis(){
		return soprotGosResis;
	}
	
}

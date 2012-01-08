package ep.diodiAndStabilitroni;


//POJO for stabilitron
public class StabilizatorNapr {
	private int CoefStabiliz;
	private float amplitudaPuls;
	private float soprotGosResis;
	private float rabTokStabilit;
	private float tokGosResistora;
	private float soprNagruzki;
	private float postNaprNaWhodeStabilizatora;
	private float temperUhod;
	
	public void setTemperUhod(float temp){
		temperUhod = temp;
	}
	
	public float getTemperUhod(){
		return temperUhod;
	}
	
	public void setPostNagrNaWhodeStabilizatora(float post){
		postNaprNaWhodeStabilizatora = post;
	}
	
	public float getPostNagrNaWhodeStabilizatora(){
		return postNaprNaWhodeStabilizatora;
	}
	
	public void setSoprNagr(float sopr){
		soprNagruzki = sopr;
	}
	
	public float getSoprNagruzki(){
		return soprNagruzki;
	}
	
	public void setTokGosResistora(float tok){
		tokGosResistora = tok;
	}
	
	public float getTokGosResistora(){
		return tokGosResistora;
	}
	
	public void setRabTokStabilitrona(float tok){
		rabTokStabilit = tok;
	}
	
	public float getRabTokStabilitrona(){
		return rabTokStabilit;
	}
	
	public void setCoefStabliz(float tokNagruzki){
		if(tokNagruzki > 0.08){
			CoefStabiliz = 30;
		} else if(tokNagruzki < 0.08) {
			CoefStabiliz = 60;
		}
	}
	
	public int getCoefStabiliz(){
		return CoefStabiliz;
	}
	
	public void setAmplitudePuls(float amplPuls){
		this.amplitudaPuls = amplPuls;
	}
	
	public float getAmplitudePuls(){
		return amplitudaPuls;
	}
	
	public void setSoprotGosResis(float sopr){
		this.soprotGosResis = sopr;
	}
	
	public float getSoprotGosResis(){
		return soprotGosResis;
	}
	
}

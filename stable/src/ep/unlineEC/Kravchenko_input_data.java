package ep.unlineEC;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import dao.KravchenkoDAOImpl;
import entity.Kravchenko_data;

public class Kravchenko_input_data implements Serializable{
	private Double[] row1;
	private Double[] row2;
	private Double u0;
	private Double r;
	private Double a2;
	private Double a1;
	private Double u1;
	private Double krutizna;
	private Double ugolOtsechki;
	private Double[] sinUgla;
	private Double[] cosUgla;
	private Double amplitudaToka;
	private Double constToka;
	private Double amplituda1G;
	private Double amplituda2G;
	private Double amplituda3G;
	private Double amplituda4G;
	private Double srednyayaKrutizna;
	private Double koefIskazhenii;

	private Double[] u;
	private Double[] i;
	private Double u0_init;
	private Double e;
	
	
	public Double[] getU() {
		return u;
	}

	public void setU(Double[] u) {
		this.u = u;
	}

	public Double[] getI() {
		return i;
	}

	public void setI(Double[] i) {
		this.i = i;
	}

	public Kravchenko_input_data(Integer variant){
		KravchenkoDAOImpl daoImpl = new KravchenkoDAOImpl();
		List<Kravchenko_data> data = daoImpl.getDataByVariant(variant);
		this.u = new Double[12];
		this.i = new Double[12];
		Iterator<Kravchenko_data> iter = data.iterator();
		for(int j = 0; j<12; j++){
			Kravchenko_data d = iter.next();
			/*this.u[j] = d.getData_u();
			this.i[j] = d.getData_i();
			this.e = d.getData_e();
			this.u0_init = d.getData_u0();*/
		}
	}
	
	public void calculateR(){
		this.r = (this.u[12]-this.u[10])/(this.i[12]-this.i[10]);
	}
	
	public static void main(String[] args){
		Kravchenko_input_data data = new Kravchenko_input_data(10);
		Double[] ii = data.getI();
		Double[] uu = data.getU();
		for(int j = 0; j<12; j++){
			System.out.println(uu[j]+" "+ii[j]);
		}
		
	}
}
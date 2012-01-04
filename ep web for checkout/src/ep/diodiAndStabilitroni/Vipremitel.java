package ep.diodiAndStabilitroni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Vipremitel implements Serializable {
	private float naprVixVipr;
	private float deltaNaprVixVipr;
	private float tokVipr;

	private float emkost;
	private float naprObr;
	private float naprVxod;

	private boolean shema;
	private int f = 50;
	//private Diod diod;

	public Vipremitel(StabilizatorNapr stab, boolean shema) {
		this.naprVixVipr = stab.getPostNagrNaWhodeStabilizatora();
		this.deltaNaprVixVipr = stab.getAmplitudePuls();
		this.tokVipr = stab.getTokGosResistora();
		this.shema = shema;

		calcAplitudVxodNaprVipr();
		calcEmkostCondensatora();
		calcAplitudObrNapr();
		
		selectSuitableDiod();
		//diod = Diod.getDiod(tokVipr, naprObr);
	}

	private void selectSuitableDiod() {
		
		
	}

	private void calcAplitudObrNapr() {
		if (shema) {
			naprObr = 2 * naprVxod;
		} else {
			naprObr = naprVxod;
		}

	}

	private void calcEmkostCondensatora() {
		int koef = 0;
		if (shema) {
			koef = 1;
		} else {
			koef = 2;
		}

		emkost = tokVipr / (f * koef * this.deltaNaprVixVipr);
	}

	private void calcAplitudVxodNaprVipr() {
		int naprPR;
		// not sure, care about this
		if (shema) {
			naprPR = 1;
		} else {
			naprPR = 2;
		}

		this.naprVxod = this.naprVixVipr + this.deltaNaprVixVipr + naprPR;

	}

	public float getNaprVixVipr() {
		return naprVixVipr;
	}

	public void setNaprVixVipr(float naprVixVipr) {
		this.naprVixVipr = naprVixVipr;
	}

	public float getDeltaNaprVixVipr() {
		return deltaNaprVixVipr;
	}

	public void setDeltaNaprVixVipr(float deltaNaprVixVipr) {
		this.deltaNaprVixVipr = deltaNaprVixVipr;
	}

	public float getTokVipr() {
		return tokVipr;
	}

	public void setTokVipr(float tokVipr) {
		this.tokVipr = tokVipr;
	}

	public float getEmkost() {
		return emkost;
	}

	public void setEmkost(float emkost) {
		this.emkost = emkost;
	}

	public float getNaprObr() {
		return naprObr;
	}

	public void setNaprObr(float naprObr) {
		this.naprObr = naprObr;
	}

	public float getNaprVxod() {
		return naprVxod;
	}

	public void setNaprVxod(float naprVxod) {
		this.naprVxod = naprVxod;
	}

	/*public Diod getDiod() {
		return diod;
	}

	public void setDiod(Diod diod) {
		this.diod = diod;
	}	
	*/
}

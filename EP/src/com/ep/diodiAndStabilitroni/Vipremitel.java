package com.ep.diodiAndStabilitroni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Vipremitel implements Serializable {
	private double naprVixVipr;
	private double deltaNaprVixVipr;
	private double tokVipr;

	private double emkost;
	private double naprObr;
	private double naprVxod;

	private boolean shema;
	private int f = 50;
	private Diod diod;

	public Vipremitel(StabilizatorNapr stab, boolean shema) {
		this.naprVixVipr = stab.getPostNagrNaWhodeStabilizatora();
		this.deltaNaprVixVipr = stab.getAmplitudePuls();
		this.tokVipr = stab.getTokGosResistora();
		this.shema = shema;

		calcAplitudVxodNaprVipr();
		calcEmkostCondensatora();
		calcAplitudObrNapr();
		diod = Diod.getDiod(tokVipr, naprObr);
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

		emkost = tokVipr / (f * koef * tokVipr);
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

	public double getNaprVixVipr() {
		return naprVixVipr;
	}

	public void setNaprVixVipr(double naprVixVipr) {
		this.naprVixVipr = naprVixVipr;
	}

	public double getDeltaNaprVixVipr() {
		return deltaNaprVixVipr;
	}

	public void setDeltaNaprVixVipr(double deltaNaprVixVipr) {
		this.deltaNaprVixVipr = deltaNaprVixVipr;
	}

	public double getTokVipr() {
		return tokVipr;
	}

	public void setTokVipr(double tokVipr) {
		this.tokVipr = tokVipr;
	}

	public double getEmkost() {
		return emkost;
	}

	public void setEmkost(double emkost) {
		this.emkost = emkost;
	}

	public double getNaprObr() {
		return naprObr;
	}

	public void setNaprObr(double naprObr) {
		this.naprObr = naprObr;
	}

	public double getNaprVxod() {
		return naprVxod;
	}

	public void setNaprVxod(double naprVxod) {
		this.naprVxod = naprVxod;
	}

	public Diod getDiod() {
		return diod;
	}

	public void setDiod(Diod diod) {
		this.diod = diod;
	}
}

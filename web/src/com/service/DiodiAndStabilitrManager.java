package com.service;

import javax.faces.event.ActionEvent;

import entity.Given;
import ep.diodiAndStabilitroni.CalculatorStabilitron;
import ep.diodiAndStabilitroni.Vipremitel;

public class DiodiAndStabilitrManager {
	private Given given;
	private CalculatorStabilitron calculatorStabilitron;
	private Vipremitel vipremitel;

	private static final String TRUE = "Верно";
	private static final String FALSE = "Неверно";

	private String Uvxst;
	private String Uvix;
	private String deltaUvxSt;
	private String deltaUvix;
	private String deltaUtemper;
	private String Ir;
	private String Ist;
	private String Inagr;
	private String C;
	private String Kst;
	private String Rn;
	private String Rgen;

	private String resUvxst;
	private String resUvix;
	private String resdeltaUvxSt;
	private String resdeltaUvix;
	private String resdeltaUtemper;
	private String resIr;
	private String resIst;
	private String resInagr;
	private String resC;
	private String resKst;
	private String resRn;
	private String resRgen;

	public void caltulate() {
		calculatorStabilitron = new CalculatorStabilitron(given,
				given.getStabilitron());

		boolean state = false;
		if (given.getShema() == 1) {
			state = true;
		}

		vipremitel = new Vipremitel(calculatorStabilitron.getStabilitron(),
				state);

	}

	public void chechResult(ActionEvent e) {

		Integer i = Integer.parseInt(Uvxst);
		Integer b = (int) calculatorStabilitron.getStabilitron()
				.getPostNagrNaWhodeStabilizatora();

		if (i == b) {
			resUvxst = TRUE;
		} else if (i == (b - 1)) {
			resUvxst = TRUE;

		} else if (i == (b + 1)) {
			resUvxst = TRUE;

		} else {
			resUvxst = FALSE;
		}

		i = Integer.parseInt(deltaUvxSt);
		b = (int) calculatorStabilitron.getStabilitron().getAmplitudePuls();
		if (i == b) {
			resdeltaUvxSt = TRUE;
		} else if (i == (b - 1)) {
			resdeltaUvxSt = TRUE;

		} else if (i == (b + 1)) {
			resdeltaUvxSt = TRUE;

		} else {
			resdeltaUvxSt = FALSE;
		}

		i = Integer.parseInt(deltaUtemper);
		b = (int) calculatorStabilitron.getStabilitron().getTemperUhod();

		if (i == b) {
			resdeltaUtemper = TRUE;
		} else if (i == (b - 1)) {
			resdeltaUtemper = TRUE;

		} else if (i == (b + 1)) {
			resdeltaUtemper = TRUE;

		} else {
			resdeltaUtemper = FALSE;
		}

		i = Integer.parseInt(Ir);
		b = (int) calculatorStabilitron.getStabilitron().getTemperUhod();

		if (i == b) {
			resIr = TRUE;
		} else if (i == (b - 1)) {
			resIr = TRUE;

		} else if (i == (b + 1)) {
			resIr = TRUE;

		} else {
			resIr = FALSE;
		}

		i = Integer.parseInt(Ist);
		b = (int) calculatorStabilitron.getStabilitron()
				.getRabTokStabilitrona();

		if (i == b) {
			resIst = TRUE;
		} else if (i == (b - 1)) {
			resIst = TRUE;

		} else if (i == (b + 1)) {
			resIst = TRUE;

		} else {
			resIst = FALSE;
		}

		i = Integer.parseInt(C);
		b = (int) vipremitel.getEmkost();

		if (i == b) {
			resC = TRUE;
		} else if (i == (b - 1)) {
			resC = TRUE;

		} else if (i == (b + 1)) {
			resC = TRUE;

		} else {
			resC = FALSE;
		}

		i = Integer.parseInt(Kst);
		b = calculatorStabilitron.getStabilitron().getCoefStabiliz();

		if (i == b) {
			resKst = TRUE;
		} else if (i == (b - 1)) {
			resKst = TRUE;

		} else if (i == (b + 1)) {
			resKst = TRUE;

		} else {
			resKst = FALSE;
		}

		i = Integer.parseInt(Rn);
		b = (int) calculatorStabilitron.getStabilitron().getSoprNagruzki();

		if (i == b) {
			resRn = TRUE;
		} else if (i == (b - 1)) {
			resRn = TRUE;

		} else if (i == (b + 1)) {
			resRn = TRUE;

		} else {
			resRn = FALSE;
		}

		i = Integer.parseInt(Rgen);
		b = (int) calculatorStabilitron.getStabilitron().getSoprotGosResis();

		if (i == b) {
			resRgen = TRUE;
		} else if (i == (b - 1)) {
			resRgen = TRUE;

		} else if (i == (b + 1)) {
			resRgen = TRUE;

		} else {
			resRgen = FALSE;
		}

	}

	public Given getGiven() {
		return given;
	}

	public void setGiven(Given given) {
		this.given = given;
	}

	public CalculatorStabilitron getCalculatorStabilitron() {
		return calculatorStabilitron;
	}

	public void setCalculatorStabilitron(
			CalculatorStabilitron calculatorStabilitron) {
		this.calculatorStabilitron = calculatorStabilitron;
	}

	public Vipremitel getViprymitel() {
		return vipremitel;
	}

	public void setViprymitel(Vipremitel calculatorViprymitel) {
		this.vipremitel = calculatorViprymitel;
	}

	public String getUvxst() {
		return Uvxst;
	}

	public void setUvxst(String uvxst) {
		Uvxst = uvxst;
	}

	public String getUvix() {
		return Uvix;
	}

	public void setUvix(String uvix) {
		Uvix = uvix;
	}

	public String getDeltaUvxSt() {
		return deltaUvxSt;
	}

	public void setDeltaUvxSt(String deltaUvxSt) {
		this.deltaUvxSt = deltaUvxSt;
	}

	public String getDeltaUvix() {
		return deltaUvix;
	}

	public void setDeltaUvix(String deltaUvix) {
		this.deltaUvix = deltaUvix;
	}

	public String getDeltaUtemper() {
		return deltaUtemper;
	}

	public void setDeltaUtemper(String deltaUtemper) {
		this.deltaUtemper = deltaUtemper;
	}

	public String getIr() {
		return Ir;
	}

	public void setIr(String ir) {
		Ir = ir;
	}

	public String getIst() {
		return Ist;
	}

	public void setIst(String ist) {
		Ist = ist;
	}

	public String getInagr() {
		return Inagr;
	}

	public void setInagr(String inagr) {
		Inagr = inagr;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getKst() {
		return Kst;
	}

	public void setKst(String kst) {
		Kst = kst;
	}

	public String getRn() {
		return Rn;
	}

	public void setRn(String rn) {
		Rn = rn;
	}

	public String getRgen() {
		return Rgen;
	}

	public void setRgen(String rgen) {
		Rgen = rgen;
	}

	public String getResUvxst() {
		return resUvxst;
	}

	public void setResUvxst(String resUvxst) {
		this.resUvxst = resUvxst;
	}

	public String getResUvix() {
		return resUvix;
	}

	public void setResUvix(String resUvix) {
		this.resUvix = resUvix;
	}

	public String getResdeltaUvxSt() {
		return resdeltaUvxSt;
	}

	public void setResdeltaUvxSt(String resdeltaUvxSt) {
		this.resdeltaUvxSt = resdeltaUvxSt;
	}

	public String getResdeltaUvix() {
		return resdeltaUvix;
	}

	public void setResdeltaUvix(String resdeltaUvix) {
		this.resdeltaUvix = resdeltaUvix;
	}

	public String getResdeltaUtemper() {
		return resdeltaUtemper;
	}

	public void setResdeltaUtemper(String resdeltaUtemper) {
		this.resdeltaUtemper = resdeltaUtemper;
	}

	public String getResIr() {
		return resIr;
	}

	public void setResIr(String resIr) {
		this.resIr = resIr;
	}

	public String getResIst() {
		return resIst;
	}

	public void setResIst(String resIst) {
		this.resIst = resIst;
	}

	public String getResInagr() {
		return resInagr;
	}

	public void setResInagr(String resInagr) {
		this.resInagr = resInagr;
	}

	public String getResC() {
		return resC;
	}

	public void setResC(String resC) {
		this.resC = resC;
	}

	public String getResKst() {
		return resKst;
	}

	public void setResKst(String resKst) {
		this.resKst = resKst;
	}

	public String getResRn() {
		return resRn;
	}

	public void setResRn(String resRn) {
		this.resRn = resRn;
	}

	public String getResRgen() {
		return resRgen;
	}

	public void setResRgen(String resRgen) {
		this.resRgen = resRgen;
	}

}

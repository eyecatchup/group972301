package com.service;

import javax.faces.event.ActionEvent;

import entity.GivenOB;
import ep.ysilitelnieKaskadi.CalculatorOB;

public class OBManager {
	private GivenOB given;
	private CalculatorOB calculatorOB;

	private String Ua;// show

	private String Uip;// show
	private String Rk;// show
	private String Ra;// show
	private String Ib;// show
	private String Ub;// show
	private String Id;// show
	private String R1;// show
	private String R2;// show

	private String Rvh;// show
	private String Rb;// show
	private String Rvih;// show
	private String C1;// show
	private String C2;// show
	private String Ca;// show
	private String Cb;// show

	private String Ki;// show
	private String Ku;// show

	private String fn1;// show
	private String fn2;// show
	private String fn3;// show
	private String fv1;// show
	private String fv2;// show
	private String fv3;// show

	private String MvN;// show
	private String MnN;// show

	private String UaStr;// show
	private String UipStr;// show

	private String RkStr;// show
	private String RaStr;// show
	private String IbStr;// show
	private String UbStr;// show
	private String IdStr;// show
	private String R1Str;// show
	private String R2Str;// show

	private String RvhStr;// show
	private String RbStrStr;// show
	private String RvihStr;// show
	private String C1Str;// show
	private String C2Str;// show
	private String CaStr;// show
	private String CbStr;// show

	private String KiStr;// show
	private String KuStr;// show

	private String fn1Str;// show
	private String fn2Str;// show
	private String fn3Str;// show
	private String fv1Str;// show
	private String fv2Str;// show
	private String fv3Str;// show

	private String MvNStr;// show
	private String MnNStr;// show

	public void calculate(String theme1) {
		calculatorOB = new CalculatorOB(given, given.getOb_Transistor());
		calculatorOB.calc();
	}

	public void checkResult(ActionEvent e) {

	}

	public GivenOB getGiven() {
		return given;
	}

	public void setGiven(GivenOB given) {
		this.given = given;
	}

	public CalculatorOB getCalculatorOB() {
		return calculatorOB;
	}

	public void setCalculatorOB(CalculatorOB calculatorOB) {
		this.calculatorOB = calculatorOB;
	}

	public String getUaStr() {
		return UaStr;
	}

	public void setUaStr(String uaStr) {
		UaStr = uaStr;
	}

	public String getUipStr() {
		return UipStr;
	}

	public void setUipStr(String uipStr) {
		UipStr = uipStr;
	}

	public String getRkStr() {
		return RkStr;
	}

	public void setRkStr(String rkStr) {
		RkStr = rkStr;
	}

	public String getRaStr() {
		return RaStr;
	}

	public void setRaStr(String raStr) {
		RaStr = raStr;
	}

	public String getIbStr() {
		return IbStr;
	}

	public void setIbStr(String ibStr) {
		IbStr = ibStr;
	}

	public String getUbStr() {
		return UbStr;
	}

	public void setUbStr(String ubStr) {
		UbStr = ubStr;
	}

	public String getIdStr() {
		return IdStr;
	}

	public void setIdStr(String idStr) {
		IdStr = idStr;
	}

	public String getR1Str() {
		return R1Str;
	}

	public void setR1Str(String r1Str) {
		R1Str = r1Str;
	}

	public String getR2Str() {
		return R2Str;
	}

	public void setR2Str(String r2Str) {
		R2Str = r2Str;
	}

	public String getRvhStr() {
		return RvhStr;
	}

	public void setRvhStr(String rvhStr) {
		RvhStr = rvhStr;
	}

	public String getRbStrStr() {
		return RbStrStr;
	}

	public void setRbStrStr(String rbStrStr) {
		RbStrStr = rbStrStr;
	}

	public String getRvihStr() {
		return RvihStr;
	}

	public void setRvihStr(String rvihStr) {
		RvihStr = rvihStr;
	}

	public String getC1Str() {
		return C1Str;
	}

	public void setC1Str(String c1Str) {
		C1Str = c1Str;
	}

	public String getC2Str() {
		return C2Str;
	}

	public void setC2Str(String c2Str) {
		C2Str = c2Str;
	}

	public String getCaStr() {
		return CaStr;
	}

	public void setCaStr(String caStr) {
		CaStr = caStr;
	}

	public String getCbStr() {
		return CbStr;
	}

	public void setCbStr(String cbStr) {
		CbStr = cbStr;
	}

	public String getKiStr() {
		return KiStr;
	}

	public void setKiStr(String kiStr) {
		KiStr = kiStr;
	}

	public String getFn1Str() {
		return fn1Str;
	}

	public void setFn1Str(String fn1Str) {
		this.fn1Str = fn1Str;
	}

	public String getFn2Str() {
		return fn2Str;
	}

	public void setFn2Str(String fn2Str) {
		this.fn2Str = fn2Str;
	}

	public String getFn3Str() {
		return fn3Str;
	}

	public void setFn3Str(String fn3Str) {
		this.fn3Str = fn3Str;
	}

	public String getFv1Str() {
		return fv1Str;
	}

	public void setFv1Str(String fv1Str) {
		this.fv1Str = fv1Str;
	}

	public String getFv2Str() {
		return fv2Str;
	}

	public void setFv2Str(String fv2Str) {
		this.fv2Str = fv2Str;
	}

	public String getFv3Str() {
		return fv3Str;
	}

	public void setFv3Str(String fv3Str) {
		this.fv3Str = fv3Str;
	}

	public String getMvNStr() {
		return MvNStr;
	}

	public void setMvNStr(String mvNStr) {
		MvNStr = mvNStr;
	}

	public String getMnNStr() {
		return MnNStr;
	}

	public void setMnNStr(String mnNStr) {
		MnNStr = mnNStr;
	}

	public String getKuStr() {
		return KuStr;
	}

	public void setKuStr(String kuStr) {
		KuStr = kuStr;
	}

	public String getUa() {
		return Ua;
	}

	public void setUa(String ua) {
		Ua = ua;
	}

	public String getUip() {
		return Uip;
	}

	public void setUip(String uip) {
		Uip = uip;
	}

	public String getRk() {
		return Rk;
	}

	public void setRk(String rk) {
		Rk = rk;
	}

	public String getRa() {
		return Ra;
	}

	public void setRa(String ra) {
		Ra = ra;
	}

	public String getIb() {
		return Ib;
	}

	public void setIb(String ib) {
		Ib = ib;
	}

	public String getUb() {
		return Ub;
	}

	public void setUb(String ub) {
		Ub = ub;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getR1() {
		return R1;
	}

	public void setR1(String r1) {
		R1 = r1;
	}

	public String getR2() {
		return R2;
	}

	public void setR2(String r2) {
		R2 = r2;
	}

	public String getRvh() {
		return Rvh;
	}

	public void setRvh(String rvh) {
		Rvh = rvh;
	}

	public String getRb() {
		return Rb;
	}

	public void setRb(String rb) {
		Rb = rb;
	}

	public String getRvih() {
		return Rvih;
	}

	public void setRvih(String rvih) {
		Rvih = rvih;
	}

	public String getC1() {
		return C1;
	}

	public void setC1(String c1) {
		C1 = c1;
	}

	public String getC2() {
		return C2;
	}

	public void setC2(String c2) {
		C2 = c2;
	}

	public String getCa() {
		return Ca;
	}

	public void setCa(String ca) {
		Ca = ca;
	}

	public String getCb() {
		return Cb;
	}

	public void setCb(String cb) {
		Cb = cb;
	}

	public String getKi() {
		return Ki;
	}

	public void setKi(String ki) {
		Ki = ki;
	}

	public String getKu() {
		return Ku;
	}

	public void setKu(String ku) {
		Ku = ku;
	}

	public String getFn1() {
		return fn1;
	}

	public void setFn1(String fn1) {
		this.fn1 = fn1;
	}

	public String getFn2() {
		return fn2;
	}

	public void setFn2(String fn2) {
		this.fn2 = fn2;
	}

	public String getFn3() {
		return fn3;
	}

	public void setFn3(String fn3) {
		this.fn3 = fn3;
	}

	public String getFv1() {
		return fv1;
	}

	public void setFv1(String fv1) {
		this.fv1 = fv1;
	}

	public String getFv2() {
		return fv2;
	}

	public void setFv2(String fv2) {
		this.fv2 = fv2;
	}

	public String getFv3() {
		return fv3;
	}

	public void setFv3(String fv3) {
		this.fv3 = fv3;
	}

	public String getMvN() {
		return MvN;
	}

	public void setMvN(String mvN) {
		MvN = mvN;
	}

	public String getMnN() {
		return MnN;
	}

	public void setMnN(String mnN) {
		MnN = mnN;
	}

}

package com.service;

import javax.faces.event.ActionEvent;

import entity.GivenOB;
import ep.ysilitelnieKaskadi.CalculatorOB;

public class OBManager {
	private static final String TRUE = "Верно";
	private static final String FALSE = "Неверно";

	private GivenOB given;
	private CalculatorOB calculatorOB;
	private double passed = 0.0;
	private double total = 25.0;
	private String result = "";

	private String Ua;// show

	private String Uip;// show
	private String Rk;// show
	private String Ra;// show
	private String Ib;// show
	private String Ub;// show
//	private String Id;// show
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
	/*private String IdStr;// show
*/	private String R1Str;// show
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

	public void calculate() {
		calculatorOB = new CalculatorOB(given, given.getOb_Transistor());
		calculatorOB.calc();
		
		MainService.checkIfStudentHasMakr(2);
	}

	public void checkResult(ActionEvent e) {
		if (MainService.checkIfStudentHasMakr(2) == false)
			return;

		Integer i = Integer.parseInt(this.C1);
		Integer b = (int) calculatorOB.getC1();

		if (i == b) {
			C1Str = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			C1Str = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			C1Str = TRUE;
			passed += 1;

		} else {
			C1Str = FALSE;
		}

		i = Integer.parseInt(this.C2);
		b = (int) calculatorOB.getC2();

		if (i == b) {
			C2Str = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			C2Str = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			C2Str = TRUE;
			passed += 1;

		} else {
			C2Str = FALSE;
		}

		i = Integer.parseInt(Ca);
		b = (int) calculatorOB.getCa();
		if (i == b) {
			CaStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			CaStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			CaStr = TRUE;
			passed += 1;

		} else {
			CaStr = FALSE;
		}

		i = Integer.parseInt(this.Cb);
		b = (int) calculatorOB.getCb();
		if (i == b) {
			CbStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			CbStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			CbStr = TRUE;
			passed += 1;

		} else {
			CbStr = FALSE;
		}

		i = Integer.parseInt(this.fn1);
		b = (int) calculatorOB.getFn1();
		if (i == b) {
			fn1Str = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			fn1Str = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			fn1Str = TRUE;
			passed += 1;

		} else {
			fn1Str = FALSE;
		}

		i = Integer.parseInt(this.fn2);
		b = (int) calculatorOB.getFn2();
		if (i == b) {
			fn2Str = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			fn2Str = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			fn2Str = TRUE;
			passed += 1;

		} else {
			fn2Str = FALSE;
		}

		i = Integer.parseInt(this.fn3);
		b = (int) calculatorOB.getFn3();
		if (i == b) {
			fn3Str = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			fn3Str = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			fn3Str = TRUE;
			passed += 1;

		} else {
			fn3Str = FALSE;
		}

		i = Integer.parseInt(this.fv1);
		b = (int) calculatorOB.getFv1();
		if (i == b) {
			fv1Str = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			fv1Str = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			fv1Str = TRUE;
			passed += 1;

		} else {
			fv1Str = FALSE;
		}

		i = Integer.parseInt(this.fv2);
		b = (int) calculatorOB.getFv2();
		if (i == b) {
			fv2Str = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			fv2Str = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			fv2Str = TRUE;
			passed += 1;

		} else {
			fv2Str = FALSE;
		}

		i = Integer.parseInt(this.fv3);
		b = (int) calculatorOB.getFv3();
		if (i == b) {
			fv3Str = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			fv3Str = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			fv3Str = TRUE;
			passed += 1;

		} else {
			fv3Str = FALSE;
		}

		i = Integer.parseInt(this.Ib);
		b = (int) calculatorOB.getIb();
		if (i == b) {
			IbStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			IbStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			IbStr = TRUE;
			passed += 1;

		} else {
			IbStr = FALSE;
		}

		/*i = Integer.parseInt(this.Id);
		b = (int) calculatorOB.getId();
		if (i == b) {
			IdStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			IdStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			IdStr = TRUE;
			passed += 1;

		} else {
			IdStr = FALSE;
		}*/

		i = Integer.parseInt(this.Ki);
		b = (int) calculatorOB.getKi();
		if (i == b) {
			KiStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			KiStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			KiStr = TRUE;
			passed += 1;

		} else {
			KiStr = FALSE;
		}

		i = Integer.parseInt(this.Ku);
		b = (int) calculatorOB.getKu();
		if (i == b) {
			KuStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			KuStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			KuStr = TRUE;
			passed += 1;

		} else {
			KuStr = FALSE;
		}

		i = Integer.parseInt(this.MnN);
		b = (int) calculatorOB.getMnN();
		if (i == b) {
			MnNStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			MnNStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			MnNStr = TRUE;
			passed += 1;

		} else {
			MnNStr = FALSE;
		}

		i = Integer.parseInt(this.MvN);
		b = (int) calculatorOB.getMvN();
		if (i == b) {
			MvNStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			MvNStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			MvNStr = TRUE;
			passed += 1;

		} else {
			MvNStr = FALSE;
		}

		i = Integer.parseInt(this.R1);
		b = (int) calculatorOB.getR1();
		if (i == b) {
			R1Str = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			R1Str = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			R1Str = TRUE;
			passed += 1;

		} else {
			R1Str = FALSE;
		}

		i = Integer.parseInt(this.R2);
		b = (int) calculatorOB.getR2();
		if (i == b) {
			R2Str = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			R2Str = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			R2Str = TRUE;
			passed += 1;

		} else {
			R2Str = FALSE;
		}

		i = Integer.parseInt(this.Ra);
		b = (int) calculatorOB.getRa();
		if (i == b) {
			RaStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			RaStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			RaStr = TRUE;
			passed += 1;

		} else {
			RaStr = FALSE;
		}

		i = Integer.parseInt(this.Rb);
		b = (int) calculatorOB.getRb();
		if (i == b) {
			RbStrStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			RbStrStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			RbStrStr = TRUE;
			passed += 1;

		} else {
			RbStrStr = FALSE;
		}

		i = Integer.parseInt(this.Rk);
		b = (int) calculatorOB.getRk();
		if (i == b) {
			RkStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			RkStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			RkStr = TRUE;
			passed += 1;

		} else {
			RkStr = FALSE;
		}

		i = Integer.parseInt(this.Rvh);
		b = (int) calculatorOB.getRvh();
		if (i == b) {
			RvhStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			RvhStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			RvhStr = TRUE;
			passed += 1;

		} else {
			RvhStr = FALSE;
		}

		i = Integer.parseInt(this.Rvih);
		b = (int) calculatorOB.getRvih();
		if (i == b) {
			RvihStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			RvihStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			RvihStr = TRUE;
			passed += 1;

		} else {
			RvihStr = FALSE;
		}

		i = Integer.parseInt(this.Ua);
		b = (int) calculatorOB.getUa();
		if (i == b) {
			UaStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			UaStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			UaStr = TRUE;
			passed += 1;

		} else {
			UaStr = FALSE;
		}

		i = Integer.parseInt(this.Ub);
		b = (int) calculatorOB.getUb();
		if (i == b) {
			UbStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			UbStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			UbStr = TRUE;
			passed += 1;

		} else {
			UbStr = FALSE;
		}

		i = Integer.parseInt(this.Uip);
		b = (int) calculatorOB.getUip();
		if (i == b) {
			UipStr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			UipStr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			UipStr = TRUE;
			passed += 1;

		} else {
			UipStr = FALSE;
		}
		
		double x = passed / total * 10;
		int z = new Double(x).intValue();

		if ((x - z) > 0.5) {
			z += 1;
		}

		setResult(new String(new Double(z).toString()));

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

	/*public String getIdStr() {
		return IdStr;
	}

	public void setIdStr(String idStr) {
		IdStr = idStr;
	}*/

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
/*
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}*/

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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

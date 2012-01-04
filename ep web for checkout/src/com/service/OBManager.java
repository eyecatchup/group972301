package com.service;

import javax.faces.event.ActionEvent;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import dao.LabDAOImpl;
import dao.StudentLabsDAOImpl;

import entity.GivenOB;
import entity.Lab;
import entity.StudentLabs;
import ep.HibernateUtil;
import ep.ysilitelnieKaskadi.CalculatorOB;

public class OBManager {
	private static final String TRUE = "Верно";
	private static final String FALSE = "Неверно";

	private Lab studentLab = new Lab();
	private GivenOB given;
	private CalculatorOB calculatorOB;
	private double passed = 0.0;
	private double total = 26.0;
	private String result = "";

	private String Ua;// show
	private String UaStr;
	private String Uip;// show
	private String UipStr;
	private String Rk;// show
	private String RkStr;
	private String Ra;// show
	private String RaStr;
	private String Ib;// show
	private String IbStr;
	private String Ub;// show
	private String UbStr;
	private String Id;// show
	private String IdStr;
	private String R1;// show
	private String R1Str;
	private String R2;// show
	private String R2Str;

	private String Rvh;// show
	private String RvhStr;
	private String Rb;// show
	private String RbStr;
	private String Rvih;// show
	private String RvihStr;
	private String C1;// show
	private String C1Str;
	private String C2;// show
	private String C2Str;
	private String Ca;// show
	private String CaStr;
	private String Cb;// show
	private String CbStr;

	private String Ki;// show
	private String KiStr;
	private String Ku;// show
	private String KuStr;

	private String fn1;// show
	private String fn1Str;
	private String fn2;// show
	private String fn2Str;
	private String fn3;// show
	private String fn3Str;
	private String fv1;// show
	private String fv1Str;
	private String fv2;// show
	private String fv2Str;
	private String fv3;// show
	private String fv3Str;

	private String MvN;// show
	private String MvNStr;
	private String MnN;// show
	private String MnNStr;

	private String ERROR_MESSAGE = "";

	public void calculate() {
		calculatorOB = new CalculatorOB(given, given.getOb_Transistor());
		calculatorOB.calc();

		if (MainService.checkIfStudentHasMakr(2) == false) {
			setERROR_MESSAGE(MainService.HAS_MARK);
		} else {
			setERROR_MESSAGE("");
		}
		setToDefault();
	}
	
	private boolean checkIfValid(Float i, Float b) {
		return (b * 1.1) > i && (b * 0.9) < i;
	}

	public void checkResult(ActionEvent e) {
		if (MainService.checkIfStudentHasMakr(2) == false) {
			setERROR_MESSAGE(MainService.HAS_MARK);
			return;
		} else {
			setERROR_MESSAGE("");
		}

		Float i = Float.parseFloat(Ua);
		Float b = (float) calculatorOB.getUa();

		if (checkIfValid(i, b)) {
			UaStr = TRUE;
			passed += 1;
		} else {
			UaStr = FALSE;
		}
		
		i = Float.parseFloat(Uip);
		b = (float) calculatorOB.getUip();

		if (checkIfValid(i, b)) {
			UipStr = TRUE;
			passed += 1;
		} else {
			UipStr = FALSE;
		}
		
		i = Float.parseFloat(Rk);
		b = (float) calculatorOB.getRk();

		if (checkIfValid(i, b)) {
			RkStr = TRUE;
			passed += 1;
		} else {
			RkStr = FALSE;
		}
		
		i = Float.parseFloat(Ra);
		b = (float) calculatorOB.getRa();

		if (checkIfValid(i, b)) {
			RaStr = TRUE;
			passed += 1;
		} else {
			RaStr = FALSE;
		}
		
		i = Float.parseFloat(Ib);
		b = (float) calculatorOB.getIb();

		if (checkIfValid(i, b)) {
			IbStr = TRUE;
			passed += 1;
		} else {
			IbStr = FALSE;
		}
		
		i = Float.parseFloat(Ub);
		b = (float) calculatorOB.getUb();

		if (checkIfValid(i, b)) {
			UbStr = TRUE;
			passed += 1;
		} else {
			UbStr = FALSE;
		}
		
		i = Float.parseFloat(Id);
		b = (float) calculatorOB.getId();

		if (checkIfValid(i, b)) {
			IdStr = TRUE;
			passed += 1;
		} else {
			IdStr = FALSE;
		}
		
		i = Float.parseFloat(R1);
		b = (float) calculatorOB.getR1();

		if (checkIfValid(i, b)) {
			R1Str = TRUE;
			passed += 1;
		} else {
			R1Str = FALSE;
		}
		
		i = Float.parseFloat(R2);
		b = (float) calculatorOB.getR2();

		if (checkIfValid(i, b)) {
			R2Str = TRUE;
			passed += 1;
		} else {
			R2Str = FALSE;
		}
		
		i = Float.parseFloat(Rvh);
		b = (float) calculatorOB.getRvh();

		if (checkIfValid(i, b)) {
			RvhStr = TRUE;
			passed += 1;
		} else {
			RvhStr = FALSE;
		}
		
		i = Float.parseFloat(Rvih);
		b = (float) calculatorOB.getRvih();

		if (checkIfValid(i, b)) {
			RvihStr = TRUE;
			passed += 1;
		} else {
			RvihStr = FALSE;
		}
		
		i = Float.parseFloat(Rb);
		b = (float) calculatorOB.getRb();

		if (checkIfValid(i, b)) {
			RbStr = TRUE;
			passed += 1;
		} else {
			RbStr = FALSE;
		}
		
		i = Float.parseFloat(C1);
		b = (float) calculatorOB.getC1();

		if (checkIfValid(i, b)) {
			C1Str = TRUE;
			passed += 1;
		} else {
			C2Str = FALSE;
		}
		
		i = Float.parseFloat(C2);
		b = (float) calculatorOB.getC2();

		if (checkIfValid(i, b)) {
			C2Str = TRUE;
			passed += 1;
		} else {
			C2Str = FALSE;
		}
		
		i = Float.parseFloat(Ca);
		b = (float) calculatorOB.getCa();

		if (checkIfValid(i, b)) {
			CaStr = TRUE;
			passed += 1;
		} else {
			CaStr = FALSE;
		}
		
		i = Float.parseFloat(Cb);
		b = (float) calculatorOB.getCb();

		if (checkIfValid(i, b)) {
			CbStr = TRUE;
			passed += 1;
		} else {
			CbStr = FALSE;
		}
		
		i = Float.parseFloat(Ki);
		b = (float) calculatorOB.getKi();

		if (checkIfValid(i, b)) {
			KiStr = TRUE;
			passed += 1;
		} else {
			KiStr = FALSE;
		}
		
		i = Float.parseFloat(Ku);
		b = (float) calculatorOB.getKu();

		if (checkIfValid(i, b)) {
			KuStr = TRUE;
			passed += 1;
		} else {
			KuStr = FALSE;
		}
		
		i = Float.parseFloat(fn1);
		b = (float) calculatorOB.getFn1();

		if (checkIfValid(i, b)) {
			fn1Str = TRUE;
			passed += 1;
		} else {
			fn1Str = FALSE;
		}
		
		i = Float.parseFloat(fn2);
		b = (float) calculatorOB.getFn2();

		if (checkIfValid(i, b)) {
			fn2Str = TRUE;
			passed += 1;
		} else {
			fn2Str = FALSE;
		}
		
		i = Float.parseFloat(fn3);
		b = (float) calculatorOB.getFn3();

		if (checkIfValid(i, b)) {
			fn3Str = TRUE;
			passed += 1;
		} else {
			fn3Str = FALSE;
		}
		
		i = Float.parseFloat(fv1);
		b = (float) calculatorOB.getFv1();

		if (checkIfValid(i, b)) {
			fv1Str = TRUE;
			passed += 1;
		} else {
			fv1Str = FALSE;
		}
		
		i = Float.parseFloat(fv2);
		b = (float) calculatorOB.getFv2();

		if (checkIfValid(i, b)) {
			fv2Str = TRUE;
			passed += 1;
		} else {
			fv2Str = FALSE;
		}
		
		i = Float.parseFloat(fv3);
		b = (float) calculatorOB.getFv3();

		if (checkIfValid(i, b)) {
			fv3Str = TRUE;
			passed += 1;
		} else {
			fv3Str = FALSE;
		}
		
		i = Float.parseFloat(MvN);
		b = (float) calculatorOB.getMvN();

		if (checkIfValid(i, b)) {
			MvNStr = TRUE;
			passed += 1;
		} else {
			MvNStr = FALSE;
		}
		
		i = Float.parseFloat(MnN);
		b = (float) calculatorOB.getMnN();

		if (checkIfValid(i, b)) {
			MnNStr = TRUE;
			passed += 1;
		} else {
			MnNStr = FALSE;
		}

		double x = passed / total * 10;
		int z = new Double(x).intValue();

		if ((x - z) > 0.5) {
			z += 1;
		}
		passed = 0;

		studentLab.setMark(new Long(z));
		studentLab.setTheme(new Long(2));
		studentLab.setVariant(new Long(MainService.getChoosedTheme_1_Var()));
		LoginService.student.getDoneLabs().add(studentLab);

		Session session = HibernateUtil.getSessionFactory().openSession();
		LabDAOImpl daoImpl = new LabDAOImpl();
		daoImpl.setSession(session);
		Transaction transaction = session.beginTransaction();
		transaction.begin();

		daoImpl.makePersistent(studentLab);

		transaction.commit();
		session.close();

		Session ses = HibernateUtil.getSessionFactory().openSession();
		StudentLabsDAOImpl studentDAOImpl = new StudentLabsDAOImpl();
		studentDAOImpl.setSession(ses);
		Transaction transaction2 = ses.beginTransaction();
		transaction2.begin();

		StudentLabs labs = new StudentLabs();
		labs.setLab(studentLab);
		labs.setStudent(LoginService.student);

		studentDAOImpl.makePersistent(labs);

		transaction2.commit();
		ses.close();

		setResult(new String(new Double(z).toString()));

	}

	private void setToDefault() {
		Ua = "";// show
		Uip = "";// show
		Rk = "";// show
		Ra = "";// show
		Ib = "";// show
		Ub = "";// show
		Id = "";// show
		R1 = "";// show
		R2 = "";// show

		Rvh = "";// show
		Rb = "";// show
		Rvih = "";// show
		C1 = "";// show
		C2 = "";// show
		Ca = "";// show
		Cb = "";// show

		Ki = "";// show
		Ku = "";// show

		fn1 = "";// show
		fn2 = "";// show
		fn3 = "";// show
		fv1 = "";// show
		fv2 = "";// show
		fv3 = "";// show

		MvN = "";// show
		MnN = "";// show
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

	public String getRbStr() {
		return RbStr;
	}

	public void setRbStr(String rbStr) {
		RbStr = rbStr;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getERROR_MESSAGE() {
		return ERROR_MESSAGE;
	}

	public void setERROR_MESSAGE(String eRROR_MESSAGE) {
		ERROR_MESSAGE = eRROR_MESSAGE;
	}

}

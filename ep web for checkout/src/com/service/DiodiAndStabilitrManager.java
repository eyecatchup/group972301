package com.service;

import javax.faces.event.ActionEvent;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.validators.StringDataValidator;

import dao.LabDAOImpl;
import dao.StudentLabsDAOImpl;
import entity.Given;
import entity.Lab;
import entity.StudentLabs;
import ep.HibernateUtil;
import ep.diodiAndStabilitroni.CalculatorStabilitron;
import ep.diodiAndStabilitroni.Vipremitel;

public class DiodiAndStabilitrManager {	
	private Given given;
	private CalculatorStabilitron calculatorStabilitron;
	private Vipremitel vipremitel;

	private Lab studentLab = new Lab();
	private double passed = 0.0;
	private double total = 6.0;
	private String resultMark = "введите данные для проверки и нажмите кнопку проверить.";

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

	private String theme;

	public void caltulate(String theme) {
		this.theme = theme;

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
		
		StringDataValidator.stateShow = true;

		Integer i = Integer.parseInt(Uvxst);
		Integer b = (int) calculatorStabilitron.getStabilitron()
				.getPostNagrNaWhodeStabilizatora();

		if (i == b) {
			resUvxst = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			resUvxst = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			resUvxst = TRUE;
			passed += 1;

		} else {
			resUvxst = FALSE;
		}

		i = Integer.parseInt(deltaUvxSt);
		b = (int) calculatorStabilitron.getStabilitron().getAmplitudePuls();
		if (i == b) {
			resdeltaUvxSt = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			resdeltaUvxSt = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			resdeltaUvxSt = TRUE;
			passed += 1;

		} else {
			resdeltaUvxSt = FALSE;
		}

		i = Integer.parseInt(deltaUtemper);
		b = (int) calculatorStabilitron.getStabilitron().getTemperUhod();

		if (i == b) {
			resdeltaUtemper = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			resdeltaUtemper = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			resdeltaUtemper = TRUE;
			passed += 1;

		} else {
			resdeltaUtemper = FALSE;
		}

		i = Integer.parseInt(Ir);
		b = (int) calculatorStabilitron.getStabilitron().getTemperUhod();

		if (i == b) {
			resIr = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			resIr = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			resIr = TRUE;
			passed += 1;

		} else {
			resIr = FALSE;
		}

		i = Integer.parseInt(Ist);
		b = (int) calculatorStabilitron.getStabilitron()
				.getRabTokStabilitrona();

		if (i == b) {
			resIst = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			resIst = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			resIst = TRUE;
			passed += 1;

		} else {
			resIst = FALSE;
		}

		i = Integer.parseInt(C);
		b = (int) vipremitel.getEmkost();

		if (i == b) {
			resC = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			resC = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			resC = TRUE;
			passed += 1;

		} else {
			resC = FALSE;
		}

		i = Integer.parseInt(Kst);
		b = calculatorStabilitron.getStabilitron().getCoefStabiliz();

		if (i == b) {
			resKst = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			resKst = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			resKst = TRUE;
			passed += 1;

		} else {
			resKst = FALSE;
		}

		i = Integer.parseInt(Rn);
		b = (int) calculatorStabilitron.getStabilitron().getSoprNagruzki();

		if (i == b) {
			resRn = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			resRn = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			resRn = TRUE;
			passed += 1;

		} else {
			resRn = FALSE;
		}

		i = Integer.parseInt(Rgen);
		b = (int) calculatorStabilitron.getStabilitron().getSoprotGosResis();

		if (i == b) {
			resRgen = TRUE;
			passed += 1;
		} else if (i == (b - 1)) {
			resRgen = TRUE;
			passed += 1;

		} else if (i == (b + 1)) {
			resRgen = TRUE;
			passed += 1;

		} else {
			resRgen = FALSE;
		}

		double x = passed / total * 10;
		int z = new Double(x).intValue();

		if ((x - z) > 0.5) {
			z += 1;
		}

		resultMark = new String(new Double(z).toString());
		
		studentLab.setMark(new Long(z));
		studentLab.setTheme(theme);
		studentLab.setVariant(new Long(MainService.getChoosedTheme_0_Var()));
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
		
		passed = 0;

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

	public Lab getStudentLab() {
		return studentLab;
	}

	public void setStudentLab(Lab studentLab) {
		this.studentLab = studentLab;
	}

	public String getResultMark() {
		return resultMark;
	}

	public void setResultMark(String resultMark) {
		this.resultMark = resultMark;
	}

}

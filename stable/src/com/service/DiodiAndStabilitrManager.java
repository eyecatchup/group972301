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
	private double total = 10.0;
	private String resultMark = "������� ������ ��� �������� � ������� ������ ���������";

	private static final String TRUE = "�����";
	private static final String FALSE = "�������";

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

	private String mainUvxst;
	private String mainUvix;
	private String maindeltaUvxSt;
	private String maindeltaUvix;
	private String maindeltaUtemper;
	private String mainIr;
	private String mainIst;
	private String mainInagr;
	private String mainC;
	private String mainKst;
	private String mainRn;
	private String mainRgen;
	private String mainDiod;

	private String diodType;
	private String resDiod;

	private String modResUvix;
	private String modeResDeltaUvix;
	private String resStabType;

	private String modUvix;
	private String modDelataUvix;
	private String stabType;

	private String Uvxm;
	private String resUvxm;

	private String ERROR_MESSAGE = "";

	public void caltulate(String theme) {

		calculatorStabilitron = new CalculatorStabilitron(given,
				given.getStabilitron());

		boolean state = false;
		if (given.getShema() == 1) {
			state = true;
		}

		vipremitel = new Vipremitel(calculatorStabilitron.getStabilitron(),
				state);

		if (LoginService.IS_ROOT) {
			setMainData();
		}

		if (MainService.checkIfStudentHasMakr(1) == false) {
			ERROR_MESSAGE = MainService.HAS_MARK;
		} else {
			ERROR_MESSAGE = "";
		}

	}

	public void chechResult(ActionEvent e) {

		if (MainService.checkIfStudentHasMakr(1) == false) {
			ERROR_MESSAGE = MainService.HAS_MARK;
			return;
		} else {
			ERROR_MESSAGE = "";
		}

		StringDataValidator.stateShow = true;

		Float i = Float.parseFloat(Uvxst);
		Float b = (Float) calculatorStabilitron.getStabilitron()
				.getPostNagrNaWhodeStabilizatora();

		if (checkIfValid(i, b)) {
			resUvxst = TRUE;
			passed += 1;
		} else {
			resUvxst = FALSE;
		}

		i = Float.parseFloat(deltaUvxSt);
		b = (Float) calculatorStabilitron.getStabilitron().getAmplitudePuls();
		if (checkIfValid(i, b)) {
			resdeltaUvxSt = TRUE;
			passed += 1;
		} else {
			resdeltaUvxSt = FALSE;
		}

		i = Float.parseFloat(deltaUtemper);
		b = (Float) calculatorStabilitron.getStabilitron().getTemperUhod();

		if (checkIfValid(i, b)) {
			resdeltaUtemper = TRUE;
			passed += 1;
		} else {
			resdeltaUtemper = FALSE;
		}

		i = Float.parseFloat(Ir);
		b = (Float) calculatorStabilitron.getStabilitron().getTokGosResistora();

		if (checkIfValid(i, b)) {
			resIr = TRUE;
			passed += 1;
		} else {
			resIr = FALSE;
		}

		i = Float.parseFloat(Ist);
		b = (Float) calculatorStabilitron.getStabilitron()
				.getRabTokStabilitrona();

		if (checkIfValid(i, b)) {
			resIst = TRUE;
			passed += 1;
		} else {
			resIst = FALSE;
		}

		i = Float.parseFloat(C);
		b = (Float) vipremitel.getEmkost();

		if (checkIfValid(i, b)) {
			resC = TRUE;
			passed += 1;
		} else {
			resC = FALSE;
		}

		i = Float.parseFloat(Kst);
		b = (float) calculatorStabilitron.getStabilitron().getCoefStabiliz();

		if (checkIfValid(i, b)) {
			resKst = TRUE;
			passed += 1;
		} else {
			resKst = FALSE;
		}

		i = Float.parseFloat(Rn);
		b = (Float) calculatorStabilitron.getStabilitron().getSoprNagruzki();

		if (checkIfValid(i, b)) {
			resRn = TRUE;
			passed += 1;
		} else {
			resRn = FALSE;
		}

		i = Float.parseFloat(Rgen);
		b = (Float) calculatorStabilitron.getStabilitron().getSoprotGosResis();

		if (checkIfValid(i, b)) {
			resRgen = TRUE;
			passed += 1;
		} else {
			resRgen = FALSE;
		}

		if (diodType.equalsIgnoreCase(given.getDiod().getName())) {
			setResDiod(TRUE);
			passed += 1;
		} else {
			setResDiod(FALSE);
		}

		if (stabType.equalsIgnoreCase(given.getStabilitron().getType())) {
			resStabType = TRUE;
			passed += 1;
		} else {
			resStabType = FALSE;
		}
		
		i = Float.parseFloat(Uvxm);
		b = (Float) vipremitel.getNaprVxod();

		if (checkIfValid(i, b)) {
			resUvxm = TRUE;
			passed += 1;
		} else {
			resUvxm = FALSE;
		}
		
		i = Float.parseFloat(modUvix);
		b = given.getNaprWihodnoe();

		if (checkIfValid(i, b)) {
			modResUvix = TRUE;
			passed += 1;
		} else {
			modResUvix = FALSE;
		}
		
		i = Float.parseFloat(modDelataUvix);
		b = given.getDeltaNaprWihodnoe();

		if (checkIfValid(i, b)) {
			modeResDeltaUvix = TRUE;
			passed += 1;
		} else {
			modeResDeltaUvix = FALSE;
		}

		double x = passed / total * 14;
		int z = new Double(x).intValue();
		System.out.println("Passed: " + passed);
		System.out.println("Result" + x);

		if ((x - z) > 0.5) {
			z += 1;
		}

		if (LoginService.IS_ROOT) {
			setMainData();
			return;
		}

		resultMark = new String(new Double(z).toString());

		studentLab.setMark(new Long(z));
		studentLab.setTheme(new Long(1));
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

	private void setMainData() {
		mainUvxst = ((Float) calculatorStabilitron.getStabilitron()
				.getPostNagrNaWhodeStabilizatora()).toString();
		maindeltaUvxSt = ((Float) calculatorStabilitron.getStabilitron()
				.getAmplitudePuls()).toString();
		maindeltaUtemper = ((Float) calculatorStabilitron.getStabilitron()
				.getTemperUhod()).toString();
		mainIr = ((Float) calculatorStabilitron.getStabilitron()
				.getTokGosResistora()).toString();
		;
		mainIst = ((Float) calculatorStabilitron.getStabilitron()
				.getRabTokStabilitrona()).toString();
		mainC = ((Float) vipremitel.getEmkost()).toString();
		mainKst = ((Integer) calculatorStabilitron.getStabilitron()
				.getCoefStabiliz()).toString();
		mainRn = ((Float) calculatorStabilitron.getStabilitron()
				.getSoprNagruzki()).toString();
		mainRgen = ((Float) calculatorStabilitron.getStabilitron()
				.getSoprotGosResis()).toString();
		mainDiod = given.getDiod().getName();

	}

	private boolean checkIfValid(Float i, Float b) {
		return (b * 1.1) > i && (b * 0.9) < i;
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

	public String getERROR_MESSAGE() {
		return ERROR_MESSAGE;
	}

	public void setERROR_MESSAGE(String eRROR_MESSAGE) {
		ERROR_MESSAGE = eRROR_MESSAGE;
	}

	public String getDiodType() {
		return diodType;
	}

	public void setDiodType(String diodType) {
		this.diodType = diodType;
	}

	public String getResDiod() {
		return resDiod;
	}

	public void setResDiod(String resDiod) {
		this.resDiod = resDiod;
	}

	public String getMainUvxst() {
		return mainUvxst;
	}

	public void setMainUvxst(String mainUvxst) {
		this.mainUvxst = mainUvxst;
	}

	public String getMainUvix() {
		return mainUvix;
	}

	public void setMainUvix(String mainUvix) {
		this.mainUvix = mainUvix;
	}

	public String getMaindeltaUvxSt() {
		return maindeltaUvxSt;
	}

	public void setMaindeltaUvxSt(String maindeltaUvxSt) {
		this.maindeltaUvxSt = maindeltaUvxSt;
	}

	public String getMaindeltaUvix() {
		return maindeltaUvix;
	}

	public void setMaindeltaUvix(String maindeltaUvix) {
		this.maindeltaUvix = maindeltaUvix;
	}

	public String getMaindeltaUtemper() {
		return maindeltaUtemper;
	}

	public void setMaindeltaUtemper(String maindeltaUtemper) {
		this.maindeltaUtemper = maindeltaUtemper;
	}

	public String getMainIr() {
		return mainIr;
	}

	public void setMainIr(String mainIr) {
		this.mainIr = mainIr;
	}

	public String getMainIst() {
		return mainIst;
	}

	public void setMainIst(String mainIst) {
		this.mainIst = mainIst;
	}

	public String getMainInagr() {
		return mainInagr;
	}

	public void setMainInagr(String mainInagr) {
		this.mainInagr = mainInagr;
	}

	public String getMainC() {
		return mainC;
	}

	public void setMainC(String mainC) {
		this.mainC = mainC;
	}

	public String getMainKst() {
		return mainKst;
	}

	public void setMainKst(String mainKst) {
		this.mainKst = mainKst;
	}

	public String getMainRn() {
		return mainRn;
	}

	public void setMainRn(String mainRn) {
		this.mainRn = mainRn;
	}

	public String getMainRgen() {
		return mainRgen;
	}

	public void setMainRgen(String mainRgen) {
		this.mainRgen = mainRgen;
	}

	public String getMainDiod() {
		return mainDiod;
	}

	public void setMainDiod(String mainDiod) {
		this.mainDiod = mainDiod;
	}

	public String getModUvix() {
		return modUvix;
	}

	public void setModUvix(String modUvix) {
		this.modUvix = modUvix;
	}

	public String getModDelataUvix() {
		return modDelataUvix;
	}

	public void setModDelataUvix(String modDelataUvix) {
		this.modDelataUvix = modDelataUvix;
	}

	public String getModResUvix() {
		return modResUvix;
	}

	public void setModResUvix(String modResUvix) {
		this.modResUvix = modResUvix;
	}

	public String getModeResDeltaUvix() {
		return modeResDeltaUvix;
	}

	public void setModeResDeltaUvix(String modeResDeltaUvix) {
		this.modeResDeltaUvix = modeResDeltaUvix;
	}

	public String getResStabType() {
		return resStabType;
	}

	public void setResStabType(String resStabType) {
		this.resStabType = resStabType;
	}

	public String getStabType() {
		return stabType;
	}

	public void setStabType(String stabType) {
		this.stabType = stabType;
	}

	public String getUvxm() {
		return Uvxm;
	}

	public void setUvxm(String uvxm) {
		Uvxm = uvxm;
	}

	public String getResUvxm() {
		return resUvxm;
	}

	public void setResUvxm(String resUvxm) {
		this.resUvxm = resUvxm;
	}

}

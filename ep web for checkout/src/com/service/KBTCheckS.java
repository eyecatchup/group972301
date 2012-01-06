package com.service;

import javax.faces.event.ActionEvent;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import dao.LabDAOImpl;
import dao.StudentLabsDAOImpl;

import entity.KBTSource;
import entity.Lab;
import entity.StudentLabs;
import ep.HibernateUtil;

public class KBTCheckS {
	private static final String TRUE = "Верно";
	private static final String FALSE = "Неверно";

	private String resultMark;
	private String Rk;
	private String UipEkv;
	private String RkEkv;
	
	private String Ikn;
	private String Ibn;
	private String Ibm;
	private String h21e;
	private String R1;
	private String R2;
	private String Tvkl;
	private String TzadVikl;
	private String Tcp;
	private String Tvikl;
	private String Tnpu;

	private String r_Rk;
	private String r_UipEkv;
	private String r_RkEkv;
	
	private String r_Ikn;
	private String r_Ibn;
	private String r_Ibm;
	private String r_h21e;
	private String r_R1;
	private String r_R2;
	private String r_Tvkl;
	private String r_TzadVikl;
	private String r_Tcp;
	private String r_Tvikl;
	private String r_Tnpu;

	private Float f_Rk;
	private Float f_UipEkv;
	private Float f_RkEkv;
	
	private Float f_Ikn;
	private Float f_Ibn;
	private Float f_Ibm;
	private Float f_h21e;
	private Float f_R1;
	private Float f_R2;
	private Float f_Tvkl;
	private Float f_TzadVikl;
	private Float f_Tcp;
	private Float f_Tvikl;
	private Float f_Tnpu;

	private String m_Rk;
	private String m_UipEkv;
	private String m_RkEkv;
	
	private String m_Ikn;
	private String m_Ibn;
	private String m_Ibm;
	private String m_h21e;
	private String m_R1;
	private String m_R2;
	private String m_Tvkl;
	private String m_TzadVikl;
	private String m_Tcp;
	private String m_Tvikl;
	private String m_Tnpu;
	private String markResult;
	private int variant;

	private KBTSource src;
	private Lab studentLab = new Lab();
	private String ERROR_MESSAGE = "";


	public void setSource(KBTSource source) {
		src = source;
		setVariant(src.getVariant());
		
		if (MainService.checkIfStudentHasMakr(3) == false) {
			setERROR_MESSAGE(MainService.HAS_MARK);
		} else {
			setERROR_MESSAGE("");
		}
		
	}

	private boolean checkIfValid(Float i, Float b) {
		return (b * 1.1) > i && (b * 0.9) < i;
	}

	public void chechResult(ActionEvent e) {
		
		if (MainService.checkIfStudentHasMakr(3) == false) {
			setERROR_MESSAGE(MainService.HAS_MARK);
			return;
		} else {
			setERROR_MESSAGE("");
		}
		
		KBTSource kbt = src;

		String Ttype = kbt.getTtype();
		Integer Variant = kbt.getVariant();
		Float Uip = kbt.getUip();
		Float Ucm = kbt.getUcm();
		Float Rn = kbt.getRn();
		Float S = kbt.getS();
		Float Uvihm = kbt.getUvihm();
		Float Upor0 = kbt.getUpor0();
		Float Upor1 = kbt.getUpor1();
		Float Cn = kbt.getCn();
		Float h21emin = kbt.getH21emin();
		Float h21emax = kbt.getH21emax();
		Float Ikb0 = kbt.getIkbo();
		Float Ubepor = kbt.getUbepor();
		Float Ck = kbt.getCk();
		Float Th21E = kbt.getTh21E();
		Float Uvih0 = kbt.getUvih0();

		try
		{
		System.out.println("Uip:" + Uip.toString());
		System.out.println("Uvihm:" + Uvihm.toString());
		System.out.println("Rn:" + Rn.toString());
		System.out.println("Ikb0:" + Ikb0.toString());
		
		f_Rk = ((Uip - Uvihm) * Rn / (Uvihm + Ikb0 * Rn));
		f_UipEkv = (Uip * Rn) / (f_Rk + Rn);
		f_RkEkv = (f_Rk * Rn) / (f_Rk + Rn);

		f_Ikn = (f_UipEkv - Uvih0) / f_RkEkv;
		f_h21e = (float) Math.sqrt(h21emin * h21emax);
		f_Ibn = (f_UipEkv - Uvih0) / (f_RkEkv * f_h21e);
		f_Ibm = S * f_Ibn;
		f_R1 = (Upor0 - Upor1) / f_Ibm;
		f_R2 = (Ubepor + Ucm) * f_R1 / (Upor0 - Ubepor);

		f_Tvkl = (float) ((1 / (2 * Math.PI * Th21E) + (Ck + Cn) * f_RkEkv) * Math
				.log((S / (S - 1))));

		float Ibobr = Ucm / f_R2;
		f_TzadVikl = (float) (Th21E / 2 * Math.log((f_Ibm + Ibobr)
				/ (f_Ibn + Ibobr)));
		f_Tcp = (float) (Th21E * Math.log(1 + f_Ibn / Ibobr));
		f_Tvikl = f_TzadVikl + f_Tcp;
		f_Tnpu = (float) (2.3 * (Ck + Cn) * f_RkEkv);
		} catch(Exception ex) {}

		int pass = 0;
		if (checkIfValid(f_Rk, Float.valueOf(Rk))) {
			m_Rk = TRUE;
			pass++;
		} else {
			m_Rk = FALSE;
		}
		r_Rk = f_Rk.toString();
		if (checkIfValid(f_UipEkv, Float.valueOf(UipEkv))) {
			m_UipEkv = TRUE;
			pass++;
		} else {
			m_UipEkv = FALSE;
		}
		r_UipEkv = f_UipEkv.toString();
		if (checkIfValid(f_RkEkv, Float.valueOf(RkEkv))) {
			m_RkEkv = TRUE;
			pass++;
		} else {
			m_RkEkv = FALSE;
		}
		r_RkEkv = f_RkEkv.toString();
		if (checkIfValid(f_Ikn, Float.valueOf(Ikn))) {
			m_Ikn = TRUE;
			pass++;
		} else {
			m_Ikn = FALSE;
		}
		r_Ikn = f_Ikn.toString();
		if (checkIfValid(f_h21e, Float.valueOf(h21e))) {
			m_h21e = TRUE;
			pass++;
		} else {
			m_h21e = FALSE;
		}
		r_h21e = f_h21e.toString();
		if (checkIfValid(f_Ibn, Float.valueOf(Ibn))) {
			m_Ibn = TRUE;
			pass++;
		} else {
			m_Ibn = FALSE;
		}
		r_Ibn = f_Ibn.toString();
		if (checkIfValid(f_Ibm, Float.valueOf(Ibm))) {
			m_Ibm = TRUE;
			pass++;
		} else {
			m_Ibm = FALSE;
		}
		r_Ibm = f_Ibm.toString();
		if (checkIfValid(f_R1, Float.valueOf(R1))) {
			m_R1 = TRUE;
			pass++;
		} else {
			m_R1 = FALSE;
		}
		r_R1 = f_R1.toString();
		if (checkIfValid(f_R2, Float.valueOf(R2))) {
			m_R2 = TRUE;
			pass++;
		} else {
			m_R2 = FALSE;
		}
		r_R2 = f_R2.toString();
		if (checkIfValid(f_Tvkl, Float.valueOf(Tvkl))) {
			m_Tvkl = TRUE;
			pass++;
		} else {
			m_Tvkl = FALSE;
		}
		r_Tvkl = f_Tvkl.toString();
		if (checkIfValid(f_TzadVikl, Float.valueOf(TzadVikl))) {
			m_TzadVikl = TRUE;
			pass++;
		} else {
			m_TzadVikl = FALSE;
		}
		r_TzadVikl = f_TzadVikl.toString();
		if (checkIfValid(f_Tcp, Float.valueOf(Tcp))) {
			m_Tcp = TRUE;
			pass++;
		} else {
			m_Tcp = FALSE;
		}
		r_Tcp = f_Tcp.toString();
		if (checkIfValid(f_Tvikl, Float.valueOf(Tvikl))) {
			m_Tvikl = TRUE;
			pass++;
		} else {
			m_Tvikl = FALSE;
		}
		r_Tvikl = f_Tvikl.toString();
		if (checkIfValid(f_Tnpu, Float.valueOf(Tnpu))) {
			m_Tnpu = TRUE;
			pass++;
		} else {
			m_Tnpu = FALSE;
		}
		r_Tnpu = f_Tnpu.toString();
		
		if (LoginService.IS_ROOT){
			return;
		}
		Integer z = Math.round(pass / 15 * 10);
		resultMark = z.toString();
		
		studentLab.setMark(new Long(z));
		studentLab.setTheme(new Long(3));
		studentLab.setVariant(new Long(MainService.getChoosedTheme_2_Var()));
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

	}

	public String getM_Rk() {
		return m_Rk;
	}

	public void setM_Rk(String m_Rk) {
		this.m_Rk = m_Rk;
	}

	public String getM_UipEkv() {
		return m_UipEkv;
	}

	public void setM_UipEkv(String m_UipEkv) {
		this.m_UipEkv = m_UipEkv;
	}

	public String getM_RkEkv() {
		return m_RkEkv;
	}

	public void setM_RkEkv(String m_RkEkv) {
		this.m_RkEkv = m_RkEkv;
	}

	public String getM_Ikn() {
		return m_Ikn;
	}

	public void setM_Ikn(String m_Ikn) {
		this.m_Ikn = m_Ikn;
	}

	public String getM_Ibn() {
		return m_Ibn;
	}

	public void setM_Ibn(String m_Ibn) {
		this.m_Ibn = m_Ibn;
	}

	public String getM_Ibm() {
		return m_Ibm;
	}

	public void setM_Ibm(String m_Ibm) {
		this.m_Ibm = m_Ibm;
	}

	public String getM_h21e() {
		return m_h21e;
	}

	public void setM_h21e(String m_h21e) {
		this.m_h21e = m_h21e;
	}

	public String getM_R1() {
		return m_R1;
	}

	public void setM_R1(String m_R1) {
		this.m_R1 = m_R1;
	}

	public String getM_R2() {
		return m_R2;
	}

	public void setM_R2(String m_R2) {
		this.m_R2 = m_R2;
	}

	public String getM_Tvkl() {
		return m_Tvkl;
	}

	public void setM_Tvkl(String m_Tvkl) {
		this.m_Tvkl = m_Tvkl;
	}

	public String getM_TzadVikl() {
		return m_TzadVikl;
	}

	public void setM_TzadVikl(String m_TzadVikl) {
		this.m_TzadVikl = m_TzadVikl;
	}

	public String getM_Tcp() {
		return m_Tcp;
	}

	public void setM_Tcp(String m_Tcp) {
		this.m_Tcp = m_Tcp;
	}

	public String getM_Tvikl() {
		return m_Tvikl;
	}

	public void setM_Tvikl(String m_Tvikl) {
		this.m_Tvikl = m_Tvikl;
	}

	public String getM_Tnpu() {
		return m_Tnpu;
	}

	public void setM_Tnpu(String m_Tnpu) {
		this.m_Tnpu = m_Tnpu;
	}

	public String getR_Rk() {
		return r_Rk;
	}

	public void setR_Rk(String r_Rk) {
		this.r_Rk = r_Rk;
	}

	public String getR_UipEkv() {
		return r_UipEkv;
	}

	public void setR_UipEkv(String r_UipEkv) {
		this.r_UipEkv = r_UipEkv;
	}

	public String getR_RkEkv() {
		return r_RkEkv;
	}

	public void setR_RkEkv(String r_RkEkv) {
		this.r_RkEkv = r_RkEkv;
	}

	
	public String getR_Ikn() {
		return r_Ikn;
	}

	public void setR_Ikn(String r_Ikn) {
		this.r_Ikn = r_Ikn;
	}

	public String getR_Ibn() {
		return r_Ibn;
	}

	public void setR_Ibn(String r_Ibn) {
		this.r_Ibn = r_Ibn;
	}

	public String getR_Ibm() {
		return r_Ibm;
	}

	public void setR_Ibm(String r_Ibm) {
		this.r_Ibm = r_Ibm;
	}

	public String getR_h21e() {
		return r_h21e;
	}

	public void setR_h21e(String r_h21e) {
		this.r_h21e = r_h21e;
	}

	public String getR_R1() {
		return r_R1;
	}

	public void setR_R1(String r_R1) {
		this.r_R1 = r_R1;
	}

	public String getR_R2() {
		return r_R2;
	}

	public void setR_R2(String r_R2) {
		this.r_R2 = r_R2;
	}

	public String getR_Tvkl() {
		return r_Tvkl;
	}

	public void setR_Tvkl(String r_Tvkl) {
		this.r_Tvkl = r_Tvkl;
	}

	public String getR_TzadVikl() {
		return r_TzadVikl;
	}

	public void setR_TzadVikl(String r_TzadVikl) {
		this.r_TzadVikl = r_TzadVikl;
	}

	public String getR_Tcp() {
		return r_Tcp;
	}

	public void setR_Tcp(String r_Tcp) {
		this.r_Tcp = r_Tcp;
	}

	public String getR_Tvikl() {
		return r_Tvikl;
	}

	public void setR_Tvikl(String r_Tvikl) {
		this.r_Tvikl = r_Tvikl;
	}

	public String getR_Tnpu() {
		return r_Tnpu;
	}

	public void setR_Tnpu(String r_Tnpu) {
		this.r_Tnpu = r_Tnpu;
	}

	public String getRk() {
		return Rk;
	}

	public void setRk(String rk) {
		Rk = rk;
	}

	public String getUipEkv() {
		return UipEkv;
	}

	public void setUipEkv(String uipEkv) {
		UipEkv = uipEkv;
	}

	public String getRkEkv() {
		return RkEkv;
	}

	public void setRkEkv(String rkEkv) {
		RkEkv = rkEkv;
	}

	public String getIkn() {
		return Ikn;
	}

	public void setIkn(String ikn) {
		Ikn = ikn;
	}

	public String getIbn() {
		return Ibn;
	}

	public void setIbn(String ibn) {
		Ibn = ibn;
	}

	public String getIbm() {
		return Ibm;
	}

	public void setIbm(String ibm) {
		Ibm = ibm;
	}

	public String getH21e() {
		return h21e;
	}

	public void setH21e(String h21e) {
		this.h21e = h21e;
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

	public String getTvkl() {
		return Tvkl;
	}

	public void setTvkl(String tvkl) {
		Tvkl = tvkl;
	}

	public String getTzadVikl() {
		return TzadVikl;
	}

	public void setTzadVikl(String tzadVikl) {
		TzadVikl = tzadVikl;
	}

	public String getTcp() {
		return Tcp;
	}

	public void setTcp(String tcp) {
		Tcp = tcp;
	}

	public String getTvikl() {
		return Tvikl;
	}

	public void setTvikl(String tvikl) {
		Tvikl = tvikl;
	}

	public String getTnpu() {
		return Tnpu;
	}

	public void setTnpu(String tnpu) {
		Tnpu = tnpu;
	}

	public String getMarkResult() {
		return markResult;
	}

	public void setMarkResult(String markResult) {
		this.markResult = markResult;
	}

	public String getResultMark() {
		return resultMark;
	}

	public void setResultMark(String resultMark) {
		this.resultMark = resultMark;
	}

	public int getVariant() {
		return variant;
	}

	public void setVariant(int variant) {
		this.variant = variant;
	}

	public String getERROR_MESSAGE() {
		return ERROR_MESSAGE;
	}

	public void setERROR_MESSAGE(String eRROR_MESSAGE) {
		ERROR_MESSAGE = eRROR_MESSAGE;
	}

}

package com.service;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import dao.DiodDao;
import dao.GivenDAOImpl;
import dao.StabilitronDAOImpl;
import entity.Given;
import entity.Stabilitron;
import ep.HibernateUtil;
import ep.diodiAndStabilitroni.CalculatorStabilitron;
import ep.diodiAndStabilitroni.Diod;
import ep.diodiAndStabilitroni.Vipremitel;

public class AddDiodiandStab {
	private String var;
	private String napr;
	private String tok;
	private String ampl;
	private Long id;

	private String type;
	private String stNapr;
	private String tokMax;
	private String tokMin;
	private String r;
	private String alpha;
	private Long stId;

	private String typeDiod;
	private String i_pr;
	private String i_pr_i_max;
	private String u_obr;
	private String t_obr_vos;
	private Long diodId;

	public static boolean update = true;

	public boolean checkStab(Given given) {
		if (given.getDeltaNaprWihodnoe() != given.getStabilitron().getNapr()
				&& given.getTok() < given.getStabilitron().getTokMax() == false) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Не подходящие параметры стабилитрона", null));
			return false;
		}

		CalculatorStabilitron calculatorStabilitron = new CalculatorStabilitron(
				given, given.getStabilitron());

		boolean state = false;
		if (given.getShema() == 1) {
			state = true;
		}

		Vipremitel vipremitel = new Vipremitel(
				calculatorStabilitron.getStabilitron(), state);

		if (vipremitel.getNaprObr() < given.getDiod().getNapr_maks()
				&& calculatorStabilitron.getStabilitron().getTokGosResistora() < given
						.getDiod().getTok_maks() == false) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Не подходящие параметры диода", null));

			return false;
		}

		return true;
	}

	private Diod checkIfExistDiod(Diod diod) {

		DiodDao dao = new DiodDao();
		Session session = HibernateUtil.openSession();
		dao.setSession(session);
		List<Diod> list = dao.findAll();
		session.close();

		for (Diod i : list) {
			if (i.getName().equalsIgnoreCase(diod.getName())) {
				return i;
			}
		}

		return null;
	}

	private Stabilitron checkIfExistStabilitron(Stabilitron stab) {

		StabilitronDAOImpl dao = new StabilitronDAOImpl();
		Session session = HibernateUtil.openSession();
		dao.setSession(session);
		List<Stabilitron> list = dao.findAll();
		session.close();

		for (Stabilitron i : list) {
			if (i.getType().equalsIgnoreCase(stab.getType())) {
				return i;
			}
		}

		return null;
	}

	public void add(ActionEvent e) {
		Stabilitron stabilitron = new Stabilitron();
		stabilitron.setNapr(Float.valueOf(stNapr));
		stabilitron.setSopr(Float.valueOf(r));
		stabilitron.setTemperCoef(Float.valueOf(alpha));
		stabilitron.setTokMax(Float.valueOf(tokMax));
		stabilitron.setTokMin(Float.valueOf(tokMin));
		stabilitron.setType(type);

		Stabilitron newStab = checkIfExistStabilitron(stabilitron);
		if (newStab != null) {
			stId = newStab.getId();
		}

		Diod diod = new Diod();
		diod.setName(typeDiod);
		diod.setNapr_maks(Float.parseFloat(u_obr));
		diod.setT_obr(Float.parseFloat(t_obr_vos));
		diod.setTok_maks(Float.parseFloat(i_pr));
		diod.setTok_i_maks(Float.parseFloat(i_pr_i_max));

		Diod newDiod = checkIfExistDiod(diod);
		if (newDiod != null) {
			diodId = newDiod.getId();
		}

		Given given = new Given();
		given.setVar(Integer.valueOf(var));
		given.setNaprWihodnoe(Float.valueOf(napr));
		given.setTok(Float.valueOf(tok));
		given.setDeltaNaprWihodnoe(Float.valueOf(ampl));
		given.setStabilitron(stabilitron);
		given.setDiod(diod);

		int i = 1;
		if (Integer.valueOf(var) % 2 == 0) {
			i = 0;
		}
		given.setShema(i);

		if (checkStab(given) == false) {
			return;
		}

		if (stId != null) {
			stabilitron.setId(stId);
		}

		Session session = HibernateUtil.openSession();
		StabilitronDAOImpl stabilitronDAOImpl = new StabilitronDAOImpl();
		stabilitronDAOImpl.setSession(session);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		stabilitronDAOImpl.makePersistent(stabilitron);
		transaction.commit();
		session.close();

		if (diodId != null) {
			diod.setId(diodId);
		}

		session = HibernateUtil.openSession();
		DiodDao diodDao = new DiodDao();
		diodDao.setSession(session);
		transaction = session.beginTransaction();
		diodDao.makePersistent(diod);
		transaction.commit();
		session.close();

		if (id != null) {
			given.setId(id);
		}

		session = HibernateUtil.openSession();
		GivenDAOImpl givenDAOImpl = new GivenDAOImpl();
		givenDAOImpl.setSession(session);
		transaction = session.beginTransaction();
		transaction.begin();
		givenDAOImpl.makePersistent(given);
		transaction.commit();
		session.close();

		clearFields();

	}

	private void clearFields() {
		var = "";
		napr = "";
		tok = "";
		ampl = "";
		id = null;

		type = "";
		stNapr = "";
		tokMax = "";
		tokMin = "";
		r = "";
		alpha = "";
		stId = null;

		typeDiod = "";
		i_pr = "";
		i_pr_i_max = "";
		u_obr = "";
		t_obr_vos = "";
		diodId = null;

		update = false;

	}

	public void update(ActionEvent e) {
		update = true;
		Iterator<UIComponent> iterator = e.getComponent().getChildren()
				.iterator();
		Given given = (Given) ((UIParameter) iterator.next()).getValue();

		id = given.getId();
		stId = given.getStabilitron().getId();
		diodId = given.getDiod().getId();

		var = given.getVar().toString();
		napr = given.getNaprWihodnoe().toString();
		tok = given.getTok().toString();
		ampl = given.getDeltaNaprWihodnoe().toString();

		type = given.getStabilitron().getType();
		stNapr = given.getStabilitron().getNapr().toString();
		tokMax = given.getStabilitron().getTokMax().toString();
		tokMin = given.getStabilitron().getTokMin().toString();
		r = given.getStabilitron().getSopr().toString();
		alpha = given.getStabilitron().getTemperCoef().toString();

		typeDiod = given.getDiod().getName();
		i_pr = given.getDiod().getTok_maks().toString();
		i_pr_i_max = given.getDiod().getTok_i_maks().toString();
		u_obr = given.getDiod().getNapr_maks().toString();
		t_obr_vos = given.getDiod().getT_obr().toString();
	}

	public void delete(ActionEvent e) {
		Iterator<UIComponent> iterator = e.getComponent().getChildren()
				.iterator();
		Given given = (Given) ((UIParameter) iterator.next()).getValue();

		Session session = HibernateUtil.openSession();
		GivenDAOImpl daoImpl = new GivenDAOImpl();
		daoImpl.setSession(session);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		daoImpl.makeTransient(given);
		transaction.commit();
		session.close();
	}

	private List<Given> getGiven() {
		Session session = HibernateUtil.openSession();
		List<Given> list = null;
		GivenDAOImpl daoImpl = new GivenDAOImpl();
		daoImpl.setSession(session);
		list = daoImpl.findAll();
		session.close();

		return list;
	}

	public List<Given> getList() {
		return getGiven();
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getTok() {
		return tok;
	}

	public void setTok(String tok) {
		this.tok = tok;
	}

	public String getAmpl() {
		return ampl;
	}

	public void setAmpl(String ampl) {
		this.ampl = ampl;
	}

	public String getNapr() {
		return napr;
	}

	public void setNapr(String napr) {
		this.napr = napr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStNapr() {
		return stNapr;
	}

	public void setStNapr(String stNapr) {
		this.stNapr = stNapr;
	}

	public String getTokMax() {
		return tokMax;
	}

	public void setTokMax(String tokMax) {
		this.tokMax = tokMax;
	}

	public String getTokMin() {
		return tokMin;
	}

	public void setTokMin(String tokMin) {
		this.tokMin = tokMin;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

	public String getAlpha() {
		return alpha;
	}

	public void setAlpha(String alpha) {
		this.alpha = alpha;
	}

	public String getTypeDiod() {
		return typeDiod;
	}

	public void setTypeDiod(String typeDiod) {
		this.typeDiod = typeDiod;
	}

	public String getI_pr() {
		return i_pr;
	}

	public void setI_pr(String i_pr) {
		this.i_pr = i_pr;
	}

	public String getI_pr_i_max() {
		return i_pr_i_max;
	}

	public void setI_pr_i_max(String i_pr_i_max) {
		this.i_pr_i_max = i_pr_i_max;
	}

	public String getU_obr() {
		return u_obr;
	}

	public void setU_obr(String u_obr) {
		this.u_obr = u_obr;
	}

	public String getT_obr_vos() {
		return t_obr_vos;
	}

	public void setT_obr_vos(String t_obr_vos) {
		this.t_obr_vos = t_obr_vos;
	}

}

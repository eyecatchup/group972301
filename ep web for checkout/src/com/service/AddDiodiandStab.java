package com.service;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import dao.GivenDAOImpl;
import dao.StabilitronDAOImpl;
import entity.Given;
import entity.Stabilitron;
import ep.HibernateUtil;

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

	public void add(ActionEvent e) {
		Stabilitron stabilitron = new Stabilitron();
		stabilitron.setNapr(Float.valueOf(stNapr));
		stabilitron.setSopr(Float.valueOf(r));
		stabilitron.setTemperCoef(Float.valueOf(alpha));
		stabilitron.setTokMax(Float.valueOf(tokMax));
		stabilitron.setTokMin(Float.valueOf(tokMin));
		stabilitron.setType(type);

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

		Given given = new Given();
		given.setVar(Integer.valueOf(var));
		given.setNaprWihodnoe(Float.valueOf(napr));
		given.setTok(Float.valueOf(tok));
		given.setDeltaNaprWihodnoe(Float.valueOf(ampl));
		given.setStabilitron(stabilitron);

		if (id != null) {
			given.setId(id);
		}

		int i = 1;
		if (Integer.valueOf(var) % 2 == 0) {
			i = 0;
		}
		given.setShema(i);
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

	}

	public void update(ActionEvent e) {
		Iterator<UIComponent> iterator = e.getComponent().getChildren()
				.iterator();
		Given given = (Given) ((UIParameter) iterator.next()).getValue();

		id = given.getId();
		stId = given.getStabilitron().getId();

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
	}

	public void delete(ActionEvent e) {
		Iterator<UIComponent> iterator = e.getComponent().getChildren()
				.iterator();
		Given given = (Given) ((UIParameter) iterator.next()).getValue();

		Session session = HibernateUtil.openSession();
		StabilitronDAOImpl daoImpl = new StabilitronDAOImpl();
		daoImpl.setSession(session);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		daoImpl.makeTransient(given.getStabilitron());
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

}

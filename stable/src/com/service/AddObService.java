package com.service;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import dao.OB_GivenDAOImpl;
import dao.OB_TransistorDAOImpl;
import entity.GivenOB;
import entity.OB_Transistor;
import ep.HibernateUtil;

public class AddObService {
	public static boolean update;
	private String type;
	private String Uka0;
	private String Ik;
	private String Eg;
	private String Rg;
	private String Rn;
	private String Cn;
	private String var;
	private Long id;

	private String tran_type;
	private String h21min;
	private String h21max;
	private String h11a;
	private String h21a;
	private String fn;
	private String fv;
	private String Ck;
	private String Ca;
	private Long tranid;

	private List<GivenOB> list;

	private OB_Transistor checkIfExistStabilitron(OB_Transistor tran) {

		OB_TransistorDAOImpl dao = new OB_TransistorDAOImpl();
		Session session = HibernateUtil.openSession();
		dao.setSession(session);
		List<OB_Transistor> list = dao.findAll();
		session.close();

		for (OB_Transistor i : list) {
			if (i.getType().equalsIgnoreCase(tran.getType())) {
				return i;
			}
		}

		return null;
	}

	public void add(ActionEvent e) {
		OB_Transistor tran = new OB_Transistor();
		tran.setCa(Float.valueOf(Ca));
		tran.setCk(Float.valueOf(Ck));
		tran.setFv(Float.valueOf(fv));
		tran.setFn(Float.valueOf(fn));
		tran.setH21a(Float.valueOf(h21a));
		tran.setH11a(Float.valueOf(h11a));
		tran.setH21max(Float.valueOf(h21max));
		tran.setH21min(Float.valueOf(h21min));
		tran.setType(tran_type);

		OB_Transistor ob_Transistor = checkIfExistStabilitron(tran);
		if (ob_Transistor != null) {
			tranid = ob_Transistor.getId();
		}

		if (tranid != null) {
			tran.setId(tranid);
		}

		OB_TransistorDAOImpl daoImpl = new OB_TransistorDAOImpl();
		Session session = HibernateUtil.openSession();
		daoImpl.setSession(session);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		daoImpl.makePersistent(tran);
		transaction.commit();
		session.close();

		GivenOB givenOB = new GivenOB();
		givenOB.setCn(Float.valueOf(Cn));
		givenOB.setEg(Float.valueOf(Eg));
		givenOB.setIk(Float.valueOf(Ik));
		givenOB.setOb_Transistor(tran);
		givenOB.setRg(Float.valueOf(Rg));
		givenOB.setRn(Float.valueOf(Rn));
		givenOB.setType(tran_type);
		givenOB.setUka0(Float.valueOf(Uka0));
		givenOB.setVar(Integer.valueOf(var));

		if (id != null) {
			givenOB.setId(id);
		}

		OB_GivenDAOImpl ob_GivenDAOImpl = new OB_GivenDAOImpl();
		session = HibernateUtil.openSession();
		ob_GivenDAOImpl.setSession(session);
		transaction = session.beginTransaction();
		transaction.begin();
		ob_GivenDAOImpl.makePersistent(givenOB);
		transaction.commit();
		session.close();

		clear();
	}

	public void update(ActionEvent e) {
		update = true;
		Iterator<UIComponent> iterator = e.getComponent().getChildren()
				.iterator();
		GivenOB given = (GivenOB) ((UIParameter) iterator.next()).getValue();

		id = given.getId();
		tranid = given.getOb_Transistor().getId();

		type = given.getType().toString();
		Uka0 = given.getUka0().toString();
		Ik = given.getIk().toString();
		Eg = given.getEg().toString();
		Rg = given.getRg().toString();
		Rn = given.getRn().toString();
		Cn = given.getCn().toString();
		var = given.getVar().toString();

		tran_type = given.getOb_Transistor().getType();
		h21min = given.getOb_Transistor().getH21min().toString();
		h21max = given.getOb_Transistor().getH21max().toString();
		h11a = given.getOb_Transistor().getH11a().toString();
		h21a = given.getOb_Transistor().getH21a().toString();
		fn = given.getOb_Transistor().getFn().toString();
		fv = given.getOb_Transistor().getFv().toString();
		Ck = given.getOb_Transistor().getCk().toString();
		Ca = given.getOb_Transistor().getCa().toString();

	}

	private void clear() {
		type = "";
		Uka0 = null;
		Ik = null;
		Eg = null;
		Rg = null;
		Rn = null;
		Cn = null;
		var = null;
		id = null;

		tran_type = "";
		h21min = null;
		h21max = null;
		h11a = null;
		h21a = null;
		fn = null;
		fv = null;
		Ck = null;
		Ca = null;
		tranid = null;

		update = false;
	}

	public void delete(ActionEvent e) {
		Iterator<UIComponent> iterator = e.getComponent().getChildren()
				.iterator();
		GivenOB given = (GivenOB) ((UIParameter) iterator.next()).getValue();

		Session session = HibernateUtil.openSession();
		OB_GivenDAOImpl daoImpl = new OB_GivenDAOImpl();
		daoImpl.setSession(session);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		daoImpl.makeTransient(given);
		transaction.commit();
		session.close();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<GivenOB> getList() {
		Session session = HibernateUtil.openSession();
		OB_GivenDAOImpl daoImpl = new OB_GivenDAOImpl();
		daoImpl.setSession(session);
		list = daoImpl.findAll();
		session.close();
		return list;
	}

	public void setList(List<GivenOB> list) {
		this.list = list;
	}

	public String getUka0() {
		return Uka0;
	}

	public void setUka0(String uka0) {
		Uka0 = uka0;
	}

	public String getIk() {
		return Ik;
	}

	public void setIk(String ik) {
		Ik = ik;
	}

	public String getEg() {
		return Eg;
	}

	public void setEg(String eg) {
		Eg = eg;
	}

	public String getRg() {
		return Rg;
	}

	public void setRg(String rg) {
		Rg = rg;
	}

	public String getRn() {
		return Rn;
	}

	public void setRn(String rn) {
		Rn = rn;
	}

	public String getCn() {
		return Cn;
	}

	public void setCn(String cn) {
		Cn = cn;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getTran_type() {
		return tran_type;
	}

	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}

	public String getH21min() {
		return h21min;
	}

	public void setH21min(String h21min) {
		this.h21min = h21min;
	}

	public String getH21max() {
		return h21max;
	}

	public void setH21max(String h21max) {
		this.h21max = h21max;
	}

	public String getH11a() {
		return h11a;
	}

	public void setH11a(String h11a) {
		this.h11a = h11a;
	}

	public String getH21a() {
		return h21a;
	}

	public void setH21a(String h21a) {
		this.h21a = h21a;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getFv() {
		return fv;
	}

	public void setFv(String fv) {
		this.fv = fv;
	}

	public String getCk() {
		return Ck;
	}

	public void setCk(String ck) {
		Ck = ck;
	}

	public String getCa() {
		return Ca;
	}

	public void setCa(String ca) {
		Ca = ca;
	}
}

package com.service;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import dao.KBTSourceDaoImpl;
import entity.KBTSource;
import ep.HibernateUtil;

public class KBTService {
	public static boolean update = false;
	// <Source data>
	private String Variant;
	private String Ttype;
	private String Ikb0;
	private String Uip;
	private String Ucm;
	private String Rn;
	private String S;
	private String Uvihm;
	private String U0por;
	private String U1por;
	private String Cn;
	private String h21emin;
	private String h21emax;
	private String Ubepor;
	private String Ck;
	private String Th21E;
	private String Uvih0;

	private List<KBTSource> kbtList;

	private Long id;

	public void clearFields() {
		Variant = "";
		Ttype = "";
		Ikb0 = "";
		Uip = "";
		Ucm = "";
		Rn = "";
		S = "";
		Uvihm = "";
		U0por = "";
		U1por = "";
		Cn = "";
		h21emin = "";
		h21emax = "";
		Ubepor = "";
		Ck = "";
		Th21E = "";
		Uvih0 = "";
		id = null;
		update = false;
	}

	public void update(ActionEvent e) {
		update = true;
		Iterator<UIComponent> iterator = e.getComponent().getChildren()
				.iterator();
		KBTSource given = (KBTSource) ((UIParameter) iterator.next())
				.getValue();

		id = given.getId();
		Variant = given.getVariant().toString();
		Ttype = given.getTtype();
		Ikb0 = given.getIkbo().toString();
		Uip = given.getUip().toString();
		Ucm = given.getUcm().toString();
		Rn = given.getRn().toString();
		S = given.getS().toString();
		Uvihm = given.getUvihm().toString();
		U0por = given.getUpor0().toString();
		U1por = given.getUpor1().toString();
		Cn = given.getCn().toString();
		h21emin = given.getH21emin().toString();
		h21emax = given.getH21emax().toString();
		Ubepor = given.getUbepor().toString();
		Ck = given.getCk().toString();
		Th21E = given.getTh21E().toString();
		Uvih0 = given.getUvih0().toString();
	}

	public void delete(ActionEvent e) {
		Iterator<UIComponent> iterator = e.getComponent().getChildren()
				.iterator();
		KBTSource given = (KBTSource) ((UIParameter) iterator.next())
				.getValue();

		Session session = HibernateUtil.openSession();
		KBTSourceDaoImpl daoImpl = new KBTSourceDaoImpl();
		daoImpl.setSession(session);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		daoImpl.makeTransient(given);
		transaction.commit();
		session.close();
	}

	public void add(ActionEvent e) {
		KBTSource new_kbt = new KBTSource();
		new_kbt.setVariant(Integer.valueOf(Variant));
		new_kbt.setCk(Float.valueOf(Ck));
		new_kbt.setCn(Float.valueOf(Cn));
		new_kbt.setH21emax(Float.valueOf(h21emax));
		new_kbt.setH21emin(Float.valueOf(h21emin));
		new_kbt.setRn(Float.valueOf(Rn));
		new_kbt.setS(Float.valueOf(S));
		new_kbt.setTh21E(Float.valueOf(Th21E));
		new_kbt.setTtype(Ttype);
		new_kbt.setUbepor(Float.valueOf(Ubepor));
		new_kbt.setUcm(Float.valueOf(Ucm));
		new_kbt.setUip(Float.valueOf(Uip));
		new_kbt.setUpor0(Float.valueOf(U0por));
		new_kbt.setUpor1(Float.valueOf(U1por));
		new_kbt.setUvih0(Float.valueOf(Uvih0));
		new_kbt.setUvihm(Float.valueOf(Uvihm));
		new_kbt.setIkbo(Float.valueOf(Ikb0));

		if (id != null) {
			new_kbt.setId(id);
		}

		Session session = HibernateUtil.openSession();
		KBTSourceDaoImpl kbtdao = new KBTSourceDaoImpl();
		kbtdao.setSession(session);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		kbtdao.makePersistent(new_kbt);
		transaction.commit();
		session.close();

		clearFields();

	}

	public String getTtype() {
		return Ttype;
	}

	public void setTtype(String ttype) {
		Ttype = ttype;
	}

	public String getIkb0() {
		return Ikb0;
	}

	public void setIkb0(String ikb0) {
		Ikb0 = ikb0;
	}

	public String getUip() {
		return Uip;
	}

	public void setUip(String uip) {
		Uip = uip;
	}

	public String getUcm() {
		return Ucm;
	}

	public void setUcm(String ucm) {
		Ucm = ucm;
	}

	public String getRn() {
		return Rn;
	}

	public void setRn(String rn) {
		Rn = rn;
	}

	public String getS() {
		return S;
	}

	public void setS(String s) {
		S = s;
	}

	public String getUvihm() {
		return Uvihm;
	}

	public void setUvihm(String uvihm) {
		Uvihm = uvihm;
	}

	public String getU0por() {
		return U0por;
	}

	public void setU0por(String u0por) {
		U0por = u0por;
	}

	public String getU1por() {
		return U1por;
	}

	public void setU1por(String u1por) {
		U1por = u1por;
	}

	public String getCn() {
		return Cn;
	}

	public void setCn(String cn) {
		Cn = cn;
	}

	public String getH21emin() {
		return h21emin;
	}

	public void setH21emin(String h21emin) {
		this.h21emin = h21emin;
	}

	public String getH21emax() {
		return h21emax;
	}

	public void setH21emax(String h21emax) {
		this.h21emax = h21emax;
	}

	public String getUbepor() {
		return Ubepor;
	}

	public void setUbepor(String ubepor) {
		Ubepor = ubepor;
	}

	public String getCk() {
		return Ck;
	}

	public void setCk(String ck) {
		Ck = ck;
	}

	public String getTh21E() {
		return Th21E;
	}

	public void setTh21E(String th21e) {
		Th21E = th21e;
	}

	public String getUvih0() {
		return Uvih0;
	}

	public void setUvih0(String uvih0) {
		Uvih0 = uvih0;
	}

	public String getVariant() {
		return Variant;
	}

	public void setVariant(String variant) {
		Variant = variant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<KBTSource> getKbtList() {
		Session session = HibernateUtil.openSession();
		KBTSourceDaoImpl daoImpl = new KBTSourceDaoImpl();
		daoImpl.setSession(session);
		kbtList = daoImpl.findAll();
		session.close();
		return kbtList;
	}

	public void setKbtList(List<KBTSource> kbtList) {
		this.kbtList = kbtList;
	}

}

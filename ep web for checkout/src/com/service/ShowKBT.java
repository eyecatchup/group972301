package com.service;

import entity.*;

public class ShowKBT {
	private KBTSource src;
	private String Ttype;
	private Integer Variant;
	private Float Uip;
	private Float Ucm;
	private Float Rn;
	private Float S;
	private Float Uvihm;
	private Float Upor0;
	private Float Upor1;
	private Float Cn;
	private Float h21emin;
	private Float h21emax;
	private Float Ikb0;
	private Float Ubepor;
	private Float Ck;
	private Float Th21E;
	private Float Uvih0;

	public KBTSource getSrc() {
		return src;
	}

	public void setSrc(KBTSource src) {
		this.src = src;

		KBTSource kbt = src;

		Ttype = kbt.getTtype();
		Variant = kbt.getVariant();
		Uip = kbt.getUip();
		Ucm = kbt.getUcm();
		Rn = kbt.getRn();
		S = kbt.getS();
		Uvihm = kbt.getUvihm();
		Upor0 = kbt.getUpor0();
		Upor1 = kbt.getUpor1();
		Cn = kbt.getCn();
		h21emin = kbt.getH21emin();
		h21emax = kbt.getH21emax();
		Ikb0 = kbt.getIkbo();
		Ubepor = kbt.getUbepor();
		Ck = kbt.getCk();
		Th21E = kbt.getTh21E();
		Uvih0 = kbt.getUvih0();
	}

	public String getTtype() {
		return Ttype;
	}

	public void setTtype(String ttype) {
		Ttype = ttype;
	}

	public Integer getVariant() {
		return Variant;
	}

	public void setVariant(Integer variant) {
		Variant = variant;
	}

	public Float getUip() {
		return Uip;
	}

	public void setUip(Float uip) {
		Uip = uip;
	}

	public Float getUcm() {
		return Ucm;
	}

	public void setUcm(Float ucm) {
		Ucm = ucm;
	}

	public Float getRn() {
		return Rn;
	}

	public void setRn(Float rn) {
		Rn = rn;
	}

	public Float getS() {
		return S;
	}

	public void setS(Float s) {
		S = s;
	}

	public Float getUvihm() {
		return Uvihm;
	}

	public void setUvihm(Float uvihm) {
		Uvihm = uvihm;
	}

	public Float getUpor0() {
		return Upor0;
	}

	public void setUpor0(Float upor0) {
		Upor0 = upor0;
	}

	public Float getUpor1() {
		return Upor1;
	}

	public void setUpor1(Float upor1) {
		Upor1 = upor1;
	}

	public Float getCn() {
		return Cn;
	}

	public void setCn(Float cn) {
		Cn = cn;
	}

	public Float getH21emin() {
		return h21emin;
	}

	public void setH21emin(Float h21emin) {
		this.h21emin = h21emin;
	}

	public Float getH21emax() {
		return h21emax;
	}

	public void setH21emax(Float h21emax) {
		this.h21emax = h21emax;
	}

	public Float getIkb0() {
		return Ikb0;
	}

	public void setIkb0(Float ikb0) {
		Ikb0 = ikb0;
	}

	public Float getUbepor() {
		return Ubepor;
	}

	public void setUbepor(Float ubepor) {
		Ubepor = ubepor;
	}

	public Float getCk() {
		return Ck;
	}

	public void setCk(Float ck) {
		Ck = ck;
	}

	public Float getTh21E() {
		return Th21E;
	}

	public void setTh21E(Float th21e) {
		Th21E = th21e;
	}

	public Float getUvih0() {
		return Uvih0;
	}

	public void setUvih0(Float uvih0) {
		Uvih0 = uvih0;
	}

	
}

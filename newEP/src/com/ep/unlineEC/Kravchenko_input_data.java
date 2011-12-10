package com.ep.unlineEC;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.dao.KravchenkoDAOImpl;
import com.entity.Kravchenko_data;

public class Kravchenko_input_data implements Serializable{
	private Double[] row1;
	private Double[] row2;
	private Double u0;
	private Double r;
	private Double a2;
	private Double a1;
	private Double u1;
	private Double krutizna;
	private Double ugolOtsechki;
	private Double[] sinUgla;
	private Double[] cosUgla;
	private Double amplitudaToka;
	private Double constToka;
	private Double amplituda1G;
	private Double amplituda2G;
	private Double amplituda3G;
	private Double amplituda4G;
	private Double srednyayaKrutizna;
	private Double koefIskazhenii;

	private Double[] u;
	private Double[] i;
	private Double u0_init;
	private Double e;
	
	
	public Double[] getU() {
		return u;
	}

	public void setU(Double[] u) {
		this.u = u;
	}

	public Double[] getI() {
		return i;
	}

	public void setI(Double[] i) {
		this.i = i;
	}

	public Kravchenko_input_data(Integer variant){
		KravchenkoDAOImpl daoImpl = new KravchenkoDAOImpl();
		List<Kravchenko_data> data = daoImpl.getDataByVariant(variant);
		this.u = new Double[12];
		this.i = new Double[12];
		Iterator<Kravchenko_data> iter = data.iterator();
		for(int j = 0; j<12; j++){
			Kravchenko_data d = iter.next();
			this.u[j] = d.getData_u();
			this.i[j] = d.getData_i();
			this.e = d.getData_e();
			this.u0_init = d.getData_u0();
		}
		this.calculateR();
		this.calculateA2();
		this.calculateA1();
		this.calculateU1();
		this.calculateKrutizna();
		this.calculateUgol();
		this.calculateCos();
		this.calculateSin();
		this.calculateAmplituda();
		this.calculateCostToka();
		this.calculateAmplituda1G();
		this.calculateAmplituda2G();
		this.calculateAmplituda3G();
		this.calculateAmplituda4G();
		this.calculateSrKrutizna();
		this.calculateKoef();
	}
	
	public void calculateR(){
		this.r = (this.u[11]-this.u[9])/(this.i[11]-this.i[9]);
	}
	
	public void calculateA2(){
		this.a2 = (this.i[11] - this.u[11]*this.i[5]/this.u[5])/(u[11]*u[11]-u[11]*u[5]);
	}
	
	public void calculateA1(){
		this.a1 = (i[5]-(u[5]*u[5]*this.a2))/u[5];
	}
	
	public void calculateU1(){
		this.u1 = u[11]-i[11]*this.r;
	}
	public void calculateKrutizna(){
		this.krutizna = 1/this.r;
	}
	public void calculateUgol(){
		this.ugolOtsechki = Math.acos((this.u1 - this.u0_init)/this.e);
	}
	public void calculateCos(){
		this.cosUgla = new Double[4];
		this.cosUgla[0] = Math.cos(this.ugolOtsechki);
		this.cosUgla[1] = Math.cos(2*this.ugolOtsechki);
		this.cosUgla[2] = Math.cos(3*this.ugolOtsechki);
		this.cosUgla[3] = Math.cos(4*this.ugolOtsechki);
	}
	public void calculateSin(){
		this.sinUgla = new Double[4];
		this.sinUgla[0] = Math.sin(this.ugolOtsechki);
		this.sinUgla[1] = Math.sin(2*this.ugolOtsechki);
		this.sinUgla[2] = Math.sin(3*this.ugolOtsechki);
		this.sinUgla[3] = Math.sin(4*this.ugolOtsechki);
	}
	public void calculateAmplituda(){
		this.amplitudaToka = this.e*(1-this.getCosUgla()[0])/this.r;
	}
	public void calculateCostToka(){
		this.constToka = this.amplitudaToka*((this.getSinUgla()[0]-this.ugolOtsechki*this.getCosUgla()[0])/(3.14*(1-this.getCosUgla()[0])));
	}
	public void calculateAmplituda1G(){
		this.amplituda1G = this.amplitudaToka*((this.ugolOtsechki-this.sinUgla[0]*this.cosUgla[0])/(3.14*(1-this.cosUgla[0])));
	}
	public void calculateAmplituda2G(){
		this.amplituda2G = 2*this.amplitudaToka*(this.sinUgla[1]*this.cosUgla[0]-2*this.cosUgla[1]*this.sinUgla[0])/(6*3.14*(1-this.cosUgla[0]));
	}
	public void calculateAmplituda3G(){
		this.amplituda3G = 2*this.amplitudaToka*(this.sinUgla[2]*this.cosUgla[0]-3*this.cosUgla[2]*this.sinUgla[0])/(24*3.14*(1-this.cosUgla[0]));
	}
	public void calculateAmplituda4G(){
		this.amplituda4G = 2*this.amplitudaToka*(this.sinUgla[3]*this.cosUgla[0]-4*this.cosUgla[3]*this.sinUgla[0])/(60*3.14*(1-this.cosUgla[0]));
	}
	public void calculateSrKrutizna(){
		this.srednyayaKrutizna = this.amplituda1G/this.e;
	}
	public void calculateKoef(){
		this.koefIskazhenii = Math.sqrt((this.amplituda2G*this.amplituda2G+this.amplituda3G*this.amplituda3G+this.amplituda4G*this.amplituda4G)/(this.amplituda1G*this.amplituda1G));
	}
	
	public Double[] getRow1() {
		return row1;
	}
	public void setRow1(Double[] row1) {
		this.row1 = row1;
	}
	public Double[] getRow2() {
		return row2;
	}
	public void setRow2(Double[] row2) {
		this.row2 = row2;
	}
	public Double getU0() {
		return u0;
	}
	public void setU0(Double u0) {
		this.u0 = u0;
	}
	public Double getA1() {
		return a1;
	}
	public void setA1(Double a1) {
		this.a1 = a1;
	}
	public Double getU1() {
		return u1;
	}
	public void setU1(Double u1) {
		this.u1 = u1;
	}
	public Double getKrutizna() {
		return krutizna;
	}
	public void setKrutizna(Double krutizna) {
		this.krutizna = krutizna;
	}
	public Double getUgolOtsechki() {
		return ugolOtsechki;
	}
	public void setUgolOtsechki(Double ugolOtsechki) {
		this.ugolOtsechki = ugolOtsechki;
	}
	public Double[] getSinUgla() {
		return sinUgla;
	}
	public void setSinUgla(Double[] sinUgla) {
		this.sinUgla = sinUgla;
	}
	public Double[] getCosUgla() {
		return cosUgla;
	}
	public void setCosUgla(Double[] cosUgla) {
		this.cosUgla = cosUgla;
	}
	public Double getAmplitudaToka() {
		return amplitudaToka;
	}
	public void setAmplitudaToka(Double amplitudaToka) {
		this.amplitudaToka = amplitudaToka;
	}
	public Double getConstToka() {
		return constToka;
	}
	public void setConstToka(Double constToka) {
		this.constToka = constToka;
	}
	public Double getAmplituda1G() {
		return amplituda1G;
	}
	public void setAmplituda1G(Double amplituda1g) {
		amplituda1G = amplituda1g;
	}
	public Double getAmplituda2G() {
		return amplituda2G;
	}
	public void setAmplituda2G(Double amplituda2g) {
		amplituda2G = amplituda2g;
	}
	public Double getAmplituda3G() {
		return amplituda3G;
	}
	public void setAmplituda3G(Double amplituda3g) {
		amplituda3G = amplituda3g;
	}
	public Double getAmplituda4G() {
		return amplituda4G;
	}
	public void setAmplituda4G(Double amplituda4g) {
		amplituda4G = amplituda4g;
	}
	public Double getSrednyayaKrutizna() {
		return srednyayaKrutizna;
	}
	public void setSrednyayaKrutizna(Double srednyayaKrutizna) {
		this.srednyayaKrutizna = srednyayaKrutizna;
	}
	public Double getKoefIskazhenii() {
		return koefIskazhenii;
	}
	public void setKoefIskazhenii(Double koefIskazhenii) {
		this.koefIskazhenii = koefIskazhenii;
	}
	public Double getU0_init() {
		return u0_init;
	}
	public void setU0_init(Double u0_init) {
		this.u0_init = u0_init;
	}
	public Double getE() {
		return e;
	}
	public void setE(Double e) {
		this.e = e;
	}
	public Double getR() {
		return r;
	}
	public void setR(Double r) {
		this.r = r;
	}
	public Double getA2() {
		return a2;
	}
	public void setA2(Double a2) {
		this.a2 = a2;
	}

}
package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Type;

@SuppressWarnings("serial")
@Entity
@Table(name = "stabilizator_napr_given")
public class Given implements Serializable {
	@Id
	@Column(name = "idstabilizator_napr")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="tok",precision=6)
	private Float tok;
	
	@Column(name="naprWihodnoe", precision=6)
	private Float naprWihodnoe;
	
	@Column(name="deltanapr_vix", precision=6)
	private Float deltaNaprWihodnoe;
	
	@Column(name="var")
	private Integer var;
	
	@Column(name="shema_type")
	@Type(type="yes_no")
	private boolean shema;

	@ManyToOne
	@JoinColumn(name="id_stab")
	private Stabilitron stabilitron;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public Float getTok() {
		return tok;
	}

	public void setTok(Float tok) {
		this.tok = tok;
	}

	public Float getNaprWihodnoe() {
		return naprWihodnoe;
	}

	public void setNaprWihodnoe(Float naprWihodnoe) {
		this.naprWihodnoe = naprWihodnoe;
	}

	public Float getDeltaNaprWihodnoe() {
		return deltaNaprWihodnoe;
	}

	public void setDeltaNaprWihodnoe(Float deltaNaprWihodnoe) {
		this.deltaNaprWihodnoe = deltaNaprWihodnoe;
	}

	public Integer getVar() {
		return var;
	}

	public void setVar(Integer var) {
		this.var = var;
	}

	public boolean isShema() {
		return shema;
	}

	public void setShema(boolean shema) {
		this.shema = shema;
	}

	public Stabilitron getStabilitron() {
		return stabilitron;
	}

	public void setStabilitron(Stabilitron stabilitron) {
		this.stabilitron = stabilitron;
	}

}

package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@SuppressWarnings("serial")
@Entity
@Table(name = "stabilitron")
public class Stabilitron implements Serializable {
	@Id
	@Column(name = "idstabilitron")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "type", length=45)
	private String type;

	@Column(name = "napr", precision = 6)
	private Float napr;

	@Column(name = "tokMax", precision = 6)
	private Float tokMax;

	@Column(name = "tokMin", precision = 6)
	private Float tokMin;

	@Column(name = "sopr", precision = 6)
	private Float sopr;

	@Column(name = "temperCoef", precision = 6)
	private Float temperCoef;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getNapr() {
		return napr;
	}

	public void setNapr(Float napr) {
		this.napr = napr;
	}

	public Float getTokMax() {
		return tokMax;
	}

	public void setTokMax(Float tokMax) {
		this.tokMax = tokMax;
	}

	public Float getTokMin() {
		return tokMin;
	}

	public void setTokMin(Float tokMin) {
		this.tokMin = tokMin;
	}

	public Float getSopr() {
		return sopr;
	}

	public void setSopr(Float sopr) {
		this.sopr = sopr;
	}

	public Float getTemperCoef() {
		return temperCoef;
	}

	public void setTemperCoef(Float temperCoef) {
		this.temperCoef = temperCoef;
	}

}

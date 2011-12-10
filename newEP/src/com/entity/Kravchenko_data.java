package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "kravchenko_data")
public class Kravchenko_data implements Serializable {
	@Id
	@Column(name = "data_id_data")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "data_u")
	private Double data_u;

	@Column(name = "data_i")
	private Double data_i;

	@Column(name = "data_variant")
	private Integer data_variant;
	
	@Column(name = "data_u0")
	private Double data_u0;
	
	@Column(name = "data_e")
	private Double data_e;

	
	public Kravchenko_data(Long id, Double data_u, Double data_i, Integer data_variant, Double data_u0, Double data_e) {
		this.id = id;
		this.data_u = data_u;
		this.data_i = data_i;
		this.data_variant = data_variant;
		this.data_u0 = data_u0;
		this.data_e = data_e;
	}
	
	public Kravchenko_data(){
		
	}

	public Double getData_u() {
		return data_u;
	}

	public void setData_u(Double data_u) {
		this.data_u = data_u;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getData_i() {
		return data_i;
	}

	public void setData_i(Double data_i) {
		this.data_i = data_i;
	}

	public Integer getData_variant() {
		return data_variant;
	}

	public void setData_variant(Integer data_variant) {
		this.data_variant = data_variant;
	}

	public Double getData_u0() {
		return data_u0;
	}

	public void setData_u0(Double data_u0) {
		this.data_u0 = data_u0;
	}

	public Double getData_e() {
		return data_e;
	}

	public void setData_e(Double data_e) {
		this.data_e = data_e;
	}

	
}

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
	private Integer data_u;

	@Column(name = "data_i")
	private Integer data_i;

	@Column(name = "data_variant")
	private Integer data_variant;

	public Integer getData_u() {
		return data_u;
	}

	public void setData_u(Integer data_u) {
		this.data_u = data_u;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getData_i() {
		return data_i;
	}

	public void setData_i(Integer data_i) {
		this.data_i = data_i;
	}

	public Integer getData_variant() {
		return data_variant;
	}

	public void setData_variant(Integer data_variant) {
		this.data_variant = data_variant;
	}

}

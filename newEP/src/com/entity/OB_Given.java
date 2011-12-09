package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name="ob_given")
public class OB_Given implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="type", length=50)
	private String type;
	
	@Column(name="Uka0")
	private Float Uka0;
	
	@Column(name="Ik")
	private Float Ik;
	
	@Column(name="Eg")
	private Float Eg;
	
	@Column(name="Rg")
	private Float Rg;
	
	@Column(name="Rn")
	private Float Rn;
	
	@Column(name="Cn")
	private Float Cn;
	
	@ManyToOne
	@JoinColumn(name="id_ob_tran")
	private OB_Transistor ob_Transistor;

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

	public Float getUka0() {
		return Uka0;
	}

	public void setUka0(Float uka0) {
		Uka0 = uka0;
	}

	public Float getIk() {
		return Ik;
	}

	public void setIk(Float ik) {
		Ik = ik;
	}

	public Float getEg() {
		return Eg;
	}

	public void setEg(Float eg) {
		Eg = eg;
	}

	public Float getRg() {
		return Rg;
	}

	public void setRg(Float rg) {
		Rg = rg;
	}

	public Float getRn() {
		return Rn;
	}

	public void setRn(Float rn) {
		Rn = rn;
	}

	public Float getCn() {
		return Cn;
	}

	public void setCn(Float cn) {
		Cn = cn;
	}

	public OB_Transistor getOb_Transistor() {
		return ob_Transistor;
	}

	public void setOb_Transistor(OB_Transistor ob_Transistor) {
		this.ob_Transistor = ob_Transistor;
	}
	
	
	
	
}

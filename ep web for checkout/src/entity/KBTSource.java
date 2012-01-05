package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "sourcedata")
public class KBTSource implements Serializable{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Ttype", length = 50)
	private String Ttype;

	@Column(name = "variant")
	private Integer Variant;

	@Column(name = "Uip", precision = 6)
	private Float Uip;

	@Column(name = "Ucm", precision = 6)
	private Float Ucm;

	@Column(name = "Rn", precision = 6)
	private Float Rn;

	@Column(name = "S", precision = 6)
	private Float S;

	@Column(name = "Uvihm", precision = 6)
	private Float Uvihm;

	@Column(name = "Upor0", precision = 6)
	private Float Upor0;

	@Column(name = "Upor1", precision = 6)
	private Float Upor1;

	@Column(name = "Cn", precision = 6)
	private Float Cn;

	@Column(name = "h21emin", precision = 6)
	private Float h21emin;

	@Column(name = "h21emax", precision = 6)
	private Float h21emax;

	@Column(name = "Ubepor", precision = 6)
	private Float Ubepor;

	@Column(name = "Ck", precision = 6)
	private Float Ck;

	@Column(name = "Th21E", precision = 6)
	private Float Th21E;

	@Column(name = "Uvih0", precision = 6)
	private Float Uvih0;
	
	@Column(name = "ikb0", precision=6)
	private Float ikbo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Float getIkbo() {
		return ikbo;
	}

	public void setIkbo(Float ikbo) {
		this.ikbo = ikbo;
	}
	
	
}

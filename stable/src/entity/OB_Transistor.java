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
@Table(name="ob_transistor")
public class OB_Transistor implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="h21min", precision=6)
	private Float h21min;
	
	@Column(name="h21max", precision=6)
	private Float h21max;
	
	@Column(name="h11a", precision = 6)
	private Float h11a;
	
	@Column(name = "h21a", precision = 6)
	private Float h21a;
	
	@Column(name = "fn", precision=6)
	private Float fn;
	
	@Column(name="fv", precision=6)
	private Float fv;
	
	@Column(name="Ck")
	private Float Ck;
	
	@Column(name="Ca")
	private Float Ca;

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

	public Float getH21min() {
		return h21min;
	}

	public void setH21min(Float h21min) {
		this.h21min = h21min;
	}

	public Float getH21max() {
		return h21max;
	}

	public void setH21max(Float h21max) {
		this.h21max = h21max;
	}

	public Float getH11a() {
		return h11a;
	}

	public void setH11a(Float h11a) {
		this.h11a = h11a;
	}

	public Float getH21a() {
		return h21a;
	}

	public void setH21a(Float h21a) {
		this.h21a = h21a;
	}

	public Float getFn() {
		return fn;
	}

	public void setFn(Float fn) {
		this.fn = fn;
	}

	public Float getFv() {
		return fv;
	}

	public void setFv(Float fv) {
		this.fv = fv;
	}

	public Float getCa() {
		return Ca;
	}

	public void setCa(Float ca) {
		Ca = ca;
	}

	public Float getCk() {
		return Ck;
	}

	public void setCk(Float ck) {
		Ck = ck;
	}
}

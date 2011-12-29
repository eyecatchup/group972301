package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "stud_group", uniqueConstraints = { @UniqueConstraint(columnNames = { "Number" }) })
public class StGroup implements Serializable {
	@Id
	@Column(name = "idgroup")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Number")
	private String number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}

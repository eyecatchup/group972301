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
@Table(name = "labs")
public class Lab implements Serializable {

	@Id
	@Column(name = "idLabs")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "theme")
	private Long theme;

	@Column(name = "variant")
	private Long variant;

	@Column(name = "mark")
	private Long mark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVariant() {
		return variant;
	}

	public void setVariant(Long variant) {
		this.variant = variant;
	}

	public Long getMark() {
		return mark;
	}

	public void setMark(Long mark) {
		this.mark = mark;
	}

	public Long getTheme() {
		return theme;
	}

	public void setTheme(Long theme) {
		this.theme = theme;
	}

}

package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name = "student")
public class Student implements Serializable {

	@Id
	@Column(name = "idnew_table")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", length = 45)
	private String name;

	@Column(name = "surname", length = 45)
	private String surname;

	@Column(name = "fathersname", length = 45)
	private String fathersName;
	
	@Column(name="password", length=45)
	private String password;

	@ManyToOne
	@JoinColumn(name="id_group")
	private StGroup group;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "stud_labs", joinColumns = { @JoinColumn(name = "idstudent") }, inverseJoinColumns = { @JoinColumn(name = "idlab") })
	private Set<Lab> doneLabs = new HashSet<Lab>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public StGroup getGroup() {
		return group;
	}

	public void setGroup(StGroup group) {
		this.group = group;
	}

	public Set<Lab> getDoneLabs() {
		return doneLabs;
	}

	public void setDoneLabs(Set<Lab> doneLabs) {
		this.doneLabs = doneLabs;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

package com.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "group")
public class Group implements Serializable {
	@Id
	@Column(name = "idgroup")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Number")
	private Long number;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "stud_groups", joinColumns = { @JoinColumn(name = "id_group") }, inverseJoinColumns = { @JoinColumn(name = "id_stud") })
	private Set<Student> students = new HashSet<Student>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}

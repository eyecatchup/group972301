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
@Table(name = "stud_labs")
public class StudentLabs implements Serializable {

	@Id
	@Column(name = "idstud_labs")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "idstudent")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "idlab")
	private Lab lab;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Lab getLab() {
		return lab;
	}

	public void setLab(Lab lab) {
		this.lab = lab;
	}

}

package com.service;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.Transaction;

import com.logic.AppLogic;

import dao.GroupDAOImpl;
import dao.StudentDAOImpl;
import entity.StGroup;
import entity.Student;
import ep.HibernateUtil;

public class LoginService {
	public static Student student;
	private String studName = "";
	private String studSurName = "";
	private String password = "";
	private String group = "";
	private String fathersName = "";

	private UIForm addForm;
	private boolean show = false;

	public String LogIn() {
		StudentDAOImpl studentDao = new StudentDAOImpl();
		studentDao.setSession(HibernateUtil.getSessionFactory().openSession());
		Transaction transaction = studentDao.getSession().beginTransaction();
		transaction.begin();

		student = studentDao.getStudentByLogin(studName, studSurName, password,
				group);
		studentDao.getSession().close();

		if (student != null) {
			return AppLogic.LOGIN_SUCCESSFULL;

		} else {
			showErrorMessage("Incorrect login or password");

			return AppLogic.LOGIN_FAILED;
		}

	}

	public void addStudent(ActionEvent e) {
		Student student = new Student();
		student.setName(studName);
		student.setSurname(studSurName);
		student.setFathersName(fathersName);
		student.setPassword(password);

		GroupDAOImpl daoImpl = new GroupDAOImpl();
		daoImpl.setSession(HibernateUtil.getSessionFactory().openSession());
		StGroup group = daoImpl.getGroutByNumber(this.group);
		daoImpl.getSession().close();
		student.setGroup(group);
		
		if(group == null) {
			showErrorMessage("Недопустимое значение группы");
			return;
		}
		
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		studentDAOImpl.setSession(HibernateUtil.getSessionFactory().openSession());
		Transaction transaction = studentDAOImpl.getSession().beginTransaction();
		transaction.begin();
		studentDAOImpl.makePersistent(student);
		transaction.commit();
		studentDAOImpl.getSession().close();
		
		studName = "";
		studSurName = "";
		fathersName = "";
		this.group = "";
		password = "";

	}

	private void showErrorMessage(String message) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				message, null));
	}

	public void displayAddForm(ActionEvent e) {
		if (e.getComponent().getId().equalsIgnoreCase("show_hide")) {
			if (show) {
				show = false;
			} else {
				show = true;
			}
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		LoginService.student = student;
	}

	public String getStudSurName() {
		return studSurName;
	}

	public void setStudSurName(String studSurName) {
		this.studSurName = studSurName;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public UIForm getAddForm() {
		return addForm;
	}

	public void setAddForm(UIForm addForm) {
		this.addForm = addForm;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

}

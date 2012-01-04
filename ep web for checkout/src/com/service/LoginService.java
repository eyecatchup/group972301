package com.service;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.logic.AppLogic;

import dao.GroupDAOImpl;
import dao.RootDao;
import dao.StudentDAOImpl;
import entity.RootEntity;
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
	public static boolean IS_ROOT = false;
	private static final String ROOT_NAME = "Владимир";
	private static final String ROOT_SURNAME = "Николаевич";

	public String LogIn() {
		if (studName.equalsIgnoreCase(ROOT_NAME)
				&& studSurName.equalsIgnoreCase(ROOT_SURNAME)) {
			RootDao rootDao = new RootDao();
			Session session = HibernateUtil.openSession();
			rootDao.setSession(session);
			RootEntity root = rootDao.getRoot();
			if (root != null) {
				if (password.equalsIgnoreCase(root.getPassword())) {
					IS_ROOT = true;
					return AppLogic.LOGIN_SUCCESSFULL;
				}
			}

			showErrorMessage("Incorrect login or password");
			return AppLogic.LOGIN_FAILED;

		}

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

		if (group == null) {
			showErrorMessage("Недопустимое значение группы");
			return;
		}

		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		studentDAOImpl.setSession(HibernateUtil.getSessionFactory()
				.openSession());
		Transaction transaction = studentDAOImpl.getSession()
				.beginTransaction();
		transaction.begin();
		studentDAOImpl.makePersistent(student);
		transaction.commit();
		studentDAOImpl.getSession().close();

		clearFields();

	}

	private void clearFields() {
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
		clearFields();
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

	public boolean isIS_ROOT() {
		return IS_ROOT;
	}

	public void setIS_ROOT(boolean iS_ROOT) {
		IS_ROOT = iS_ROOT;
	}

}

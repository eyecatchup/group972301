package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import dao.GroupDAOImpl;
import dao.LabDAOImpl;
import dao.StudentDAOImpl;
import entity.Lab;
import entity.StGroup;
import entity.Student;
import ep.HibernateUtil;

public class StudentService {
	public static String curGroup;
	public static List<String> strGroupList;
	public static List<Student> studGroupList = new ArrayList<Student>();
	public static List<StGroup> groupList;
	public static List<Student> studList;

	public static boolean load = false;

	public static String groupNumber;

	public void addGroup(ActionEvent e) {
		StGroup group = new StGroup();
		group.setNumber(groupNumber);

		Session session = HibernateUtil.openSession();
		GroupDAOImpl groupDAOImpl = new GroupDAOImpl();
		groupDAOImpl.setSession(session);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		groupDAOImpl.makePersistent(group);
		transaction.commit();
		session.close();

		getGroups();
	}

	public void deleteGroup(ActionEvent e) {
		//real face palm
		List<List<Lab>> doneLabs = new ArrayList<List<Lab>>();
		for(Student i: studGroupList) {
			doneLabs.add(i.getDoneLabs());
		}
		
		StGroup group = getGroup(curGroup);
		Session session = HibernateUtil.openSession();
		GroupDAOImpl groupDAOImpl = new GroupDAOImpl();
		groupDAOImpl.setSession(session);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		groupDAOImpl.makeTransient(group);
		transaction.commit();
		session.close();
		
		session = HibernateUtil.openSession();
		LabDAOImpl labDAOImpl = new LabDAOImpl();
		labDAOImpl.setSession(session);
		transaction = session.beginTransaction();
		transaction.begin();

		for(List<Lab> i: doneLabs) {
			for(Lab j: i){
				labDAOImpl.makeTransient(j);
			}
		}
		
		transaction.commit();
		session.close();
		
	}

	public void deleteStudentResult(ActionEvent e) {
		Iterator<UIComponent> iterator = e.getComponent().getChildren()
				.iterator();
		Lab lab = (Lab) ((UIParameter) iterator.next()).getValue();

		Session session = HibernateUtil.openSession();
		LabDAOImpl daoImpl = new LabDAOImpl();
		daoImpl.setSession(session);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		daoImpl.makeTransient(lab);
		transaction.commit();
		session.close();
	}

	public void deleteStudent(ActionEvent e) {
		Iterator<UIComponent> iterator = e.getComponent().getChildren()
				.iterator();
		Student student = (Student) ((UIParameter) iterator.next()).getValue();
		List<Lab> doneLabs = student.getDoneLabs();

		Session session = HibernateUtil.openSession();
		StudentDAOImpl daoImpl = new StudentDAOImpl();
		daoImpl.setSession(session);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		daoImpl.makeTransient(student);
		transaction.commit();
		session.close();

		if (doneLabs != null) {
			session = HibernateUtil.openSession();
			LabDAOImpl labDAOImpl = new LabDAOImpl();
			labDAOImpl.setSession(session);
			transaction = session.beginTransaction();
			transaction.begin();

			for (Lab i : doneLabs) {
				labDAOImpl.makeTransient(i);
			}

			transaction.commit();
			session.close();
		}
	}

	private List<StudLabsInfo> doneLabsList;

	class StudLabsInfo {
		private String theme;
		private String mark;

		public StudLabsInfo(int theme, String mark) {
			switch (theme) {
			case 1:
				this.theme = MainService.theme0;
				break;
			case 2:
				this.theme = MainService.theme1;
				break;
			case 3:
				this.theme = MainService.theme2;
			}

			this.mark = mark;
		}

		public String getTheme() {
			return theme;
		}

		public void setTheme(String theme) {
			this.theme = theme;
		}

		public String getMark() {
			return mark;
		}

		public void setMark(String mark) {
			this.mark = mark;
		}

	}

	public static StGroup getGroup(String number) {
		StGroup group = null;

		for (StGroup i : groupList) {
			if (i.getNumber().equalsIgnoreCase(number)) {
				group = i;
			}
		}

		return group;
	}

	private static List<StGroup> getGroups() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		GroupDAOImpl groupDAOImpl = new GroupDAOImpl();
		groupDAOImpl.setSession(session);
		groupList = groupDAOImpl.findAll();
		session.close();

		if (groupList != null) {
			strGroupList = new LinkedList<String>();
			for (StGroup i : groupList) {
				strGroupList.add(i.getNumber());
			}

			if (strGroupList.size() != 0 && load == false) {
				StGroup group = groupList.get(0);
				curGroup = group.getNumber();
				groupNumber = curGroup;

				studList = getStudents();
				for (Student i : studList) {
					if (i.getGroup().getNumber()
							.equalsIgnoreCase(group.getNumber())) {
						StudentService.studGroupList.add(i);
					}
				}

			}
		}

		return groupList;
	}

	public static List<Student> getStudents() {
		List<Student> studentList;
		Session session = HibernateUtil.getSessionFactory().openSession();
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		studentDAOImpl.setSession(session);
		studentList = studentDAOImpl.findAll();
		session.close();
		return studentList;
	}

	public String getCurGroup() {
		return curGroup;
	}

	public void setCurGroup(String curGroup) {
		StudentService.curGroup = curGroup;
	}

	public List<Student> getStudList() {
		studList = getStudents();
		return studList;
	}

	public void setStudList(List<Student> studList) {
		StudentService.studList = studList;
	}

	public List<StGroup> getGroupList() {
		// groupList = getGroups();
		return groupList;
	}

	public void setGroupList(List<StGroup> groupList) {
		StudentService.groupList = groupList;
	}

	public List<String> getStrGroupList() {
		groupList = getGroups();
		return strGroupList;
	}

	public void setStrGroupList(List<String> strGroupList) {
		StudentService.strGroupList = strGroupList;
	}

	public List<StudLabsInfo> getDoneLabsList() {
		return doneLabsList;
	}

	public void setDoneLabsList(List<StudLabsInfo> doneLabsList) {
		this.doneLabsList = doneLabsList;
	}

	public List<Student> getStudGroupList() {

		studList = getStudents();
		StGroup group = StudentService.getGroup(curGroup);
		studGroupList.clear();

		for (Student i : StudentService.studList) {
			if (i.getGroup().getNumber().equalsIgnoreCase(group.getNumber())) {
				StudentService.studGroupList.add(i);
			}
		}

		return studGroupList;
	}

	public void setStudGroupList(List<Student> studGroupList) {
		StudentService.studGroupList = studGroupList;
	}

	public String getGroupNumber() {
		groupNumber = curGroup;
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		StudentService.groupNumber = groupNumber;
	}

}

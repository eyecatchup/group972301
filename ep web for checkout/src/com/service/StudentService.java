package com.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.classic.Session;

import dao.GroupDAOImpl;
import dao.StudentDAOImpl;
import entity.StGroup;
import entity.Student;
import ep.HibernateUtil;

public class StudentService {
	private String curGroup;
	public static List<String> strGroupList;
	public static List<StGroup> groupList = getGroups();
	public static List<Student> studList = getStudents();
	public static List<Student> studGroupList = new ArrayList<Student>();

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
		List<StGroup> groupList;
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
		this.curGroup = curGroup;
	}

	public List<Student> getStudList() {
		return studList;
	}

	public void setStudList(List<Student> studList) {
		this.studList = studList;
	}

	public List<StGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<StGroup> groupList) {
		this.groupList = groupList;
	}

	public List<String> getStrGroupList() {
		return strGroupList;
	}

	public void setStrGroupList(List<String> strGroupList) {
		this.strGroupList = strGroupList;
	}

	public List<StudLabsInfo> getDoneLabsList() {
		return doneLabsList;
	}

	public void setDoneLabsList(List<StudLabsInfo> doneLabsList) {
		this.doneLabsList = doneLabsList;
	}

	public List<Student> getStudGroupList() {
		return studGroupList;
	}

	public void setStudGroupList(List<Student> studGroupList) {
		this.studGroupList = studGroupList;
	}

}

package com.dao;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.entity.Group;
import com.entity.Lab;
import com.entity.Student;
import com.entity.StudentLabs;

public class SessionFactory {
	private static AnnotationConfiguration aconf;
	private static Configuration config;
	private static org.hibernate.SessionFactory sessionFactory;

	static {
		aconf = new AnnotationConfiguration().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Lab.class)
				.addAnnotatedClass(Group.class)
				.addAnnotatedClass(StudentLabs.class)
				.addAnnotatedClass(com.entity.Given.class)
				.addAnnotatedClass(com.entity.Stabilitron.class);
		

		config = aconf.configure();
		sessionFactory = config.configure().buildSessionFactory();
	}
	
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	
	public static AnnotationConfiguration getAconf() {
		return aconf;
	}

	public static void setAconf(AnnotationConfiguration aconf) {
		SessionFactory.aconf = aconf;
	}

	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
		SessionFactory.sessionFactory = sessionFactory;
	}
}

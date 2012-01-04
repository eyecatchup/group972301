package ep;

import java.security.Security;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import entity.Given;
import entity.GivenOB;
import entity.Lab;
import entity.OB_Transistor;
import entity.StGroup;
import entity.Stabilitron;
import entity.Student;
import entity.StudentLabs;
import ep.diodiAndStabilitroni.Diod;

public class HibernateUtil {
	private static AnnotationConfiguration aconf;
	private static Configuration config;
	private static org.hibernate.SessionFactory sessionFactory;

	static {
		aconf = new AnnotationConfiguration().addAnnotatedClass(StGroup.class)
				.addAnnotatedClass(Security.class)
				.addAnnotatedClass(Given.class)
				.addAnnotatedClass(GivenOB.class).addAnnotatedClass(Lab.class)
				.addAnnotatedClass(Stabilitron.class)
				.addAnnotatedClass(OB_Transistor.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentLabs.class)
				.addAnnotatedClass(Diod.class);

		config = aconf.configure();
		sessionFactory = config.configure().buildSessionFactory();

	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}

	public static AnnotationConfiguration getAconf() {
		return aconf;
	}

	public static void setAconf(AnnotationConfiguration aconf) {
		HibernateUtil.aconf = aconf;
	}

	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(
			org.hibernate.SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}

}
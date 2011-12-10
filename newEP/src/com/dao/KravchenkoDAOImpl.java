package com.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Kravchenko_data;
import com.ep.HibernateUtil;

public class KravchenkoDAOImpl extends GenericDaoIml<Kravchenko_data, Long>{
	private SessionFactory sessionFactory;
	
	public KravchenkoDAOImpl(){
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public List<Kravchenko_data> getDataByVariant(Integer variant){
		Session session = sessionFactory.openSession();
		return session.createQuery("from Kravchenko_data").list();
	}
	
	public void addDataToVariant(List<Double> u, List<Double> i, Integer variant, Double u0,Double e ){
		if(u.size() == i.size() && u != null && i !=null){
			Session session = sessionFactory.openSession();
			Transaction tran = session.beginTransaction();
			Iterator<Double> iterU = u.iterator();
			Iterator<Double> iterI = i.iterator();
			while(iterU.hasNext()){
				Double uInt = iterU.next();
				Double iInt = iterI.next();
				Kravchenko_data data = new Kravchenko_data(null, uInt, iInt, variant, u0, e);
			}
			tran.commit();
			session.close();
		}
	}
}

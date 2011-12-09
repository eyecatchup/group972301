package com.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;

public class GenericDaoIml<E, PK extends Serializable> implements
		GenericDAO<E, PK> {

	/* ADD get all method and find by example */

	private Class<E> persistentClass;
	private Session session;

	@SuppressWarnings("unchecked")
	public GenericDaoIml() {
		this.persistentClass = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void setSession(Session s) {
		this.session = s;
	}

	public Session getSession() {
		if (session == null)    
			throw new IllegalStateException(
					"Session has not been set on DAO before usage");
		return session;
	}

	public Class<E> getPersistanceClass() {
		return persistentClass;
	}

	@Override
	public E makePersistent(E entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public void makeTransient(E entity) {
		getSession().delete(entity);
	}

	public void flush() {
		getSession().flush();
	}

	@Override
	public List<E> findAll() {
		return findByCriteria();
	}

	@Override
	public List<E> findByExample(E exampleInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findById(PK id) {
		E entity;
		entity = (E) getSession().get(persistentClass, id);
		return entity;
	}

	public void clear() {
		getSession().clear();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByCriteria(Criterion... crit) {
		Criteria criteria = getSession().createCriteria(persistentClass)
				//this is works like inner join!
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		for (Criterion i : crit) {
			criteria.add(i);
		}

		return criteria.list();

	}

}

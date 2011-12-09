package com.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E, PK extends Serializable> {
	E findById(PK id);
	 
    List<E> findAll();
 
    List<E> findByExample(E exampleInstance);
 
    E makePersistent(E entity);
 
    void makeTransient(E entity);
}

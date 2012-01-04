package com.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.hibernate.classic.Session;

import dao.GivenDAOImpl;
import entity.Given;
import ep.HibernateUtil;

public class StabilizAddVariantValid implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		String number = (String) arg2;
		
		Session session = HibernateUtil.openSession();
		GivenDAOImpl daoImpl = new GivenDAOImpl();
		daoImpl.setSession(session);
		Given given = daoImpl.getGivenByVariant(Integer.parseInt(number));
		session.close();
		
		if(given != null) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Данный вариант уже имеется");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
	}
	
}

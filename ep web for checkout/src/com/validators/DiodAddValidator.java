package com.validators;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.hibernate.classic.Session;

import dao.DiodDao;
import ep.HibernateUtil;
import ep.diodiAndStabilitroni.Diod;

public class DiodAddValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		String type = (String) arg2;

		DiodDao dao = new DiodDao();
		Session session = HibernateUtil.openSession();
		dao.setSession(session);
		List<Diod> list = dao.findAll();
		session.close();
		
		for(Diod i: list) {
			if (i.getName().equalsIgnoreCase(type)){
				FacesMessage message = new FacesMessage();
				message.setDetail("Данный диод уже имеется");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}

}

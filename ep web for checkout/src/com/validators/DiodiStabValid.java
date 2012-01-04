package com.validators;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.hibernate.classic.Session;

import dao.GroupDAOImpl;
import entity.StGroup;
import ep.HibernateUtil;

public class DiodiStabValid implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {

		String groupNumber = (String) arg2;

		if (checkIfExistGroup(groupNumber)) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Данная группа уже имеется");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

	}

	private boolean checkIfExistGroup(String groupNumber) {
		List<StGroup> groups;
		Session session = HibernateUtil.openSession();
		GroupDAOImpl daoImpl = new GroupDAOImpl();
		daoImpl.setSession(session);
		groups = daoImpl.findAll();
		session.close();

		for (StGroup i : groups) {
			if (i.getNumber().equalsIgnoreCase(groupNumber)) {
				return true;
			}
		}

		return false;
	}

}

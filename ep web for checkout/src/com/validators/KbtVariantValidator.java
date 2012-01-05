package com.validators;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.hibernate.classic.Session;

import com.service.KBTService;

import dao.KBTSourceDaoImpl;
import entity.KBTSource;
import ep.HibernateUtil;

public class KbtVariantValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		if (KBTService.update == true) {
			return;
		}

		Integer number = Integer.valueOf((String) arg2);

		Session session = HibernateUtil.openSession();
		KBTSourceDaoImpl daoImpl = new KBTSourceDaoImpl();
		daoImpl.setSession(session);
		List<KBTSource> list = daoImpl.findAll();
		session.close();

		for (KBTSource i : list)
			if (i.getVariant().intValue() == number.intValue()) {
				FacesMessage message = new FacesMessage();
				message.setDetail("Данный вариант уже имеется");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}

	}

}

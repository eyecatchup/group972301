package com.validators;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.hibernate.classic.Session;

import com.service.AddObService;

import dao.OB_GivenDAOImpl;
import entity.GivenOB;
import ep.HibernateUtil;

public class ObVariantValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		if (AddObService.update == true) {
			return;
		}

		Integer number = Integer.valueOf((String) arg2);

		Session session = HibernateUtil.openSession();
		OB_GivenDAOImpl daoImpl = new OB_GivenDAOImpl();
		daoImpl.setSession(session);
		List<GivenOB> list = daoImpl.findAll();
		session.close();

		for (GivenOB i : list)
			if (i.getVar().intValue() == number.intValue()) {
				FacesMessage message = new FacesMessage();
				message.setDetail("Данный вариант уже имеется");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}


	}

}

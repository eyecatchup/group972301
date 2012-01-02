package com.service;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import entity.StGroup;
import entity.Student;

public class changeListener implements ValueChangeListener{
	@Override
	public void processValueChange(ValueChangeEvent ce)
			throws AbortProcessingException {
		StudentService.studList = StudentService.getStudents();
		StGroup group = StudentService.getGroup((String) ce.getNewValue());
		StudentService.studGroupList.clear(); 

		for (Student i : StudentService.studList) {
			if (i.getGroup().getNumber().equalsIgnoreCase(group.getNumber())) {
				StudentService.studGroupList.add(i);
			}
		}

	}
}

package com.service;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class changeListener implements ValueChangeListener{
	@Override
	public void processValueChange(ValueChangeEvent ce)
			throws AbortProcessingException {

		StudentService.curGroup = (String) ce.getNewValue();
		StudentService.groupNumber = StudentService.curGroup;
		StudentService.load = true;
		/*StudentService.studList = StudentService.getStudents();
		StGroup group = StudentService.getGroup();
		StudentService.studGroupList.clear(); 

		for (Student i : StudentService.studList) {
			if (i.getGroup().getNumber().equalsIgnoreCase(group.getNumber())) {
				StudentService.studGroupList.add(i);
			}
		}*/

	}
}

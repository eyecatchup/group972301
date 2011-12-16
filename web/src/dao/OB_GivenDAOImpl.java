package dao;

import java.util.ArrayList;
import java.util.List;

import entity.OB_Given;

public class OB_GivenDAOImpl extends GenericDaoIml<OB_Given, Long> {
	
	public List<Integer> getVariants(){
		List<Integer> newList = new ArrayList<Integer>();
		List<OB_Given> given = findAll();
		
		for (OB_Given i : given){
			newList.add(i.getVar());
		}
		
		return newList;
	}
}

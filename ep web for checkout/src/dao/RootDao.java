package dao;

import java.util.List;

import entity.RootEntity;

public class RootDao extends GenericDaoIml<RootEntity, Long> {
	public RootEntity getRoot() {
		List<RootEntity> list = findAll();
		if(list.size() ==1 ) {
			return list.get(0);
		}
		
		return null;
			
	}
}

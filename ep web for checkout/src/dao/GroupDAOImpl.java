package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;

import entity.StGroup;

public class GroupDAOImpl extends GenericDaoIml<StGroup, Long> {

	@SuppressWarnings("unchecked")
	public StGroup getGroutByNumber(String number) {
		StGroup group = new StGroup();
		group.setNumber(number);

		Example example = Example.create(group).excludeProperty("idgroup")
				.ignoreCase().enableLike();

		List<StGroup> list = getSession().createCriteria(getPersistanceClass())
				.add(example)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		if(list.size() == 1){
			return list.get(0);
		}

		return null;

	}
}

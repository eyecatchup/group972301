package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;

import entity.Given;

public class GivenDAOImpl extends GenericDaoIml<Given, Long> {
	public List<Integer> getVariants() {
		List<Integer> newList = new ArrayList<Integer>();
		List<Given> given = findAll();

		for (Given i : given) {
			newList.add(i.getVar());
		}

		return newList;
	}

	@SuppressWarnings("unchecked")
	public Given getGivenByVariant(int Var) {
		Given given = new Given();
		given.setVar(Var);

		Example example = Example.create(given).enableLike()
				.excludeProperty("tok").excludeProperty("naprWihodnoe")
				.excludeProperty("deltanapr_vix").excludeProperty("shemaType")
				.excludeProperty("id_stab").excludeZeroes();

		List<Given> list = getSession().createCriteria(getPersistanceClass())
				.add(example).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		if(list.size() == 1){
			return list.get(0);
		}

		return null;

	}
}

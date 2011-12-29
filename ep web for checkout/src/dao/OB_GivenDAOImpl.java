package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;

import entity.GivenOB;

public class OB_GivenDAOImpl extends GenericDaoIml<GivenOB, Long> {

	public List<Integer> getVariants() {
		List<Integer> newList = new ArrayList<Integer>();
		List<GivenOB> given = findAll();

		for (GivenOB i : given) {
			newList.add(i.getVar());
		}

		return newList;
	}

	@SuppressWarnings("unchecked")
	public GivenOB getGivenByVariant(int Var) {
		GivenOB given = new GivenOB();
		given.setVar(Var);

		Example example = Example.create(given).enableLike()
				.excludeProperty("type").excludeProperty("Uka0")
				.excludeProperty("Ik").excludeProperty("Eg")
				.excludeProperty("Rg").excludeProperty("Rn")
				.excludeProperty("Cn").excludeProperty("id_ob_tran")
				.excludeZeroes();

		List<GivenOB> list = getSession().createCriteria(getPersistanceClass())
				.add(example)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		if (list.size() == 1) {
			return list.get(0);
		}

		return null;

	}

}

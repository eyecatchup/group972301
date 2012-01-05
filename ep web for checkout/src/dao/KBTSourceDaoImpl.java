package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;

import entity.KBTSource;

public class KBTSourceDaoImpl extends GenericDaoIml<KBTSource, Long> {
	public List<Integer> getVariants() {
		List<Integer> newList = new ArrayList<Integer>();
		List<KBTSource> given = findAll();

		for (KBTSource i : given) {
			newList.add(i.getVariant());
		}

		return newList;
	}

	@SuppressWarnings("unchecked")
	public KBTSource getSourceByVariant(int Var) {
		KBTSource given = new KBTSource();
		given.setVariant(Var);

		Example example = Example.create(given).enableLike()
				.excludeProperty("Uvih0").excludeProperty("Ttype")
				.excludeProperty("Ikb0").excludeProperty("Uip")
				.excludeProperty("Ucm").excludeProperty("Rn")
				.excludeProperty("S").excludeProperty("Uvihm")
				.excludeProperty("U0por").excludeProperty("U1por")
				.excludeProperty("Cn").excludeProperty("h21emin")
				.excludeProperty("h21emax").excludeProperty("Ubepor")
				.excludeProperty("Ck").excludeProperty("Th21E")
				.excludeProperty("id_stab").excludeZeroes();

		List<KBTSource> list = getSession().createCriteria(getPersistanceClass())
				.add(example).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		if(list.size() == 1){
			return list.get(0);
		}

		return null;

	}
}

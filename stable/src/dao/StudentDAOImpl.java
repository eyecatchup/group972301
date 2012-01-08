package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;

import entity.Student;

public class StudentDAOImpl extends GenericDaoIml<Student, Long> {

	@SuppressWarnings("unchecked")
	public Student getStudentByLogin(String name, String surname,
			String pswd, String groupID) {
		Student studentExample = new Student();
		studentExample.setName(name);
		studentExample.setSurname(surname);
		studentExample.setPassword(pswd);

		Example example = Example.create(studentExample)
				.excludeProperty("fathersname").excludeProperty("idnew_table").excludeProperty("id_group")
				.ignoreCase().enableLike();

		List<Student> logedIn = getSession().createCriteria(Student.class)
				.add(example)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		Student studentReturn;
		if (logedIn.size() == 1) {
			studentReturn = logedIn.get(0);
			if (studentReturn.getGroup().getNumber().equalsIgnoreCase(groupID)) {
				return studentReturn;
			}
		}

		return null;
	}
}

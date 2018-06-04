/**
 * 
 */
package org.jma.wireless.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jma.wireless.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Needa-Con
 *
 */
@Repository
@Transactional
public class PersonDAOImpl extends AbstractDao<Integer, Person> implements PersonDAO {

	@Override
	public void savePerson(Person person) {

		save(person);

	}

	@Override
	public List<Person> findAllPersons() {
		Criteria c = createEntityCriteria();
		return (List<Person>) c.list();
	}

	@Override
	public Person findById(int id) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("id", id));
		Person p1 = (Person) c.uniqueResult();
		System.out.println("Inside dao");
		System.out.println("person is "+p1);
		return p1;
	}
	
	@Override
	public void updatePerson(Person person) {
		update(person);
		
	}

	@Override
	public void deletePerson(int id) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("id", id));
		Person p1 = (Person) c.uniqueResult();
		if(p1!=null) {
		
			delete(p1);
		}

	}

}

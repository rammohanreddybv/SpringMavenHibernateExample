/**
 * 
 */
package org.jma.wireless.service;

import java.util.List;

import org.jma.wireless.dao.PersonDAO;
import org.jma.wireless.dto.PersonDTO;
import org.jma.wireless.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Needa-Con
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO dao;

	@Override
	public Person create(PersonDTO personDTO) {
		Person p = personDTO.toPerson();
		dao.savePerson(p);
		return p;
	}

	@Override
	public List<Person> getAllPersons() {
		return dao.findAllPersons();
	}

	@Override
	public Person getPerson(int id) {
		return dao.findById(id) == null ? null : dao.findById(id);
	}

	@Override
	public Person updatePerson(Person person) {
		int id = person.getId();
		Person p1 = dao.findById(id) == null ? null : dao.findById(id);
		if (p1 != null) {
			p1.setName(person.getName());
			p1.setEmail(person.getEmail());
			dao.updatePerson(p1);
			return p1;
		}
		return null;
	}

	@Override
	public void deletePerson(int id) {
		dao.deletePerson(id);
	}

}

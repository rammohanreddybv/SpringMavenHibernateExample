/**
 * 
 */
package org.jma.wireless.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.jma.wireless.dao.PersonDAO;
import org.jma.wireless.dto.PersonDTO;
import org.jma.wireless.model.Person;
import org.jma.wireless.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Needa-Con
 *
 */
@Service
@Transactional
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
	public List<PersonDTO> getAllPersons() {
		List<Person> persons=dao.findAllPersons();
		List<PersonDTO> personsDTO=new ArrayList<>();
		for(Person p:persons) {
			if(personsDTO.contains(PersonDTO.getPersonDTO(p))) {
				System.out.println("True");
			}else {
			personsDTO.add(PersonDTO.getPersonDTO(p));
			}
			System.out.println(PersonDTO.getPersonDTO(p).toString());
		}
		return personsDTO.stream().distinct().collect(Collectors.toList());
		
	}

	@Override
	public PersonDTO getPerson(int id) {
		Person p = dao.findById(id) == null ? null : dao.findById(id);
		if(p!=null) {
			return PersonDTO.getPersonDTO(p);
		}
		return null;
	}

	@Override
	public PersonDTO updatePerson(Person person) {
		int id = person.getPersonId();
		Person p1 = dao.findById(id) == null ? null : dao.findById(id);
		System.out.println(p1.toString());
		if (p1 != null) {
			p1.setName(person.getName());
			p1.setEmail(person.getEmail());
			System.out.println(p1.toString());
			dao.updatePerson(p1);
			return PersonDTO.getPersonDTO(p1);
		}
		return null;
	}

	@Override
	public void deletePerson(int id) {
		dao.deletePerson(id);
	}

}

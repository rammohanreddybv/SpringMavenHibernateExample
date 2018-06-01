package org.jma.wireless.dao;

import java.util.List;

import org.jma.wireless.model.Person;

public interface PersonDAO {

	void savePerson(Person person);

	List<Person> findAllPersons();

	Person findById(int id);
	
	void updatePerson(Person person);

	void deletePerson(int id);

}

/**
 * 
 */
package org.jma.wireless.service;

import java.util.List;

import org.jma.wireless.dto.JoinDTO;
import org.jma.wireless.dto.PersonDTO;
import org.jma.wireless.dto.TeamDTO;
import org.jma.wireless.model.Person;
import org.springframework.stereotype.Service;

/**
 * @author Needa-Con
 *
 */
@Service("personService")
public interface PersonService {

	Person create(PersonDTO personDTO);

	List<PersonDTO> getAllPersons();

	PersonDTO getPerson(int id);

	PersonDTO updatePerson(PersonDTO personDTO);

	void deletePerson(int id);

	List<TeamDTO> joinTeams(JoinDTO joinDTO);

}

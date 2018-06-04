/**
 * 
 */
package org.jma.wireless.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.jma.wireless.dao.PersonDAO;
import org.jma.wireless.dao.TeamDAO;
import org.jma.wireless.dto.JoinDTO;
import org.jma.wireless.dto.PersonDTO;
import org.jma.wireless.dto.TeamDTO;
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
	private PersonDAO personDAO;

	@Autowired
	private TeamDAO teamDAO;

	@Override
	public Person create(PersonDTO personDTO) {
		Person p = personDTO.toPerson();
		personDAO.savePerson(p);
		return p;
	}

	@Override
	public List<PersonDTO> getAllPersons() {
		List<Person> persons = personDAO.findAllPersons();
		List<PersonDTO> personsDTO = new ArrayList<>();
		for (Person p : persons) {
			if (personsDTO.contains(PersonDTO.getPersonDTO(p))) {
				System.out.println("True");
			} else {
				personsDTO.add(PersonDTO.getPersonDTO(p));
			}
			System.out.println(PersonDTO.getPersonDTO(p).toString());
		}
		return personsDTO.stream().distinct().collect(Collectors.toList());

	}

	@Override
	public PersonDTO getPerson(int id) {
		Person p = personDAO.findById(id) == null ? null : personDAO.findById(id);
		if (p != null) {
			return PersonDTO.getPersonDTO(p);
		}
		return null;
	}

	@Override
	public PersonDTO updatePerson(PersonDTO personDTO) {
		int id = personDTO.getId();
		Person p1 = personDAO.findById(id) == null ? null : personDAO.findById(id);
		System.out.println(p1.toString());
		if (p1 != null) {
			if (personDTO.getName() != null)
				p1.setName(personDTO.getName());
			if (personDTO.getEmail() != null)
				p1.setEmail(personDTO.getEmail());
			System.out.println(p1.toString());
			personDAO.updatePerson(p1);
			return PersonDTO.getPersonDTO(p1);
		}
		return null;
	}

	@Override
	public void deletePerson(int id) {
		personDAO.deletePerson(id);
	}

	@Override
	public List<TeamDTO> joinTeams(JoinDTO joinDTO) {
		Person p = personDAO.findById(joinDTO.getPersonId());
		if (p != null) {
			Team t;
			for (Integer teamId:joinDTO.getTeams()) {
				t = teamDAO.findById(teamId);
				if (t != null) {
					p.getTeamList().add(t);
				}
			}
			personDAO.updatePerson(p);
			return listOfTeams(p.getTeamList());
		}
		return null;
	}

	private List<TeamDTO> listOfTeams(Set<Team> teamList) {
		List<TeamDTO> teams = new ArrayList<TeamDTO>();
		for (Team t : teamList) {
			teams.add(TeamDTO.getTeamDTO(t));
		}
		return teams;
	}

}

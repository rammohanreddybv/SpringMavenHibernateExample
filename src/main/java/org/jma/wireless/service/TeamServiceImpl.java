/**
 * 
 */
package org.jma.wireless.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.jma.wireless.dao.PersonDAO;
import org.jma.wireless.dao.TaskDAO;
import org.jma.wireless.dao.TeamDAO;
import org.jma.wireless.dto.AssignDTO;
import org.jma.wireless.dto.PersonDTO;
import org.jma.wireless.dto.TaskDTO;
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
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDAO teamDAO;

	@Autowired
	private PersonDAO personDAO;

	@Autowired
	private TaskDAO taskDAO;

	@Override
	public Team create(TeamDTO teamDTO) {
		Team t = teamDTO.toTeam();
		teamDAO.saveTeam(t);
		return t;
	}

	@Override
	public List<TeamDTO> getAllTeams() {
		List<Team> teams = teamDAO.findAllTeams();
		List<TeamDTO> teamDTOs = new ArrayList<>();
		for (Team t : teams) {
			teamDTOs.add(TeamDTO.getTeamDTO(t));
		}
		return teamDTOs;
	}

	@Override
	public TeamDTO getTeam(int id) {
		Team t = teamDAO.findById(id) == null ? null : teamDAO.findById(id);
		return TeamDTO.getTeamDTO(t);
	}

	@Override
	@Transactional
	public TeamDTO updateTeam(TeamDTO teamDTO) {
		int id = teamDTO.getId();
		Team t1 = teamDAO.findById(id) == null ? null : teamDAO.findById(id);
		if (t1 != null) {
			if (teamDTO.getName() != null)
				t1.setName(teamDTO.getName());
			if (teamDTO.getPurpose() != null)
				t1.setPurpose(teamDTO.getPurpose());
			teamDAO.updateTeam(t1);
			return TeamDTO.getTeamDTO(t1);
		}
		return null;
	}

	@Override
	public void deleteTeam(int id) {
		teamDAO.deleteTeam(id);
	}

	@Override
	public List<TaskDTO> getTasksOfATeam(int id) {
		return teamDAO.getTasksOfATeam(id);

	}

	@Override
	public List<PersonDTO> assignPersons(AssignDTO assignDTO) {
		Team t = teamDAO.findById(assignDTO.getTeamId());
		if (t != null) {
			Person p;
			for (Integer personId : assignDTO.getPersons()) {
				p = personDAO.findById(personId);
				if (p != null) {
					t.getPersonList().add(p);

				}
			}
			teamDAO.updateTeam(t);

			return listOfPersons(t);
		}
		return null;
	}

	private List<PersonDTO> listOfPersons(Team t) {

		List<PersonDTO> persons = new ArrayList<PersonDTO>();
		Team t1 = teamDAO.findById(t.getId());

		for (Person p : t1.getPersonList()) {
			persons.add(PersonDTO.getPersonDTO(p));
		}
		return persons;
	}

}

/**
 * 
 */
package org.jma.wireless.service;

import java.util.List;

import org.jma.wireless.dto.AssignDTO;
import org.jma.wireless.dto.PersonDTO;
import org.jma.wireless.dto.TaskDTO;
import org.jma.wireless.dto.TeamDTO;
import org.jma.wireless.model.Person;
import org.jma.wireless.model.Task;
import org.jma.wireless.model.Team;
import org.springframework.stereotype.Service;

/**
 * @author Needa-Con
 *
 */
@Service("teamService")
public interface TeamService {

	Team create(TeamDTO teamDTO);

	List<TeamDTO> getAllTeams();

	TeamDTO getTeam(int id);

	

	void deleteTeam(int id);
	
	List<TaskDTO> getTasksOfATeam(int id);

	TeamDTO updateTeam(TeamDTO teamDTO);

	List<PersonDTO> assignPersons(AssignDTO assignDTO);
	
	
	

}

/**
 * 
 */
package org.jma.wireless.service;

import java.util.List;

import org.jma.wireless.dto.TeamDTO;
import org.jma.wireless.model.Team;
import org.springframework.stereotype.Service;

/**
 * @author Needa-Con
 *
 */
@Service("teamService")
public interface TeamService {

	Team create(TeamDTO teamDTO);

	List<Team> getAllTeams();

	Team getTeam(int id);

	Team updateTeam(Team team);

	void deleteTeam(int id);

}

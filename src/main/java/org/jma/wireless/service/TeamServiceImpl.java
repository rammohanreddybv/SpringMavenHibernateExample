/**
 * 
 */
package org.jma.wireless.service;

import java.util.List;

import org.jma.wireless.dao.TeamDAO;
import org.jma.wireless.dto.TeamDTO;
import org.jma.wireless.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Needa-Con
 *
 */
@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDAO dao;

	@Override
	public Team create(TeamDTO teamDTO) {
		Team p = teamDTO.toTeam();
		dao.saveTeam(p);
		return p;
	}

	@Override
	public List<Team> getAllTeams() {
		return dao.findAllTeams();
	}

	@Override
	public Team getTeam(int id) {
		return dao.findById(id) == null ? null : dao.findById(id);
	}

	@Override
	public Team updateTeam(Team team) {
		int id = team.getId();
		Team t1 = dao.findById(id) == null ? null : dao.findById(id);
		if (t1 != null) {
			t1.setName(team.getName());
			t1.setPurpose(team.getPurpose());
			dao.updateTeam(t1);
			return t1;
		}
		return null;
	}

	@Override
	public void deleteTeam(int id) {
		dao.deleteTeam(id);
	}

}

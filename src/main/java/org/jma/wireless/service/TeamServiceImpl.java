/**
 * 
 */
package org.jma.wireless.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.jma.wireless.dao.TaskDAO;
import org.jma.wireless.dao.TeamDAO;
import org.jma.wireless.dto.TaskDTO;
import org.jma.wireless.dto.TeamDTO;
import org.jma.wireless.model.Person;
import org.jma.wireless.model.Task;
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
	private TeamDAO dao;
	@Autowired
	private TaskDAO taskDAO;

	@Override
	public Team create(TeamDTO teamDTO) {
		Team t = teamDTO.toTeam();
		dao.saveTeam(t);
		return t;
	}

	@Override
	public List<TeamDTO> getAllTeams() {
		List<Team> teams=dao.findAllTeams();
		List<TeamDTO> teamDTOs=new ArrayList<>();
		for(Team t:teams) {
			teamDTOs.add(TeamDTO.getTeamDTO(t));
		}
		return teamDTOs;
	}

	@Override
	public TeamDTO getTeam(int id) {
		Team t=dao.findById(id) == null ? null : dao.findById(id);
		return TeamDTO.getTeamDTO(t);
	}

	@Override
	@Transactional
	public Team updateTeam(Team team) {
		int id = team.getTeamId();
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
	
	@Override
	public 	List<TaskDTO> getTasksOfATeam(int id){
		 return dao.getTasksOfATeam(id);
		 
	}
	
	

}

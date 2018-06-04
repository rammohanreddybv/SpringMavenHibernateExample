package org.jma.wireless.dao;

import java.util.List;

import org.jma.wireless.dto.TaskDTO;
import org.jma.wireless.model.Task;
import org.jma.wireless.model.Team;

public interface TeamDAO {

	void saveTeam(Team team);

	List<Team> findAllTeams();

	Team findById(int id);
	
	void updateTeam(Team team);

	void deleteTeam(int id);
	
	List<TaskDTO> getTasksOfATeam(int id);
	
	
	

}

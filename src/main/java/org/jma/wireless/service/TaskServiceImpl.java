/**
 * 
 */
package org.jma.wireless.service;

import java.util.HashSet;
import java.util.Set;

import org.jma.wireless.dao.TaskDAO;
import org.jma.wireless.dao.TeamDAO;
import org.jma.wireless.dto.TaskDTO;
import org.jma.wireless.model.Person;
import org.jma.wireless.model.Task;
import org.jma.wireless.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Needa-Con
 *
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDAO dao;
	@Autowired
	private TeamDAO teamDAO;

	@Override
	public Task create(TaskDTO taskDTO) {
		Task p = taskDTO.toTask();
		int teamId = taskDTO.getTeamId();
		Team t = teamDAO.findById(teamId) == null ? null : teamDAO.findById(teamId);
		if (t != null) {
			p.setTeam(t);
			// fetch the team from the taskDTO.teamId
			// populate task if the team exists
			System.out.println(p.toString());
			if (t != null) {
				p.setTeam(t);
				dao.saveTask(p);
			}

			return p;
		}
		return null;
	}



	@Override
	public TaskDTO getTask(int id) {
		Task t = dao.findById(id) == null ? null : dao.findById(id);
		System.out.println(t.getId() + " " + t.getName() + " " + t.getTeam().getId());
		return TaskDTO.getTaskDTO(t);
	}

	@Override
	public Task updateTask(TaskDTO taskDTO) {
		int id = taskDTO.getId();
		Task p1 = dao.findById(id) == null ? null : dao.findById(id);
		if (p1 != null) {
			if(taskDTO.getName()!=null)
			p1.setName(taskDTO.getName());
			if(taskDTO.getTeamId()!=p1.getId())
				p1.setName(taskDTO.getName());
			dao.updateTask(p1);
			return p1;
		}
		return null;
	}

	@Override
	public void deleteTask(int id) {
		dao.deleteTask(id);
	}

}

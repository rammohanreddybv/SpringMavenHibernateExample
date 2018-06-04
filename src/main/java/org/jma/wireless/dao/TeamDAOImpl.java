/**
 * 
 */
package org.jma.wireless.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jma.wireless.dto.TaskDTO;
import org.jma.wireless.model.Task;
import org.jma.wireless.model.Team;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Needa-Con
 *
 */
@Repository
@Transactional
public class TeamDAOImpl extends AbstractDao<Integer, Team> implements TeamDAO {

	@Override
	public void saveTeam(Team team) {

		save(team);

	}

	@Override
	public List<Team> findAllTeams() {
		Criteria c = createEntityCriteria();
		return (List<Team>) c.list();
	}

	@Override
	public Team findById(int id) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("id", id));
		Team p1 = (Team) c.uniqueResult();
		return p1;
	}
	
	@Override
	public void updateTeam(Team team) {
		update(team);
		
	}

	@Override
	public void deleteTeam(int id) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("id", id));
		Team p1 = (Team) c.uniqueResult();
		if(p1!=null) {
		
			delete(p1);
		}

	}

	@Override
	public List<TaskDTO> getTasksOfATeam(int id) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("id", id));
		Team p1 = (Team) c.uniqueResult();
		List<TaskDTO> taskDTOList=new ArrayList<>();
		if(p1!=null) {
		
		Set<Task> tasks=p1.getTasks();
		
		for(Task t:tasks) {
			
			System.out.println(TaskDTO.getTaskDTO(t));
			taskDTOList.add(TaskDTO.getTaskDTO(t));
		}
			return taskDTOList;
		}
		
		return taskDTOList;
		
	}
	
	
}

package org.jma.wireless.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jma.wireless.model.Person;
import org.jma.wireless.model.Task;
import org.jma.wireless.model.Team;

public class TeamDTO {

	private int id;
	private String name;
	private String purpose;
	
	private List<Integer> taskIds=new ArrayList<>();//populate only taskIds from the taskset
	
	private List<Integer> personIds=new ArrayList<>();
	
	public List<Integer> getPersonIds() {
		return personIds;
	}



	public void setPersonIds(List<Integer> personIds) {
		this.personIds = personIds;
	}



	public static TeamDTO getTeamDTO(Team team) {
		TeamDTO dto = new TeamDTO();
		dto.setId(team.getTeamId());
		dto.setName(team.getName());
		dto.setPurpose(team.getPurpose());
		Set<Task> tasks=team.getTasks();
		List<Integer> ids=new ArrayList<>();
		for(Task t:tasks) {
			int id=t.getId();
			ids.add(id);
			
		}
		dto.setTaskIds(ids);
		
		Set<Person> persons=team.getPersonList();
		List<Integer> pIds=new ArrayList<>();
		for(Person p:persons) {
			int id=p.getPersonId();
			pIds.add(id);
		}
		
		dto.setPersonIds(pIds);
		
		return dto;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public List<Integer> getTaskIds() {
		return taskIds;
	}



	public void setTaskIds(List<Integer> taskIds) {
		this.taskIds = taskIds;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Team toTeam() {
		Team p = new Team();
		p.setName(name);
		p.setPurpose(purpose);
		//populate task Id list or populate with taskdto
		
		return p;
	}

	@Override
	public String toString() {
		return "TeamDTO [id=" + id + ", name=" + name + ", purpose=" + purpose + ", taskIds=" + taskIds + "]";
	}

	
}

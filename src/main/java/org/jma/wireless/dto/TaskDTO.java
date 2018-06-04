package org.jma.wireless.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jma.wireless.model.Person;
import org.jma.wireless.model.Task;

public class TaskDTO {

	private int id;
	
	private String name;
	
	private int teamId;
	
	

	
	public static TaskDTO getTaskDTO(Task task) {
		TaskDTO dto = new TaskDTO();
		dto.setId(task.getId());
		dto.setName(task.getName());
		dto.setTeamId(task.getTeam().getTeamId());
		
	
		
		
		return dto;
	}

	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Task toTask() {
		Task p = new Task();
		p.setName(name);
		return p;
	}

	

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}




	@Override
	public String toString() {
		return "TaskDTO [id=" + id + ", name=" + name + ", teamId=" + teamId + "]";
	}


	
}

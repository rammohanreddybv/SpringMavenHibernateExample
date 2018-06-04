package org.jma.wireless.dto;

import java.util.List;

public class JoinDTO {

	private int personId;

	private List<Integer> teams;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public List<Integer> getTeams() {
		return teams;
	}

	public void setTeams(List<Integer> teams) {
		this.teams = teams;
	}

}

package org.jma.wireless.dto;

import org.jma.wireless.model.Person;
import org.jma.wireless.model.Team;

public class TeamDTO {

	private String name;
	private String purpose;

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
		return p;
	}

	@Override
	public String toString() {
		return "TeamDTO [name=" + name + ", purpose=" + purpose + "]";
	}

}

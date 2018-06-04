package org.jma.wireless.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personId;

	private String name;
	private String email;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "person_team", joinColumns = { @JoinColumn(name = "PERSON_ID") }, 
	inverseJoinColumns = {@JoinColumn(name = "TEAM_ID") })
	private Set<Team> teamList = new HashSet<Team>();

	public Person() {

	}

	public Person(int personId, String name, String email, Set<Team> teamList) {
		super();
		this.personId = personId;
		this.name = name;
		this.email = email;
		this.teamList = teamList;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public Set<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(Set<Team> teamList) {
		this.teamList = teamList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

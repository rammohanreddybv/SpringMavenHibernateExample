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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String purpose;
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private Set<Task> tasks = new HashSet<Task>();
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "person_team", joinColumns = { @JoinColumn(name = "TEAM_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PERSON_ID") })
	private Set<Person> personList = new HashSet<Person>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team(int teamId, String name, String purpose, Set<Task> tasks, Set<Person> personList) {
		super();
		this.id = teamId;
		this.name = name;
		this.purpose = purpose;
		this.tasks = tasks;
		this.personList = personList;
	}

	public Team() {

	}

	public Set<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(Set<Person> personList) {
		this.personList = personList;
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

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}

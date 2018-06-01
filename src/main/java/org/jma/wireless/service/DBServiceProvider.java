package org.jma.wireless.service;

import java.util.List;
import java.util.TreeMap;

import org.jma.wireless.model.Person;
import org.jma.wireless.model.Team;
import org.springframework.stereotype.Service;

@Service
public class DBServiceProvider {
	
	TreeMap<Integer, Person> person_map;
	TreeMap<Integer, Team> team_map;
	//TreeMap<Integer, Integer> person_team_mapper;
	int lastP, lastT;
	
	public String test() {
		System.out.println("Test method called...");
		System.out.println("persons = "+person_map);
		System.out.println("Teams = "+team_map);
		return "test has been called";
	}
	
	public String populate() {
		createPerson("Satya", "satyamail");
		createPerson("Ram", "rammail");
		createPerson("Rajiv", "rajivmail");
		
		createTeam("SatyaTeam", "Satyas team");
		createTeam("RamTeam", "Rams Team");
		createTeam("RajivTeam", "Rajiv's Team");
		
		return "Success";
	}
	
	public DBServiceProvider() {
		super();
		this.person_map = new TreeMap<Integer, Person>();
		this.team_map = new TreeMap<Integer, Team>();
		lastP = 0; lastT = 0;
	}	
	
	public Team createTeam(String name, String purpose) {
		int last_team = lastT;
		lastT++;
		Team team = new Team(last_team, name, purpose);
		team_map.put(last_team, team);
		return team;
	}
	
	public List<Team> getTeams(){
		return (List<Team>) team_map.values();
	}
	
	public Team getTeam(int id) {
		return team_map.containsKey(id)? team_map.get(id) : null;
	}
	
	public boolean updateTeam(Integer id, String name, String purpose) {
		boolean retval = false;
		if (team_map.containsKey(id)) {
			Team team = team_map.get(id);
			team.setName(name);
			team.setPurpose(purpose);
			retval = true;
		}
		return retval;
	}
	
	public boolean deleteTeam(int id) {
		boolean retval = false;
		if(team_map.containsKey(id)) {
			team_map.remove(id);
			retval = true;
		}		
		return retval;
	}

	public Person createPerson(String name, String email) {
		int last_person = lastP;
		lastP++;
		//need to add Person attribute manually after the new
		Person person = new Person();
		person_map.put(last_person, person);
		return person;
	}
	
	public List<Person> getPersons(){
		return (List<Person>) person_map.values();
	}
	
	public Person getPerson(int id) {
		return person_map.containsKey(id)? person_map.get(id) : null;
	}
	
	public boolean updatePerson(Integer id, String name, String email) {
		boolean retval = false;
		if (person_map.containsKey(id)) {
			Person person = person_map.get(id);
			person.setName(name);
			person.setEmail(email);
			retval = true;
		}
		return retval;
	}
	
	public boolean deletePerson(int id) {
		boolean retval = false;
		if(person_map.containsKey(id)) {
			person_map.remove(id);
			retval = true;
		}
		
		return retval;
	}
	
	
	
}

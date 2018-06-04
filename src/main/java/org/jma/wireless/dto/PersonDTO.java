/**
 * 
 */
package org.jma.wireless.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jma.wireless.model.Person;
import org.jma.wireless.model.Task;
import org.jma.wireless.model.Team;

/**
 * @author Needa-Con
 *
 */
public class PersonDTO {

	private int id;
	private String name;
	private String email;
	
	private List<Integer> teamIds=new ArrayList<>();
	
	public List<Integer> getTeamIds() {
		return teamIds;
	}

	public void setTeamIds(List<Integer> teamIds) {
		this.teamIds = teamIds;
	}

	public static PersonDTO getPersonDTO(Person person) {
		PersonDTO dto = new PersonDTO();
		dto.setId(person.getId());
		dto.setEmail(person.getEmail());
		dto.setName(person.getName());
		Set<Team> teams=person.getTeamList();
		List<Integer> ids=new ArrayList<>();
		for(Team t:teams) {
			int id=t.getId();
			ids.add(id);
		}
		dto.setTeamIds(ids);
		return dto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Person toPerson() {
		Person p = new Person();
		p.setName(name);
		p.setEmail(email);
	
		return p;
	}

	@Override
	public String toString() {
		return "PersonDTO [id=" + id + ", name=" + name + ", email=" + email + ", teamIds=" + teamIds + "]";
	}

	

	
}

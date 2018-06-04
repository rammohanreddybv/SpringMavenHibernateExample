package org.jma.wireless.controller;

import java.util.List;

import org.jma.wireless.dto.AssignDTO;
import org.jma.wireless.dto.JoinDTO;
import org.jma.wireless.dto.PersonDTO;
import org.jma.wireless.dto.TeamDTO;
import org.jma.wireless.service.PersonService;
import org.jma.wireless.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	@Autowired
	PersonService personService;
	@Autowired
	TeamService teamService;

	@PostMapping("/join")
	public List<TeamDTO> join(@RequestBody JoinDTO joinDTO) {
		// one person id, multiple teamIds
		return personService.joinTeams(joinDTO);
	}

	@PostMapping("/assign")
	public List<PersonDTO> assign(@RequestBody AssignDTO assignDTO) {
		// one team id, multiple persons
		return teamService.assignPersons(assignDTO);
	}
}

/**
 * 
 */
package org.jma.wireless.controller;

import java.util.List;

import org.jma.wireless.dto.TaskDTO;
import org.jma.wireless.dto.TeamDTO;
import org.jma.wireless.model.Task;
import org.jma.wireless.model.Team;
import org.jma.wireless.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Needa-Con
 *
 */
@RestController
// @RequestMapping("/team")
public class TeamController {

	@Autowired
	TeamService teamService;

	@PostMapping(value = "/team", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TeamDTO create(@RequestBody TeamDTO teamDTO) {

		Team p = teamService.create(teamDTO);

		return TeamDTO.getTeamDTO(p);
	}

	@GetMapping("/team")
	public @ResponseBody List<TeamDTO> getAllTeams() {
		return teamService.getAllTeams();
	}
	
	@GetMapping("/team/{id}")
	public @ResponseBody TeamDTO getTeam(@PathVariable("id") int id) {
		return teamService.getTeam(id);
	}
	
	@PutMapping(value = "/team", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TeamDTO updateTeam(@RequestBody Team team) {
		
		Team p=teamService.updateTeam(team);
		
		return TeamDTO.getTeamDTO(p);
		
	}
	
	@DeleteMapping("/team/{id}")
	public void deleteTeam(@PathVariable("id") int id) {
		teamService.deleteTeam(id);
	}
	
	@GetMapping("/team/{id}/tasks")
	public List<TaskDTO> getTasksOfATeam(@PathVariable("id") int id){
		return teamService.getTasksOfATeam(id);
	}
	
	
}

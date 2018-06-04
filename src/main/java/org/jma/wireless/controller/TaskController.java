/**
 * 
 */
package org.jma.wireless.controller;

import java.util.List;

import org.jma.wireless.dto.TaskDTO;
import org.jma.wireless.model.Task;
import org.jma.wireless.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Needa-Con
 *
 */
@RestController
// @RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskService taskService;

	@PostMapping(value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TaskDTO create(@RequestBody TaskDTO taskDTO) {

		Task p = taskService.create(taskDTO);

		return TaskDTO.getTaskDTO(p);
	}

//	@GetMapping("/task")
//	public @ResponseBody List<TaskDTO> getAllTasks() {
//		return taskService.getAllTasks();
//	}
	
	@GetMapping("/task/{id}")
	public @ResponseBody TaskDTO getTask(@PathVariable("id") int id) {
		
		return taskService.getTask(id);
	}
	
	@PutMapping(value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TaskDTO updateTask(@RequestBody Task task) {//ReuestBody need to change to TaskDTO 
		
		Task p=taskService.updateTask(task);
		
		return TaskDTO.getTaskDTO(p);
		
	}
	
	@DeleteMapping("/task/{id}")
	public void deleteTask(@PathVariable("id") int id) {
		taskService.deleteTask(id);
	}
}

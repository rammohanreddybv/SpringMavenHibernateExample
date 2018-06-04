/**
 * 
 */
package org.jma.wireless.service;

import java.util.List;

import org.jma.wireless.dto.TaskDTO;
import org.jma.wireless.model.Task;
import org.springframework.stereotype.Service;

/**
 * @author Needa-Con
 *
 */
@Service("taskService")
public interface TaskService {

	Task create(TaskDTO taskDTO);

	//List<TaskDTO> getAllTasks();

	TaskDTO getTask(int id);

	Task updateTask(Task task);

	void deleteTask(int id);

}

package org.jma.wireless.dao;

import java.util.List;

import org.jma.wireless.model.Task;

public interface TaskDAO {

	void saveTask(Task p);

	List<Task> findAllTasks();

	Task findById(int id);
	
	void updateTask(Task task);

	void deleteTask(int id);
	
	
	
	

}

/**
 * 
 */
package org.jma.wireless.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jma.wireless.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Needa-Con
 *
 */
@Repository
@Transactional
public class TaskDAOIml extends AbstractDao<Integer, Task> implements TaskDAO {

	@Override
	public void saveTask(Task task) {

		save(task);

	}

	@Override
	public List<Task> findAllTasks() {
		Criteria c = createEntityCriteria();
		return (List<Task>) c.list();
	}

	@Override
	public Task findById(int id) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("id", id));
		Task p1 = (Task) c.uniqueResult();
		return p1;
	}

	@Override
	public void updateTask(Task task) {
		update(task);

	}

	@Override
	public void deleteTask(int id) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("id", id));
		Task p1 = (Task) c.uniqueResult();
		if (p1 != null) {

			delete(p1);
		}

	}

}

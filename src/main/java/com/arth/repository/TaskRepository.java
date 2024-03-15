package com.arth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arth.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

	List<TaskEntity> findByModuleId(Integer moduleId);
	
	@Query(value=" select t.* from task t join taskuser tu on t.task_id = tu.task_id where t.project_id = :projectId and tu.userid = :userId",nativeQuery = true)
	List<TaskEntity> findByProjectIdAndUserId(Integer projectId,Integer userId);
	
	@Query(value="select distinct t.* from task t join module m on t.module_id = m.module_id join taskuser tu on t.task_id = tu.task_id where t.module_id = :moduleId  and tu.userid = :userId and tu.assign_status = 1",nativeQuery = true)
	List<TaskEntity> findByModuleIdAndUserId(Integer moduleId , Integer userId);
}

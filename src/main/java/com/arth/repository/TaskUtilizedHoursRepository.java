package com.arth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arth.entity.TaskUtilizedHoursEntity;

@Repository
public interface TaskUtilizedHoursRepository extends JpaRepository<TaskUtilizedHoursEntity,Integer> {

	
	@Query(value="select sum(utilized_hours)  from taskutilizedhours where task_id = :taskId ",nativeQuery=true)
	Float totalTaskTimeByTaskId(Integer taskId);
	
	@Query(value="select sum(utilized_hours)  from taskutilizedhours where module_id = :moduleId ",nativeQuery=true)
	Float totalTaskTimeByModuleId(Integer moduleId);
	
	@Query(value="select sum(utilized_hours)  from taskutilizedhours where project_id = :projectId ",nativeQuery=true)
	Float totalTaskTimeByProjectId(Integer projectId);
	
}

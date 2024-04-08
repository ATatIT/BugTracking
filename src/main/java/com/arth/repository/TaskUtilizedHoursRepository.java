package com.arth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arth.dto.taskutilizedHoursDto;
import com.arth.entity.TaskUtilizedHoursEntity;

@Repository
public interface TaskUtilizedHoursRepository extends JpaRepository<TaskUtilizedHoursEntity,Integer> {

	
	@Query(value="select sum(utilized_hours)  from taskutilizedhours where task_id = :taskId ",nativeQuery=true)
	Float totalTaskTimeByTaskId(Integer taskId);
	
	@Query(value="select sum(utilized_hours)  from taskutilizedhours where module_id = :moduleId ",nativeQuery=true)
	Float totalTaskTimeByModuleId(Integer moduleId);
	
	@Query(value="select sum(utilized_hours)  from taskutilizedhours where project_id = :projectId ",nativeQuery=true)
	Float totalTaskTimeByProjectId(Integer projectId);
	
	@Query(value="select sum(t.utilized_hours) as utilizedHours , t.user_id as userId,p.projecttitle as projectTitle from taskutilizedhours t,project p  where t.project_id = p.project_id and t.user_id = :userId and t.project_id in(:projectId)  group by t.project_id",nativeQuery=true)
	List<taskutilizedHoursDto> totalTaskTimeByProjectIdAccordingToUser(Integer userId , List<Integer> projectId);
}

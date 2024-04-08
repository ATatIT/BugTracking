package com.arth.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arth.dto.BugReportDto;
import com.arth.entity.BugReportEntity;

@Repository
public interface BugReportRepository extends JpaRepository<BugReportEntity, Integer> {

	List<BugReportEntity> findByTaskIdAndStatusIn(Integer taskId, List<Integer> status);

	@Query(value = "SELECT b.status , b.bug_id as bugId,b.task_id as taskId ,b.bug_name as bugName,b.date, t.title AS title, m.module_name AS moduleName, p.projecttitle AS projectTitle FROM bugreport b , task t,module m ,project p, users u where b.task_id = t.task_id and b.module_id = m.module_id and b.project_id = p.project_id and b.user_id = u.user_id and b.user_id = :userId and b.status = :status", nativeQuery = true)
	List<BugReportDto> findAllBugsWithDetails(Integer userId, Integer status);

	@Query(value = " SELECT b.description,b.comment,b.status , b.bug_id as bugId,b.task_id as taskId ,b.bug_name as bugName,b.date,b.approve_date as approveDate, t.title AS title, m.module_name AS moduleName, p.projecttitle AS projectTitle , u.first_name as firstName FROM bugreport b , task t,module m ,project p, users u where b.task_id = t.task_id and b.module_id = m.module_id and b.project_id = p.project_id and b.user_id = u.user_id  and t.task_id = :taskId and b.status IN :status", nativeQuery = true)
	List<BugReportDto> findAllBugsWithDetailsByTaskIdAndStatus(@Param("taskId") Integer taskId,
			@Param("status") List<Integer> status);

	@Query(value = " select b.bug_id as bugId, tu.task_id as taskId ,u.first_name as firstName from bugreport b,taskuser tu,users u where b.task_id = tu.task_id and u.user_id = tu.userID and tu.task_id = :taskId", nativeQuery = true)
	List<BugReportDto> findAllBugswithDeveloper(Integer taskId);

	BugReportEntity findByBugIdAndTaskId(Integer bugId, Integer taskId);

	BugReportEntity findByProjectIdAndModuleIdAndTaskIdAndStatus(Integer projectId, Integer moduleId, Integer taskId,
			Integer status);

	// for chart
	@Query(value = " select p.projecttitle , p.total_utilized_hours as utilizedHours , COUNT(CASE WHEN b.status = 5 THEN b.bug_id END) AS approveBugs,COUNT(CASE WHEN b.status = 6 THEN b.bug_id END) AS Bugs from project p , bugreport b where p.project_id = b.project_id and p.project_id in (:projectId) and b.status in(5,6) group by p.project_id order by p.project_id", nativeQuery = true)
	List<BugReportDto> getBugsAccordingProjects(List<Integer> projectId);
}

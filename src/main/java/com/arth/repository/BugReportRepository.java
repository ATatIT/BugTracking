package com.arth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arth.dto.BugReportDto;
import com.arth.entity.BugReportEntity;

@Repository
public interface BugReportRepository extends JpaRepository<BugReportEntity, Integer> {
	
	List<BugReportEntity> findByTaskIdAndStatusIn(Integer taskId,List<Integer> status);
	
	@Query(value = "SELECT b.*, t.title, m.moduleName, p.projecttitle " +
	        "FROM BugReport b " +
	        "JOIN Task t ON b.task_id = t.task_id " +
	        "JOIN Module m ON b.module_id = m.module_id " +
	        "JOIN Project p ON b.project_id = p.project_id", nativeQuery = true)
	List<BugReportDto> findAllBugsWithDetails();

}

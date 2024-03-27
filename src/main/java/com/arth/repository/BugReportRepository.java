package com.arth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arth.entity.BugReportEntity;

@Repository
public interface BugReportRepository extends JpaRepository<BugReportEntity, Integer> {
	
	@Query(value = " select b.*,t.title , m.module_name , p.projecttitle from bugreport b , task t , module m, project p  where b.task_id = t.task_id and b.module_id = m.module_id and b.project_id = p.project_id",nativeQuery = true)
	List<BugReportEntity> findAllBugs();
}

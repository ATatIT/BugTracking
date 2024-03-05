package com.arth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arth.entity.ProjectEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer >{

	@Query(value="select count(*) from project  where project_status_id = :projectStatusId",nativeQuery = true)
	Integer getProjectAccordingToSatatus(Integer projectStatusId);
	
	@Query(value="select count(*) from project where month(project_completion_date) < :month",nativeQuery = true)
	Integer getDueProjects(Integer month);
	
	
}

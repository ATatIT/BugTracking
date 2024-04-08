package com.arth.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arth.dto.BugReportDto;
import com.arth.entity.ProjectEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer >{

	// for admin
	List<ProjectEntity> findByProjectStatusId(Integer projectStatusId);
	
	@Query(value="select * from project where month(project_completion_date) < :month",nativeQuery = true)
	List<ProjectEntity> getDueProjects(Integer month);
	
	// for developer
	@Query(value="select count(*) from  project p, projectuser pu where pu.project_id = p.project_id and pu.user_id = :userId",nativeQuery = true)
	Integer findProjectsByUserId(Integer userId);
	
	@Query(value="select p.* from  project p, projectuser pu where pu.project_id = p.project_id and pu.user_id = :userId",nativeQuery = true)
	List<ProjectEntity> getProjectsOfUserId(Integer userId);
	
	@Query(value="SELECT count(*) FROM project p JOIN projectuser pu ON pu.project_id = p.project_id WHERE MONTH(p.project_completion_date) < :month AND pu.user_id = :userId",nativeQuery = true)
	Integer getDueProjectsByUserId(Integer month, Integer userId);
	
	@Query(value="SELECT count(*) FROM project p JOIN projectuser pu ON pu.project_id = p.project_id WHere p.project_status_id = :statusId and pu.user_id = :userId",nativeQuery = true)
	Integer getProjectsByUserIdAccordingToStatus(Integer userId, Integer statusId);
	
}

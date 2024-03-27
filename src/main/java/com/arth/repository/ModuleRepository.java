package com.arth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arth.entity.ModuleEntity;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, Integer> {

	List<ModuleEntity> findByProjectId(Integer projectId);
	
	List<ModuleEntity> findByProjectIdAndStatus(Integer projectId , Integer status);
	
	@Query(value="select DISTINCT m.* from module m join task t on m.module_id = t.module_id join taskuser tu on t.task_id = tu.task_id where t.project_id = :projectId and  tu.userid = :userId and tu.assign_status = 1",nativeQuery = true)
	List<ModuleEntity> findByProjectIdAndUserId(Integer projectId,Integer userId);
	
}

package com.arth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arth.entity.ProjectUserEntity;

public interface ProjectUserRepository extends JpaRepository<ProjectUserEntity, Integer> {
	ProjectUserEntity findByProjectIdAndUserId(Integer projectId, Integer userId);
}

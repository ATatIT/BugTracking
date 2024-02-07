package com.arth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arth.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer >{

}

package com.arth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arth.entity.ProjectStatusEntity;

@Repository
public interface ProjectStatusRepository extends JpaRepository<ProjectStatusEntity, Integer>{

}

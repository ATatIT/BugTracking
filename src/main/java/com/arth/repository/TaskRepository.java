package com.arth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arth.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

}

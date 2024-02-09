package com.arth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arth.entity.TaskUserEntity;

public interface TaskUserRepositoy extends JpaRepository<TaskUserEntity, Integer> {

}

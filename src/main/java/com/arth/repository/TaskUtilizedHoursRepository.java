package com.arth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arth.entity.TaskUtilizedHoursEntity;

@Repository
public interface TaskUtilizedHoursRepository extends JpaRepository<TaskUtilizedHoursEntity,Integer> {

}

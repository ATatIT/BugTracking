package com.arth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arth.entity.ModuleEntity;

public interface ModuleRepository extends JpaRepository<ModuleEntity, Integer> {

}

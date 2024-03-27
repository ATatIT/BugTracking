package com.arth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arth.entity.ModuleEntity;
import com.arth.entity.ProjectEntity;
import com.arth.entity.TaskEntity;
import com.arth.repository.ModuleRepository;
import com.arth.repository.ProjectRepository;
import com.arth.repository.TaskRepository;
import com.arth.repository.TaskUtilizedHoursRepository;

@Service
public class EffortsService {

	@Autowired
	TaskRepository taskRepo;

	@Autowired
	TaskUtilizedHoursRepository taskUtilizedHoursRepository;

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	ProjectRepository projectRepository;

	public void calculateTaskHours(Integer taskId) {

		TaskEntity task = taskRepo.findById(taskId).get();
		ModuleEntity module = moduleRepository.findById(task.getModuleId()).get();
		ProjectEntity project = projectRepository.findById(task.getProjectId()).get();
		
		

		Float taskSum = taskUtilizedHoursRepository.totalTaskTimeByTaskId(taskId);
		Float moduleSum = taskUtilizedHoursRepository.totalTaskTimeByModuleId(task.getModuleId());
		Float projectSum = taskUtilizedHoursRepository.totalTaskTimeByProjectId(task.getProjectId());

		task.setTotalUtilizedHours(taskSum);
		module.setTotalUtilizedHours(moduleSum.intValue());
		project.setTotalUtilizedHours(projectSum.intValue());

		taskRepo.save(task);
		moduleRepository.save(module);
		projectRepository.save(project);
		
		//for status updation
		List<TaskEntity> allTask =  taskRepo.findByModuleId(module.getModuleId());
		Long notCompletedStatus = allTask.stream().filter(t->t.getStatus()!=4 && t.getStatus()!=5).count();
		
		if(notCompletedStatus == 0) {
			module.setStatus(4);
			moduleRepository.save(module); 
		}else {
			module.setStatus(task.getStatus());
			moduleRepository.save(module);
		}
		
		
	
	}
}

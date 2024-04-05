package com.arth.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.dto.BugReportDto;
import com.arth.entity.BugReportEntity;
import com.arth.entity.ModuleEntity;
import com.arth.entity.ProjectEntity;
import com.arth.entity.ProjectStatusEntity;
import com.arth.entity.TaskEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.BugReportRepository;
import com.arth.repository.ModuleRepository;
import com.arth.repository.ProjectRepository;
import com.arth.repository.ProjectStatusRepository;
import com.arth.repository.TaskRepository;
import com.arth.repository.UserRepository;
import com.arth.service.EffortsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TesterDashboardController {

	@Autowired
	ProjectRepository projectRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	TaskRepository taskRepo;

	@Autowired
	ModuleRepository moduleRepo;

	@Autowired
	ProjectStatusRepository projectStatusRepo;

	@Autowired
	BugReportRepository bugReportRepo;
	
	@Autowired
	EffortsService efforts;
	


	@GetMapping("/testerdashboard")
	public String testerDashboard(HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer totalproject = projectRepo.findProjectsByUserId(user.getUserId());
		model.addAttribute("totalproject", totalproject);

		Integer m = LocalDate.now().getMonthValue();
		Integer dueProject = projectRepo.getDueProjectsByUserId(m, user.getUserId());
		model.addAttribute("dueProject", dueProject);

		Integer OngoingProject = projectRepo.getProjectsByUserIdAccordingToStatus(user.getUserId(), 3);
		model.addAttribute("OngoingProject", OngoingProject);

		Integer pipelineProject = projectRepo.getProjectsByUserIdAccordingToStatus(user.getUserId(), 2);
		model.addAttribute("pipelineProject", pipelineProject);
		return "TesterDashboard";
	}

	// for reporting bug
	@GetMapping("bugreport")
	public String bugReport(@RequestParam("taskId") Integer taskId, @RequestParam("moduleId") Integer moduleID,
			@RequestParam("projectId") Integer projectId, HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		model.addAttribute("user", user);

		LocalDate d = LocalDate.now();
		model.addAttribute("date", d);

		ProjectEntity project = projectRepo.findById(projectId).get();
		model.addAttribute("project", project);

		ModuleEntity module = moduleRepo.findById(moduleID).get();
		model.addAttribute("module", module);

		TaskEntity task = taskRepo.findById(taskId).get();
		model.addAttribute("task", task);

		List<ProjectStatusEntity> status = projectStatusRepo.findAll().subList(4, 6);
		model.addAttribute("status", status);
		
		BugReportEntity bug = bugReportRepo.findByProjectIdAndModuleIdAndTaskIdAndStatus(projectId, moduleID, taskId,6);	
		if (bug != null  ) {
			model.addAttribute("bug", bug);
			return "UpdateBugReport";
		}else {
			
			return "BugReport";
		}
	}

	@PostMapping("/savebugreport")
	public String saveBugReport(BugReportEntity bugreport) {
		bugReportRepo.save(bugreport);
		
		// for task status update
		TaskEntity task = taskRepo.findById(bugreport.getTaskId()).get();
		task.setStatus(bugreport.getStatus());
		taskRepo.save(task);
		efforts.calculateTaskHours(task.getTaskId());
		return "redirect:/listmoduleoftester?projectId="+bugreport.getProjectId();
	}
	
	@GetMapping("/buglist")
	public String bugList(@RequestParam("projectId") Integer projectId,HttpSession session,Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<Integer> status = Arrays.asList(5,6); 
		List<TaskEntity> tasks = taskRepo.findAllTasksByProjectId(projectId);
		List<BugReportDto> bugs = new ArrayList<>();
		for (TaskEntity task : tasks) {
	        bugs.addAll(bugReportRepo.findAllBugsWithDetailsByTaskIdAndStatus(task.getTaskId(), status));
	    }
		model.addAttribute("bugs", bugs);
		return "BugList"; 
	}
	
	@GetMapping("/viewbug")//genral
	public String viewBug(@RequestParam("taskId") Integer taskId,Model model) {
		
		List<Integer> status = Arrays.asList(6);
		
		List<BugReportDto> bugs = bugReportRepo.findAllBugsWithDetailsByTaskIdAndStatus(taskId,status);
		List<BugReportDto> dev = bugReportRepo.findAllBugswithDeveloper(taskId);
		
		model.addAttribute("bugs", bugs);
		model.addAttribute("task", taskRepo.findById(taskId).get());
		
		Map<Integer, String> bugIdToSortedNames = new HashMap<>();

		for (BugReportDto bug : dev) {
		    int bugId = bug.getBugId();
		    String firstName = bug.getFirstName();
		    bugIdToSortedNames.merge(bugId, firstName, (oldValue, newValue) -> oldValue + ", " + newValue);
		}
		model.addAttribute("dev", bugIdToSortedNames);
		return "ViewBug";
	}
	
	@GetMapping("/viewtesterbug")//fortester
	public String viewTesterBug(@RequestParam("bugId")Integer bugId,@RequestParam("taskId")Integer taskId,Model model) {
		BugReportEntity bug = bugReportRepo.findByBugIdAndTaskId(bugId, taskId);
		model.addAttribute("bug", bug);
		return "ViewTesterBug";
	}
	
	//for admin
	@GetMapping("/viewallbugs")
	public String viewAllBugs(@RequestParam("projectId")Integer projectId,Model model) {
		//defected
		List<Integer> status = Arrays.asList(5,6); 
	    List<TaskEntity> tasks = taskRepo.findAllTasksByProjectId(projectId);
	    List<BugReportDto> bugs = new ArrayList<>();
	    Map<Integer, String> bugIdToSortedNames = new HashMap<>();

	    for (TaskEntity task : tasks) {
	        bugs.addAll(bugReportRepo.findAllBugsWithDetailsByTaskIdAndStatus(task.getTaskId(), status));
	        List<BugReportDto> dev = bugReportRepo.findAllBugswithDeveloper(task.getTaskId());
	        for (BugReportDto bug : dev) {
	            int bugId = bug.getBugId();
	            String firstName = bug.getFirstName();
	            bugIdToSortedNames.merge(bugId, firstName, (oldValue, newValue) -> oldValue + ", " + newValue);
	        }
	    }

	    model.addAttribute("bugs", bugs);
	    model.addAttribute("task", tasks); 
	    model.addAttribute("dev", bugIdToSortedNames);
		return "ViewAllBugs";
	}
}

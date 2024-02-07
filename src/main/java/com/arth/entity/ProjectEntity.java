package com.arth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class ProjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	private String projecttitle;
	private String description;
	private Integer projectStatusId;
	private String docURL;
	private Integer estimatedHours;
	private Integer totalUtilizedHours;
	private String projectStartDate;
	private String projectCompletionDate;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjecttitle() {
		return projecttitle;
	}
	public void setProjecttitle(String projecttitle) {
		this.projecttitle = projecttitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getProjectStatusId() {
		return projectStatusId;
	}
	public void setProjectStatusId(Integer projectStatusId) {
		this.projectStatusId = projectStatusId;
	}
	public String getDocURL() {
		return docURL;
	}
	public void setDocURL(String docURL) {
		this.docURL = docURL;
	}
	public Integer getEstimatedHours() {
		return estimatedHours;
	}
	public void setEstimatedHours(Integer estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
	public Integer getTotalUtilizedHours() {
		return totalUtilizedHours;
	}
	public void setTotalUtilizedHours(Integer totalUtilizedHours) {
		this.totalUtilizedHours = totalUtilizedHours;
	}
	public String getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public String getProjectCompletionDate() {
		return projectCompletionDate;
	}
	public void setProjectCompletionDate(String projectCompletionDate) {
		this.projectCompletionDate = projectCompletionDate;
	}
	
	
	

}

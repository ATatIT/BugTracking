package com.arth.dto;

public interface BugReportDto {
	Integer getBugId();
	String getTaskId();
	String getStatus();
	String getBugName();
	String getDate();
	String getApproveDate();
	String getTitle();
	String getModuleName();
	String getProjectTitle();
	String getDescription();
	String getComment();
	String getFirstName();
	
	//for chart
	float getUtilizedHours();
	Integer getApproveBugs();
	Integer getBugs();
}

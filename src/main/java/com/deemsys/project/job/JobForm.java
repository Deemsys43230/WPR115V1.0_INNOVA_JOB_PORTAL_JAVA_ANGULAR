package com.deemsys.project.job;

import java.util.List;

import com.deemsys.project.jobtag.JobTagForm;
import com.deemsys.project.jobtagmap.JobTagMapForm;


/**
 * 
 * @author Deemsys
 *
 */
public class JobForm {

	private Long jobId;
	private Integer jobCategoryId;
	private String name;
	private String description;
	private String addedDate;
	private List<Long> jobTagId;
	private List<JobTagMapForm> jobTagMapForms;
	private Integer isEnable;
	private Integer status;
	
	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Integer getJobCategoryId() {
		return jobCategoryId;
	}

	public void setJobCategoryId(Integer jobCategoryId) {
		this.jobCategoryId = jobCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	public List<Long> getJobTagId() {
		return jobTagId;
	}

	public void setJobTagId(List<Long> jobTagId) {
		this.jobTagId = jobTagId;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<JobTagMapForm> getJobTagMapForms() {
		return jobTagMapForms;
	}

	public void setJobTagForms(List<JobTagMapForm> jobTagMapForms) {
		this.jobTagMapForms = jobTagMapForms;
	}

	public JobForm(Long jobId, Integer jobCategoryId, String name,
			String description, String addedDate, Integer isEnable,
			Integer status) {
		super();
		this.jobId = jobId;
		this.jobCategoryId = jobCategoryId;
		this.name = name;
		this.description = description;
		this.addedDate = addedDate;
		this.isEnable = isEnable;
		this.status = status;
	}

	public JobForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

package com.deemsys.project.job;

public class JobSearchForm {
	private String jobKeyword;
	private Integer jobCategoryId;
	public JobSearchForm(String jobKeyword, Integer jobCategoryId) {
		super();
		this.jobKeyword = jobKeyword;
		this.jobCategoryId = jobCategoryId;
	}
	public JobSearchForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getJobKeyword() {
		return jobKeyword;
	}
	public void setJobKeyword(String jobKeyword) {
		this.jobKeyword = jobKeyword;
	}
	public Integer getJobCategoryId() {
		return jobCategoryId;
	}
	public void setJobCategoryId(Integer jobCategoryId) {
		this.jobCategoryId = jobCategoryId;
	}
	
}

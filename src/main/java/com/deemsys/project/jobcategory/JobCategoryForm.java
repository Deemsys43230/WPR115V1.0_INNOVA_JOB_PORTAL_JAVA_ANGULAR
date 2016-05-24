package com.deemsys.project.jobcategory;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Deemsys
 *
 */
public class JobCategoryForm {

	private Integer jobCategoryId;
	private String categoryName;
	private String description;
	private Integer isJobAvailable;
	private Integer status;
	public JobCategoryForm(Integer jobCategoryId, String categoryName,
			String description, Integer isJobAvailable, Integer status) {
		super();
		this.jobCategoryId = jobCategoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.isJobAvailable = isJobAvailable;
		this.status = status;
	}
	public Integer getJobCategoryId() {
		return jobCategoryId;
	}
	public void setJobCategoryId(Integer jobCategoryId) {
		this.jobCategoryId = jobCategoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIsJobAvailable() {
		return isJobAvailable;
	}
	public void setIsJobAvailable(Integer isJobAvailable) {
		this.isJobAvailable = isJobAvailable;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public JobCategoryForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

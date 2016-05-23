package com.deemsys.project.entity;

// Generated May 23, 2016 4:52:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * JobCategory generated by hbm2java
 */
@Entity
@Table(name = "job_category", catalog = "innova")
public class JobCategory implements java.io.Serializable {

	private Integer jobCategoryId;
	private String categoryName;
	private String description;
	private Integer isJobAvailable;
	private Integer status;
	private Set<Job> jobs = new HashSet<Job>(0);

	public JobCategory() {
	}

	public JobCategory(String categoryName, String description,
			Integer isJobAvailable, Integer status, Set<Job> jobs) {
		this.categoryName = categoryName;
		this.description = description;
		this.isJobAvailable = isJobAvailable;
		this.status = status;
		this.jobs = jobs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "job_category_id", unique = true, nullable = false)
	public Integer getJobCategoryId() {
		return this.jobCategoryId;
	}

	public void setJobCategoryId(Integer jobCategoryId) {
		this.jobCategoryId = jobCategoryId;
	}

	@Column(name = "category_name", length = 60)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "description", length = 300)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "is_job_available")
	public Integer getIsJobAvailable() {
		return this.isJobAvailable;
	}

	public void setIsJobAvailable(Integer isJobAvailable) {
		this.isJobAvailable = isJobAvailable;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobCategory")
	public Set<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

}

package com.deemsys.project.entity;

// Generated May 23, 2016 4:52:30 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JobTag generated by hbm2java
 */
@Entity
@Table(name = "job_tag", catalog = "innova")
public class JobTag implements java.io.Serializable {

	private Long jobTagsId;
	private Job job;
	private String tags;
	private Integer status;

	public JobTag() {
	}

	public JobTag(Job job, String tags, Integer status) {
		this.job = job;
		this.tags = tags;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "job_tags_id", unique = true, nullable = false)
	public Long getJobTagsId() {
		return this.jobTagsId;
	}

	public void setJobTagsId(Long jobTagsId) {
		this.jobTagsId = jobTagsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_id")
	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Column(name = "tags", length = 60)
	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}

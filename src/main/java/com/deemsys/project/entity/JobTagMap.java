package com.deemsys.project.entity;

// Generated May 26, 2016 2:42:36 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JobTagMap generated by hbm2java
 */
@Entity
@Table(name = "job_tag_map", catalog = "innova")
public class JobTagMap implements java.io.Serializable {

	private JobTagMapId id;
	private JobTags jobTags;
	private Job job;

	public JobTagMap() {
	}

	public JobTagMap(JobTagMapId id) {
		this.id = id;
	}

	public JobTagMap(JobTagMapId id, JobTags jobTags, Job job) {
		this.id = id;
		this.jobTags = jobTags;
		this.job = job;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "jobId", column = @Column(name = "job_id")),
			@AttributeOverride(name = "tagId", column = @Column(name = "tag_id")),
			@AttributeOverride(name = "status", column = @Column(name = "status")) })
	public JobTagMapId getId() {
		return this.id;
	}

	public void setId(JobTagMapId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tag_id", insertable = false, updatable = false)
	public JobTags getJobTags() {
		return this.jobTags;
	}

	public void setJobTags(JobTags jobTags) {
		this.jobTags = jobTags;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_id", insertable = false, updatable = false)
	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}

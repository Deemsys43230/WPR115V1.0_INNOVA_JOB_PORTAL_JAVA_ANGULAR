package com.deemsys.project.entity;

// Generated May 23, 2016 4:52:30 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JobSeeker generated by hbm2java
 */
@Entity
@Table(name = "job_seeker", catalog = "innova")
public class JobSeeker implements java.io.Serializable {

	private String jobSeekerId;
	private ResumeDetail resumeDetail;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Integer status;

	public JobSeeker() {
	}

	public JobSeeker(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public JobSeeker(String jobSeekerId, ResumeDetail resumeDetail,
			String firstName, String lastName, String email,
			String phoneNumber, Integer status) {
		this.jobSeekerId = jobSeekerId;
		this.resumeDetail = resumeDetail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	@Id
	@Column(name = "job_seeker_id", unique = true, nullable = false, length = 32)
	public String getJobSeekerId() {
		return this.jobSeekerId;
	}

	public void setJobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_detail_id")
	public ResumeDetail getResumeDetail() {
		return this.resumeDetail;
	}

	public void setResumeDetail(ResumeDetail resumeDetail) {
		this.resumeDetail = resumeDetail;
	}

	@Column(name = "first_name", length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone_number", length = 20)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}

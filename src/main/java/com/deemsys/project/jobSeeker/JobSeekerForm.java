package com.deemsys.project.jobSeeker;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Deemsys
 *
 */
public class JobSeekerForm {

	private String jobSeekerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Integer status;
	private String resumeName;
	private String resumeType;
	public String getJobSeekerId() {
		return jobSeekerId;
	}
	public void setJobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getResumeName() {
		return resumeName;
	}
	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}
	public String getResumeType() {
		return resumeType;
	}
	public void setResumeType(String resumeType) {
		this.resumeType = resumeType;
	}
	public JobSeekerForm(String jobSeekerId, String firstName, String lastName,
			String email, String phoneNumber, Integer status,
			String resumeName, String resumeType) {
		super();
		this.jobSeekerId = jobSeekerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.resumeName = resumeName;
		this.resumeType = resumeType;
	}
	public JobSeekerForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

package com.deemsys.project.jobtag;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.deemsys.project.entity.Job;

/**
 * 
 * @author Deemsys
 *
 */
public class JobTagForm {

	private Long jobId;
	private String tags;
	private Integer status;
	
	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public JobTagForm(Long jobId, String tags, Integer status) {
		super();
		this.jobId = jobId;
		this.tags = tags;
		this.status = status;
	}

	public JobTagForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

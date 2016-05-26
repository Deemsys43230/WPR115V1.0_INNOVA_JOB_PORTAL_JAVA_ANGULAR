package com.deemsys.project.jobtagmap;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Deemsys
 *
 */
public class JobTagMapForm {

	private Long jobId;
	private Long tagId;
	private String tag;
	private Integer status;
	
	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public JobTagMapForm(Long jobId, Long tagId, String tag, Integer status) {
		super();
		this.jobId = jobId;
		this.tagId = tagId;
		this.tag = tag;
		this.status = status;
	}

	public JobTagMapForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

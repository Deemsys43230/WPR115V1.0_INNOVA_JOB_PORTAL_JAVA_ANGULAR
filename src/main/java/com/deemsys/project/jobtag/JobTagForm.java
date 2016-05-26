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

	private Long tagId;
	private String tagName;
	private Date addedDate;
	private Integer status;
	private Integer isNew;
	
	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsNew() {
		return isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

	public JobTagForm(Long tagId, String tagName, Date addedDate, Integer status) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.addedDate = addedDate;
		this.status = status;
	}

	public JobTagForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

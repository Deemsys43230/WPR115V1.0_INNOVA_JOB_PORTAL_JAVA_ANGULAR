package com.deemsys.project.latestnews;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Deemsys
 *
 */
public class LatestNewsForm {

	private Long latestNewsId;
	private String title;
	private String description;
	private String addedDate;
	private Integer status;
	private String titleImageUrl;
	
	public Long getLatestNewsId() {
		return latestNewsId;
	}

	public void setLatestNewsId(Long latestNewsId) {
		this.latestNewsId = latestNewsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	public String getTitleImageUrl() {
		return titleImageUrl;
	}

	public void setTitleImageUrl(String titleImageUrl) {
		this.titleImageUrl = titleImageUrl;
	}

	public LatestNewsForm(Long latestNewsId, String title, String description,
			String addedDate, Integer status,String titleImageUrl) {
		super();
		this.latestNewsId = latestNewsId;
		this.title = title;
		this.description = description;
		this.addedDate = addedDate;
		this.status = status;
		this.titleImageUrl=titleImageUrl;
	}

	public LatestNewsForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

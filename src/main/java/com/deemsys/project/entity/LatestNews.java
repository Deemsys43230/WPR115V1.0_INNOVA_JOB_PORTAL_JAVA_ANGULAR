package com.deemsys.project.entity;

// Generated May 27, 2016 7:55:43 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LatestNews generated by hbm2java
 */
@Entity
@Table(name = "latest_news", catalog = "innova")
public class LatestNews implements java.io.Serializable {

	private Long latestNewsId;
	private String title;
	private String description;
	private Date addedDate;
	private Integer status;
	private String fileReferenceName;

	public LatestNews() {
	}

	public LatestNews(String title, String description, Date addedDate,
			Integer status, String fileReferenceName) {
		this.title = title;
		this.description = description;
		this.addedDate = addedDate;
		this.status = status;
		this.fileReferenceName = fileReferenceName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "latest_news_id", unique = true, nullable = false)
	public Long getLatestNewsId() {
		return this.latestNewsId;
	}

	public void setLatestNewsId(Long latestNewsId) {
		this.latestNewsId = latestNewsId;
	}

	@Column(name = "title", length = 150)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "added_date", length = 19)
	public Date getAddedDate() {
		return this.addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "file_reference_name", length = 100)
	public String getFileReferenceName() {
		return this.fileReferenceName;
	}

	public void setFileReferenceName(String fileReferenceName) {
		this.fileReferenceName = fileReferenceName;
	}

}

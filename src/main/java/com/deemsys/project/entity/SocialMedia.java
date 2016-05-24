package com.deemsys.project.entity;

// Generated May 24, 2016 3:57:03 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SocialMedia generated by hbm2java
 */
@Entity
@Table(name = "social_media", catalog = "innova")
public class SocialMedia implements java.io.Serializable {

	private Integer socialMediaId;
	private String facebookLink;
	private String twitterLink;
	private String googlePlusLink;
	private String linkedInLink;
	private String status;

	public SocialMedia() {
	}

	public SocialMedia(String facebookLink, String twitterLink,
			String googlePlusLink, String linkedInLink, String status) {
		this.facebookLink = facebookLink;
		this.twitterLink = twitterLink;
		this.googlePlusLink = googlePlusLink;
		this.linkedInLink = linkedInLink;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "social_media_id", unique = true, nullable = false)
	public Integer getSocialMediaId() {
		return this.socialMediaId;
	}

	public void setSocialMediaId(Integer socialMediaId) {
		this.socialMediaId = socialMediaId;
	}

	@Column(name = "facebook_link", length = 100)
	public String getFacebookLink() {
		return this.facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	@Column(name = "twitter_link", length = 100)
	public String getTwitterLink() {
		return this.twitterLink;
	}

	public void setTwitterLink(String twitterLink) {
		this.twitterLink = twitterLink;
	}

	@Column(name = "google_plus_link", length = 100)
	public String getGooglePlusLink() {
		return this.googlePlusLink;
	}

	public void setGooglePlusLink(String googlePlusLink) {
		this.googlePlusLink = googlePlusLink;
	}

	@Column(name = "linked_in_link", length = 100)
	public String getLinkedInLink() {
		return this.linkedInLink;
	}

	public void setLinkedInLink(String linkedInLink) {
		this.linkedInLink = linkedInLink;
	}

	@Column(name = "status", length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

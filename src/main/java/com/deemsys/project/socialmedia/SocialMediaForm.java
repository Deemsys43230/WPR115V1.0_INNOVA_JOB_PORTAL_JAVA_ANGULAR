package com.deemsys.project.socialmedia;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Deemsys
 *
 */
public class SocialMediaForm {

	private Integer socialMediaId;
	private String facebookLink;
	private String twitterLink;
	private String googlePlusLink;
	private String linkedInLink;
	private String status;
	public Integer getSocialMediaId() {
		return socialMediaId;
	}
	public void setSocialMediaId(Integer socialMediaId) {
		this.socialMediaId = socialMediaId;
	}
	public String getFacebookLink() {
		return facebookLink;
	}
	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}
	public String getTwitterLink() {
		return twitterLink;
	}
	public void setTwitterLink(String twitterLink) {
		this.twitterLink = twitterLink;
	}
	public String getGooglePlusLink() {
		return googlePlusLink;
	}
	public void setGooglePlusLink(String googlePlusLink) {
		this.googlePlusLink = googlePlusLink;
	}
	public String getLinkedInLink() {
		return linkedInLink;
	}
	public void setLinkedInLink(String linkedInLink) {
		this.linkedInLink = linkedInLink;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SocialMediaForm(Integer socialMediaId, String facebookLink,
			String twitterLink, String googlePlusLink, String linkedInLink,
			String status) {
		super();
		this.socialMediaId = socialMediaId;
		this.facebookLink = facebookLink;
		this.twitterLink = twitterLink;
		this.googlePlusLink = googlePlusLink;
		this.linkedInLink = linkedInLink;
		this.status = status;
	}
	public SocialMediaForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

package com.deemsys.project.testimonial;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Deemsys
 *
 */
public class TestimonialForm {

	private Long testimonialId;
	private String description;
	private String saidBy;
	private String destination;
	private Integer status;
	
	public Long getTestimonialId() {
		return testimonialId;
	}

	public void setTestimonialId(Long testimonialId) {
		this.testimonialId = testimonialId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSaidBy() {
		return saidBy;
	}

	public void setSaidBy(String saidBy) {
		this.saidBy = saidBy;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public TestimonialForm(Long testimonialId, String description,
			String saidBy, String destination, Integer status) {
		super();
		this.testimonialId = testimonialId;
		this.description = description;
		this.saidBy = saidBy;
		this.destination = destination;
		this.status = status;
	}

	public TestimonialForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

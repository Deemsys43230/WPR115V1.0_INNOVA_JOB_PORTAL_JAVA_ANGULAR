package com.deemsys.project.resumedetail;


/**
 * 
 * @author Deemsys
 *
 */
public class ResumeDetailForm {

	private String resumeId;
	private String name;
	private String type;
	private String reference;
	private Integer status;
	public String getResumeId() {
		return resumeId;
	}
	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public ResumeDetailForm(String resumeId, String name, String type,
			String reference, Integer status) {
		super();
		this.resumeId = resumeId;
		this.name = name;
		this.type = type;
		this.reference = reference;
		this.status = status;
	}
	public ResumeDetailForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

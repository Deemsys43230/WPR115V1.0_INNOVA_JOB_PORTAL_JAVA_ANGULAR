package com.deemsys.project.documentLocation;

/**
 * 
 * @author Deemsys
 *
 */
public class DocumentLocationForm {

	private Integer docLocationId;
	private String docLocation;
	private String description;
	private Integer status;
	public Integer getDocLocationId() {
		return docLocationId;
	}
	public void setDocLocationId(Integer docLocationId) {
		this.docLocationId = docLocationId;
	}
	public String getDocLocation() {
		return docLocation;
	}
	public void setDocLocation(String docLocation) {
		this.docLocation = docLocation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public DocumentLocationForm(Integer docLocationId, String docLocation,
			String description, Integer status) {
		super();
		this.docLocationId = docLocationId;
		this.docLocation = docLocation;
		this.description = description;
		this.status = status;
	}
	public DocumentLocationForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

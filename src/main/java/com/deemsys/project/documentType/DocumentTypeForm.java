package com.deemsys.project.documentType;

/**
 * 
 * @author Deemsys
 *
 */
public class DocumentTypeForm {

	private Integer docTypeId;
	private String docTypeName;
	private String docPrefix;
	private String description;
	private Integer status;
	public Integer getDocTypeId() {
		return docTypeId;
	}
	public void setDocTypeId(Integer docTypeId) {
		this.docTypeId = docTypeId;
	}
	public String getDocTypeName() {
		return docTypeName;
	}
	public void setDocTypeName(String docTypeName) {
		this.docTypeName = docTypeName;
	}
	public String getDocPrefix() {
		return docPrefix;
	}
	public void setDocPrefix(String docPrefix) {
		this.docPrefix = docPrefix;
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
	public DocumentTypeForm(Integer docTypeId, String docTypeName,
			String docPrefix, String description, Integer status) {
		super();
		this.docTypeId = docTypeId;
		this.docTypeName = docTypeName;
		this.docPrefix = docPrefix;
		this.description = description;
		this.status = status;
	}
	public DocumentTypeForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

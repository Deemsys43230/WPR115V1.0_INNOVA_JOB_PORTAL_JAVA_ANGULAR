package com.deemsys.project.entity;

// Generated Apr 23, 2016 6:04:02 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EmailRecepientsId generated by hbm2java
 */
@Embeddable
public class EmailRecepientsId implements java.io.Serializable {

	private int userId;
	private int moduleId;

	public EmailRecepientsId() {
	}

	public EmailRecepientsId(int userId, int moduleId) {
		this.userId = userId;
		this.moduleId = moduleId;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "module_id", nullable = false)
	public int getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EmailRecepientsId))
			return false;
		EmailRecepientsId castOther = (EmailRecepientsId) other;

		return (this.getUserId() == castOther.getUserId())
				&& (this.getModuleId() == castOther.getModuleId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserId();
		result = 37 * result + this.getModuleId();
		return result;
	}

}

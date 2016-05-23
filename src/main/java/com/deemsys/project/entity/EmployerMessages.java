package com.deemsys.project.entity;

// Generated May 23, 2016 4:52:30 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmployerMessages generated by hbm2java
 */
@Entity
@Table(name = "employer_messages", catalog = "innova")
public class EmployerMessages implements java.io.Serializable {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String subject;
	private String message;
	private Integer status;

	public EmployerMessages() {
	}

	public EmployerMessages(String firstName, String lastName, String email,
			String subject, String message, Integer status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "first_name", length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "subject", length = 100)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "message", length = 800)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}

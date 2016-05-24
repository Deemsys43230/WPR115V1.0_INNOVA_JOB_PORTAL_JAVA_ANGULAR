package com.deemsys.project.employermessage;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Deemsys
 *
 */
public class EmployerMessagesForm {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String subject;
	private String message;
	private String messageDate;
	private Integer status;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public EmployerMessagesForm(Integer id, String firstName, String lastName,
			String email, String subject, String message, String messageDate, Integer status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.messageDate = messageDate;
		this.status = status;
	}

	public EmployerMessagesForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

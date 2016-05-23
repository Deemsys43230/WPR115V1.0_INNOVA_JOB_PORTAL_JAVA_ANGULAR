package com.deemsys.project.contactdetail;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Deemsys
 *
 */
public class ContactDetailForm {

	private Integer contactId;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String email;
	private String phoneNumber;
	private Integer status;
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public ContactDetailForm(Integer contactId, String street, String city,
			String state, String country, String zipCode, String email,
			String phoneNumber, Integer status) {
		super();
		this.contactId = contactId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}
	public ContactDetailForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

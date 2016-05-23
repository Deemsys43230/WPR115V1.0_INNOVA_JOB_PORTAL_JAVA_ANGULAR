package com.deemsys.project.login;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.deemsys.project.entity.Roles;

/**
 * 
 * @author Deemsys
 *
 */
public class LoginForm {

	private Integer loginId;
	private Roles roles;
	private String username;
	private String password;
	private Integer isEnable;
	private Integer status;
	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LoginForm(Integer loginId, Roles roles, String username,
			String password, Integer isEnable, Integer status) {
		super();
		this.loginId = loginId;
		this.roles = roles;
		this.username = username;
		this.password = password;
		this.isEnable = isEnable;
		this.status = status;
	}
	public LoginForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

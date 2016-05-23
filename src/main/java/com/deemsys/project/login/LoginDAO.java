package com.deemsys.project.login;

import com.deemsys.project.common.IGenericDAO;
import com.deemsys.project.entity.Login;
import com.deemsys.project.entity.Template;
import com.deemsys.project.entity.Users;
/**
 * 
 * @author Deemsys
 *
 */
public interface LoginDAO extends IGenericDAO<Login>{

	//Function to check for user name
	public Login getByUserName(String username);
}

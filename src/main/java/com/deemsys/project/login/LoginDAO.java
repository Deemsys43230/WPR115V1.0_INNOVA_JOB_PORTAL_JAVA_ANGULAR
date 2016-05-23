package com.deemsys.project.login;

import com.deemsys.project.common.IGenericDAO;
import com.deemsys.project.entity.Login;
/**
 * 
 * @author Deemsys
 *
 */
public interface LoginDAO extends IGenericDAO<Login>{

	public Login getByUserName(String username);

}

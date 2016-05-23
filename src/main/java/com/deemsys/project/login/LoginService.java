package com.deemsys.project.login;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.entity.Login;
/**
 * 
 * @author Deemsys
 *
 * Login 	 - Entity
 * login 	 - Entity Object
 * logins 	 - Entity List
 * loginDAO   - Entity DAO
 * loginForms - EntityForm List
 * LoginForm  - EntityForm
 *
 */
@Service
@Transactional
public class LoginService {

	@Autowired
	LoginDAO loginDAO;
	
	//Get All Entries
	public List<LoginForm> getLoginList()
	{
		List<LoginForm> loginForms=new ArrayList<LoginForm>();
		
		List<Login> logins=new ArrayList<Login>();
		
		logins=loginDAO.getAll();
		
		for (Login login : logins) {
			//TODO: Fill the List
			
		}
		
		return loginForms;
	}
	
	//Get Particular Entry
	public LoginForm getLogin(Integer getId)
	{
		Login login=new Login();
		
		login=loginDAO.get(getId);
		
		//TODO: Convert Entity to Form
		//Start
		
		LoginForm loginForm=new LoginForm();
		
		//End
		
		return loginForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeLogin(LoginForm loginForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		Login login=new Login();
		
		//Logic Ends
		
		
		loginDAO.merge(login);
		return 1;
	}
	
	//Save an Entry
	public int saveLogin(LoginForm loginForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		Login login=new Login();
		
		//Logic Ends
		
		loginDAO.save(login);
		return 1;
	}
	
	//Update an Entry
	public int updateLogin(LoginForm loginForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		Login login=new Login();
		
		//Logic Ends
		
		loginDAO.update(login);
		return 1;
	}
	
	//Delete an Entry
	public int deleteLogin(Integer id)
	{
		loginDAO.delete(id);
		return 1;
	}
	
	
	
}

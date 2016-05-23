package com.deemsys.project.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.entity.Users;
/**
 * 
 * @author Deemsys
 *
 * Users 	 - Entity
 * Users 	 - Entity Object
 * Userss 	 - Entity List
 * UsersDAO   - Entity DAO
 * UsersForms - EntityForm List
 * UsersForm  - EntityForm
 *
 */
@Service
@Transactional
public class UsersService {

	@Autowired
	UsersDAO UsersDAO;
	
	//Get All Entries
	public List<UsersForm> getUsersList()
	{
		List<UsersForm> UsersForms=new ArrayList<UsersForm>();
		
		List<Users> Userss=new ArrayList<Users>();
		
		Userss=UsersDAO.getAll();
		
		for (Users Users : Userss) {
			//TODO: Fill the List
			
		}
		
		return UsersForms;
	}
	
	//Get Particular Entry
	public UsersForm getUsers(Integer getId)
	{
		Users Users=new Users();
		
		Users=UsersDAO.get(getId);
		
		//TODO: Convert Entity to Form
		//Start
		
		UsersForm UsersForm=new UsersForm();
		
		//End
		
		return UsersForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeUsers(UsersForm UsersForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		Users Users=new Users();
		
		//Logic Ends
		
		
		UsersDAO.merge(Users);
		return 1;
	}
	
	//Save an Entry
	public int saveUsers(UsersForm UsersForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		Users Users=new Users();
		
		//Logic Ends
		
		UsersDAO.save(Users);
		return 1;
	}
	
	//Update an Entry
	public int updateUsers(UsersForm UsersForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		Users Users=new Users();
		
		//Logic Ends
		
		UsersDAO.update(Users);
		return 1;
	}
	
	//Delete an Entry
	public int deleteUsers(Integer id)
	{
		UsersDAO.delete(id);
		return 1;
	}
	
	
	
}

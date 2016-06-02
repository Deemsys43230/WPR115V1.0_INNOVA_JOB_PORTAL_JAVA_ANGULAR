package com.deemsys.project.employermessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.common.JobPortalConstants;
import com.deemsys.project.entity.EmployerMessages;
/**
 * 
 * @author Deemsys
 *
 * EmployerMessages 	 - Entity
 * employerMessages 	 - Entity Object
 * employerMessagess 	 - Entity List
 * employerMessagesDAO   - Entity DAO
 * employerMessagesForms - EntityForm List
 * EmployerMessagesForm  - EntityForm
 *
 */
@Service
@Transactional
public class EmployerMessagesService {

	@Autowired
	EmployerMessgagesDAO employerMessagesDAO;
	
	//Get All Entries
	public List<EmployerMessagesForm> getEmployerMessagesList()
	{
		List<EmployerMessagesForm> employerMessagesForms=new ArrayList<EmployerMessagesForm>();
		
		List<EmployerMessages> employerMessagess=new ArrayList<EmployerMessages>();
		
		employerMessagess=employerMessagesDAO.getAll();
		
		for (EmployerMessages employerMessages : employerMessagess) {
			//TODO: Fill the List
			EmployerMessagesForm employerMessagesForm=new EmployerMessagesForm(employerMessages.getId(), employerMessages.getFirstName(),employerMessages.getLastName(), employerMessages.getEmail(), employerMessages.getSubject(),employerMessages.getWebsite(), employerMessages.getMessage(), JobPortalConstants.convertMonthFormat(employerMessages.getMessageDate()), employerMessages.getStatus());
			employerMessagesForms.add(employerMessagesForm);
		}
		
		return employerMessagesForms;
	}
	
	//Get Particular Entry
	public EmployerMessagesForm getEmployerMessages(Integer getId)
	{
		EmployerMessages employerMessages=new EmployerMessages();
		
		employerMessages=employerMessagesDAO.get(getId);
		
		//TODO: Convert Entity to Form
		//Start
		
		EmployerMessagesForm employerMessagesForm=new EmployerMessagesForm(employerMessages.getId(), employerMessages.getFirstName(),employerMessages.getLastName(), employerMessages.getEmail(), employerMessages.getSubject(),employerMessages.getWebsite(), employerMessages.getMessage(), JobPortalConstants.convertMonthFormat(employerMessages.getMessageDate()), employerMessages.getStatus());
		
		//End
		
		return employerMessagesForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeEmployerMessages(EmployerMessagesForm employerMessagesForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		if(employerMessagesForm.getMessageDate()==null)
			employerMessagesForm.setMessageDate(new Date().toString());
		EmployerMessages employerMessages=new EmployerMessages(employerMessagesForm.getFirstName(), employerMessagesForm.getLastName(), employerMessagesForm.getEmail(), employerMessagesForm.getSubject(),employerMessagesForm.getWebsite(), employerMessagesForm.getMessage(), new Date(), 1);
		employerMessages.setId(employerMessagesForm.getId());
		
		//Logic Ends
		
		
		employerMessagesDAO.merge(employerMessages);
		return 1;
	}
	
	//Save an Entry
	public int saveEmployerMessages(EmployerMessagesForm employerMessagesForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		EmployerMessages employerMessages=new EmployerMessages(employerMessagesForm.getFirstName(), employerMessagesForm.getLastName(), employerMessagesForm.getEmail(), employerMessagesForm.getSubject(),employerMessagesForm.getWebsite(), employerMessagesForm.getMessage(), new Date(), 1);
		
		//Logic Ends
		
		employerMessagesDAO.save(employerMessages);
		return 1;
	}
	
	//Update an Entry
	public int updateEmployerMessages(EmployerMessagesForm employerMessagesForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		EmployerMessages employerMessages=new EmployerMessages(employerMessagesForm.getFirstName(), employerMessagesForm.getLastName(), employerMessagesForm.getEmail(), employerMessagesForm.getSubject(),employerMessagesForm.getWebsite(), employerMessagesForm.getMessage(), new Date(), 1);
		employerMessages.setId(employerMessagesForm.getId());
		//Logic Ends
		
		employerMessagesDAO.update(employerMessages);
		return 1;
	}
	
	//Delete an Entry
	public int deleteEmployerMessages(Integer id)
	{
		employerMessagesDAO.delete(id);
		return 1;
	}
	
	// Get Employer Count
	public Integer getEmployerCount(){
		return employerMessagesDAO.getAll().size();
	}
	
}

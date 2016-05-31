package com.deemsys.project.contactmessages;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.common.JobPortalConstants;
import com.deemsys.project.entity.ContactMessages;
import com.deemsys.project.entity.JobCategory;
/**
 * 
 * @author Deemsys
 *
 * ContactMessages 	 - Entity
 * contactMessages 	 - Entity Object
 * contactMessagess 	 - Entity List
 * contactMessagesDAO   - Entity DAO
 * contactMessagesForms - EntityForm List
 * ContactMessagesForm  - EntityForm
 *
 */
@Service
@Transactional
public class ContactMessagesService {

	@Autowired
	ContactMessagesDAO contactMessagesDAO;
	
	//Get All Entries
	public List<ContactMessagesForm> getContactMessagesList()
	{
		List<ContactMessagesForm> contactMessagesForms=new ArrayList<ContactMessagesForm>();
		
		List<ContactMessages> contactMessagess=new ArrayList<ContactMessages>();
		
		contactMessagess=contactMessagesDAO.getAll();
		
		for (ContactMessages contactMessages : contactMessagess) {
			//TODO: Fill the List
			ContactMessagesForm contactMessagesForm=new ContactMessagesForm(contactMessages.getId(), contactMessages.getFirstName(),contactMessages.getLastName(), contactMessages.getEmail(), contactMessages.getSubject(),contactMessages.getWebsite(), contactMessages.getMessage(), JobPortalConstants.convertMonthFormat(contactMessages.getMessageDate()), contactMessages.getStatus());
			contactMessagesForms.add(contactMessagesForm);
		}
		
		return contactMessagesForms;
	}
	
	//Get Particular Entry
	public ContactMessagesForm getContactMessages(Integer getId)
	{
		ContactMessages contactMessages=new ContactMessages();
		
		contactMessages=contactMessagesDAO.get(getId);
		
		//TODO: Convert Entity to Form
		//Start
		
		ContactMessagesForm contactMessagesForm=new ContactMessagesForm(contactMessages.getId(), contactMessages.getFirstName(),contactMessages.getLastName(), contactMessages.getEmail(), contactMessages.getSubject(),contactMessages.getWebsite(), contactMessages.getMessage(), JobPortalConstants.convertMonthFormat(contactMessages.getMessageDate()), contactMessages.getStatus());
		
		//End
		
		return contactMessagesForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeContactMessages(ContactMessagesForm contactMessagesForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		if(contactMessagesForm.getMessageDate()==null)
			contactMessagesForm.setMessageDate(new Date().toString());
		ContactMessages contactMessages=new ContactMessages(contactMessagesForm.getFirstName(), contactMessagesForm.getLastName(), contactMessagesForm.getEmail(), contactMessagesForm.getSubject(),contactMessagesForm.getWebsite(), contactMessagesForm.getMessage(), JobPortalConstants.convertYearFormat(contactMessagesForm.getMessageDate()), 1);
		contactMessages.setId(contactMessagesForm.getId());
		
		//Logic Ends
		
		
		contactMessagesDAO.merge(contactMessages);
		return 1;
	}
	
	//Save an Entry
	public int saveContactMessages(ContactMessagesForm contactMessagesForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		ContactMessages contactMessages=new ContactMessages(contactMessagesForm.getFirstName(), contactMessagesForm.getLastName(), contactMessagesForm.getEmail(), contactMessagesForm.getSubject(),contactMessagesForm.getWebsite(), contactMessagesForm.getMessage(), new Date(), 1);
		
		//Logic Ends
		
		contactMessagesDAO.save(contactMessages);
		return 1;
	}
	
	//Update an Entry
	public int updateContactMessages(ContactMessagesForm contactMessagesForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		ContactMessages contactMessages=new ContactMessages(contactMessagesForm.getFirstName(), contactMessagesForm.getLastName(), contactMessagesForm.getEmail(), contactMessagesForm.getSubject(),contactMessagesForm.getWebsite(), contactMessagesForm.getMessage(), new Date(), 1);
		contactMessages.setId(contactMessagesForm.getId());
		//Logic Ends
		
		contactMessagesDAO.update(contactMessages);
		return 1;
	}
	
	//Delete an Entry
	public int deleteContactMessages(Integer id)
	{
		contactMessagesDAO.delete(id);
		return 1;
	}
	
	// Get Employer Count
	public Integer contactMessageCountUnread(){
		return contactMessagesDAO.getUnreadMessageCount();
	}

	public void markAsRead(Integer contactMessageId) {
		// TODO Auto-generated method stub
		ContactMessages contactMessages=contactMessagesDAO.get(contactMessageId);
		if(contactMessages.getStatus()==1){
			contactMessages.setStatus(0);
			contactMessagesDAO.merge(contactMessages);
		}		
	}
	
}

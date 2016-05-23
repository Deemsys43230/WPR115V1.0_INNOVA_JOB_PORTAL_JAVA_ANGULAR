package com.deemsys.project.contactdetail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.entity.ContactDetail;
/**
 * 
 * @author Deemsys
 *
 * ContactDetail 	 - Entity
 * contactDetail 	 - Entity Object
 * contactDetails 	 - Entity List
 * contactDetailDAO   - Entity DAO
 * contactDetailForms - EntityForm List
 * ContactDetailForm  - EntityForm
 *
 */
@Service
@Transactional
public class ContactDetailService {

	@Autowired
	ContactDetailDAO contactDetailDAO;
	
	//Get All Entries
	public List<ContactDetailForm> getContactDetailList()
	{
		List<ContactDetailForm> contactDetailForms=new ArrayList<ContactDetailForm>();
		
		List<ContactDetail> contactDetails=new ArrayList<ContactDetail>();
		
		contactDetails=contactDetailDAO.getAll();
		
		for (ContactDetail contactDetail : contactDetails) {
			//TODO: Fill the List
			contactDetailForms.add(new ContactDetailForm(contactDetail.getContactId(), contactDetail.getStreet(), contactDetail.getCity(), contactDetail.getState(), contactDetail.getCountry(), contactDetail.getZipCode(), contactDetail.getEmail(), contactDetail.getPhoneNumber(), contactDetail.getStatus()));
		}
		
		return contactDetailForms;
	}
	
	//Get Particular Entry
	public ContactDetailForm getContactDetail(Integer getId)
	{
		ContactDetail contactDetail=new ContactDetail();
		
		contactDetail=contactDetailDAO.get(getId);
		
		//TODO: Convert Entity to Form
		//Start
		
		ContactDetailForm contactDetailForm=new ContactDetailForm(contactDetail.getContactId(), contactDetail.getStreet(), contactDetail.getCity(), contactDetail.getState(), contactDetail.getCountry(), contactDetail.getZipCode(), contactDetail.getEmail(), contactDetail.getPhoneNumber(), contactDetail.getStatus());
		
		//End
		
		return contactDetailForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeContactDetail(ContactDetailForm contactDetailForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		ContactDetail contactDetail=new ContactDetail(contactDetailForm.getStreet(), contactDetailForm.getCity(), contactDetailForm.getStreet(), contactDetailForm.getCountry(), contactDetailForm.getZipCode(), contactDetailForm.getEmail(), contactDetailForm.getPhoneNumber(), contactDetailForm.getStatus());
		contactDetail.setContactId(1);
		//Logic Ends
		
		
		contactDetailDAO.merge(contactDetail);
		return 1;
	}
	
	//Save an Entry
	public int saveContactDetail(ContactDetailForm contactDetailForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		ContactDetail contactDetail=new ContactDetail();
		
		//Logic Ends
		
		contactDetailDAO.save(contactDetail);
		return 1;
	}
	
	//Update an Entry
	public int updateContactDetail(ContactDetailForm contactDetailForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		ContactDetail contactDetail=new ContactDetail();
		
		//Logic Ends
		
		contactDetailDAO.update(contactDetail);
		return 1;
	}
	
	//Delete an Entry
	public int deleteContactDetail(Integer id)
	{
		contactDetailDAO.delete(id);
		return 1;
	}
	
	
	
}

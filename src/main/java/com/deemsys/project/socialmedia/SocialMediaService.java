package com.deemsys.project.socialmedia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.entity.SocialMedia;
/**
 * 
 * @author Deemsys
 *
 * SocialMedia 	 - Entity
 * socialMedia 	 - Entity Object
 * socialMedias 	 - Entity List
 * socialMediaDAO   - Entity DAO
 * socialMediaForms - EntityForm List
 * SocialMediaForm  - EntityForm
 *
 */
@Service
@Transactional
public class SocialMediaService {

	@Autowired
	SocialMediaDAO socialMediaDAO;
	
	//Get All Entries
	public List<SocialMediaForm> getSocialMediaList()
	{
		List<SocialMediaForm> socialMediaForms=new ArrayList<SocialMediaForm>();
		
		List<SocialMedia> socialMedias=new ArrayList<SocialMedia>();
		
		socialMedias=socialMediaDAO.getAll();
		
		for (SocialMedia socialMedia : socialMedias) {
			//TODO: Fill the List
			socialMediaForms.add(new SocialMediaForm(socialMedia.getSocialMediaId(), socialMedia.getFacebookLink(), socialMedia.getTwitterLink(), socialMedia.getGooglePlusLink(), socialMedia.getLinkedInLink(), socialMedia.getStatus()));
		}
		
		return socialMediaForms;
	}
	
	//Get Particular Entry
	public SocialMediaForm getSocialMedia(Integer getId)
	{
		SocialMedia socialMedia=new SocialMedia();
		
		socialMedia=socialMediaDAO.get(getId);
		
		//TODO: Convert Entity to Form
		//Start
		SocialMediaForm socialMediaForm=new SocialMediaForm();
		if(socialMedia!=null)
		socialMediaForm=new SocialMediaForm(socialMedia.getSocialMediaId(), socialMedia.getFacebookLink(), socialMedia.getTwitterLink(), socialMedia.getGooglePlusLink(), socialMedia.getLinkedInLink(), socialMedia.getStatus());
		
		//End
		
		return socialMediaForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeSocialMedia(SocialMediaForm socialMediaForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		SocialMedia socialMedia=new SocialMedia(socialMediaForm.getFacebookLink(), socialMediaForm.getTwitterLink(), socialMediaForm.getGooglePlusLink(), socialMediaForm.getLinkedInLink(), socialMediaForm.getStatus());
		socialMedia.setSocialMediaId(socialMediaForm.getSocialMediaId());
		//Logic Ends
		
		
		socialMediaDAO.merge(socialMedia);
		return 1;
	}
	
	//Save an Entry
	public int saveSocialMedia(SocialMediaForm socialMediaForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		SocialMedia socialMedia=new SocialMedia();
		
		//Logic Ends
		
		socialMediaDAO.save(socialMedia);
		return 1;
	}
	
	//Update an Entry
	public int updateSocialMedia(SocialMediaForm socialMediaForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		SocialMedia socialMedia=new SocialMedia();
		
		//Logic Ends
		
		socialMediaDAO.update(socialMedia);
		return 1;
	}
	
	//Delete an Entry
	public int deleteSocialMedia(Integer id)
	{
		socialMediaDAO.delete(id);
		return 1;
	}
	
	
	
}

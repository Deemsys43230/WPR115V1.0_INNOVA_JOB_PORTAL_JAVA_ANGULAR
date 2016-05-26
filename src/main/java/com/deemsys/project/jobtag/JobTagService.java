package com.deemsys.project.jobtag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.transaction.JOnASTransactionManagerLookup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jibx.JibxMarshaller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.entity.JobTags;
import com.deemsys.project.entity.Template;
import com.deemsys.project.template.TemplateForm;
/**
 * 
 * @author Deemsys
 *
 * JobTag 	 - Entity
 * jobTag 	 - Entity Object
 * jobTags 	 - Entity List
 * jobTagDAO   - Entity DAO
 * jobTagForms - EntityForm List
 * JobTagForm  - EntityForm
 *
 */
@Service
@Transactional
public class JobTagService {

	@Autowired
	JobTagDAO jobTagDAO;
	
	
	
	//Get Job Tags
	public List<JobTagForm> getJobTagList()
	{
		
List<JobTagForm> jobTagForms=new ArrayList<JobTagForm>();
		
		List<JobTags> jobTags = new ArrayList<JobTags>();
		jobTags=jobTagDAO.getAll();
		for (JobTags jobTags2 : jobTags) {
			JobTagForm jobTagForm=new JobTagForm(jobTags2.getTagId(), jobTags2.getTagName(), jobTags2.getAddedDate(), jobTags2.getStatus());
			jobTagForms.add(jobTagForm);
		}
		return jobTagForms;
	}
	
	//Get Particular Entry
	public JobTagForm getJobTag(Long getId)
	{
		JobTags jobTags=new JobTags();
			
		//jobTags=jobTagDAO.get(getId);
			
		//TODO: Convert Entity to Form
		//Start
			
		JobTagForm jobTagForm=new JobTagForm();
			
		//End
			
		return jobTagForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeJobTag(JobTagForm jobTagForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		JobTags jobTag=new JobTags(jobTagForm.getTagName(), new Date(), 1, null);
		jobTagDAO.merge(jobTag);
		
		
		//Logic Ends
		
		return 1;
	}
	
	//Save an Entry
	public Long saveJobTag(JobTagForm jobTagForm)
	{
		//TODO: Convert Form to Entity Here	
		//Logic Starts
		
		JobTags jobTag=new JobTags(jobTagForm.getTagName(), new Date(), 1, null);
		jobTagDAO.save(jobTag);
		
		//Logic Ends
		
		return jobTag.getTagId();
	}
	
	//Update an Entry
	public int updateJobTag(JobTagForm jobTagForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		JobTags jobTag=new JobTags(jobTagForm.getTagName(), new Date(), 1, null);
		jobTagDAO.update(jobTag);
		
		//Logic Ends
		
		return 1;
	}
	
	//Delete an Entry
	public int deleteJobTag(Integer id)
	{
		jobTagDAO.delete(id);
		return 1;
	}
	
	//Delete an Entry
	public int deleteJobTagByJobId(Integer jobId)
	{
		jobTagDAO.delete(jobId);
		return 1;
	}
	
	
}

package com.deemsys.project.jobtag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.entity.JobTag;
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
	public List<String> getJobTag(Long jobId)
	{
		
		List<String> tags=new ArrayList<String>();
		List<JobTag> jobTags=jobTagDAO.getJobTagByJobId(jobId);
		//TODO: Convert Entity to Form
		//Start
		for (JobTag jobTag : jobTags) {
			tags.add(jobTag.getId().getTags());
		}
		
		//End
		
		return tags;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeJobTag(JobTagForm jobTagForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		JobTag jobTag=new JobTag();
		
		//Logic Ends
		
		
		jobTagDAO.merge(jobTag);
		return 1;
	}
	
	//Save an Entry
	public int saveJobTag(JobTagForm jobTagForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		JobTag jobTag=new JobTag();
		
		//Logic Ends
		
		jobTagDAO.save(jobTag);
		return 1;
	}
	
	//Update an Entry
	public int updateJobTag(JobTagForm jobTagForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		JobTag jobTag=new JobTag();
		
		//Logic Ends
		
		jobTagDAO.update(jobTag);
		return 1;
	}
	
	//Delete an Entry
	public int deleteJobTag(Integer id)
	{
		jobTagDAO.delete(id);
		return 1;
	}
	
	//Delete an Entry
	public int deleteJobTagByJobId(Long jobId)
	{
		jobTagDAO.deleteJobTagByJobId(jobId);
		return 1;
	}
	
}

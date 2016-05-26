package com.deemsys.project.jobtagmap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.entity.JobTagMap;
/**
 * 
 * @author Deemsys
 *
 * JobTagMap 	 - Entity
 * jobTagMap 	 - Entity Object
 * jobTagMaps 	 - Entity List
 * jobTagMapDAO   - Entity DAO
 * jobTagMapForms - EntityForm List
 * JobTagMapForm  - EntityForm
 *
 */
@Service
@Transactional
public class JobTagMapService {

	@Autowired
	JobTagMapDAO jobTagMapDAO;
	
	public List<Long> getJobTagMappedListId(Long jobId){
		List<JobTagMap> jobTagMaps=new ArrayList<JobTagMap>();
		
		List<Long> tagId=new ArrayList<Long>();
		
		jobTagMaps=jobTagMapDAO.getJobTagMapByJobId(jobId);
		for (JobTagMap jobTagMap : jobTagMaps) {
			tagId.add(jobTagMap.getId().getTagId());
		}
		
		return tagId;
	}
	
	//Get All Entries
	public List<JobTagMapForm> getJobTagMapList()
	{
		List<JobTagMapForm> jobTagMapForms=new ArrayList<JobTagMapForm>();
		
		List<JobTagMap> jobTagMaps=new ArrayList<JobTagMap>();
		
		jobTagMaps=jobTagMapDAO.getAll();
		
		for (JobTagMap jobTagMap : jobTagMaps) {
			//TODO: Fill the List
			
		}
		
		return jobTagMapForms;
	}
	
	//Get Particular Entry
	public JobTagMapForm getJobTagMap(Integer getId)
	{
		JobTagMap jobTagMap=new JobTagMap();
		
		jobTagMap=jobTagMapDAO.get(getId);
		
		//TODO: Convert Entity to Form
		//Start
		
		JobTagMapForm jobTagMapForm=new JobTagMapForm();
		
		//End
		
		return jobTagMapForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeJobTagMap(JobTagMapForm jobTagMapForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		JobTagMap jobTagMap=new JobTagMap();
		
		//Logic Ends
		
		
		jobTagMapDAO.merge(jobTagMap);
		return 1;
	}
	
	//Save an Entry
	public int saveJobTagMap(JobTagMapForm jobTagMapForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		JobTagMap jobTagMap=new JobTagMap();
		
		//Logic Ends
		
		jobTagMapDAO.save(jobTagMap);
		return 1;
	}
	
	//Update an Entry
	public int updateJobTagMap(JobTagMapForm jobTagMapForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		JobTagMap jobTagMap=new JobTagMap();
		
		//Logic Ends
		
		jobTagMapDAO.update(jobTagMap);
		return 1;
	}
	
	//Delete an Entry
	public int deleteJobTagMap(Integer id)
	{
		jobTagMapDAO.delete(id);
		return 1;
	}
	
	public void deleteJobTagMapByJobId(Long jobId){
		jobTagMapDAO.deleteJobTagMapByJobId(jobId);
	}
	
	
}

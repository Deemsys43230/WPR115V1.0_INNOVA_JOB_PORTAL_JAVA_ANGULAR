package com.deemsys.project.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.common.JobPortalConstants;
import com.deemsys.project.entity.Job;
import com.deemsys.project.entity.JobCategory;
import com.deemsys.project.entity.JobTagMap;
import com.deemsys.project.entity.JobTagMapId;
import com.deemsys.project.entity.JobTags;
import com.deemsys.project.jobtag.JobTagDAO;
import com.deemsys.project.jobtagmap.JobTagMapDAO;
import com.deemsys.project.jobtagmap.JobTagMapForm;
import com.deemsys.project.jobtagmap.JobTagMapService;
/**
 * 
 * @author Deemsys
 *
 * Job 	 - Entity
 * job 	 - Entity Object
 * jobs 	 - Entity List
 * jobDAO   - Entity DAO
 * jobForms - EntityForm List
 * JobForm  - EntityForm
 *
 */
@Service
@Transactional
public class JobService {

	@Autowired
	JobDAO jobDAO;
	
	@Autowired
	JobTagMapDAO jobTagMapDAO;
	
	@Autowired
	JobTagMapService jobTagMapService;
	
	//Get All Entries
	public List<JobForm> getJobList()
	{
		List<JobForm> jobForms=new ArrayList<JobForm>();
		
		List<Job> jobs=new ArrayList<Job>();
		
		jobs=jobDAO.getAll();
		
		for (Job job : jobs) {
			//TODO: Fill the List
			JobForm jobForm=new JobForm(job.getJobId(), job.getJobCategory().getJobCategoryId(), job.getJobCategory().getCategoryName(), job.getName(), job.getDescription(),JobPortalConstants.convertMonthFormat(job.getAddedDate()), job.getIsEnable(), job.getStatus());
			jobForm.setJobTagId(jobTagMapService.getJobTagMappedListId(job.getJobId()));
			jobForms.add(jobForm);
		}
		
		return jobForms;
	}
	
	//Get Particular Entry
	public JobForm getJob(Long jobId)
	{
		Job job=new Job();
		
		job=jobDAO.getJobById(jobId);
		
		//TODO: Convert Entity to Form
		//Start
		JobForm jobForm=new JobForm(job.getJobId(), job.getJobCategory().getJobCategoryId(), job.getJobCategory().getCategoryName(),job.getName(), job.getDescription(),JobPortalConstants.convertMonthFormat(job.getAddedDate()), job.getIsEnable(), job.getStatus());
		jobForm.setJobTagMapForms(jobTagMapService.getJobTagMapListByJobId(jobId));
		//End
		
		return jobForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeJob(JobForm jobForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		JobCategory jobCategory=new JobCategory();
		jobCategory.setJobCategoryId(jobForm.getJobCategoryId());
		Job job=new Job(jobCategory, jobForm.getName(), jobForm.getDescription(), new Date(), jobForm.getIsEnable(), jobForm.getStatus(), null);
		job.setJobId(jobForm.getJobId());
		
		//Logic Ends
		
		
		jobDAO.merge(job);
		return 1;
	}
	
	//Save an Entry
	public int saveJob(JobForm jobForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		JobCategory jobCategory=new JobCategory();
		jobCategory.setJobCategoryId(jobForm.getJobCategoryId());
		Job job=new Job(jobCategory, jobForm.getName(), jobForm.getDescription(), new Date(), jobForm.getIsEnable(), jobForm.getStatus(), null);
		
		//Logic Ends
		jobDAO.save(job);
		
		for (Long tagId : jobForm.getJobTagId()) {
			JobTagMapId jobTagMapId=new JobTagMapId(job.getJobId(), tagId, 1);
			JobTags jobTags=new JobTags();
			jobTags.setTagId(tagId);
			JobTagMap jobTagMap=new JobTagMap(jobTagMapId, jobTags, job);
			jobTagMapDAO.save(jobTagMap);
		}
		return 1;
	}
	
	//Update an Entry
	public int updateJob(JobForm jobForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		JobCategory jobCategory=new JobCategory();
		jobCategory.setJobCategoryId(jobForm.getJobCategoryId());
		Job job=new Job(jobCategory, jobForm.getName(), jobForm.getDescription(), new Date(), jobForm.getIsEnable(), jobForm.getStatus(), null);
		job.setJobId(jobForm.getJobId());
		
		jobDAO.update(job);
		
		// Delete Job Tag By Job Id
		 jobTagMapDAO.deleteJobTagMapByJobId(jobForm.getJobId());
		 
		// Insert Job Tags
		 for (Long tagId : jobForm.getJobTagId()) {
				JobTagMapId jobTagMapId=new JobTagMapId(job.getJobId(), tagId, 1);
				JobTags jobTags=new JobTags();
				jobTags.setTagId(tagId);
				JobTagMap jobTagMap=new JobTagMap(jobTagMapId, jobTags, job);
				jobTagMapDAO.save(jobTagMap);
		}
		//Logic Ends
		return 1;
	}
	
	//Delete an Entry
	public int deleteJob(Integer id)
	{
		jobDAO.delete(id);
		return 1;
	}
	
	// Enable or Disable Job
	public Integer enableOrDisableJob(Long jobId){
		
		Job job=jobDAO.getJobById(jobId);
		if(job.getIsEnable()==1){
			job.setIsEnable(0);
		}else{
			job.setIsEnable(1);
		}
		
		jobDAO.merge(job);
		
		return 1;
	}
	
	//Get All Enabled Entries For User
	public List<JobForm> getAllJobsForUser()
	{
		List<JobForm> jobForms=new ArrayList<JobForm>();
			
		List<Job> jobs=new ArrayList<Job>();
			
		jobs=jobDAO.getAllJobsForUser();
			
		for (Job job : jobs) {
			//TODO: Fill the List
			JobForm jobForm=new JobForm(job.getJobId(), job.getJobCategory().getJobCategoryId(), job.getJobCategory().getCategoryName(), job.getName(), job.getDescription(),JobPortalConstants.convertMonthFormat(job.getAddedDate()), job.getIsEnable(), job.getStatus());
			jobForm.setJobTagId(jobTagMapService.getJobTagMappedListId(job.getJobId()));
			jobForms.add(jobForm);
		}
			
		return jobForms;
	}
	
	// get Jobs Count
	public Integer getJobCount(){
		return jobDAO.getAll().size();
	}
	
}

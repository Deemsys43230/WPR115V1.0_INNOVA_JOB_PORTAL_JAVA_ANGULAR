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
import com.deemsys.project.entity.JobTag;
import com.deemsys.project.entity.JobTagId;
import com.deemsys.project.jobtag.JobTagDAO;
import com.deemsys.project.jobtag.JobTagService;
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
	JobTagService jobTagService;
	
	@Autowired
	JobTagDAO jobTagDAO;
	
	//Get All Entries
	public List<JobForm> getJobList()
	{
		List<JobForm> jobForms=new ArrayList<JobForm>();
		
		List<Job> jobs=new ArrayList<Job>();
		
		jobs=jobDAO.getAll();
		
		for (Job job : jobs) {
			//TODO: Fill the List
			JobForm jobForm=new JobForm(job.getJobId(), job.getJobCategory().getJobCategoryId(), job.getName(), job.getDescription(),JobPortalConstants.convertMonthFormat(job.getAddedDate()), job.getIsEnable(), job.getStatus());
			jobForm.setJobTags(jobTagService.getJobTag(job.getJobId()));
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
		JobForm jobForm=new JobForm(job.getJobId(), job.getJobCategory().getJobCategoryId(), job.getName(), job.getDescription(),JobPortalConstants.convertMonthFormat(job.getAddedDate()), job.getIsEnable(), job.getStatus());
		jobForm.setJobTags(jobTagService.getJobTag(jobId));
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
		
		
		
		for (String tag : jobForm.getJobTags()) {
			JobTagId jobTagId=new JobTagId(job.getJobId(), tag, 1);
			JobTag jobTag=new JobTag(jobTagId, job);
			jobTagDAO.save(jobTag);
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
		 jobTagService.deleteJobTagByJobId(jobForm.getJobId());
		 
		// Insert Job Tags
		 for (String tag : jobForm.getJobTags()) {
			JobTagId jobTagId=new JobTagId(job.getJobId(), tag, 1);
			JobTag jobTag=new JobTag(jobTagId, job);
			jobTagDAO.save(jobTag);
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
	
}

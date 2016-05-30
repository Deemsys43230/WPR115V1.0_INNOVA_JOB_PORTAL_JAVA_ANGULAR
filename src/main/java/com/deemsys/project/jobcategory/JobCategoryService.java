package com.deemsys.project.jobcategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.entity.JobCategory;
/**
 * 
 * @author Deemsys
 *
 * JobCategory 	 - Entity
 * jobCategory 	 - Entity Object
 * jobCategorys 	 - Entity List
 * jobCategoryDAO   - Entity DAO
 * jobCategoryForms - EntityForm List
 * JobCategoryForm  - EntityForm
 *
 */
@Service
@Transactional
public class JobCategoryService {

	@Autowired
	JobCategoryDAO jobCategoryDAO;
	
	//Get All Entries
	public List<JobCategoryForm> getJobCategoryList()
	{
		List<JobCategoryForm> jobCategoryForms=new ArrayList<JobCategoryForm>();
		
		List<JobCategory> jobCategorys=new ArrayList<JobCategory>();
		
		jobCategorys=jobCategoryDAO.getAll();
		
		for (JobCategory jobCategory : jobCategorys) {
			//TODO: Fill the List
			jobCategoryForms.add(new JobCategoryForm(jobCategory.getJobCategoryId(), jobCategory.getCategoryName(), jobCategory.getDescription(), jobCategory.getIsJobAvailable(), jobCategory.getStatus()));
		}
		
		return jobCategoryForms;
	}
	
	//Get Particular Entry
	public JobCategoryForm getJobCategory(Integer getId)
	{
		JobCategory jobCategory=new JobCategory();
		
		jobCategory=jobCategoryDAO.get(getId);
		
		//TODO: Convert Entity to Form
		//Start
		
		JobCategoryForm jobCategoryForm=new JobCategoryForm(jobCategory.getJobCategoryId(), jobCategory.getCategoryName(), jobCategory.getDescription(), jobCategory.getIsJobAvailable(), jobCategory.getStatus());
		
		//End
		
		return jobCategoryForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeJobCategory(JobCategoryForm jobCategoryForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		JobCategory jobCategory=new JobCategory(jobCategoryForm.getCategoryName(), jobCategoryForm.getDescription(), jobCategoryForm.getIsJobAvailable(), jobCategoryForm.getStatus(), null);
		jobCategory.setJobCategoryId(jobCategoryForm.getJobCategoryId());
		//Logic Ends
		
		
		jobCategoryDAO.merge(jobCategory);
		return 1;
	}
	
	//Save an Entry
	public int saveJobCategory(JobCategoryForm jobCategoryForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		JobCategory jobCategory=new JobCategory(jobCategoryForm.getCategoryName(), jobCategoryForm.getDescription(), jobCategoryForm.getIsJobAvailable(), jobCategoryForm.getStatus(), null);
		
		//Logic Ends
		
		jobCategoryDAO.save(jobCategory);
		return 1;
	}
	
	//Update an Entry
	public int updateJobCategory(JobCategoryForm jobCategoryForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		JobCategory jobCategory=new JobCategory();
		
		//Logic Ends
		
		jobCategoryDAO.update(jobCategory);
		return 1;
	}
	
	//Delete an Entry
	public int deleteJobCategory(Integer id)
	{
		jobCategoryDAO.delete(id);
		return 1;
	}
	
	//Enable Disable
	public void enableDisableJobCategory(Integer docTypeId) {
		// TODO Auto-generated method stub
		JobCategory jobCategory=jobCategoryDAO.get(docTypeId);
		if(jobCategory.getStatus()==1)
			jobCategory.setStatus(0);
		else
			jobCategory.setStatus(1);
		
		jobCategoryDAO.merge(jobCategory);
	}
	
	
	//Get All Entries
	public List<JobCategoryForm> getJobCategoryListForUser()
	{
		List<JobCategoryForm> jobCategoryForms=new ArrayList<JobCategoryForm>();
		
		List<JobCategory> jobCategorys=new ArrayList<JobCategory>();
			
		jobCategorys=jobCategoryDAO.getJobCategoryListForUser();
			
		for (JobCategory jobCategory : jobCategorys) {
			//TODO: Fill the List
			jobCategoryForms.add(new JobCategoryForm(jobCategory.getJobCategoryId(), jobCategory.getCategoryName(), jobCategory.getDescription(), jobCategory.getIsJobAvailable(), jobCategory.getStatus()));
		}
			
		return jobCategoryForms;
	}
}

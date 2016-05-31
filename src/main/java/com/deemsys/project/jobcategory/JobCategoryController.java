
package com.deemsys.project.jobcategory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deemsys.project.job.JobForm;

/**
 * 
 * @author Deemsys
 *
 */
@Controller
public class JobCategoryController {
	
	@Autowired
	JobCategoryService jobCategoryService;

    @RequestMapping(value="/Admin/getJobCategory",method=RequestMethod.GET)
	public String getJobCategory(@RequestParam("id") Integer id,ModelMap model)
	{
    	model.addAttribute("jobCategoryForm",jobCategoryService.getJobCategory(id));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/Admin/mergeJobCategory",method=RequestMethod.POST)
   	public String mergeJobCategory(@RequestBody JobCategoryForm jobCategoryForm,ModelMap model)
   	{
    	jobCategoryService.mergeJobCategory(jobCategoryForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/saveUpdateJobCategory",method=RequestMethod.POST)
   	public String saveJobCategory(@RequestBody JobCategoryForm jobCategoryForm,ModelMap model)
   	{
    	jobCategoryService.mergeJobCategory(jobCategoryForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="/Admin/deleteJobCategory",method=RequestMethod.POST)
   	public String deleteJobCategory(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	model.addAttribute("isDelete",jobCategoryService.deleteJobCategory(id));
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/deleteJobCategoryWithJob",method=RequestMethod.POST)
   	public String deleteJobCategoryWithJob(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	jobCategoryService.deleteJobCategoryWithJob(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/getAllJobCategorys",method=RequestMethod.GET)
   	public String getAllJobCategorys(ModelMap model)
   	{
    	model.addAttribute("jobCategoryForms",jobCategoryService.getJobCategoryList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/getAllJobCategorysForUser",method=RequestMethod.GET)
   	public String getAllJobCategorysForUser(ModelMap model)
   	{
    	model.addAttribute("jobCategoryForms",jobCategoryService.getJobCategoryListForUser());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/enableDisableJobCategory",method=RequestMethod.POST)
   	public String enableDisableJobCategory(@RequestParam("id") Integer jobCategoryId,ModelMap model)
   	{
    	jobCategoryService.enableDisableJobCategory(jobCategoryId);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
    
    // Check Job Category Exist
    @RequestMapping(value="/Admin/checkJobCategoryExist",method=RequestMethod.POST)
   	public String getJobCategoryExist(@RequestBody JobCategoryForm jobCategoryForm,ModelMap model)
   	{
    	model.addAttribute("isJobCategoryExist",jobCategoryService.checkJobCategory(jobCategoryForm));
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
}

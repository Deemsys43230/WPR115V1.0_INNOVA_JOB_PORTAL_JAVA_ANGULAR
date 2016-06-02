
package com.deemsys.project.job;


import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Deemsys
 *
 */
@Controller
public class JobController {
	
	@Autowired
	JobService jobService;
	
	@Resource(name="appProperties")
	private Properties appProperties;

    @RequestMapping(value="/Admin/getJob",method=RequestMethod.GET)
	public String getJob(@RequestParam("jobId") Long jobId,ModelMap model)
	{
    	model.addAttribute("jobForm",jobService.getJob(jobId));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/Admin/mergeJob",method=RequestMethod.POST)
   	public String mergeJob(@RequestBody JobForm jobForm,ModelMap model)
   	{
    	jobService.mergeJob(jobForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/saveUpdateJob",method=RequestMethod.POST)
   	public String saveJob(@RequestBody JobForm jobForm,ModelMap model)
   	{
    	if(jobForm.getJobId()==null)
    		jobService.saveJob(jobForm);
    	else
    		jobService.updateJob(jobForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="/Admin/deleteJob",method=RequestMethod.POST)
   	public String deleteJob(@RequestParam("jobId") Long jobId,ModelMap model)
   	{
    	
    	jobService.deleteJob(jobId);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/getJobCount",method=RequestMethod.GET)
   	public String getJobCount(ModelMap model)
   	{
    	model.addAttribute("jobCount",jobService.getJobCount());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/getAllJobs",method=RequestMethod.GET)
   	public String getAllJobs(ModelMap model)
   	{
    	model.addAttribute("jobForms",jobService.getJobList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
        
    @RequestMapping(value="/Admin/enableDisableJob",method=RequestMethod.POST)
   	public String enableDisableJob(@RequestParam("jobId") Long jobId,ModelMap model)
   	{
    	jobService.enableOrDisableJob(jobId);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
    
    // User Side Search Job
    @RequestMapping(value="/searchJobs",method=RequestMethod.POST)
   	public String searchJobs(@RequestBody JobSearchForm jobSearchForm,ModelMap model)
   	{
    	model.addAttribute("jobForms",jobService.searchJobs(jobSearchForm));
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    // User Side Get Job Details
    @RequestMapping(value="/getJobDetailsForUser",method=RequestMethod.GET)
	public String getJobDetailsForUser(@RequestParam("jobId") Long jobId,ModelMap model)
	{
    	model.addAttribute("jobForm",jobService.getJob(jobId));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	

    // Check Job Title Exist
    @RequestMapping(value="Admin/checkJobTitleExist",method=RequestMethod.POST)
   	public String getJobTitleExist(@RequestBody JobForm jobForm,ModelMap model)
   	{
    	model.addAttribute("isJobExist",jobService.checkJobTitle(jobForm));
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    //For Sharing
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
   	public String get(@PathVariable Long id,ModelMap model)
   	{
    	JobForm jobForm=jobService.getJob(id);
    	model.addAttribute("title",jobForm.getName()+" - Innova Consultancy Group");
       	model.addAttribute("description",jobForm.getDescription().replaceAll("\\<.*?\\>", ""));
       	model.addAttribute("url",appProperties.getProperty("appLink")+id+"#/jobs-details/"+id);
       	model.addAttribute("image",appProperties.getProperty("appLink")+"resources/images/jobs-openings.jpg");
   		return "/index";
   	}
}

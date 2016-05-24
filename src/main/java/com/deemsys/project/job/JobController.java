
package com.deemsys.project.job;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
   	public String deleteJob(@RequestParam("jobId") Integer jobId,ModelMap model)
   	{
    	
    	jobService.deleteJob(jobId);
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
}

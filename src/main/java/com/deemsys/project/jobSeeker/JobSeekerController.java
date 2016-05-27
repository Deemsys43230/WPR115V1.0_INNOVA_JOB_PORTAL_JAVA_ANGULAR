
package com.deemsys.project.jobSeeker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.deemsys.project.jobSeeker.JobSeekerForm;
import com.deemsys.project.jobSeeker.JobSeekerService;

/**
 * 
 * @author Deemsys
 *
 */
@Controller
public class JobSeekerController {
	
	@Autowired
	JobSeekerService jobSeekerService;

    @RequestMapping(value="Admin/getJobSeeker",method=RequestMethod.GET)
	public String getJobSeeker(@RequestParam("id") String id,ModelMap model)
	{
    	model.addAttribute("jobSeekerForm",jobSeekerService.getJobSeeker(id));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/mergeJobSeeker",method=RequestMethod.POST)
   	public String mergeJobSeeker(@ModelAttribute("jobSeekerForm") JobSeekerForm jobSeekerForm,ModelMap model)
   	{
    	jobSeekerService.mergeJobSeeker(jobSeekerForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/updateJobSeeker",method=RequestMethod.POST)
   	public String saveJobSeeker(@RequestBody JobSeekerForm jobSeekerForm,ModelMap model)
   	{
    	jobSeekerService.updateJobSeeker(jobSeekerForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/saveResume",method=RequestMethod.POST)
   	public String saveResume(@RequestParam("resume") MultipartFile resumeFile,ModelMap model)
   	{
    	model.addAttribute("jobSeekerId",jobSeekerService.saveResume(resumeFile));
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
       
    @RequestMapping(value="Admin/deleteJobSeeker",method=RequestMethod.POST)
   	public String deleteJobSeeker(@RequestParam("id") String id,ModelMap model)
   	{
    	
    	jobSeekerService.deleteJobSeeker(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="Admin/getAllJobSeekers",method=RequestMethod.GET)
   	public String getAllJobSeekers(ModelMap model)
   	{
    	model.addAttribute("jobSeekerForms",jobSeekerService.getJobSeekerList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
}

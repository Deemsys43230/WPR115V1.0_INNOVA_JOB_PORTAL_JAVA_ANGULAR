
package com.deemsys.project.jobtag;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deemsys.project.jobtag.JobTagForm;
import com.deemsys.project.jobtag.JobTagService;

/**
 * 
 * @author Deemsys
 *
 */
@Controller
public class JobTagController {
	
	@Autowired
	JobTagService jobTagService;

    @RequestMapping(value="/Admin/getJobTag",method=RequestMethod.GET)
	public String getJobTag(@RequestParam("id") Long id,ModelMap model)
	{
    	model.addAttribute("jobTagForm",jobTagService.getJobTag(id));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/Admin/mergeJobTag",method=RequestMethod.POST)
   	public String mergeJobTag(@RequestBody JobTagForm jobTagForm,ModelMap model)
   	{
    	jobTagService.mergeJobTag(jobTagForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/saveUpdateJobTag",method=RequestMethod.POST)
   	public String saveJobTag(@RequestBody JobTagForm jobTagForm,ModelMap model)
   	{
    	model.addAttribute("tagId",jobTagService.saveJobTag(jobTagForm));
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="/Admin/deleteJobTag",method=RequestMethod.POST)
   	public String deleteJobTag(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	jobTagService.deleteJobTag(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/getAllJobTags",method=RequestMethod.GET)
   	public String getAllJobTags(ModelMap model)
   	{
    	model.addAttribute("jobTagForms",jobTagService.getJobTagList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
}

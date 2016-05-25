
package com.deemsys.project.resumedetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.deemsys.project.resumedetail.ResumeDetailForm;
import com.deemsys.project.resumedetail.ResumeDetailService;

/**
 * 
 * @author Deemsys
 *
 */
@Controller
public class ResumeDetailController {
	
	@Autowired
	ResumeDetailService resumeDetailService;

    @RequestMapping(value="Admin/getResumeDetail",method=RequestMethod.GET)
	public String getResumeDetail(@RequestParam("id") String id,ModelMap model)
	{
    	model.addAttribute("resumeDetailForm",resumeDetailService.getResumeDetail(id));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/mergeResumeDetail",method=RequestMethod.POST)
   	public String mergeResumeDetail(@RequestParam("uploadFile") MultipartFile uploadFile,ModelMap model)
   	{
    	model.addAttribute("uploadedFileInfo",resumeDetailService.mergeResumeDetail(uploadFile));
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/saveUpdateResumeDetail",method=RequestMethod.POST)
   	public String saveResumeDetail(@RequestParam("uploadFile") MultipartFile uploadFile,ModelMap model)
   	{
    	model.addAttribute("uploadedFileInfo",resumeDetailService.mergeResumeDetail(uploadFile));
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="Admin/deleteResumeDetail",method=RequestMethod.POST)
   	public String deleteResumeDetail(@RequestParam("id") String id,ModelMap model)
   	{
    	
    	resumeDetailService.deleteResumeDetail(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="Admin/getAllResumeDetails",method=RequestMethod.GET)
   	public String getAllResumeDetails(ModelMap model)
   	{
    	model.addAttribute("resumeDetailForms",resumeDetailService.getResumeDetailList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
}

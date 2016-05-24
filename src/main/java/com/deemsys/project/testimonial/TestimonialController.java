
package com.deemsys.project.testimonial;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deemsys.project.testimonial.TestimonialForm;
import com.deemsys.project.testimonial.TestimonialService;

/**
 * 
 * @author Deemsys
 *
 */
@Controller
public class TestimonialController {
	
	@Autowired
	TestimonialService testimonialService;

    @RequestMapping(value="/Admin/getTestimonial",method=RequestMethod.GET)
	public String getTestimonial(@RequestParam("testimonialId") Long testimonialId,ModelMap model)
	{
    	model.addAttribute("testimonialForm",testimonialService.getTestimonial(testimonialId));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/Admin/mergeTestimonial",method=RequestMethod.POST)
   	public String mergeTestimonial(@RequestBody TestimonialForm testimonialForm,ModelMap model)
   	{
    	testimonialService.mergeTestimonial(testimonialForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/saveUpdateTestimonial",method=RequestMethod.POST)
   	public String saveTestimonial(@RequestBody TestimonialForm testimonialForm,ModelMap model)
   	{
    	if(testimonialForm.getTestimonialId().equals(""))
    		testimonialService.saveTestimonial(testimonialForm);
    	else
    		testimonialService.updateTestimonial(testimonialForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="/Admin/deleteTestimonial",method=RequestMethod.POST)
   	public String deleteTestimonial(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	testimonialService.deleteTestimonial(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/getAllTestimonials",method=RequestMethod.GET)
   	public String getAllTestimonials(ModelMap model)
   	{
    	model.addAttribute("testimonialForms",testimonialService.getTestimonialList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/enableDisableTestimonial",method=RequestMethod.POST)
   	public String enableDisableTestimonial(@RequestParam("testimonialId") Long testimonialId,ModelMap model)
   	{
    	testimonialService.enableOrDisbaleTestimonial(testimonialId);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
}

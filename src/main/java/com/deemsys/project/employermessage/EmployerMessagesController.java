
package com.deemsys.project.employermessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deemsys.project.employermessage.EmployerMessagesForm;
import com.deemsys.project.employermessage.EmployerMessagesService;

/**
 * 
 * @author Deemsys
 *
 */
@Controller
public class EmployerMessagesController {
	
	@Autowired
	EmployerMessagesService employerMessagesService;

    @RequestMapping(value="Admin/getEmployerMessages",method=RequestMethod.GET)
	public String getEmployerMessages(@RequestParam("id") Integer id,ModelMap model)
	{
    	model.addAttribute("employerMessagesForm",employerMessagesService.getEmployerMessages(id));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/mergeEmployerMessages",method=RequestMethod.POST)
   	public String mergeEmployerMessages(@RequestBody EmployerMessagesForm employerMessagesForm,ModelMap model)
   	{
    	employerMessagesService.mergeEmployerMessages(employerMessagesForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/saveUpdateEmployerMessages",method=RequestMethod.POST)
   	public String saveEmployerMessages(@RequestBody EmployerMessagesForm employerMessagesForm,ModelMap model)
   	{
    	if(employerMessagesForm.getId().equals(""))
    		employerMessagesService.saveEmployerMessages(employerMessagesForm);
    	else
    		employerMessagesService.updateEmployerMessages(employerMessagesForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="Admin/deleteEmployerMessages",method=RequestMethod.POST)
   	public String deleteEmployerMessages(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	employerMessagesService.deleteEmployerMessages(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="Admin/getAllEmployerMessagess",method=RequestMethod.GET)
   	public String getAllEmployerMessagess(ModelMap model)
   	{
    	model.addAttribute("employerMessagesForms",employerMessagesService.getEmployerMessagesList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
}

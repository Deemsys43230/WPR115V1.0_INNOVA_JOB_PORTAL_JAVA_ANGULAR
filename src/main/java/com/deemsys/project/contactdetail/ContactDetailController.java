
package com.deemsys.project.contactdetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class ContactDetailController {
	
	@Autowired
	ContactDetailService contactDetailService;

    @RequestMapping(value="/getContactDetail",method=RequestMethod.GET)
	public String getContactDetail(@RequestParam("id") Integer id,ModelMap model)
	{
    	model.addAttribute("contactDetailForm",contactDetailService.getContactDetail(id));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="Admin/mergeContactDetail",method=RequestMethod.POST)
   	public String mergeContactDetail(@RequestBody ContactDetailForm contactDetailForm,ModelMap model)
   	{
    	contactDetailService.mergeContactDetail(contactDetailForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="Admin/saveUpdateContactDetail",method=RequestMethod.POST)
   	public String saveContactDetail(@RequestBody ContactDetailForm contactDetailForm,ModelMap model)
   	{
    	contactDetailService.mergeContactDetail(contactDetailForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="Admin/deleteContactDetail",method=RequestMethod.POST)
   	public String deleteContactDetail(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	contactDetailService.deleteContactDetail(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/getAllContactDetails",method=RequestMethod.GET)
   	public String getAllContactDetails(ModelMap model)
   	{
    	model.addAttribute("contactDetailForms",contactDetailService.getContactDetailList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
}

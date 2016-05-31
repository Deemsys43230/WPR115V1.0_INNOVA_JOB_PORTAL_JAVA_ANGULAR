
package com.deemsys.project.contactmessages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deemsys.project.contactmessages.ContactMessagesForm;
import com.deemsys.project.contactmessages.ContactMessagesService;

/**
 * 
 * @author Deemsys
 *
 */
@Controller
public class ContactMessagesController {
	
	@Autowired
	ContactMessagesService contactMessagesService;

    @RequestMapping(value="Admin/getContactMessages",method=RequestMethod.GET)
	public String getContactMessages(@RequestParam("id") Integer id,ModelMap model)
	{
    	model.addAttribute("contactMessagesForm",contactMessagesService.getContactMessages(id));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/mergeContactMessages",method=RequestMethod.POST)
   	public String mergeContactMessages(@RequestBody ContactMessagesForm contactMessagesForm,ModelMap model)
   	{
    	contactMessagesService.mergeContactMessages(contactMessagesForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/saveUpdateContactMessages",method=RequestMethod.POST)
   	public String saveContactMessages(@RequestBody ContactMessagesForm contactMessagesForm,ModelMap model)
   	{
    	if(contactMessagesForm.getId().equals(""))
    		contactMessagesService.saveContactMessages(contactMessagesForm);
    	else
    		contactMessagesService.updateContactMessages(contactMessagesForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="Admin/deleteContactMessages",method=RequestMethod.POST)
   	public String deleteContactMessages(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	contactMessagesService.deleteContactMessages(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="Admin/getAllContactMessagess",method=RequestMethod.GET)
   	public String getAllContactMessagess(ModelMap model)
   	{
    	model.addAttribute("contactMessagesForms",contactMessagesService.getContactMessagesList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="Admin/getMessagesCountUnread",method=RequestMethod.GET)
   	public String getEmployerCount(ModelMap model)
   	{
    	model.addAttribute("contactMessageCount",contactMessagesService.contactMessageCountUnread());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/markAsRead",method=RequestMethod.POST)
   	public String enableDisableJobCategory(@RequestParam("id") Integer contactMessageId,ModelMap model)
   	{
    	contactMessagesService.markAsRead(contactMessageId);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
}

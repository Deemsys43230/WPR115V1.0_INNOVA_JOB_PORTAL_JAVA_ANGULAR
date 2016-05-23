
package com.deemsys.project.socialmedia;


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
public class SocialMediaController {
	
	@Autowired
	SocialMediaService socialMediaService;

    @RequestMapping(value="/getSocialMedia",method=RequestMethod.GET)
	public String getSocialMedia(@RequestParam("id") Integer id,ModelMap model)
	{
    	model.addAttribute("socialMediaForm",socialMediaService.getSocialMedia(id));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="Admin/mergeSocialMedia",method=RequestMethod.POST)
   	public String mergeSocialMedia(@RequestBody SocialMediaForm socialMediaForm,ModelMap model)
   	{
    	socialMediaService.mergeSocialMedia(socialMediaForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="Admin/saveUpdateSocialMedia",method=RequestMethod.POST)
   	public String saveSocialMedia(@RequestBody SocialMediaForm socialMediaForm,ModelMap model)
   	{
    	socialMediaService.mergeSocialMedia(socialMediaForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="Admin/deleteSocialMedia",method=RequestMethod.POST)
   	public String deleteSocialMedia(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	socialMediaService.deleteSocialMedia(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/getAllSocialMedias",method=RequestMethod.GET)
   	public String getAllSocialMedias(ModelMap model)
   	{
    	model.addAttribute("socialMediaForms",socialMediaService.getSocialMediaList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
}

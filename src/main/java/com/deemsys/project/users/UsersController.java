
package com.deemsys.project.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Deemsys
 *
 */
@Controller
public class UsersController {
	
	@Autowired
	UsersService UsersService;

    @RequestMapping(value="/getUsers",method=RequestMethod.GET)
	public String getUsers(@RequestParam("id") Integer id,ModelMap model)
	{
    	model.addAttribute("UsersForm",UsersService.getUsers(id));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/mergeUsers",method=RequestMethod.POST)
   	public String mergeUsers(@ModelAttribute("UsersForm") UsersForm UsersForm,ModelMap model)
   	{
    	UsersService.mergeUsers(UsersForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/saveUpdateUsers",method=RequestMethod.POST)
   	public String saveUsers(@ModelAttribute("UsersForm") UsersForm UsersForm,ModelMap model)
   	{
    	if(UsersForm.getBlogId().equals(""))
    		UsersService.saveUsers(UsersForm);
    	else
    		UsersService.updateUsers(UsersForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="/deleteUsers",method=RequestMethod.POST)
   	public String deleteUsers(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	UsersService.deleteUsers(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/getAllUserss",method=RequestMethod.GET)
   	public String getAllUserss(ModelMap model)
   	{
    	model.addAttribute("UsersForms",UsersService.getUsersList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
}

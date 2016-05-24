
package com.deemsys.project.login;


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
public class LoginController {
	
	@Autowired
	LoginService loginService;

	// Login Page
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(ModelMap model)
	{
    	model.addAttribute("requestSuccess",true);
		return "/login";
	}
	
	// Dashboard Page
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String adminDashboard(ModelMap model)
	{
    	model.addAttribute("requestSuccess",true);
		return "/home";
	}
	
    @RequestMapping(value="/getLogin",method=RequestMethod.GET)
	public String getLogin(@RequestParam("id") Integer id,ModelMap model)
	{
    	model.addAttribute("loginForm",loginService.getLogin(id));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/mergeLogin",method=RequestMethod.POST)
   	public String mergeLogin(@ModelAttribute("loginForm") LoginForm loginForm,ModelMap model)
   	{
    	loginService.mergeLogin(loginForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/saveUpdateLogin",method=RequestMethod.POST)
   	public String saveLogin(@ModelAttribute("loginForm") LoginForm loginForm,ModelMap model)
   	{
    	loginService.updateLogin(loginForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="/deleteLogin",method=RequestMethod.POST)
   	public String deleteLogin(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	loginService.deleteLogin(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/getAllLogins",method=RequestMethod.GET)
   	public String getAllLogins(ModelMap model)
   	{
    	model.addAttribute("loginForms",loginService.getLoginList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
}

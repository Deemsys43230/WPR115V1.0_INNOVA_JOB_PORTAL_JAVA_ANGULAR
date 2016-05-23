package com.deemsys.project.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Deemsys
 * 
 */
@Controller
public class LoginController {
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getDashboard(ModelMap model) {
		model.addAttribute("requestSuccess", true);
		return "/login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex(ModelMap model) {
		model.addAttribute("requestSuccess", true);
		return "/index";
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public @ResponseBody String getDashboard1(ModelMap model) {
		model.addAttribute("requestSuccess", true);
		return "Success";
	}
}

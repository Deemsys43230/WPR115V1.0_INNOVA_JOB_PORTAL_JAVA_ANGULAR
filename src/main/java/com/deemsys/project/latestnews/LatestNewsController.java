
package com.deemsys.project.latestnews;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deemsys.project.latestnews.LatestNewsForm;
import com.deemsys.project.latestnews.LatestNewsService;

/**
 * 
 * @author Deemsys
 *
 */
@Controller
public class LatestNewsController {
	
	@Autowired
	LatestNewsService latestNewsService;

    @RequestMapping(value="/getLatestNews",method=RequestMethod.GET)
	public String getLatestNews(@RequestParam("latestNewsId") Long latestNewsId,ModelMap model)
	{
    	model.addAttribute("latestNewsForm",latestNewsService.getLatestNews(latestNewsId));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/Admin/mergeLatestNews",method=RequestMethod.POST)
   	public String mergeLatestNews(@RequestBody LatestNewsForm latestNewsForm,ModelMap model)
   	{
    	latestNewsService.mergeLatestNews(latestNewsForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/saveUpdateLatestNews",method=RequestMethod.POST)
   	public String saveLatestNews(@RequestBody LatestNewsForm latestNewsForm,ModelMap model)
   	{
    	if(latestNewsForm.getLatestNewsId()==null)
    		latestNewsService.saveLatestNews(latestNewsForm);
    	else
    		latestNewsService.updateLatestNews(latestNewsForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="/Admin/deleteLatestNews",method=RequestMethod.POST)
   	public String deleteLatestNews(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	latestNewsService.deleteLatestNews(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/getAllLatestNewss",method=RequestMethod.GET)
   	public String getAllLatestNewss(ModelMap model)
   	{
    	model.addAttribute("latestNewsForms",latestNewsService.getLatestNewsList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
    
    @RequestMapping(value="/Admin/enableDisableNews",method=RequestMethod.POST)
   	public String enableDisableNews(@RequestParam("latestNewsId") Long latestNewsId,ModelMap model)
   	{
    	latestNewsService.enableOrDisbaleNews(latestNewsId);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
}


package com.deemsys.project.documentLocation;


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
public class DocumentLocationController {
	
	@Autowired
	DocumentService documentLocationService;

    @RequestMapping(value="/Admin/getDocumentLocation",method=RequestMethod.GET)
	public String getDocumentLocation(@RequestParam("id") Integer id,ModelMap model)
	{
    	model.addAttribute("documentLocationForm",documentLocationService.getDocumentLocation(id));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/Admin/mergeDocumentLocation",method=RequestMethod.POST)
   	public String mergeDocumentLocation(@ModelAttribute("documentLocationForm") DocumentLocationForm documentLocationForm,ModelMap model)
   	{
    	documentLocationService.mergeDocumentLocation(documentLocationForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/saveUpdateDocumentLocation",method=RequestMethod.POST)
   	public String saveDocumentLocation(@ModelAttribute("documentLocationForm") DocumentLocationForm documentLocationForm,ModelMap model)
   	{
    	
    	documentLocationService.saveDocumentLocation(documentLocationForm);
       	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="/Admin/deleteDocumentLocation",method=RequestMethod.POST)
   	public String deleteDocumentLocation(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	documentLocationService.deleteDocumentLocation(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/getAllDocumentLocations",method=RequestMethod.GET)
   	public String getAllDocumentLocations(ModelMap model)
   	{
    	model.addAttribute("documentLocationForms",documentLocationService.getDocumentLocationList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
}

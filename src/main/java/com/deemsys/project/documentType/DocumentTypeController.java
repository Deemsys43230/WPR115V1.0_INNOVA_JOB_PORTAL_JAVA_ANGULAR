
package com.deemsys.project.documentType;


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
public class DocumentTypeController {
	
	@Autowired
	DocumentTypeService documentTypeService;

    @RequestMapping(value="/Admin/getDocumentType",method=RequestMethod.GET)
	public String getDocumentType(@RequestParam("id") Integer id,ModelMap model)
	{
    	model.addAttribute("documentTypeForm",documentTypeService.getDocumentType(id));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
	
    
    @RequestMapping(value="/Admin/mergeDocumentType",method=RequestMethod.POST)
   	public String mergeDocumentType(@ModelAttribute("documentTypeForm") DocumentTypeForm documentTypeForm,ModelMap model)
   	{
    	documentTypeService.mergeDocumentType(documentTypeForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/saveUpdateDocumentType",method=RequestMethod.POST)
   	public String saveDocumentType(@RequestBody DocumentTypeForm documentTypeForm,ModelMap model)
   	{
    	documentTypeService.mergeDocumentType(documentTypeForm);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
   
    
    @RequestMapping(value="/Admin/deleteDocumentType",method=RequestMethod.POST)
   	public String deleteDocumentType(@RequestParam("id") Integer id,ModelMap model)
   	{
    	
    	documentTypeService.deleteDocumentType(id);
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
    
    @RequestMapping(value="/Admin/getAllDocumentTypes",method=RequestMethod.GET)
   	public String getAllDocumentTypes(ModelMap model)
   	{
    	model.addAttribute("documentTypeForms",documentTypeService.getDocumentTypeList());
    	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}	
}

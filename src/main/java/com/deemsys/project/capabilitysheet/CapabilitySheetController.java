
package com.deemsys.project.capabilitysheet;


import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * 
 * @author Deemsys
 *
 */
@Controller
public class CapabilitySheetController {
	
	@Autowired
	CapabilitySheetService capabilitySheetService;
	
	@Resource(name="appProperties")
	private Properties appProperties;

    @RequestMapping(value="Admin/uploadCapabilitySheet",method=RequestMethod.POST)
	public String getCapabilitySheet(@RequestParam("sheet") MultipartFile sheet,ModelMap model)
	{
    	model.addAttribute("success",capabilitySheetService.uploadCapabilitySheet(sheet));
    	model.addAttribute("requestSuccess",true);
		return "/returnPage";
	}
    
    @RequestMapping(value="/getCapabilitySheetLink",method=RequestMethod.GET)
   	public String getCapabilitySheetLink(ModelMap model)
   	{
       	model.addAttribute("sheetLink",appProperties.getProperty("bucketUrl")+appProperties.getProperty("bucketName")+"/"+appProperties.getProperty("capabilitySheetFolder")+appProperties.getProperty("capabilitySheetName"));
       	model.addAttribute("requestSuccess",true);
   		return "/returnPage";
   	}
	
    
}

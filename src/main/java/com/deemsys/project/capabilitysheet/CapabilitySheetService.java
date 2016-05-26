package com.deemsys.project.capabilitysheet;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.deemsys.project.common.AWSFileUpload;

@Service
@Transactional
public class CapabilitySheetService {
	
	@Autowired
	AWSFileUpload awsFileUpload;
	
	@Resource(name="appProperties")
	private Properties appProperties;
	
	public boolean uploadCapabilitySheet(MultipartFile sheet){
		try {
			awsFileUpload.uploadFileToAWSS3(sheet,appProperties.getProperty("capabilitySheetFolder"),appProperties.getProperty("capabilitySheetName"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}

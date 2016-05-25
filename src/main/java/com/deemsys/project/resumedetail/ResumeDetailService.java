package com.deemsys.project.resumedetail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.deemsys.project.common.AWSFileUpload;
import com.deemsys.project.entity.ResumeDetail;
/**
 * 
 * @author Deemsys
 *
 * ResumeDetail 	 - Entity
 * resumeDetail 	 - Entity Object
 * resumeDetails 	 - Entity List
 * resumeDetailDAO   - Entity DAO
 * resumeDetailForms - EntityForm List
 * ResumeDetailForm  - EntityForm
 *
 */
@Service
@Transactional
public class ResumeDetailService {

	@Autowired
	ResumeDetailDAO resumeDetailDAO;
	
	@Autowired
	AWSFileUpload awsFileUpload;
	
	//Get All Entries
	public List<ResumeDetailForm> getResumeDetailList()
	{
		List<ResumeDetailForm> resumeDetailForms=new ArrayList<ResumeDetailForm>();
		
		List<ResumeDetail> resumeDetails=new ArrayList<ResumeDetail>();
		
		resumeDetails=resumeDetailDAO.getAll();
		
		for (ResumeDetail resumeDetail : resumeDetails) {
			//TODO: Fill the List
			resumeDetailForms.add(new ResumeDetailForm(resumeDetail.getResumeId(), resumeDetail.getName(), resumeDetail.getType(), resumeDetail.getReference(), resumeDetail.getStatus()));
		}
		
		return resumeDetailForms;
	}
	
	//Get Particular Entry
	public ResumeDetailForm getResumeDetail(String getId)
	{
		ResumeDetail resumeDetail=new ResumeDetail();
		
		resumeDetail=resumeDetailDAO.get(getId);
		
		//TODO: Convert Entity to Form
		//Start
		
		ResumeDetailForm resumeDetailForm=new ResumeDetailForm(resumeDetail.getResumeId(), resumeDetail.getName(), resumeDetail.getType(), resumeDetail.getReference(), resumeDetail.getStatus());
		//End
		
		return resumeDetailForm;
	}
	
	//Merge an Entry (Save or Update)
	public ResumeDetail mergeResumeDetail(MultipartFile uploadedResume)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		String uuidString=UUID.randomUUID().toString().replaceAll("-", "");
		
		//File Upload
		try {
			awsFileUpload.uploadFileToAWSS3(uploadedResume, uuidString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResumeDetail resumeDetail=new ResumeDetail(uuidString, uploadedResume.getOriginalFilename(), uploadedResume.getContentType(), uuidString+"."+uploadedResume.getOriginalFilename().substring(uploadedResume.getOriginalFilename().lastIndexOf(".")+1), 1, null);
		
		//Logic Ends
		
		
		resumeDetailDAO.merge(resumeDetail);
		return resumeDetail;
	}
	
	//Save an Entry
	public int saveResumeDetail(ResumeDetailForm resumeDetailForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		ResumeDetail resumeDetail=new ResumeDetail();
		
		//Logic Ends
		
		resumeDetailDAO.save(resumeDetail);
		return 1;
	}
	
	//Update an Entry
	public int updateResumeDetail(ResumeDetailForm resumeDetailForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		ResumeDetail resumeDetail=new ResumeDetail();
		
		//Logic Ends
		
		resumeDetailDAO.update(resumeDetail);
		return 1;
	}
	
	//Delete an Entry
	public int deleteResumeDetail(String id)
	{
		try {
			awsFileUpload.deleteFileFromAWSS3(resumeDetailDAO.get(id).getReference());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resumeDetailDAO.delete(id);
		return 1;
	}
	
	
	
}

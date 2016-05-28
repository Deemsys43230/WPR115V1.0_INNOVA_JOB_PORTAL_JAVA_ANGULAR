package com.deemsys.project.jobSeeker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.deemsys.project.common.AWSFileUpload;
import com.deemsys.project.entity.JobSeeker;
/**
 * 
 * @author Deemsys
 *
 * JobSeeker 	 - Entity
 * jobSeeker 	 - Entity Object
 * jobSeekers 	 - Entity List
 * jobSeekerDAO   - Entity DAO
 * jobSeekerForms - EntityForm List
 * JobSeekerForm  - EntityForm
 *
 */
@Service
@Transactional
public class JobSeekerService {

	@Autowired
	JobSeekerDAO jobSeekerDAO;
	
	@Autowired
	AWSFileUpload awsFileUpload;
	
	@Resource(name="appProperties")
	private Properties appProperties;
	
	//Get All Entries
	public List<JobSeekerForm> getJobSeekerList()
	{
		List<JobSeekerForm> jobSeekerForms=new ArrayList<JobSeekerForm>();
		
		List<JobSeeker> jobSeekers=new ArrayList<JobSeeker>();
		
		jobSeekers=jobSeekerDAO.getAll();
		String resumeUrl=appProperties.getProperty("bucketUrl")+appProperties.getProperty("bucketName")+"/"+appProperties.getProperty("resumeFolder");
		for (JobSeeker jobSeeker : jobSeekers) {
			//TODO: Fill the List
			jobSeekerForms.add(new JobSeekerForm(jobSeeker.getJobSeekerId(), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getEmail(), jobSeeker.getPhoneNumber(), jobSeeker.getStatus(), jobSeeker.getResumeName(), jobSeeker.getResumeType(),resumeUrl+jobSeeker.getJobSeekerId()+getExtension(jobSeeker.getResumeName()),jobSeeker.getInterestedIn()));
		}
		
		return jobSeekerForms;
	}
	
	//Get Particular Entry
	public JobSeekerForm getJobSeeker(String getId)
	{
		JobSeeker jobSeeker=new JobSeeker();
		
		jobSeeker=jobSeekerDAO.get(getId);
		
		//TODO: Convert Entity to Form
		//Start
		String resumeUrl=appProperties.getProperty("bucketUrl")+appProperties.getProperty("bucketName")+"/"+appProperties.getProperty("resumeFolder");
		JobSeekerForm jobSeekerForm=new JobSeekerForm(jobSeeker.getJobSeekerId(), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getEmail(), jobSeeker.getPhoneNumber(), jobSeeker.getStatus(), jobSeeker.getResumeName(), jobSeeker.getResumeType(),resumeUrl+jobSeeker.getJobSeekerId()+getExtension(jobSeeker.getResumeName()),jobSeeker.getInterestedIn());
		
		//End
		
		return jobSeekerForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeJobSeeker(JobSeekerForm jobSeekerForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		JobSeeker jobSeeker=new JobSeeker();
		
		//Logic Ends
		
		
		jobSeekerDAO.merge(jobSeeker);
		return 1;
	}
	
	//Save an Entry
	public String saveResume(MultipartFile resume)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		String uuidString=UUID.randomUUID().toString().replaceAll("-", "");
		//File Upload
		try {
			File file=awsFileUpload.saveTemporaryFile(resume);
			awsFileUpload.uploadFileToAWSS3(file,appProperties.getProperty("resumeFolder"),uuidString+getExtension(resume.getOriginalFilename()));
			file.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JobSeeker jobSeeker=new JobSeeker(uuidString, null, null, null, null, null, resume.getOriginalFilename(), resume.getContentType(), null);
		
		//Logic Ends
		
		jobSeekerDAO.save(jobSeeker);
		return uuidString;
	}
	
	//Update an Entry
	public int updateJobSeeker(JobSeekerForm jobSeekerForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		JobSeeker jobSeeker=jobSeekerDAO.get(jobSeekerForm.getJobSeekerId());
		jobSeeker.setJobSeekerId(jobSeekerForm.getJobSeekerId());
		jobSeeker.setFirstName(jobSeekerForm.getFirstName());
		jobSeeker.setLastName(jobSeekerForm.getLastName());
		jobSeeker.setEmail(jobSeekerForm.getEmail());
		jobSeeker.setPhoneNumber(jobSeekerForm.getPhoneNumber());
		jobSeeker.setInterestedIn(jobSeekerForm.getInterestedIn());
		jobSeeker.setStatus(jobSeekerForm.getStatus());
		//Logic Ends
		
		jobSeekerDAO.update(jobSeeker);
		return 1;
	}
	
	//Delete an Entry
	public int deleteJobSeeker(String id)
	{
		JobSeeker jobSeeker=jobSeekerDAO.get(id);
		try {
			awsFileUpload.deleteFileFromAWSS3(jobSeeker.getJobSeekerId()+getExtension(jobSeeker.getResumeName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jobSeekerDAO.delete(id);
		return 1;
	}
	
	//Get Extension
	public String getExtension(String fileName){
		String ext=fileName.substring(fileName.lastIndexOf("."));
		return ext;
	}
	
	// Get Job Seeker Count
	public Integer getJobSeekerCount(){
		return jobSeekerDAO.getAll().size();
	}
}

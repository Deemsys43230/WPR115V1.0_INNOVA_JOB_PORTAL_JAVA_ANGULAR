package com.deemsys.project.latestnews;

import java.awt.image.BufferedImage;
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
import com.deemsys.project.common.ImageResizeService;
import com.deemsys.project.common.JobPortalConstants;
import com.deemsys.project.entity.LatestNews;
/**
 * 
 * @author Deemsys
 *
 * LatestNews 	 - Entity
 * latestNews 	 - Entity Object
 * latestNewss 	 - Entity List
 * latestNewsDAO   - Entity DAO
 * latestNewsForms - EntityForm List
 * LatestNewsForm  - EntityForm
 *
 */
@Service
@Transactional
public class LatestNewsService {

	@Autowired
	LatestNewsDAO latestNewsDAO;
	
	@Autowired
	AWSFileUpload awsFileUpload;
	
	@Resource(name="appProperties")
	private Properties appProperties;
	
	@Autowired
	private ImageResizeService imageResizeService;
	
	//Get All Entries
	public List<LatestNewsForm> getLatestNewsList()
	{
		List<LatestNewsForm> latestNewsForms=new ArrayList<LatestNewsForm>();
		
		List<LatestNews> latestNewss=new ArrayList<LatestNews>();
		
		latestNewss=latestNewsDAO.getAll();
		
		for (LatestNews latestNews : latestNewss) {
			//TODO: Fill the List
			LatestNewsForm latestNewsForm = new LatestNewsForm(latestNews.getLatestNewsId(), latestNews.getTitle(), latestNews.getDescription(), JobPortalConstants.convertMonthFormat(latestNews.getAddedDate()), latestNews.getStatus(),getTitleImageUrl(latestNews));
			latestNewsForms.add(latestNewsForm);
		}
		
		return latestNewsForms;
	}
	
	//Get Particular Entry
	public LatestNewsForm getLatestNews(Long latestNewsId)
	{
		LatestNews latestNews=new LatestNews();
		
		latestNews=latestNewsDAO.getLatestNewsById(latestNewsId);
		
		//TODO: Convert Entity to Form
		//Start
		
		LatestNewsForm latestNewsForm = new LatestNewsForm(latestNews.getLatestNewsId(), latestNews.getTitle(), latestNews.getDescription(), JobPortalConstants.convertMonthFormat(latestNews.getAddedDate()), latestNews.getStatus(),getTitleImageUrl(latestNews));
		
		//End
		
		return latestNewsForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeLatestNews(LatestNewsForm latestNewsForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		LatestNews latestNews=new LatestNews(latestNewsForm.getTitle(), latestNewsForm.getDescription(), new Date(), 1,null);
		latestNews.setLatestNewsId(latestNewsForm.getLatestNewsId());
		
		//Logic Ends
		
		
		latestNewsDAO.merge(latestNews);
		return 1;
	}
	
	//Save an Entry
	public Long saveLatestNews(MultipartFile titleImage)
	{
		//TODO: Convert Form to Entity Here	
		UUID uuid=UUID.randomUUID();
		String newsFileName=uuid.toString().replace("-", "")+getExtension(titleImage.getOriginalFilename());
		try {
			File file=awsFileUpload.saveTemporaryFile(titleImage);			
			awsFileUpload.uploadFileToAWSS3(file, appProperties.getProperty("newsFolder"),newsFileName);
			file.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		//Logic Starts
		LatestNews latestNews=new LatestNews(null, null, new Date(), 1,newsFileName);
		latestNewsDAO.save(latestNews);
		//Logic Ends
		return latestNews.getLatestNewsId();
	}
	
	//Update an Entry
	public int updateLatestNews(LatestNewsForm latestNewsForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		LatestNews latestNews=latestNewsDAO.getLatestNewsById(latestNewsForm.getLatestNewsId());
		latestNews.setTitle(latestNewsForm.getTitle());
		latestNews.setDescription(latestNewsForm.getDescription());
		//Logic Ends
		
		latestNewsDAO.update(latestNews);
		return 1;
	}
	
	//Delete an Entry
	public int deleteLatestNews(Integer id)
	{
		latestNewsDAO.delete(id);
		return 1;
	}
	
	public void enableOrDisbaleNews(Long newsId){
		LatestNews latestNews=latestNewsDAO.getLatestNewsById(newsId);
		
		if(latestNews.getStatus()==1){
			latestNews.setStatus(0);
		}else{
			latestNews.setStatus(1);
		}
		
		latestNewsDAO.merge(latestNews);
	}
	
	//Get Extension
	public String getExtension(String fileName){
		String ext=fileName.substring(fileName.lastIndexOf("."));
		return ext;
	}
	
	//Get URL
	public String getTitleImageUrl(LatestNews latestNews){
		return appProperties.getProperty("bucketUrl")+appProperties.getProperty("bucketName")+"/"+appProperties.getProperty("newsFolder")+latestNews.getFileReferenceName();
	}
	
	//Get Enabled Entries For User
	public List<LatestNewsForm> getAllLatestNewsForUser()
	{
		List<LatestNewsForm> latestNewsForms=new ArrayList<LatestNewsForm>();
			
		List<LatestNews> latestNewss=new ArrayList<LatestNews>();
			
		latestNewss=latestNewsDAO.getAllLatestNewsForUser();
			
		for (LatestNews latestNews : latestNewss) {
			//TODO: Fill the List
			LatestNewsForm latestNewsForm = new LatestNewsForm(latestNews.getLatestNewsId(), latestNews.getTitle(), latestNews.getDescription(), JobPortalConstants.convertMonthFormat(latestNews.getAddedDate()), latestNews.getStatus(),getTitleImageUrl(latestNews));
			latestNewsForms.add(latestNewsForm);
		}
			
		return latestNewsForms;
	}
}

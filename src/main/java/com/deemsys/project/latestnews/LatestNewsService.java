package com.deemsys.project.latestnews;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	//Get All Entries
	public List<LatestNewsForm> getLatestNewsList()
	{
		List<LatestNewsForm> latestNewsForms=new ArrayList<LatestNewsForm>();
		
		List<LatestNews> latestNewss=new ArrayList<LatestNews>();
		
		latestNewss=latestNewsDAO.getAll();
		
		for (LatestNews latestNews : latestNewss) {
			//TODO: Fill the List
			LatestNewsForm latestNewsForm = new LatestNewsForm(latestNews.getLatestNewsId(), latestNews.getTitle(), latestNews.getDescription(), JobPortalConstants.convertMonthFormat(latestNews.getAddedDate()), latestNews.getStatus());
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
		
		LatestNewsForm latestNewsForm = new LatestNewsForm(latestNews.getLatestNewsId(), latestNews.getTitle(), latestNews.getDescription(), JobPortalConstants.convertMonthFormat(latestNews.getAddedDate()), latestNews.getStatus());
		
		//End
		
		return latestNewsForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeLatestNews(LatestNewsForm latestNewsForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		LatestNews latestNews=new LatestNews(latestNewsForm.getTitle(), latestNewsForm.getDescription(), new Date(), 1);
		latestNews.setLatestNewsId(latestNewsForm.getLatestNewsId());
		
		//Logic Ends
		
		
		latestNewsDAO.merge(latestNews);
		return 1;
	}
	
	//Save an Entry
	public int saveLatestNews(LatestNewsForm latestNewsForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		LatestNews latestNews=new LatestNews(latestNewsForm.getTitle(), latestNewsForm.getDescription(), new Date(), 1);
		
		//Logic Ends
		
		latestNewsDAO.save(latestNews);
		return 1;
	}
	
	//Update an Entry
	public int updateLatestNews(LatestNewsForm latestNewsForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		LatestNews latestNews=new LatestNews(latestNewsForm.getTitle(), latestNewsForm.getDescription(), new Date(), 1);
		latestNews.setLatestNewsId(latestNewsForm.getLatestNewsId());
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
	
	
}

package com.deemsys.project.testimonial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.entity.LatestNews;
import com.deemsys.project.entity.Testimonial;
/**
 * 
 * @author Deemsys
 *
 * Testimonial 	 - Entity
 * testimonial 	 - Entity Object
 * testimonials 	 - Entity List
 * testimonialDAO   - Entity DAO
 * testimonialForms - EntityForm List
 * TestimonialForm  - EntityForm
 *
 */
@Service
@Transactional
public class TestimonialService {

	@Autowired
	TestimonialDAO testimonialDAO;
	
	//Get All Entries
	public List<TestimonialForm> getTestimonialList()
	{
		List<TestimonialForm> testimonialForms=new ArrayList<TestimonialForm>();
		
		List<Testimonial> testimonials=new ArrayList<Testimonial>();
		
		testimonials=testimonialDAO.getAll();
		
		for (Testimonial testimonial : testimonials) {
			//TODO: Fill the List
			TestimonialForm testimonialForm=new TestimonialForm(testimonial.getTestimonialId(), testimonial.getDescription(), testimonial.getSaidBy(), testimonial.getDestination(), testimonial.getStatus());
			testimonialForms.add(testimonialForm);
		}
		
		return testimonialForms;
	}
	
	//Get Particular Entry
	public TestimonialForm getTestimonial(Long testimonialId)
	{
		Testimonial testimonial=new Testimonial();
		
		testimonial=testimonialDAO.getTestimonialById(testimonialId);
		
		//TODO: Convert Entity to Form
		//Start
		TestimonialForm testimonialForm=new TestimonialForm(testimonial.getTestimonialId(), testimonial.getDescription(), testimonial.getSaidBy(), testimonial.getDestination(), testimonial.getStatus());
		//End
		
		return testimonialForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeTestimonial(TestimonialForm testimonialForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		Testimonial testimonial=new Testimonial(testimonialForm.getDescription(), testimonialForm.getSaidBy(), testimonialForm.getDestination(), 1);
		testimonial.setTestimonialId(testimonialForm.getTestimonialId());
		//Logic Ends
		
		
		testimonialDAO.merge(testimonial);
		return 1;
	}
	
	//Save an Entry
	public int saveTestimonial(TestimonialForm testimonialForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		Testimonial testimonial=new Testimonial(testimonialForm.getDescription(), testimonialForm.getSaidBy(), testimonialForm.getDestination(), 1);
		//Logic Ends
		
		testimonialDAO.save(testimonial);
		return 1;
	}
	
	//Update an Entry
	public int updateTestimonial(TestimonialForm testimonialForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		Testimonial testimonial=new Testimonial(testimonialForm.getDescription(), testimonialForm.getSaidBy(), testimonialForm.getDestination(), 1);
		testimonial.setTestimonialId(testimonialForm.getTestimonialId());
		
		//Logic Ends
		
		testimonialDAO.update(testimonial);
		return 1;
	}
	
	//Delete an Entry
	public int deleteTestimonial(Integer id)
	{
		testimonialDAO.delete(id);
		return 1;
	}
	
	public void enableOrDisbaleTestimonial(Long testimonialId){
		Testimonial testimonial=testimonialDAO.getTestimonialById(testimonialId);
		
		if(testimonial.getStatus()==1){
			testimonial.setStatus(0);
		}else{
			testimonial.setStatus(1);
		}
		
		testimonialDAO.merge(testimonial);
	}
	
}

package com.deemsys.project.testimonial;

import java.util.List;

import com.deemsys.project.common.IGenericDAO;
import com.deemsys.project.entity.Testimonial;
/**
 * 
 * @author Deemsys
 *
 */
public interface TestimonialDAO extends IGenericDAO<Testimonial>{
	public Testimonial getTestimonialById(Long testimonialId);
	public List<Testimonial> getAllTestimonialForUser();
}

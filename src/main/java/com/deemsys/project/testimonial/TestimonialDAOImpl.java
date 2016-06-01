package com.deemsys.project.testimonial;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deemsys.project.common.BasicQuery;
import com.deemsys.project.entity.Testimonial;

/**
 * 
 * @author Deemsys
 *
 */
@Repository
public class TestimonialDAOImpl implements TestimonialDAO{
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(Testimonial entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void merge(Testimonial entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(entity);
	}	
	
	@Override
	public Testimonial get(Integer id) {
		// TODO Auto-generated method stub
		return (Testimonial) this.sessionFactory.getCurrentSession().get(Testimonial.class, id);
	}

	@Override
	public Testimonial update(Testimonial entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(entity);
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(this.get(id));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Testimonial> getAll() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createCriteria(Testimonial.class).addOrder(Order.desc("testimonialId")).list();
	}

	@Override
	public List<Testimonial> find(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Testimonial> find(String paramName, Long paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Testimonial> find(String paramName, Integer paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Testimonial> find(BasicQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Testimonial> find(String queryString, String[] paramNames,
			String[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Testimonial> find(String ParamName, Date date1, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Testimonial> find(String ParamName, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean disable(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean enable(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkName(Integer id, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Testimonial> getActiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Testimonial getTestimonialById(Long testimonialId) {
		// TODO Auto-generated method stub
		Testimonial testimonial =(Testimonial) this.sessionFactory.getCurrentSession().createCriteria(Testimonial.class).add(Restrictions.eq("testimonialId", testimonialId)).uniqueResult();
		return testimonial;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Testimonial> getAllTestimonialForUser() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createCriteria(Testimonial.class).add(Restrictions.eq("status", 1)).addOrder(Order.desc("testimonialId")).list();
	}

	

}

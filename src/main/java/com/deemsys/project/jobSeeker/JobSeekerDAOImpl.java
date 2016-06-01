package com.deemsys.project.jobSeeker;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deemsys.project.common.BasicQuery;
import com.deemsys.project.entity.JobSeeker;

/**
 * 
 * @author Deemsys
 *
 */
@Repository
public class JobSeekerDAOImpl implements JobSeekerDAO{
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(JobSeeker entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void merge(JobSeeker entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(entity);
	}	
	
	@Override
	public JobSeeker get(Integer id) {
		// TODO Auto-generated method stub
		return (JobSeeker) this.sessionFactory.getCurrentSession().get(JobSeeker.class, id);
	}
	
	@Override
	public JobSeeker get(String id) {
		// TODO Auto-generated method stub
		return (JobSeeker) this.sessionFactory.getCurrentSession().get(JobSeeker.class, id);
	}

	@Override
	public JobSeeker update(JobSeeker entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(entity);
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(this.get(id));
		
	}
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(this.get(id));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobSeeker> getAll() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createCriteria(JobSeeker.class).addOrder(Order.desc("jobSeekerId")).list();
	}

	@Override
	public List<JobSeeker> find(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSeeker> find(String paramName, Long paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSeeker> find(String paramName, Integer paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSeeker> find(BasicQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSeeker> find(String queryString, String[] paramNames,
			String[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSeeker> find(String ParamName, Date date1, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSeeker> find(String ParamName, Date date) {
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
	public List<JobSeeker> getActiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	

}

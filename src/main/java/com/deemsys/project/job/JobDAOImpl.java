package com.deemsys.project.job;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deemsys.project.common.BasicQuery;
import com.deemsys.project.entity.Job;

/**
 * 
 * @author Deemsys
 *
 */
@Repository
public class JobDAOImpl implements JobDAO{
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(Job entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void merge(Job entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(entity);
	}	
	
	@Override
	public Job get(Integer id) {
		// TODO Auto-generated method stub
		return (Job) this.sessionFactory.getCurrentSession().get(Job.class, id);
	}

	@Override
	public Job update(Job entity) {
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
	public List<Job> getAll() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createCriteria(Job.class).list();
	}

	@Override
	public List<Job> find(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> find(String paramName, Long paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> find(String paramName, Integer paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> find(BasicQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> find(String queryString, String[] paramNames,
			String[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> find(String ParamName, Date date1, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> find(String ParamName, Date date) {
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
	public List<Job> getActiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Job getJobById(Long jobId) {
		// TODO Auto-generated method stub
		Job job=(Job) this.sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("jobId", jobId)).uniqueResult();
		return job;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getAllJobsForUser() {
		// TODO Auto-generated method stub
		List<Job> jobs=this.sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("isEnable", 1)).list();
		return jobs;
	}

	

}

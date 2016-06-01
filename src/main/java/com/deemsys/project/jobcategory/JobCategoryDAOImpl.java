package com.deemsys.project.jobcategory;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deemsys.project.common.BasicQuery;
import com.deemsys.project.entity.JobCategory;

/**
 * 
 * @author Deemsys
 *
 */
@Repository
public class JobCategoryDAOImpl implements JobCategoryDAO{
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(JobCategory entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void merge(JobCategory entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(entity);
	}	
	
	@Override
	public JobCategory get(Integer id) {
		// TODO Auto-generated method stub
		return (JobCategory) this.sessionFactory.getCurrentSession().get(JobCategory.class, id);
	}

	@Override
	public JobCategory update(JobCategory entity) {
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
	public List<JobCategory> getAll() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createCriteria(JobCategory.class).list();
	}

	@Override
	public List<JobCategory> find(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobCategory> find(String paramName, Long paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobCategory> find(String paramName, Integer paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobCategory> find(BasicQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobCategory> find(String queryString, String[] paramNames,
			String[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobCategory> find(String ParamName, Date date1, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobCategory> find(String ParamName, Date date) {
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
		JobCategory jobCategory=(JobCategory) this.sessionFactory.getCurrentSession().createCriteria(JobCategory.class).add(Restrictions.eq("categoryName", name)).uniqueResult();
		if(jobCategory!=null){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean checkName(Integer id, String name) {
		// TODO Auto-generated method stub
		JobCategory jobCategory=(JobCategory) this.sessionFactory.getCurrentSession().createCriteria(JobCategory.class).add(Restrictions.and(Restrictions.ne("jobCategoryId", id),Restrictions.eq("categoryName", name))).uniqueResult();
		if(jobCategory!=null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<JobCategory> getActiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobCategory> getJobCategoryListForUser() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createCriteria(JobCategory.class).add(Restrictions.eq("status", 1)).list();
	}

	

}

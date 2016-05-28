package com.deemsys.project.job;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
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

	@Override
	public List<Job> searchJobs(JobSearchForm jobSearchForm) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(Job.class,"j1");
		criteria.createAlias("jobCategory", "jc1");
		criteria.createAlias("jobTagMaps", "jt1");
		criteria.createAlias("jt1.jobTags", "t1");
		
		//Check With Job Keyword
		Criterion tagNameLikeCriterion=Restrictions.like("t1.tagName",jobSearchForm.getJobKeyword(),MatchMode.ANYWHERE);
		
		//Check with Job title
		Criterion jobTitleLikeCriterion=Restrictions.like("j1.name",jobSearchForm.getJobKeyword(),MatchMode.ANYWHERE);
				
		criteria.add(Restrictions.or(tagNameLikeCriterion, jobTitleLikeCriterion));
		
		
		if(jobSearchForm.getJobCategoryId()!=0){
			Criterion jobCategoryCriterion=Restrictions.eq("jc1.jobCategoryId", jobSearchForm.getJobCategoryId());
			criteria.add(jobCategoryCriterion);
		}
		
		/*ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("j1.jobId"));
		projectionList.add(Projections.property("j1.name"));
		projectionList.add(Projections.property("j1.addedDate"));
		projectionList.add(Projections.groupProperty("j1.jobId"));
		
		criteria.setProjection(projectionList);
		
		*/
		@SuppressWarnings("unchecked")
		List<Job> jobs=criteria.list();
		return jobs;
	}

	

}

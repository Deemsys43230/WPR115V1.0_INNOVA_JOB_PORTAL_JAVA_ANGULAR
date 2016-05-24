package com.deemsys.project.jobtag;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deemsys.project.common.BasicQuery;
import com.deemsys.project.entity.JobTag;

/**
 * 
 * @author Deemsys
 *
 */
@Repository
public class JobTagDAOImpl implements JobTagDAO{
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(JobTag entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void merge(JobTag entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(entity);
	}	
	
	@Override
	public JobTag get(Integer id) {
		// TODO Auto-generated method stub
		return (JobTag) this.sessionFactory.getCurrentSession().get(JobTag.class, id);
	}

	@Override
	public JobTag update(JobTag entity) {
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
	public List<JobTag> getAll() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createCriteria(JobTag.class).list();
	}

	@Override
	public List<JobTag> find(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobTag> find(String paramName, Long paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobTag> find(String paramName, Integer paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobTag> find(BasicQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobTag> find(String queryString, String[] paramNames,
			String[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobTag> find(String ParamName, Date date1, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobTag> find(String ParamName, Date date) {
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
	public List<JobTag> getActiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobTag> getJobTagByJobId(Long jobId) {
		// TODO Auto-generated method stub
		List<JobTag> jobTags=this.sessionFactory.getCurrentSession().createCriteria(JobTag.class).add(Restrictions.eq("job.jobId", jobId)).list();
		return jobTags;
	}

	@Override
	public void deleteJobTagByJobId(Long jobId) {
		// TODO Auto-generated method stub
		List<JobTag> jobTags=this.getJobTagByJobId(jobId);
		for (JobTag jobTag : jobTags) {
			this.sessionFactory.getCurrentSession().delete(jobTag);
		}
	}

	

}

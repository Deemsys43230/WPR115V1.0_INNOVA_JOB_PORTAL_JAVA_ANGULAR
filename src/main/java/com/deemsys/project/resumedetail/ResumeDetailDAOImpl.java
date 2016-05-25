package com.deemsys.project.resumedetail;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deemsys.project.common.BasicQuery;
import com.deemsys.project.entity.ResumeDetail;

/**
 * 
 * @author Deemsys
 *
 */
@Repository
public class ResumeDetailDAOImpl implements ResumeDetailDAO{
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(ResumeDetail entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void merge(ResumeDetail entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(entity);
	}	
	
	@Override
	public ResumeDetail get(Integer id) {
		// TODO Auto-generated method stub
		return (ResumeDetail) this.sessionFactory.getCurrentSession().get(ResumeDetail.class, id);
	}

	@Override
	public ResumeDetail update(ResumeDetail entity) {
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
	public List<ResumeDetail> getAll() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createCriteria(ResumeDetail.class).list();
	}

	@Override
	public List<ResumeDetail> find(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResumeDetail> find(String paramName, Long paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResumeDetail> find(String paramName, Integer paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResumeDetail> find(BasicQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResumeDetail> find(String queryString, String[] paramNames,
			String[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResumeDetail> find(String ParamName, Date date1, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResumeDetail> find(String ParamName, Date date) {
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
	public List<ResumeDetail> getActiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResumeDetail get(String id) {
		// TODO Auto-generated method stub
		return (ResumeDetail) this.sessionFactory.getCurrentSession().get(ResumeDetail.class, id);
	}
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(this.get(id));
		
	}

}

package com.deemsys.project.latestnews;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sun.rmi.server.UnicastRef;

import com.deemsys.project.common.BasicQuery;
import com.deemsys.project.entity.LatestNews;

/**
 * 
 * @author Deemsys
 *
 */
@Repository
public class LatestNewsDAOImpl implements LatestNewsDAO{
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(LatestNews entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void merge(LatestNews entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(entity);
	}	
	
	@Override
	public LatestNews get(Integer id) {
		// TODO Auto-generated method stub
		return (LatestNews) this.sessionFactory.getCurrentSession().get(LatestNews.class, id);
	}

	@Override
	public LatestNews update(LatestNews entity) {
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
	public List<LatestNews> getAll() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createCriteria(LatestNews.class).list();
	}

	@Override
	public List<LatestNews> find(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LatestNews> find(String paramName, Long paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LatestNews> find(String paramName, Integer paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LatestNews> find(BasicQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LatestNews> find(String queryString, String[] paramNames,
			String[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LatestNews> find(String ParamName, Date date1, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LatestNews> find(String ParamName, Date date) {
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
	public List<LatestNews> getActiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LatestNews getLatestNewsById(Long latestNewsId) {
		// TODO Auto-generated method stub
		LatestNews latestNews=(LatestNews) this.sessionFactory.getCurrentSession().createCriteria(LatestNews.class).add(Restrictions.eq("latestNewsId", latestNewsId)).uniqueResult();
		return latestNews;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LatestNews> getAllLatestNewsForUser() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createCriteria(LatestNews.class).add(Restrictions.eq("status", 1)).list();
	
	}



}

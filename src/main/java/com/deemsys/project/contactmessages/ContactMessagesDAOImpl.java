package com.deemsys.project.contactmessages;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deemsys.project.common.BasicQuery;
import com.deemsys.project.entity.ContactMessages;

/**
 * 
 * @author Deemsys
 *
 */
@Repository
public class ContactMessagesDAOImpl implements ContactMessagesDAO{
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(ContactMessages entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void merge(ContactMessages entity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(entity);
	}	
	
	@Override
	public ContactMessages get(Integer id) {
		// TODO Auto-generated method stub
		return (ContactMessages) this.sessionFactory.getCurrentSession().get(ContactMessages.class, id);
	}

	@Override
	public ContactMessages update(ContactMessages entity) {
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
	public List<ContactMessages> getAll() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createCriteria(ContactMessages.class).list();
	}

	@Override
	public List<ContactMessages> find(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactMessages> find(String paramName, Long paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactMessages> find(String paramName, Integer paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactMessages> find(BasicQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactMessages> find(String queryString, String[] paramNames,
			String[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactMessages> find(String ParamName, Date date1, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactMessages> find(String ParamName, Date date) {
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
	public List<ContactMessages> getActiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUnreadMessageCount() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createCriteria(ContactMessages.class).add(Restrictions.eq("status", 1)).list().size();
	}

	

}

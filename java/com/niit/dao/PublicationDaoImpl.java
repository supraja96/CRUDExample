package com.niit.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Publication;



@Repository("publicationDao")
public class PublicationDaoImpl implements PublicationDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	
	public void addPublication(Publication publication) {
		sessionFactory.getCurrentSession().saveOrUpdate(publication);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	
	public List<Publication> getPublications() {
		return (List<Publication>) sessionFactory.getCurrentSession().createCriteria(Publication.class).list();
	}
	@Transactional
	public Publication getPublication(int pubId) {
		return (Publication) sessionFactory.getCurrentSession().get(Publication.class, pubId);
	}

	@Transactional
	
	public void deletePublication(int pubId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Publication WHERE pubId = "+pubId).executeUpdate();
	}

}

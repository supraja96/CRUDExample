package com.niit.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;


@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCategory(Category category) {
	
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(category);
		Transaction tx=session.beginTransaction();
		tx.commit();
	
	
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	
	public List<Category> getCategories() {
		return (List<Category>) sessionFactory.openSession().
				createCriteria(Category.class).list();
	}
	@Transactional
	
	public Category getCategory(int categoryId) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, categoryId);
	}
	@Transactional
	
	public void deleteCategory(int categoryId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM category WHERE categoryId = "+categoryId).executeUpdate();
	}

}

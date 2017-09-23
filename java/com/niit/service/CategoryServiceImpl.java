package com.niit.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}

	public List<Category> getCategories() {
		return categoryDao.getCategories();
	}

	public Category getCategory(int categoryId) {
		return categoryDao.getCategory(categoryId);
	}

	public void deleteCategory(int categoryId) {
		categoryDao.deleteCategory(categoryId);
	}

}

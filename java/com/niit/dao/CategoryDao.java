package com.niit.dao;
import java.util.List;

import com.niit.model.Category;

public interface CategoryDao {
	
	public void addCategory(Category category);
	
	public List<Category> getCategories();
	
	public Category getCategory(int categoryId);
	
	public void deleteCategory(int categoryId);
}

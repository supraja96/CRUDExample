package com.niit.service;
import java.util.List;

import com.niit.model.Category;

public interface CategoryService {
	
	public void addCategory(Category category);
	
	public List<Category> getCategories();
	
	public Category getCategory(int categoryId);
	
	public void deleteCategory(int categoryId);

}

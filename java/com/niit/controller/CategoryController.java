package com.niit.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Category;
import com.niit.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(@ModelAttribute("category") Category category)
	{
		return "addCategory";
		
	}
	
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return new ModelAndView("redirect:/listCategory");
	}
	
	

	@RequestMapping(value = "/listCategory", method = RequestMethod.GET)
	public ModelAndView addCategory(@ModelAttribute("category")  Category category,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("categories",  categoryService.getCategories());
		return new ModelAndView("addCategory", model);
	}

	
	@RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
	public ModelAndView deleteCategory(@ModelAttribute("command")  Category category,
			BindingResult result) {
		categoryService.deleteCategory(category.getCategoryId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("categories",  categoryService.getCategories());
		return new ModelAndView("addCategory", model);
	}
	
	@RequestMapping(value = "/editCategory", method = RequestMethod.GET)
	public ModelAndView editCategory(@ModelAttribute("command")  Category category,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("category",  categoryService.getCategory(category.getCategoryId()));
		model.put("categories",  categoryService.getCategories());
		return new ModelAndView("addCategory", model);
	}
	
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public List<Category> getCategories() 
	{
		return categoryService.getCategories();
	}
}

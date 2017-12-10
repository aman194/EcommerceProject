package com.niit.shoppingback.dao;

import java.util.ArrayList;

import com.niit.shoppingback.model.Category;

public interface CategoryDao {
	boolean addCategory(Category c);
	boolean delCategory(int id);
	boolean updCategory(Category c);
	Category getCategoryById(int id);
	ArrayList<Category> getAllCategories();
}
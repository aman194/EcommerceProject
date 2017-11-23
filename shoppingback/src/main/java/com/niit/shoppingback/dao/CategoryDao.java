package com.niit.shoppingback.dao;

import java.util.ArrayList;

import com.niit.shoppingback.model.Category;

public interface CategoryDao {
	boolean addCategory(Category c);
	boolean delCategory(int id);
	Category getCategoryById(int id);
	ArrayList<Category> getAllCategories();
}
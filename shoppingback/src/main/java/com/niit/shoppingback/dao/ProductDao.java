package com.niit.shoppingback.dao;

import java.util.ArrayList;

import com.niit.shoppingback.model.Product;

public interface ProductDao {
	boolean addProduct(Product pa);
	boolean delProduct(int id);
	Product getProductById(int id);
	ArrayList<Product> getAllProducts();
	
}
package com.niit.shoppingback.dao;

import java.util.ArrayList;

import com.niit.shoppingback.model.Supplier;

public interface SupplierDao {
	boolean addSupplier(Supplier su);
	boolean delSupplier(int id);
	Supplier getSupplierById(int id);
	ArrayList<Supplier> getAllSuppliers();
	
}
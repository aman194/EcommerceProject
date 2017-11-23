package com.niit.shoppingback.daoimpl;

import java.util.ArrayList;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingback.dao.ProductDao;
import com.niit.shoppingback.model.Product;


@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SessionFactory sf;
	
	public ProductDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public boolean addProduct(Product pa) {
		Session s =sf.openSession();
		Transaction t = s.beginTransaction();
		s.saveOrUpdate(pa);
		t.commit();
		return true;
	}

	public boolean delProduct(int id) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Product p = s.get(Product.class, id);
		s.delete(p);
		t.commit();
		return true;
	}


	public Product getProductById(int id) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Product pa = s.get(Product.class, id);
		t.commit();
		return pa;
	}

	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> list;
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		list = (ArrayList<Product>) s.createQuery("from Product").list();
		t.commit();
		return list;
	}

}

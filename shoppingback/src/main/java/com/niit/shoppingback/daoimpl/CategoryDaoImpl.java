package com.niit.shoppingback.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingback.dao.CategoryDao;
import com.niit.shoppingback.model.Category;
@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sf;
	
	static Category cat;
	
	public CategoryDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	
	}

	public boolean addCategory(Category c) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(c);
		t.commit();
		return true;
	}

	public boolean delCategory(int id) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Category c=s.get(Category.class, id);
		s.delete(c);
		t.commit();
		return true;
	}

	public boolean updCategory(Category c) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		cat.setName(c.getName());
		cat.setSid(c.getSid());
		s.update(cat);
		t.commit();
		return true;
	}
	
	public Category getCategoryById(int id) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		cat=s.get(Category.class, id);
		t.commit();
		return cat;
	}

	public ArrayList<Category> getAllCategories() {
		ArrayList<Category> list;
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		list = (ArrayList<Category>) s.createQuery("from Category").list();
		t.commit();
		return list;
	}
	
	
}
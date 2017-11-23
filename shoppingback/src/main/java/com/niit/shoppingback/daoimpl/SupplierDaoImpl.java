package com.niit.shoppingback.daoimpl;

import java.util.ArrayList;


import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingback.dao.SupplierDao;
import com.niit.shoppingback.model.Supplier;

public class SupplierDaoImpl implements SupplierDao{
	
	
	@Autowired
	SessionFactory sf;
	
	public SupplierDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}


	public boolean addSupplier(Supplier su) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(su);
		t.commit();
		return true;
	}

	public boolean delSupplier(int id) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Supplier su=s.get(Supplier.class, id);
		s.delete(su);
		t.commit();
		return true;
	}

		public Supplier getSupplierById(int id) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Supplier su=s.get(Supplier.class, id);
		t.commit();
		return su;
	}

	public ArrayList<Supplier> getAllSuppliers() {
		ArrayList<Supplier> list;
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		list = (ArrayList<Supplier>) ss.createQuery("from Supplier").list();
		t.commit();
		return list;
	}

}

package com.niit.shoppingback.daoimpl;

//import java.util.ArrayList;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingback.dao.CustomerDao;
import com.niit.shoppingback.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	SessionFactory sf;
	
	public CustomerDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	public boolean addCustomer(Customer c) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		c.setEnabled(true);
		c.setRole("ROLE_USER");
		s.save(c);
		t.commit();
		return true;
	}
	/*@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Customer> getAllCustomers(){
		ArrayList<Customer> list;
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		list = (ArrayList<Customer>) s.createQuery("from Customer").list();
		t.commit();
		return list;
}
	
	*/
	public Customer getCustomerByEmail(String email) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Criteria cr = s.createCriteria(Customer.class);
		cr.add(Restrictions.eq("email", email));
		Customer c = (Customer)cr.uniqueResult();
		return c;
	}
	

}

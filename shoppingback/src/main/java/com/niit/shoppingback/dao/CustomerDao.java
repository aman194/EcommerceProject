package com.niit.shoppingback.dao;

//import java.util.ArrayList;

import com.niit.shoppingback.model.Customer;

public interface CustomerDao {
	boolean addCustomer(Customer c);
	//ArrayList<Customer> getAllCustomers();
	Customer getCustomerByEmail(String email);
	
}

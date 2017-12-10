package com.niit.shoppingback;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingback.dao.CustomerDao;
import com.niit.shoppingback.model.Customer;

public class CustomerTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.shoppingback");
		ctx.refresh();
		CustomerDao cd = (CustomerDao)ctx.getBean("CustomerDaoImpl");
		Customer c = new Customer();
		c.setAddress("chennai");
		c.setEmail("anjkfb@gmail.com");
		c.setName("rak");
		c.setPassword("aanna");
		c.setPhno("55471551212");
		assertTrue(cd.addCustomer(c));
		
		
		//assertNotNull(cd);
		ctx.close();
	}

}
/*package com.niit.shoppingback;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingback.dao.SupplierDao;
import com.niit.shoppingback.model.Supplier;

public class SupplierTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.shoppingback");
		ctx.refresh();
		SupplierDao sd = (SupplierDao)ctx.getBean("SupplierDaoImpl");
		Supplier su = new Supplier();
		su.setSname("moahn");		
		assertTrue(sd.addSupplier(su));
		
		
		//assertNotNull(cd);
		ctx.close();
	}

}
*/
/*package com.niit.shoppingback;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingback.dao.CategoryDao;
import com.niit.shoppingback.model.Category;

public class CategoryTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.shoppingback");
		ctx.refresh();
		CategoryDao rd = (CategoryDao)ctx.getBean("CategoryDaoImpl");
		Category cg = new Category();
		cg.setName("home appliances2");
		cg.setSid("1");
		assertTrue(rd.addCategory(cg));
		
		//assertNotNull(cd);
		ctx.close();
	}

}
*/
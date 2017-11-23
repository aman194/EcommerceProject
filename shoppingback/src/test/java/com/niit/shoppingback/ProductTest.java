/*package com.niit.shoppingback;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingback.dao.ProductDao;
import com.niit.shoppingback.model.Product;

public class ProductTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.shoppingback");
		ctx.refresh();
		ProductDao pd = (ProductDao)ctx.getBean("ProductDaoImpl");
		Product pa = new Product();
		pa.setName("roller");
		pa.setDescription("verrrry good use for lifetime");
		pa.setStock("20");
		pa.setPrice("200.54");
		assertTrue(pd.addProduct(pa));
	
		//assertNotNull(cd);
				ctx.close();
	}

}
*/
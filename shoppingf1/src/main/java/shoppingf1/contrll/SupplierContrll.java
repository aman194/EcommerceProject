package shoppingf1.contrll;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingback.dao.SupplierDao;
import com.niit.shoppingback.model.Supplier;

@Controller
public class SupplierContrll {
	static AnnotationConfigApplicationContext ctx;
	static SupplierDao sd;
	static {
		ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.shoppingback");
		ctx.refresh();
		try {
			sd = (SupplierDao)ctx.getBean("SupplierDaoImpl");
		}
		catch(Exception e) {
			System.out.println("error="+e);
		}
	}
	
	@RequestMapping("/supplier")
	public ModelAndView ct2() {
		ModelAndView m = new ModelAndView("supplier");
		m.addObject("slist", sd.getAllSuppliers());
		return m;
	}
	
	
	@RequestMapping("/addSupplier")
	public String ct1() {
		return "addSupplier";	
	}
	
	@RequestMapping("/saveSupplier")
	public String gosavecategory(HttpServletRequest req) {
		Supplier s = new Supplier();
		s.setName(req.getParameter("name"));
		return "Supplier";
	}
}

package shoppingf1.contrll;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingback.dao.CategoryDao;
import com.niit.shoppingback.model.Category;


@Controller
public class CategoryContrll {
	
	static AnnotationConfigApplicationContext ctx;
	static CategoryDao cg;
	static {
		ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.shoppingback");
		ctx.refresh();
		try {
			cg = (CategoryDao)ctx.getBean("CategoryDaoImpl");
		}
		catch(Exception e) {
			System.out.println("error="+e);
		}
	}
	
	@RequestMapping("/category")
	public ModelAndView ct2() {
		ModelAndView m = new ModelAndView("category");
		m.addObject("clist", cg.getAllCategories());
		return m;
	}

	@RequestMapping("/addCategory")
		public String ct1() {
			return "addcategory";	
		}
	@RequestMapping("/saveCategory")
	public String gosavecategory(HttpServletRequest req) {
		Category cx = new Category();
		cx.setName(req.getParameter("name"));
		cx.setSid(req.getParameter("sid"));
		cg.addCategory(cx);
		return "redirect:category";
	}
	
	
	
}

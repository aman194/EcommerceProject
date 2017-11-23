package shoppingf1.contrll;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingback.dao.ProductDao;

import com.niit.shoppingback.model.Product;

@Controller
public class ProductContrll {
	static AnnotationConfigApplicationContext ctx;
	static ProductDao pd;
	static {
		ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.shoppingback");
		ctx.refresh();
		try {
			pd = (ProductDao)ctx.getBean("ProductDaoImpl");
		}
		catch(Exception e) {
			System.out.println("error="+e);
		}
	}
	
	@RequestMapping("/product")
	public ModelAndView pr2() {
		ModelAndView m = new ModelAndView("product");
		m.addObject("plist", pd.getAllProducts());
		return m;
	}
	
	@RequestMapping("/addproduct")
	public String pr1() {
		return "addproduct";
		
	}
	
	@RequestMapping("/saveProduct")
	public String gosaveproduct(HttpServletRequest req) {
		Product p = new Product();
		p.setCid(Integer.parseInt(req.getParameter("cid")));
		p.setName(req.getParameter("name"));
		p.setDescription(req.getParameter("desp"));
		p.setPrice(req.getParameter("price"));
		p.setStock(req.getParameter("stock"));
		pd.addProduct(p);
		return "redirect:product";
		}
	@RequestMapping("/delpro/{id}")
	public String delproPro(@PathVariable("id")int id){
		pd.delProduct(id);
		return "redirect:/product";
	}
	@RequestMapping("/editpro/{id}")
	public ModelAndView editproCat(@PathVariable("id")int id){
		Product p = pd.getProductById(id);
		ModelAndView m = new ModelAndView("addproduct");
		m.addObject("product",p);
		return m;
}
	
	
}
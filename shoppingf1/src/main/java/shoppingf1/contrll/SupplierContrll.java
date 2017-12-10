package shoppingf1.contrll;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingback.dao.SupplierDao;
import com.niit.shoppingback.model.Supplier;

@Controller
public class SupplierContrll {
	static AnnotationConfigApplicationContext ctx;
	static SupplierDao sd;
	static int upd;
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
	
	@RequestMapping("/addsupplier")
	public String ct1() {
		upd=0;
		return "addsupplier";	
	}
	
	@RequestMapping("/savesupplier")
	public String gosavecategory(HttpServletRequest req) {
		Supplier s = new Supplier();
		s.setName(req.getParameter("name"));
		if(upd==0)
			sd.addSupplier(s);
		else
			sd.updSupplier(s);
		return "redirect:supplier";
	}
	@RequestMapping("/delSup/{id}")
	public String delsupSup(@PathVariable("id")int id){
		sd.delSupplier(id);
		return "redirect:/supplier";
	}
	@RequestMapping("/editSup/{id}")
	public ModelAndView editsupSup(@PathVariable("id")int id){
		Supplier s = sd.getSupplierById(id);
		ModelAndView m = new ModelAndView("addsupplier");
		m.addObject("supplier",s);
		upd=1;
		return m;
	}
}

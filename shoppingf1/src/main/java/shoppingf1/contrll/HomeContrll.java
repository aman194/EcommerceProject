package shoppingf1.contrll;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingback.dao.CustomerDao;
import com.niit.shoppingback.model.Customer;

@Controller
public class HomeContrll {

	static AnnotationConfigApplicationContext ctx;
	static CustomerDao cd;
	static {
		ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.shoppingback");
		ctx.refresh();
		try {
			cd = (CustomerDao)ctx.getBean("CustomerDaoImpl");
		}
		catch(Exception e) {
			System.out.println("error="+e);
		}
	}
	@RequestMapping(value = {"/","/index"})
	public String goHome() {
		return "home";
	}

	@RequestMapping("/login")
	public String goSingup() {
		return "Login";
	}
	
	@RequestMapping("/signup")
	public String goSingup1() {
		return "signup";
	}
	
	@RequestMapping("/register")
	public String goRegister(HttpServletRequest req) {
		Customer c =new Customer();
		c.setName(req.getParameter("name"));
		c.setEmail(req.getParameter("email"));
		c.setPassword(req.getParameter("pwd"));
		c.setAddress(req.getParameter("address"));
		c.setPhno(req.getParameter("phone"));
		cd.addCustomer(c);
		return "Login";
	}
}

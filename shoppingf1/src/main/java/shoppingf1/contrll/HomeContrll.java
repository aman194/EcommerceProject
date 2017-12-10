package shoppingf1.contrll;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView Home() {
		ModelAndView mv =new ModelAndView("/home");
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/login")
	public String gologin() {
		return "Login";
	}
	
	@RequestMapping(value ="/Login", method = RequestMethod.GET)
		public ModelAndView loginPage(@RequestParam(value ="error",required = false) String error,
				@RequestParam(value = "logout",required = false)String logout) {
				ModelAndView mv =new ModelAndView();
				if(error !=null) {
					mv.addObject("error","Invalid Credentials provided.");
				}
				
				if(logout !=null) {
					mv.addObject("message","Logged out from Sivam successfully.");
				}
				mv.setViewName("Login");
				return mv;
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
	
	@RequestMapping("/aboutus")
	public ModelAndView aboutUs() {
		ModelAndView m =new ModelAndView("/aboutus");
		return m;
		
		}
	
	@RequestMapping("/ContactUs")
	public ModelAndView contactUs() {
		ModelAndView m =new ModelAndView("/ContactUs");
		return m;
		
		}
}


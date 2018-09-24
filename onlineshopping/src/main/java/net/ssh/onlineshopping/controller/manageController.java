package net.ssh.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "manage")
public class manageController {

	
	@RequestMapping(value="products", method = RequestMethod.GET)
	public ModelAndView manageProducts()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("UserClickManageProducts",true);
		mv.addObject("title","Manage Products");
		return mv;
	}
	
}

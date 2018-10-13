package net.ssh.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.ssh.onlineshopping.service.CartLineServiceClass;
import net.ssh.shoppingbackend.dao.CartLineDAO;

@Controller
@RequestMapping(value = "/cart")
public class CartContoller {
	
	@Autowired
	private CartLineServiceClass cartService;
	
	@Autowired
	CartLineDAO lineDAO;
	
	@RequestMapping(value = "/show")
	@ResponseBody
	
	public ModelAndView showCart()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Cart");
		mv.addObject("UserClickCart",true );
		mv.addObject("carts", cartService.getCartLine());
		return mv;
	}
	

}

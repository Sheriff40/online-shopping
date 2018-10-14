package net.ssh.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.ssh.onlineshopping.service.CartLineServiceClass;
import net.ssh.shoppingbackend.dao.CartLineDAO;
import net.ssh.shoppingbackend.dto.CartLine;
import net.ssh.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value = "/cart")
public class CartContoller {
	
	@Autowired
	private CartLineServiceClass cartService;
	
	@Autowired
	CartLineDAO lineDAO;
	
	@RequestMapping(value = "/show")
	
	public ModelAndView showCart()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Cart");
		mv.addObject("UserClickCart",true );
		mv.addObject("carts", cartService.getCartLine());
		return mv;
	}
	

	@RequestMapping(value = "/{cartId}/update/")
	
	public String updateCart(@PathVariable("cartId")int id, @RequestParam("count")int count)
	{
		cartService.updateCartLine(id,count);
		return "redirect:/cart/show";
	}
	
}

package net.ssh.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	public ModelAndView showCart(@RequestParam(value = "result",required=false) String result)
	{
		
		ModelAndView mv = new ModelAndView("page");
		if(result!=null)
		{
			switch(result)
			{
				case("true"):
					mv.addObject("message","CartLine Updated Successfully");
				 break;
				case("false"):
					mv.addObject("error","CartLine Cannot be update Successfully");
				 break;
				
			}
		}
		
		mv.addObject("title","Cart");
		mv.addObject("UserClickCart",true );
		mv.addObject("carts", cartService.getCartLine());
		return mv;
	}
	

	@RequestMapping(value = "/{cartId}/update/")
	
	public String updateCart(@PathVariable("cartId")int id, @RequestParam("count")int count)
	{
		String response = cartService.updateCartLine(id,count);
		return "redirect:/cart/show/?"+response;
	}
	
	@RequestMapping(value = "/{id}/delete")
	public String deleteCartLine(@PathVariable("id")int id)
	{
			String response = cartService.deleteCartLine(id);
			return "redirect:/cart/show/?"+response;
		
	}
	
}

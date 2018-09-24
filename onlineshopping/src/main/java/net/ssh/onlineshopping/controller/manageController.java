package net.ssh.onlineshopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.ssh.shoppingbackend.dao.CategoryDAO;
import net.ssh.shoppingbackend.dao.productDAO;
import net.ssh.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value = "manage")
public class manageController {

	
	@Autowired
	CategoryDAO dao;
	
	@Autowired
	productDAO productDAO;
	
	@RequestMapping(value="products", method = RequestMethod.GET) 
	public ModelAndView manageProducts(@RequestParam(name = "operation", required = false)String operate)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("UserClickManageProducts",true);
		mv.addObject("title","Manage Products");
		Product prod = new Product();
		prod.setActive(true);
		prod.setSupplierId(1);
		mv.addObject("product",prod);
		mv.addObject("category",dao.getCustomers());
		if(operate!=null)
		{
			if(operate.equals("product"))
			{
				mv.addObject("message","Successfully inserted the product");
			}
			
		}
		
		return mv;
	}
	
	@RequestMapping(value="products/save", method = RequestMethod.POST)
	public String manageProducts(@Valid @ModelAttribute("product")Product product, BindingResult results, Model model)
	{
		if(results.hasErrors())
		{
			model.addAttribute("UserClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			return "page";
		}
		
		productDAO.insert(product);
		return "redirect:/manage/products?operation=product";
	}
}